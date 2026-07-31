# JavaWarehouse - CRUD

**JavaWarehouse** is a Java-based warehouse management system that uses an Amazon RDS MySQL database to store and manage inventory data. It allows users to add, edit, remove, and search for items, as well as view sorted tables and recent modification history.

---

## Features

- **Add Item**: Insert a new item into the warehouse.
- **Edit Item**: Update information of an existing item.
- **Remove Item**: Delete an item from the database.
- **Search Item**: Search for items by name or other fields.
- **View Table**: Display all items in a table format.
- **Sort Items**: Sort items by name, category, quantity or price.
- **View History**: Display a log of recent modifications made to the database.

---

## Technologies Used

- **Java 11+**
- **MySQL Connector/J (8.4.0)**
- **Amazon RDS (MySQL Engine - db.t3.micro)**
- **AWS Systems Manager (SSM) Parameter Store**
- **AWS CloudFormation** (Infrastructure as Code)
- **JDBC (Java Database Connectivity)**

---

## Configuration Required

### 1. External JDBC Driver Setup
Since this is a standard Java project (without Maven/Gradle build tools), you must include the **MySQL Connector/J 8.4.0** `.jar` file in your project's classpath / referenced libraries:

- **Library:** `mysql-connector-j-8.4.0.jar`
- **IDE Setup:**
  - **VS Code:** Add `mysql-connector-j-8.4.0.jar` under *Java Projects* > *Referenced Libraries*.
  - **Eclipse:** Right-click project > *Build Path* > *Add External Archives* > Select `mysql-connector-j-8.4.0.jar`.
  - **IntelliJ:** Go to *Project Structure* > *Modules* > *Dependencies* > Add JAR file.
- **Terminal Execution:**
  ```bash
  javac -cp .:mysql-connector-j-8.4.0.jar database/Database.java Main.java
  java -cp .:mysql-connector-j-8.4.0.jar Main

### 2. Database Connection Credentials
**Important:**

Before running the application, update the file src/database/Database.java with your Amazon RDS Endpoint and database credentials created via CloudFormation or AWS Console.

Example configuration in Database.java:
```
package database;

public class Database {

    // AWS
    public static String url = "jdbc:mysql://<YOUR-RDS-ENDPOINT.rds.amazonaws.com>:3306/";
    public static String databaseName = "my_db";
    public static String tableName = "produtos";
    public static String userName = "admin";
    public static String password = "YOUR_RDS_PASSWORD_HERE";

}
```

### 3. Infrastructure Setup (AWS CloudFormation)
To provision the required AWS resources (RDS MySQL Instance & SSM Parameters) on AWS Academy Sandbox:

Upload *JavaWarehouse/infra/template-rds.yaml* to AWS CloudFormation.

Specify stack parameters (DBMasterUsername and DBMasterPassword).

Deploy the stack and copy the generated RDS Endpoint from the stack Outputs section into Database.java.