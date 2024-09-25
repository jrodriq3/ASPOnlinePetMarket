
package Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import net.ucanaccess.jdbc.UcanaccessSQLException;

public class ShoppingCart {
    private int cartID;
    private int customerID;
    private String createdAt;
    private String updatedAt;
    private List<Product> productList;
    
    public ShoppingCart() {
        cartID = 0;
        customerID = 0;
        createdAt = "";
        updatedAt = "";
        productList = new ArrayList<>();
        
    }

    public ShoppingCart(int cartID, int customerID, String createdAt, String updatedAt) {
        this.cartID = cartID;
        this.customerID = customerID;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public List<Product> getProductList() {
        return productList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }
    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
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
            String sql = "select * from ShoppingCarts where CartID = '" + getCartID() + "';";
            ResultSet rs = stmt.executeQuery(sql);

            rs.next();
            cartID = Integer.parseInt(rs.getString(1));
            customerID = Integer.parseInt(rs.getString(2));
            createdAt = rs.getString(3);
            updatedAt = rs.getString(4);
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
            String sql = "insert into ShoppingCarts "
                        +"VALUES ( '" + getCartID() + "', '" + getCustomerID()+ "', '" + getCreatedAt()+ "', '" + getUpdatedAt() + "');";
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
            String sql = "UPDATE ShoppingCarts " +
                              "SET CustomerID = " + "'" + getCustomerID()+ "', " +
                              "CreatedAt = " + "'" + getCreatedAt()+ "', " +
                              "UpdatedAt = " + "'" + getUpdatedAt()+ "' " +
                              "WHERE CartID = '" + getCartID() + "';";
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
            String sql = "delete from ShoppingCarts where CartID = '" + getCartID() + "';";
            stmt.executeUpdate(sql);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int getNextAutoIncrementIDWithRollback() {
        int nextCartID = -1;
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
            String insertSQL = "INSERT INTO ShoppingCarts (CustomerID, CreatedAt) VALUES ('2', '2024-08-08')";
            stmt.executeUpdate(insertSQL, Statement.RETURN_GENERATED_KEYS);

            // Fetch the auto-incremented ID
            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                nextCartID = rs.getInt(1);  // Get the auto-increment value
            }

            // Rollback the insert so it doesn't affect the database
            con.rollback();

            con.setAutoCommit(true);  // End transaction
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

        return nextCartID;
    }
    public void displayRecord() {
        System.out.println("CartID: " + getCartID());
        System.out.println("CustomerID: " + getCustomerID());
        System.out.println("CreatedAt: " + getCreatedAt());
        System.out.println("UpdatedAt: " + getUpdatedAt());             
    }
    public static void main(String[] args) {
        // Testing selectDB
        System.out.println("SELECT TESTING STARTED");
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCartID(1);
        shoppingCart.selectDB();
        shoppingCart.displayRecord();
        System.out.println("SELECT TESTING DONE");

        System.out.println("");
        System.out.println("");
        
        // Testing insertDB
        System.out.println("INSERT TESTING STARTED");
        shoppingCart = new ShoppingCart();
        int nextAvailableCartID = getNextAutoIncrementIDWithRollback();
        System.out.println("NEXT AVAILABLE CART ID = " + nextAvailableCartID);
        shoppingCart.setCartID(nextAvailableCartID);
        shoppingCart.setCustomerID(1);
        shoppingCart.setCreatedAt("2024-09-09");
        shoppingCart.setUpdatedAt("2024-09-09");
        shoppingCart.insertDB();
        shoppingCart = new ShoppingCart();
        shoppingCart.setCartID(nextAvailableCartID);
        shoppingCart.selectDB();
        shoppingCart.displayRecord();
        System.out.println("INSERT TESTING DONE");

        System.out.println("");
        System.out.println("");
        
        // Testing updateDB
        System.out.println("UPDATE TESTING STARTED");
        shoppingCart = new ShoppingCart();
        shoppingCart.setCartID(nextAvailableCartID);
        shoppingCart.selectDB();
        System.out.println("BEFORE UPDATING");
        shoppingCart.displayRecord();
        shoppingCart.setCustomerID(1);
        shoppingCart.setUpdatedAt("2024-09-10");
        shoppingCart.updateDB();
        shoppingCart = new ShoppingCart();
        shoppingCart.setCartID(nextAvailableCartID);
        shoppingCart.selectDB();
        System.out.println("AFTER UPDATING");
        shoppingCart.displayRecord();
        System.out.println("UPDATE TESTING DONE");

        System.out.println("");
        System.out.println("");
        
        // Testing deleteDB
        System.out.println("DELETE TESTING STARTED");
        shoppingCart = new ShoppingCart();
        shoppingCart.setCartID(nextAvailableCartID);
        shoppingCart.selectDB();
        System.out.println("BEFORE DELETING");
        shoppingCart.displayRecord();
        shoppingCart.deleteDB();
        System.out.println("AFTER DELETING");
        shoppingCart = new ShoppingCart();
        shoppingCart.setCartID(nextAvailableCartID);
        shoppingCart.selectDB();
        shoppingCart.displayRecord();
        System.out.println("DELETE TESTING DONE");
        
    }
}
