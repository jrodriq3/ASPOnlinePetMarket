/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import net.ucanaccess.jdbc.UcanaccessSQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author jasonrodriguez
 */
public class Product {
    private int productID;
    private String productName;
    private String productDescription;
    private int stockQuantity;
    private String category;
    private double productPrice;
    public Product() {
        productID = 0;
        productName = "";
        productDescription = "";
        stockQuantity = 0;
        category = "";
        productPrice = 0.0;
    }
    public Product(int productID, String productName, String productDescription, int stockQuantity, String category, double productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productDescription = productDescription;
        this.stockQuantity = stockQuantity;
        this.category = category;
        this.productPrice = productPrice;
    }
    public int getProductID() {
        return productID;
    }
    public void setProductID(int productID) {
        this.productID = productID;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductDescription() {
        return productDescription;
    }
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    public int getStockQuantity() {
        return stockQuantity;
    }
    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public double getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
    public static List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            // Determine the operating system
            String os = System.getProperty("os.name").toLowerCase();
            String conURL;

            if (os.contains("win")) {
                conURL = "jdbc:ucanaccess://C://Users/jason/Dropbox/Desktop-JasonsMacBookAircopy/DESKDOCS/AdvancedSystemProject/Project/Database/PetStoreASPDatabase.accdb";
            } else if (os.contains("mac")) {
                conURL = "jdbc:ucanaccess:///Users/jasonrodriguez/Dropbox/Desktop-JasonsMacBookAircopy/DESKDOCS/AdvancedSystemProject/Project/Database/PetStoreASPDatabase.accdb";
            } else {
                throw new UnsupportedOperationException("Unsupported operating system: " + os);
            }

            // Connect to the database
            con = DriverManager.getConnection(conURL);
            stmt = con.createStatement();

            // Query to get all products
            String sql = "SELECT * FROM Products";
            rs = stmt.executeQuery(sql);

            // Iterate through the result set and create Product objects
            while (rs.next()) {
                int productID = rs.getInt("ProductID");
                String productName = rs.getString("ProductName");
                String productDescription = rs.getString("ProductDescription");
                int stockQuantity = rs.getInt("StockQuantity");
                String category = rs.getString("Category");
                double productPrice = rs.getDouble("ProductPrice");

                // Create a new Product object and add it to the list
                Product product = new Product(productID, productName, productDescription, stockQuantity, category, productPrice);
                productList.add(product);
            }

            // Close the connection
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productList;
        }
    
    public void selectDB() {
        try {
            // loading driver and database file

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            // Determine the operating system
            String os = System.getProperty("os.name").toLowerCase();
            String conURL;

            if (os.contains("win")) {
                // Path for Windows
                conURL = "jdbc:ucanaccess://C://Users/jason/Dropbox/Desktop-JasonsMacBookAircopy/DESKDOCS/AdvancedSystemProject/Project/Database/PetStoreASPDatabase.accdb";
            } else if (os.contains("mac")) {
                // Path for macOS
                conURL = "jdbc:ucanaccess:///Users/jasonrodriguez/Dropbox/Desktop-JasonsMacBookAircopy/DESKDOCS/AdvancedSystemProject/Project/Database/PetStoreASPDatabase.accdb";
            } else {
                // Optionally handle other operating systems or throw an error
                throw new UnsupportedOperationException("Unsupported operating system: " + os);
            }


            Connection con = DriverManager.getConnection(conURL);
            Statement stmt = con.createStatement();
            String sql = "select * from Products where ProductID = '" + getProductID() + "';";
            ResultSet rs = stmt.executeQuery(sql);

            rs.next();
            
            productID = Integer.parseInt(rs.getString(1));
            
            productName = rs.getString(2);
            productDescription = rs.getString(3);
            
            stockQuantity = Integer.parseInt(rs.getString(4));
            category = rs.getString(5);
            productPrice = Double.parseDouble(rs.getString(6));
            con.close();            
        } 
        catch (UcanaccessSQLException e) {System.out.println("That record doesn't exits");}
        catch (Exception e) {e.printStackTrace();}
    }
    public void updateDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            // Determine the operating system
            String os = System.getProperty("os.name").toLowerCase();
            String conURL;

