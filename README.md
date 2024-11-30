## **Project Report: Home Inventory System**  

### **Introduction**  
The **Home Inventory System** is a Java-based application designed to manage and maintain a personal inventory of items. The program provides functionalities such as adding, deleting, displaying, and searching for items in an inventory. Users can also save and load the inventory data from a file. This system is useful for keeping track of household items, ensuring proper documentation for insurance, or simply organizing belongings efficiently.

---

### **Features**  
1. **Add Item:**  
   - Users can add a new inventory item by providing details like description, location, serial number, purchase details, and an optional photo file path.

2. **Delete Item:**  
   - The program allows users to delete items from the inventory based on their index.

3. **Display Inventory:**  
   - Displays all the items currently in the inventory with their respective details.

4. **Search Inventory:**  
   - Searches the inventory based on a keyword in the description and displays matching results.

5. **Save Inventory:**  
   - Saves the current inventory data to a text file (`inventory.txt`) for future use.

6. **Load Inventory:**  
   - Loads inventory data from the `inventory.txt` file at the start of the program if the file exists.

7. **Exit:**  
   - Allows the user to exit the program safely.

---

### **Class Details**  

#### **1. InventoryItem Class**  
This class represents an individual inventory item and encapsulates all relevant properties.  

**Attributes:**  
- `description` (String)  
- `location` (String)  
- `serialNumber` (String)  
- `marked` (boolean)  
- `purchasePrice` (String)  
- `purchaseDate` (String)  
- `purchaseLocation` (String)  
- `note` (String)  
- `photoFile` (String)  

**Methods:**  
- Getter methods for all attributes.  
- `toString()` method for a formatted string representation of the item's details.  

#### **2. HomeInventorySystem Class**  
This is the main class that manages the inventory and provides the user interface.  

**Attributes:**  
- `FILE_NAME` (String): The name of the file used to save and load inventory data.  
- `inventory` (ArrayList<InventoryItem>): Stores the list of inventory items.  
- `scanner` (Scanner): Used for user input.  

**Methods:**  
- `main(String[] args)`: Entry point of the program. Handles menu navigation.  
- `printMenu()`: Displays the program menu.  
- `loadInventory()`: Reads inventory data from a file and loads it into memory.  
- `saveInventory()`: Writes inventory data to a file.  
- `addItem()`: Prompts the user to input details for a new item and adds it to the inventory.  
- `deleteItem()`: Deletes an item based on its index.  
- `displayInventory()`: Prints details of all items in the inventory.  
- `searchInventory()`: Searches for items based on a description keyword.  

---

### **File Handling**  
The program uses the `inventory.txt` file to persist inventory data between sessions. Data is saved in a sequential format, with each item's details written line by line. This ensures a simple and efficient structure for saving and loading.  

**File Format Example:**  
```
Description
Location
SerialNumber
true
PurchasePrice
PurchaseDate
PurchaseLocation
Note
PhotoFile
```

---

### **Code Workflow**  
1. On startup, the program attempts to load the inventory from `inventory.txt`.  
2. The user interacts with the program through a menu-driven interface.  
3. Depending on the selected option, the program performs operations such as adding, deleting, displaying, searching, or saving items.  
4. Changes made during the session are saved when the user explicitly selects the save option or exits the program.  

---

### **Limitations and Improvements**  
#### **Current Limitations:**  
- No exception handling for invalid user inputs (e.g., entering text when a number is expected).  
- The inventory file format is simple but not robust, as errors in file structure can lead to data loss or incorrect loading.  
- Limited validation for input data like purchase date or price.  

#### **Potential Improvements:**  
1. **Input Validation:**  
   Add validation for fields such as date and price to ensure accurate data entry.  

2. **Error Handling:**  
   Implement robust exception handling to manage incorrect user inputs or file-related errors.  

3. **GUI Integration:**  
   Enhance the user experience by developing a graphical interface using JavaFX or Swing.  

4. **Advanced Search:**  
   Extend search functionality to include multiple fields like serial numbers, locations, or notes.  

5. **Database Support:**  
   Replace text file storage with a relational database for better scalability and data integrity.  

---

### **Conclusion**  
The **Home Inventory System** is a functional and practical application for managing household inventory items. While it offers a solid foundation with core features, there is significant potential for further development. By addressing its current limitations and incorporating advanced features, the system can become a more powerful and user-friendly tool for personal inventory management.
