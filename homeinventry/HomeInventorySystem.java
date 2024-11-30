package homeinventry;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class InventoryItem {
    private String description;
    private String location;
    private String serialNumber;
    private boolean marked;
    private String purchasePrice;
    private String purchaseDate;
    private String purchaseLocation;
    private String note;
    private String photoFile;

    public InventoryItem(String description, String location, String serialNumber, boolean marked, 
                         String purchasePrice, String purchaseDate, String purchaseLocation, 
                         String note, String photoFile) {
        this.description = description;
        this.location = location;
        this.serialNumber = serialNumber;
        this.marked = marked;
        this.purchasePrice = purchasePrice;
        this.purchaseDate = purchaseDate;
        this.purchaseLocation = purchaseLocation;
        this.note = note;
        this.photoFile = photoFile;
    }

    public String getDescription() { return description; }
    public String getLocation() { return location; }
    public String getSerialNumber() { return serialNumber; }
    public boolean isMarked() { return marked; }
    public String getPurchasePrice() { return purchasePrice; }
    public String getPurchaseDate() { return purchaseDate; }
    public String getPurchaseLocation() { return purchaseLocation; }
    public String getNote() { return note; }
    public String getPhotoFile() { return photoFile; }

    @Override
    public String toString() {
        return "Description: " + description +
               "\nLocation: " + location +
               "\nSerial Number: " + serialNumber +
               "\nMarked: " + (marked ? "Yes" : "No") +
               "\nPurchase Price: " + purchasePrice +
               "\nPurchase Date: " + purchaseDate +
               "\nPurchase Location: " + purchaseLocation +
               "\nNote: " + note +
               "\nPhoto File: " + photoFile;
    }
}

public class HomeInventorySystem {
    private static final String FILE_NAME = "inventory.txt";
    private static ArrayList<InventoryItem> inventory = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadInventory();

        int choice;
        do {
            printMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    deleteItem();
                    break;
                case 3:
                    displayInventory();
                    break;
                case 4:
                    searchInventory();
                    break;
                case 5:
                    saveInventory();
                    break;
                case 6:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 6);
    }

    private static void printMenu() {
        System.out.println("\n=== Home Inventory System ===");
        System.out.println("1. Add Item");
        System.out.println("2. Delete Item");
        System.out.println("3. Display Inventory");
        System.out.println("4. Search Inventory");
        System.out.println("5. Save Inventory");
        System.out.println("6. Exit");
    }

    private static void loadInventory() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String description = line;
                String location = reader.readLine();
                String serialNumber = reader.readLine();
                boolean marked = Boolean.parseBoolean(reader.readLine());
                String purchasePrice = reader.readLine();
                String purchaseDate = reader.readLine();
                String purchaseLocation = reader.readLine();
                String note = reader.readLine();
                String photoFile = reader.readLine();
                inventory.add(new InventoryItem(description, location, serialNumber, marked, 
                                                purchasePrice, purchaseDate, purchaseLocation, 
                                                note, photoFile));
            }
            System.out.println("Inventory loaded successfully with " + inventory.size() + " items.");
        } catch (IOException e) {
            System.out.println("No existing inventory file found. Starting fresh.");
        }
    }

    private static void saveInventory() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (InventoryItem item : inventory) {
                writer.println(item.getDescription());
                writer.println(item.getLocation());
                writer.println(item.getSerialNumber());
                writer.println(item.isMarked());
                writer.println(item.getPurchasePrice());
                writer.println(item.getPurchaseDate());
                writer.println(item.getPurchaseLocation());
                writer.println(item.getNote());
                writer.println(item.getPhotoFile());
            }
            System.out.println("Inventory saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving inventory to file.");
        }
    }

    private static void addItem() {
        System.out.print("Enter item description: ");
        String description = scanner.nextLine();

        System.out.print("Enter location: ");
        String location = scanner.nextLine();

        System.out.print("Enter serial number: ");
        String serialNumber = scanner.nextLine();

        System.out.print("Is the item marked? (true/false): ");
        boolean marked = Boolean.parseBoolean(scanner.nextLine());

        System.out.print("Enter purchase price: ");
        String purchasePrice = scanner.nextLine();

        System.out.print("Enter purchase date (MM/DD/YYYY): ");
        String purchaseDate = scanner.nextLine();

        System.out.print("Enter purchase location: ");
        String purchaseLocation = scanner.nextLine();

        System.out.print("Enter any notes: ");
        String note = scanner.nextLine();

        System.out.print("Enter photo file path: ");
        String photoFile = scanner.nextLine();

        inventory.add(new InventoryItem(description, location, serialNumber, marked, 
                                        purchasePrice, purchaseDate, purchaseLocation, 
                                        note, photoFile));
        System.out.println("Item added successfully.");
    }

    private static void deleteItem() {
        if (inventory.isEmpty()) {
            System.out.println("No items to delete.");
            return;
        }

        System.out.print("Enter the index of the item to delete (1 to " + inventory.size() + "): ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (index < 1 || index > inventory.size()) {
            System.out.println("Invalid index. No item deleted.");
            return;
        }

        inventory.remove(index - 1);
        System.out.println("Item deleted successfully.");
    }

    private static void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("No items in inventory.");
            return;
        }

        for (int i = 0; i < inventory.size(); i++) {
            System.out.println("\n=== Item " + (i + 1) + " ===");
            System.out.println(inventory.get(i));
        }
    }

    private static void searchInventory() {
        System.out.print("Enter the description to search: ");
        String searchTerm = scanner.nextLine();

        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getDescription().contains(searchTerm)) {
                System.out.println("\nItem found at index " + (i + 1) + ":");
                System.out.println(inventory.get(i));
                return;
            }
        }
        System.out.println("No matching items found.");
    }
}
