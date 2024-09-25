package Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import net.ucanaccess.jdbc.UcanaccessSQLException;

/**
 *
 * @author jasonrodriguez
 */
public class OrderItem {
    private int orderItemID;
    private int orderID;
    private int productID;
    private String productName;
    private int quantity;
    private double price;
    private String createdAt;
    private String updatedAt;
    public OrderItem() {
        orderItemID = 0;
        orderID = 0;
        productID = 0;
        productName = "";
        quantity = 1;
        price = -1;
        createdAt = "2000-01-01";
        updatedAt = "2000-01-01";
    }

    public OrderItem(int orderItemID, int orderID, int productID, int quantity, double price, String createdAt, String updatedAt) {
        this.orderItemID = orderItemID;
        this.orderID = orderID;
        this.productID = productID;
        this.quantity = quantity;
        this.price = price;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName() {
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
            String sql = "select ProductName from Products where ProductID = '" + getProductID() + "';";
            ResultSet rs = stmt.executeQuery(sql);

            rs.next();
            productName = rs.getString("ProductName");
            con.close();
            
        } 
        catch (UcanaccessSQLException e) {System.out.println("That record doesn't exits");}
        catch (Exception e) {e.printStackTrace();}
    }

    public int getOrderItemID() {
        return orderItemID;
    }

    public void setOrderItemID(int orderItemID) {
        this.orderItemID = orderItemID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
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
            String sql = "select * from OrderItems where OrderItemID = '" + getOrderItemID() + "';";
            ResultSet rs = stmt.executeQuery(sql);

            rs.next();
            orderItemID = Integer.parseInt(rs.getString("OrderItemID"));
            orderID = Integer.parseInt(rs.getString("OrderID"));
            productID = Integer.parseInt(rs.getString("ProductID"));
            quantity = Integer.parseInt(rs.getString("Quantity"));
            price = Double.parseDouble(rs.getString("Price"));
            createdAt = rs.getString("CreatedAt");
            updatedAt = rs.getString("UpdatedAt");
            setProductName();
            con.close();
            
        } 
        catch (UcanaccessSQLException e) {System.out.println("That record doesn't exits");}
        catch (Exception e) {e.printStackTrace();}
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
            String sql = "insert into OrderItems "
                        +"VALUES ( '" + getOrderItemID() + "', '" + getOrderID()+ "', '" + getProductID()+ "', '" + getQuantity()+ "', '" 
                    + getPrice()+ "', '" + getCreatedAt()+ "', '" + getUpdatedAt() + "');";
            stmt.executeUpdate(sql);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public void updateDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
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
            String sql = "UPDATE OrderItems " +
                              "SET OrderID = " + "'" + getOrderID()+ "', " +
                              "ProductID = " + "'" + getProductID()+ "', " +
                              "Quantity = " + "'" + getQuantity()+ "', " +
                              "Price = " + "'" + getPrice()+ "', " +
                              "CreatedAt = " + "'" + getCreatedAt()+ "', " +
                              "UpdatedAt = " + "'" + getUpdatedAt()+ "' " +
                              "WHERE OrderItemID = '" + getOrderItemID() + "';";
            stmt.executeUpdate(sql);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public void deleteDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
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
            String sql = "delete from OrderItems where OrderItemID = '" + getOrderItemID() + "';";
            stmt.executeUpdate(sql);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int getNextAutoIncrementIDWithRollback() {
        int nextOrderItemID = -1;
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
            String insertSQL = "INSERT INTO OrderItems (OrderID, ProductID) VALUES ('1', '3')";
            stmt.executeUpdate(insertSQL, Statement.RETURN_GENERATED_KEYS);

            // Fetch the auto-incremented ID
            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                nextOrderItemID = rs.getInt(1);  // Get the auto-increment value
            }

            // Rollback the insert so it doesn't affect the database
            con.rollback();

            con.setAutoCommit(true);  // End transaction
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

        return nextOrderItemID;
    }
    public void displayRecord() {
        System.out.println("OrderItemID: " + getOrderItemID());
        System.out.println("OrderID: " + getOrderID());
        System.out.println("ProductID: " + getProductID());
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Price: " + getPrice());        
        System.out.println("CreatedAt: " + getCreatedAt());
        System.out.println("UpdatedAt: " + getUpdatedAt());        
    }
    public static void main(String[] args) {
        
        
        // Testing selectDB
        System.out.println("SELECT TESTING STARTED");
        OrderItem oi = new OrderItem();
        oi.setOrderItemID(1);
        oi.selectDB();
        oi.displayRecord();
        System.out.println("SELECT TESTING DONE");

        System.out.println("");
        System.out.println("");
        
        // Testing insertDB
        System.out.println("INSERT TESTING STARTED");
        oi = new OrderItem();
        int nextAvailableOrderItemID = getNextAutoIncrementIDWithRollback();
        oi.setOrderItemID(nextAvailableOrderItemID);
        System.out.println("NEXT AVAILABLE ORDER ITEM ID = " + nextAvailableOrderItemID);
        oi.setOrderID(1);
        oi.setProductID(1);
        oi.setQuantity(5);
        oi.setPrice(20.05);
        oi.setCreatedAt("2024-09-08");
        oi.setUpdatedAt("2024-09-08");
        oi.insertDB();
        oi = new OrderItem();
        oi.setOrderItemID(nextAvailableOrderItemID);
        oi.selectDB();
        oi.displayRecord();
        System.out.println("INSERT TESTING DONE");

        System.out.println("");
        System.out.println("");

        // Testing updateDB
        System.out.println("UPDATE TESTING STARTED");
        oi = new OrderItem();
        oi.setOrderItemID(nextAvailableOrderItemID);
        oi.selectDB();
        System.out.println("BEFORE UPDATING");
        oi.displayRecord();
        oi.setQuantity(20);
        oi.updateDB();
        oi = new OrderItem();
        oi.setOrderItemID(nextAvailableOrderItemID);
        oi.selectDB();
        System.out.println("AFTER UPDATING");
        oi.displayRecord();
        System.out.println("UPDATE TESTING DONE");

        System.out.println("");
        System.out.println("");

        // Testing deleteDB
        System.out.println("DELETE TESTING STARTED");
        oi = new OrderItem();
        oi.setOrderItemID(nextAvailableOrderItemID);
        oi.selectDB();
        System.out.println("BEFORE DELETING");
        oi.displayRecord();
        oi.deleteDB();
        System.out.println("AFTER DELETING");
        oi = new OrderItem();
        oi.setOrderItemID(nextAvailableOrderItemID);
        oi.selectDB();
        oi.displayRecord();
        System.out.println("DELETE TESTING DONE");
        
    }
    
}