            if (os.contains("win")) {
                // Path for Windows
                conURL = "jdbc:ucanaccess://C://Users/jason/Dropbox/Desktop-JasonsMacBookAircopy/DESKDOCS/AdvancedSystemProject/Project/Database/PetStoreASPDatabase.accdb";
            } else if (os.contains("mac")) {
                // Path for macOS
                conURL = "jdbc:ucanaccess:///Users/jasonrodriguez/Dropbox/Desktop-JasonsMacBookAircopy/DESKDOCS/AdvancedSystemProject/Project/Database/PetStoreASPDatabase.accdb";
            } else {
                // Optionally handle other operating systems or throw an error
                throw new UnsupportedOperationException("Unsupported operating system: " + os);
            }
            Connection con = DriverManager.getConnection(conURL);
            Statement stmt = con.createStatement();
            String sql = "UPDATE Products " +
                              "SET ProductName = " + "'" + getProductName() + "', " +
                              "ProductDescription = " + "'" + getProductDescription()+ "', " +
                              "StockQuantity = " + "'" + getStockQuantity()+ "', " +
                              "Category = " + "'" + getCategory()+ "', " +
                              "ProductPrice = " + "'" + getProductPrice() + "' " +
                              "WHERE ProductID = '" + getProductID() + "';";
            stmt.executeUpdate(sql);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void insertDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            // Determine the operating system
            String os = System.getProperty("os.name").toLowerCase();
            String conURL;

            if (os.contains("win")) {
                // Path for Windows
                conURL = "jdbc:ucanaccess://C://Users/jason/Dropbox/Desktop-JasonsMacBookAircopy/DESKDOCS/AdvancedSystemProject/Project/Database/PetStoreASPDatabase.accdb";
            } else if (os.contains("mac")) {
                // Path for macOS
                conURL = "jdbc:ucanaccess:///Users/jasonrodriguez/Dropbox/Desktop-JasonsMacBookAircopy/DESKDOCS/AdvancedSystemProject/Project/Database/PetStoreASPDatabase.accdb";
            } else {
                // Optionally handle other operating systems or throw an error
                throw new UnsupportedOperationException("Unsupported operating system: " + os);
            }
            Connection con = DriverManager.getConnection(conURL);
            Statement stmt = con.createStatement();
            String sql = "insert into Products "
                        +"VALUES ( '" + getProductID() + "', '" + getProductName() + "', '" + getProductDescription()+ "', '" + getStockQuantity()+ "', '" 
                    + getCategory()+ "', '" + getProductPrice() + "');";
            stmt.executeUpdate(sql);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            // Determine the operating system
            String os = System.getProperty("os.name").toLowerCase();
            String conURL;

            if (os.contains("win")) {
                // Path for Windows
                conURL = "jdbc:ucanaccess://C://Users/jason/Dropbox/Desktop-JasonsMacBookAircopy/DESKDOCS/AdvancedSystemProject/Project/Database/PetStoreASPDatabase.accdb";
            } else if (os.contains("mac")) {
                // Path for macOS
                conURL = "jdbc:ucanaccess:///Users/jasonrodriguez/Dropbox/Desktop-JasonsMacBookAircopy/DESKDOCS/AdvancedSystemProject/Project/Database/PetStoreASPDatabase.accdb";
            } else {
                // Optionally handle other operating systems or throw an error
                throw new UnsupportedOperationException("Unsupported operating system: " + os);
            }
            Connection con = DriverManager.getConnection(conURL);
            Statement stmt = con.createStatement();
            String sql = "delete from Products where ProductID = '" + getProductID() + "';";
            stmt.executeUpdate(sql);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static int getNextAutoIncrementIDWithRollback() {
        int nextProductID = -1;
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            // Determine the operating system
            String os = System.getProperty("os.name").toLowerCase();
            String conURL;

            if (os.contains("win")) {
                conURL = "jdbc:ucanaccess://C://Users/jason/Dropbox/Desktop-JasonsMacBookAircopy/DESKDOCS/AdvancedSystemProject/Project/Database/PetStoreASPDatabase.accdb";
            } else if (os.contains("mac")) {
                conURL = "jdbc:ucanaccess:///Users/jasonrodriguez/Dropbox/Desktop-JasonsMacBookAircopy/DESKDOCS/AdvancedSystemProject/Project/Database/PetStoreASPDatabase.accdb";
            } else {
                throw new UnsupportedOperationException("Unsupported operating system: " + os);
            }

            con = DriverManager.getConnection(conURL);
            con.setAutoCommit(false);  // Start transaction

            stmt = con.createStatement();

            // Insert a temporary row to trigger auto-increment
            String insertSQL = "INSERT INTO Products (ProductName, ProductDescription) VALUES ('temp', 'temp')";
            stmt.executeUpdate(insertSQL, Statement.RETURN_GENERATED_KEYS);

            // Fetch the auto-incremented ID
            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                nextProductID = rs.getInt(1);  // Get the auto-increment value
            }

