
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
public class Payment {
    private int paymentID;
    private int orderID;
    private String paymentDate;
    private String paymentMethod;
    private String paymentStatus;
    private String createdAt;
    private String updatedAt;

    public Payment() {
        paymentID = 0;
        orderID = 0;
        paymentDate = "";
        paymentMethod = "";
        paymentStatus = "";
        createdAt = "";
        updatedAt = "";
    }
    public Payment(int paymentID, int orderID, String paymentDate, String paymentMethod, String paymentStatus, String createdAt, String updatedAt) {
        this.paymentID = paymentID;
        this.orderID = orderID;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
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
            String sql = "select * from Payments where PaymentID = '" + getPaymentID() + "';";
            ResultSet rs = stmt.executeQuery(sql);

            rs.next();
            paymentID = Integer.parseInt(rs.getString(1));
            orderID = Integer.parseInt(rs.getString(2));
            paymentDate = rs.getString(3);
            paymentMethod = rs.getString(4);
            paymentStatus = rs.getString(5);
            createdAt = rs.getString(6);
            updatedAt = rs.getString(7);
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
            String sql = "insert into Payments "
                        +"VALUES ( '" + getPaymentID() + "', '" + getOrderID() + "', '" + getPaymentDate() + "', '" + getPaymentMethod() + "', '" 
                    + getPaymentStatus() + "', '" + getCreatedAt() + "', '" + getUpdatedAt() + "');";
            stmt.executeUpdate(sql);
            con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            String sql = "UPDATE Payments " +
                              "SET OrderID = " + "'" + getOrderID() + "', " +
                              "PaymentDate = " + "'" + getPaymentDate() + "', " +
                              "PaymentMethod = " + "'" + getPaymentMethod() + "', " +
                              "PaymentStatus = " + "'" + getPaymentStatus() + "', " +
                              "CreatedAt = " + "'" + getCreatedAt() + "', " +
                              "UpdatedAt = " + "'" + getUpdatedAt() + "' " +
                              "WHERE PaymentID = '" + getPaymentID() + "';";
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
            String sql = "delete from Payments where PaymentID = '" + getPaymentID() + "';";
            stmt.executeUpdate(sql);
            con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static int getNextAutoIncrementIDWithRollback() {
        int nextPaymentID = -1;
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
            String insertSQL = "INSERT INTO Payments (OrderID, PaymentMethod) VALUES ('1', 'temp')";
            stmt.executeUpdate(insertSQL, Statement.RETURN_GENERATED_KEYS);

            // Fetch the auto-incremented ID
            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                nextPaymentID = rs.getInt(1);  // Get the auto-increment value
            }

            // Rollback the insert so it doesn't affect the database
            con.rollback();

            con.setAutoCommit(true);  // End transaction
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

        return nextPaymentID;
    }
    public void displayRecord() {
        System.out.println("PaymentID: " + getPaymentID());
        System.out.println("OrderID: " + getOrderID());
        System.out.println("PaymentDate: " + getPaymentDate());
        System.out.println("PaymentMethod: " + getPaymentMethod());
        System.out.println("PaymentStatus: " + getPaymentStatus());
        System.out.println("CreatedAt: " + getCreatedAt());
        System.out.println("UpdatedAt: " + getUpdatedAt());
    }
    public static void main(String[] args) {
        // Testing selectDB
        System.out.println("SELECT TESTING STARTED");
        Payment payment = new Payment();
        payment.setPaymentID(1);
        payment.selectDB();
        payment.displayRecord();
        System.out.println("SELECT TESTING DONE");
        
        System.out.println("");
        System.out.println("");
        
        // Testing insertDB
        System.out.println("INSERT TESTING STARTED");
        payment = new Payment();
        int nextAvailablePaymentID = getNextAutoIncrementIDWithRollback();
        payment.setPaymentID(nextAvailablePaymentID);
        System.out.println("NEXT AVAILABLE PAYMENT ID = " + nextAvailablePaymentID);
        payment.setOrderID(1);
        payment.setPaymentDate("2024-09-09");
        payment.setPaymentMethod("Debit");
        payment.setPaymentStatus("Paid");
        payment.setCreatedAt("2024-09-09");
        payment.setUpdatedAt("2024-09-09");
        payment.insertDB();
        payment = new Payment();
        payment.setPaymentID(nextAvailablePaymentID);
        payment.selectDB();
        payment.displayRecord();
        System.out.println("INSERT TESTING DONE");
        
        System.out.println("");
        System.out.println("");
        
        // Testing updateDB
        System.out.println("UPDATE TESTING STARTED");
        payment = new Payment();
        payment.setPaymentID(nextAvailablePaymentID);
        payment.selectDB();
        System.out.println("BEFORE UPDATING");
        payment.displayRecord();
        payment.setOrderID(2);
        payment.setPaymentDate("2024-09-09");
        payment.setPaymentMethod("Debit");
        payment.setPaymentStatus("Pending");
        payment.setCreatedAt("2024-09-09");
        payment.setUpdatedAt("2024-09-10");
        payment.updateDB();
        payment = new Payment();
        payment.setPaymentID(nextAvailablePaymentID);
        payment.selectDB();
        System.out.println("AFTER UPDATING");
        payment.displayRecord();
        System.out.println("UPDATE TESTING DONE");
        
        System.out.println("");
        System.out.println("");
        
        // Testing deleteDB
        System.out.println("DELETE TESTING STARTED");
        payment = new Payment();
        payment.setPaymentID(nextAvailablePaymentID);
        payment.selectDB();
        System.out.println("BEFORE DELETING");
        payment.displayRecord();
        payment.deleteDB();
        System.out.println("AFTER DELETING");
        payment = new Payment();
        payment.setPaymentID(nextAvailablePaymentID);
        payment.selectDB();
        payment.displayRecord();
        
    }
    
}
