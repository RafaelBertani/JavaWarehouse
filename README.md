# JavaWarehouse

**JavaWarehouse** is a Java-based warehouse management system that uses a MySQL database to store and manage inventory data. It allows users to add, edit, remove, and search for items, as well as view sorted tables and recent modification history.

---

## 🚀 Features

- ➕ **Add Item**: Insert a new item into the warehouse.
- ✏️ **Edit Item**: Update information of an existing item.
- ❌ **Remove Item**: Delete an item from the database.
- 🔍 **Search Item**: Search for items by name or other fields.
- 📊 **View Table**: Display all items in a table format.
- 🔄 **Sort Items**: Sort items by name, category, quantity, or price.
- 🕓 **View History**: Display a log of recent modifications made to the database.

---

## 🧰 Technologies Used

- **Java 11+**
- **MySQL**
- **JDBC (Java Database Connectivity)**

---

## ⚙️ Configuration Required

> 🔐 **Important:**  
> In order for the application to run correctly on your machine, you must edit the file  
> `src/database/Database.java` and set your local MySQL username and password.

Example:
```java
private static final String USER = "root";
private static final String PASSWORD = "your_mysql_password_here";
