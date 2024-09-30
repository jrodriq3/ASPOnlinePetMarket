package Business;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import net.ucanaccess.jdbc.UcanaccessSQLException;
import java.util.List;
public class Staff {
    private int staffID;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private List<Order> allOrders;
    private List<Customer> allCustomers;
    

    public Staff() {
        staffID = 0;
        password = "";
        firstName = "";
        lastName = "";
        email = "";
        phoneNumber = "";
        allOrders = new ArrayList<>();
        allCustomers = new ArrayList<>();
    }
    public Staff(int staffID, String password, String firstName, String lastName, String email, String phoneNumber) {
        this.staffID = staffID;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public List<Order> getAllOrders() {
        return allOrders;
    }
    public void setAllOrders() {
        try {
            // loading driver and database file
            allOrders.clear();
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
            String sql = "SELECT * FROM Orders";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Order order = new Order();
                order.setOrderID(rs.getInt("OrderID"));
                order.setCustomerID(rs.getInt("CustomerID"));
                order.setOrderDate(rs.getString("OrderDate"));
                order.setOrderStatus(rs.getString("OrderStatus"));
                order.getAddress().setStreetAddress(rs.getString("ShippingStreet"));
                order.getAddress().setCity(rs.getString("ShippingCity"));
                order.getAddress().setState(rs.getString("ShippingState"));
                order.getAddress().setZipCode(rs.getInt("ShippingZip"));
                order.setCreatedAt(rs.getString("CreatedAt"));
                order.setUpdatedAt(rs.getString("UpdatedAt"));
                
                order.setTotalAmount(rs.getString("TotalAmount"));
                order.setNameOnCard(rs.getString("NameOnCard"));
                
                allOrders.add(order); // Add each order to the list
            }
            con.close();
            
        } 
        
        catch (UcanaccessSQLException e) {System.out.println("That record doesn't exits");}
        catch (Exception e) {e.printStackTrace();}
    }
    public List<Customer> getAllCustomers() {
        return allCustomers;
    }
    public void setAllCustomers() {
        try {
            // loading driver and database file
            allOrders.clear();
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
            String sql = "SELECT * FROM Customers";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomerID(rs.getInt("CustomerID"));
                customer.setFirstName(rs.getString("FirstName"));
                customer.setLastName(rs.getString("LastName"));
                customer.setPassword(rs.getString("Password"));
                customer.setEmail(rs.getString("Email"));
                customer.setStreet(rs.getString("Street"));
                customer.setCity(rs.getString("City"));
                customer.setState(rs.getString("State"));
                customer.setZip(rs.getInt("ZipCode"));
                customer.setPhoneNumber(rs.getString("PhoneNumber"));
                allCustomers.add(customer);
            }
            con.close();
            
        } 
        
        catch (UcanaccessSQLException e) {System.out.println("That record doesn't exits");}
        catch (Exception e) {e.printStackTrace();}
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
            String sql = "select * from Staff where StaffID = '" + getStaffID() + "';";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            staffID = Integer.parseInt(rs.getString(1));
            password = rs.getString(2);
            firstName = rs.getString(3);
            lastName = rs.getString(4);
            email = rs.getString(5);
            phoneNumber = rs.getString(6);
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
            String sql = "insert into Staff "
                        +"VALUES ( '" + getStaffID() + "', '" + getPassword() + "', '" + getFirstName() + "', '" + getLastName() + "', '" 
                    + getEmail() + "', '" + getPhoneNumber() + "');";
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
            String sql = "UPDATE Staff " +
                              "SET Password = " + "'" + getPassword() + "', " +
                              "FirstName = " + "'" + getFirstName() + "', " +
                              "LastName = " + "'" + getLastName()+ "', " +
                              "Email = " + "'" + getEmail() + "', " +
                              "PhoneNumber = " + "'" + getPhoneNumber() + "' " +
                              "WHERE StaffID = '" + getStaffID() + "';";
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
            String sql = "delete from Staff where StaffID = '" + getStaffID() + "';";
            stmt.executeUpdate(sql);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int getNextAutoIncrementIDWithRollback() {
        int nextStaffID = -1;
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
            String insertSQL = "INSERT INTO Staff (FirstName, LastName) VALUES ('temp', 'temp')";
            stmt.executeUpdate(insertSQL, Statement.RETURN_GENERATED_KEYS);

            // Fetch the auto-incremented ID
            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                nextStaffID = rs.getInt(1);  // Get the auto-increment value
            }

            // Rollback the insert so it doesn't affect the database
            con.rollback();

            con.setAutoCommit(true);  // End transaction
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

        return nextStaffID;
    }
    public void displayRecord() {
        System.out.println("StaffID: " + getStaffID());
        System.out.println("Password: " + getPassword());
        System.out.println("FirstName: " + getFirstName());
        System.out.println("LastName: " + getLastName());
        System.out.println("Email: " + getEmail());
        System.out.println("PhoneNumber: " + getPhoneNumber());
    }
    public static void main(String[] args) {
        // testing selectDB
        System.out.println("SELECT TESTING STARTED");
        Staff employee = new Staff();
        employee.setStaffID(1);
        employee.selectDB();
        employee.displayRecord();
        System.out.println("SELECT TESTING DONE");
        
        System.out.println("");
        System.out.println("");
        
        // testing insertDB
        System.out.println("INSERT TESTING STARTED");
        employee = new Staff();
        int nextAvailableStaffID = getNextAutoIncrementIDWithRollback();
        employee.setStaffID(nextAvailableStaffID);
        System.out.println("NEXT AVAILABLE STAFF ID = " + nextAvailableStaffID);
        employee.setPassword("1234");
        employee.setFirstName("Jay");
        employee.setLastName("Rod");
        employee.setEmail("Jay@Yahoo.com");
        employee.setPhoneNumber("7708899253");
        employee.insertDB();
        employee = new Staff();
        employee.setStaffID(nextAvailableStaffID);
        employee.selectDB();
        employee.displayRecord();
        System.out.println("INSERT TESTING DONE");
        
        System.out.println("");
        System.out.println("");
        
        // testing updateDB
        System.out.println("UPDATE TESTING STARTED");
        employee = new Staff();
        employee.setStaffID(nextAvailableStaffID);
        employee.selectDB();
        System.out.println("BEFOR UPDATING");
        employee.displayRecord();
        employee.setFirstName("JayMan");
        employee.updateDB();
        employee = new Staff();
        employee.setStaffID(nextAvailableStaffID);
        employee.selectDB();
        System.out.println("AFTER UPDATING");
        employee.displayRecord();
        System.out.println("UPDATE TESTING DONE");
        
        System.out.println("");
        System.out.println("");
        
        // testing deleteDB
        System.out.println("DELETE TESTING STARTED");
        employee = new Staff();
        employee.setStaffID(nextAvailableStaffID);
        employee.selectDB();
        System.out.println("BEFORE DELETING");
        employee.displayRecord();
        employee.deleteDB();
        System.out.println("AFTER DELETING");
        employee = new Staff();
        employee.setStaffID(nextAvailableStaffID);
        employee.selectDB();
        employee.displayRecord();
        
        
    }
}
