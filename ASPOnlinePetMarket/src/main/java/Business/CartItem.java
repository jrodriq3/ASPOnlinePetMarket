package Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import net.ucanaccess.jdbc.UcanaccessSQLException;

public class CartItem {
    private int cartItemID;
    private int cartID;
    private int productID;
    private int quantity;
    private String createdAt;
    private String updatedAt;

    public CartItem() {
        cartItemID = 0;
        cartID = 0;
        productID = 0;
        quantity = -1;
        createdAt = "";
        updatedAt = "";
    }
    public CartItem(int cartItemID, int cartID, int productID, int quantity, String createdAt, String updatedAt) {
        this.cartItemID = cartItemID;
        this.cartID = cartID;
        this.productID = productID;
        this.quantity = quantity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getCartItemID() {
        return cartItemID;
    }

    public void setCartItemID(int cartItemID) {
        this.cartItemID = cartItemID;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
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
            String sql = "select * from CartItems where CartItemID = '" + getCartItemID() + "';";
            ResultSet rs = stmt.executeQuery(sql);

            rs.next();
            cartItemID = Integer.parseInt(rs.getString(1));
            cartID = Integer.parseInt(rs.getString(2));
            productID = Integer.parseInt(rs.getString(3));
            quantity = Integer.parseInt(rs.getString(4));
            createdAt = rs.getString(5);
            updatedAt = rs.getString(6);
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
            String sql = "insert into CartItems "
                        +"VALUES ( '" + getCartItemID() + "', '" + getCartID()+ "', '" + getProductID()+ "', '" + getQuantity()+ "', '" 
                    + getCreatedAt()+ "', '" + getUpdatedAt() + "');";
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
            String sql = "UPDATE CartItems " +
                              "SET CartID = " + "'" + getCartID() + "', " +
                              "ProductID = " + "'" + getProductID()+ "', " +
                              "Quantity = " + "'" + getQuantity()+ "', " +
                              "CreatedAt = " + "'" + getCreatedAt()+ "', " +
                              "UpdatedAt = " + "'" + getUpdatedAt()+ "' " +
                              "WHERE CartItemID = '" + getCartItemID() + "';";
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
            String sql = "delete from CartItems where CartItemID = '" + getCartItemID() + "';";
            stmt.executeUpdate(sql);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int getNextAutoIncrementIDWithRollback() {
        int nextCartItemID = -1;
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
            String insertSQL = "INSERT INTO CartItems (CartID, ProductID) VALUES ('1', '3')";
            stmt.executeUpdate(insertSQL, Statement.RETURN_GENERATED_KEYS);

            // Fetch the auto-incremented ID
            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                nextCartItemID = rs.getInt(1);  // Get the auto-increment value
            }

            // Rollback the insert so it doesn't affect the database
            con.rollback();

            con.setAutoCommit(true);  // End transaction
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

        return nextCartItemID;
    }
    public void displayRecord() {
        System.out.println("CartItemID: " + getCartItemID());
        System.out.println("CartID: " + getCartID());
        System.out.println("ProductID: " + getProductID());
        System.out.println("Quantity: " + getQuantity());     
        System.out.println("CreatedAt: " + getCreatedAt());
        System.out.println("UpdatedAt: " + getUpdatedAt());        
    }
    public static void main(String[] args) {
        // testing selectDB
        System.out.println("SELECT TESTING STARTED");
        CartItem ci = new CartItem();
        ci.setCartItemID(1);
        ci.selectDB();
        ci.displayRecord();
        System.out.println("SELECT TESTING DONE");
        
        // testing insertDB
        System.out.println("INSERT TESTING STARTED");
        ci = new CartItem();
        int nextAvailableCartItemID = getNextAutoIncrementIDWithRollback();
        ci.setCartItemID(nextAvailableCartItemID);
        System.out.println("NEXT AVAILABLE CART ITEM ID = " + nextAvailableCartItemID);
        ci.setCartID(1);
        ci.setProductID(2);
        ci.setQuantity(4);
        ci.setCreatedAt("2024-08-07");
        ci.setUpdatedAt("2024-08-07");
        ci.insertDB();
        ci = new CartItem();
        ci.setCartItemID(nextAvailableCartItemID);
        ci.selectDB();
        ci.displayRecord();
        System.out.println("INSERT TESTING DONE");
        
        
        // testing updateDB
        System.out.println("UPDATE TESTING STARTED");
        ci = new CartItem();
        ci.setCartItemID(nextAvailableCartItemID);
        ci.selectDB();
        System.out.println("BEFOR UPDATING");
        ci.displayRecord();
        ci.setQuantity(5);
        ci.updateDB();
        ci = new CartItem();
        ci.setCartItemID(nextAvailableCartItemID);
        ci.selectDB();
        System.out.println("AFTER UPDATING");
        ci.displayRecord();
        System.out.println("UPDATE TESTING DONE");
        
        // testing deleteDB
        System.out.println("DELETE TESTING STARTED");
        ci = new CartItem();
        ci.setCartItemID(nextAvailableCartItemID);
        ci.selectDB();
        System.out.println("BEFORE DELETING");
        ci.displayRecord();
        ci.deleteDB();
        System.out.println("AFTER DELETING");
        ci = new CartItem();
        ci.setCartItemID(nextAvailableCartItemID);
        ci.selectDB();
        ci.displayRecord();
        
    }
}