            // Rollback the insert so it doesn't affect the database
            con.rollback();

            con.setAutoCommit(true);  // End transaction
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

        return nextProductID;
    }
    
    public void displayRecord() {
        System.out.println("ProductID: " + getProductID());
        System.out.println("ProductName: " + getProductName());
        System.out.println("ProductDescription: " + getProductDescription());
        System.out.println("StockQuantity: " + getStockQuantity());
        System.out.println("Category: " + getCategory());
        System.out.println("ProductPrice: " + getProductPrice());
    }
    public static void main(String[] args) {
        // Testing getAllProducts()
        System.out.println("GET ALL PRODUCTS TESTING STARTED");
        List<Product> productList = getAllProducts();

        if (productList.isEmpty()) {
            System.out.println("No products found in the database.");
        } else {
            for (Product p : productList) {
                System.out.println("Product ID: " + p.getProductID());
                System.out.println("Product Name: " + p.getProductName());
                System.out.println("Product Description: " + p.getProductDescription());
                System.out.println("Stock Quantity: " + p.getStockQuantity());
                System.out.println("Category: " + p.getCategory());
                System.out.println("Price: " + p.getProductPrice());
                System.out.println("-----------------------------------");
            }
        }
        System.out.println("GET ALL PRODUCTS TESTING DONE");
        
//        // Testing selectDB
//        System.out.println("SELECT TESTING STARTED");
//        Product product = new Product();
//        product.setProductID(1);
//        product.selectDB();
//        product.displayRecord();
//        System.out.println("SELECT TESTING DONE");
//
//        System.out.println("");
//        System.out.println("");
//        
//        // Testing insertDB
//        System.out.println("INSERT TESTING STARTED");
//        product = new Product();
//        int nextAvailableProductID = getNextAutoIncrementIDWithRollback();
//        System.out.println("NEXT AVAILABLE PRODUCT ID = " + nextAvailableProductID);
//        product.setProductID(nextAvailableProductID);
//        product.setProductName("lizard food");
//        product.setProductDescription("healthy lizard food");
//        product.setCategory("reptile");
//        product.setStockQuantity(15);
//        product.setProductPrice(19.00);
//        product.insertDB();
//        product = new Product();
//        product.setProductID(nextAvailableProductID);
//        product.selectDB();
//        product.displayRecord();
//        System.out.println("INSERT TESTING DONE");
//
//        System.out.println("");
//        System.out.println("");
//        
//        // Testing updateDB
//        System.out.println("UPDATE TESTING STARTED");
//        product = new Product();
//        product.setProductID(nextAvailableProductID);
//        product.selectDB();
//        System.out.println("BEFORE UPDATING");
//        product.displayRecord();
//        product.setProductName("reptile food");
//        product.setProductDescription("healthy reptile food");
//        product.setCategory("lizards");
//        product.setStockQuantity(20);
//        product.setProductPrice(25.00);
//        product.updateDB();
//        product = new Product();
//        product.setProductID(nextAvailableProductID);
//        product.selectDB();
//        System.out.println("AFTER UPDATING");
//        product.displayRecord();
//        System.out.println("UPDATE TESTING DONE");
//
//        System.out.println("");
//        System.out.println("");
//        
//        // Testing deleteDB
//        System.out.println("DELETE TESTING STARTED");
//        product = new Product();
//        product.setProductID(nextAvailableProductID);
//        product.selectDB();
//        System.out.println("BEFORE DELETING");
//        product.displayRecord();
//        product.deleteDB();
//        System.out.println("AFTER DELETING");
//        product = new Product();
//        product.setProductID(nextAvailableProductID);
//        product.selectDB();
//        product.displayRecord();
//        System.out.println("DELETE TESTING DONE");
    }
            
}
