package Business;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import net.ucanaccess.jdbc.UcanaccessSQLException;
import java.util.List;


public class Customer {
    private int customerID;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private Address address;
    private String phoneNumber;
    private List<Order> orderList;
    public Customer() {
        customerID = 0;
        firstName = "";
        lastName = "";
        password = "";
        email = "";
        address = new Address();
        phoneNumber = "";
        orderList = new ArrayList<>();
    }
    public Customer(int customerID, String firstName, String lastName, String password, String email, String streetAddress, String city, String state, int zip, String phoneNumber) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.address.setStreetAddress(streetAddress);
        this.address.setCity(city);
        this.address.setState(state);
        this.address.setZipCode(zip);
        this.phoneNumber = phoneNumber;
    }
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return address.getStreetAddress();
    }

    public void setStreet(String streetAddress) {
        address.setStreetAddress(streetAddress);
    }

    public String getCity() {
        return address.getCity();
    }

    public void setCity(String city) {
        address.setCity(city);
    }

    public String getState() {
        return address.getState();
    }

    public void setState(String state) {
        address.setState(state);
    }
    public int getZip() {
        return address.getZipCode();
    }
    public void setZip(int zip) {
        address.setZipCode(zip);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Address getAddress() {
        return address;
    }
    public List<Order> getOrderList() {
        return orderList;
    }
    public void setOrderList() {
        // loading driver and database file
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
            String sql = "select * from Orders where CustomerID = '" + getCustomerID() + "';";
            ResultSet rs = stmt.executeQuery(sql);
            // Loop through the result set and create Order objects
            while (rs.next()) {
                Order order = new Order();
                order.setOrderID(rs.getInt("OrderID"));
                order.setCustomerID(rs.getInt("CustomerID"));
                order.setOrderDate(rs.getString("OrderDate"));
                order.setOrderStatus(rs.getString("OrderStatus"));
                order.setStreetAddress(rs.getString("ShippingStreet"));
                order.setState(rs.getString("ShippingState"));
                order.setZip(rs.getInt("ShippingZip"));
                order.setCreatedAt(rs.getString("CreatedAt"));
                order.setUpdatedAt(rs.getString("UpdatedAt"));
                order.setTotalAmount(rs.getString("TotalAmount"));
                orderList.add(order);
            }
            con.close();            
        } 
        
        catch (UcanaccessSQLException e) {System.out.println("That record doesn't exits");}
        catch (Exception e) {e.printStackTrace();}
    }
    public void selectDBByEmail(String email) {
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
            String sql = "select * from Customers where Email = '" + email + "';";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                customerID = rs.getInt("CustomerID");
                firstName = rs.getString("FirstName");
                lastName = rs.getString("LastName");
                password = rs.getString("Password");
                this.email = rs.getString("Email");                
                address.setStreetAddress(rs.getString("Street"));
                address.setCity(rs.getString("City"));
                address.setState(rs.getString("State"));
                address.setZipCode(rs.getInt("ZipCode"));
                phoneNumber = rs.getString("PhoneNumber");
                setOrderList();
            } else {
                System.out.println("No record found for the given email");
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
            String sql = "select * from Customers where CustomerID = '" + getCustomerID() + "';";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            customerID = rs.getInt("CustomerID");
            firstName = rs.getString("FirstName");
            lastName = rs.getString("LastName");
            password = rs.getString("Password");
            email = rs.getString("Email");
            address.setStreetAddress(rs.getString("Street"));
            address.setCity(rs.getString("City"));
            address.setState(rs.getString("State"));
            address.setZipCode(rs.getInt("ZipCode"));
            phoneNumber = rs.getString("PhoneNumber");
            setOrderList();
            con.close();
            
            ///Users/jasonrodriguez/Dropbox/Desktop-JasonsMacBookAircopy/DESKDOCS/AdvancedSystemProject/Project/Database
            
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
            String sql = "insert into Customers "
                        +"VALUES ( '" + getCustomerID() + "', '" + getFirstName() + "', '" + getLastName() + "', '" + getPassword() + "', '" 
                    + getEmail() + "', '" + this.address.getStreetAddress() + "', '" + this.address.getCity() + "', '" + this.address.getState() + "', '" + this.address.getZipCode() + "', '" + getPhoneNumber() + "');";
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
            String sql = "UPDATE Customers " +
                              "SET FirstName = " + "'" + getFirstName() + "', " +
                              "LastName = " + "'" + getLastName() + "', " +
                              "Password = " + "'" + getPassword() + "', " +
                              "Email = " + "'" + getEmail() + "', " +
                              "Street = " + "'" + getStreet() + "', " +
                              "City = " + "'" + getCity() + "', " +
                              "State = " + "'" + getState() + "', " +
                              "ZipCode = " + "'" + Integer.toString(getZip()) + "', " +
                              "PhoneNumber = " + "'" + getPhoneNumber() + "' " +
                              "WHERE CustomerID = '" + getCustomerID() + "';";
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
            String sql = "delete from Customers where CustomerID = '" + getCustomerID() + "';";
            stmt.executeUpdate(sql);
            con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void displayRecord() {
        System.out.println("CustomerID: " + getCustomerID());
        System.out.println("FirstName: " + getFirstName());
        System.out.println("LastName: " + getLastName());
        System.out.println("Password: " + getPassword());
        System.out.println("Email: " + getEmail());
        System.out.println("Address: " + this.address.toString());
        System.out.println("PhoneNumber: " + getPhoneNumber());
    }
    public static int getNextAutoIncrementIDWithRollback() {
        int nextCustomerID = -1;
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
            String insertSQL = "INSERT INTO Customers (FirstName, LastName) VALUES ('temp', 'temp')";
            stmt.executeUpdate(insertSQL, Statement.RETURN_GENERATED_KEYS);

            // Fetch the auto-incremented ID
            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                nextCustomerID = rs.getInt(1);  // Get the auto-increment value
            }

            // Rollback the insert so it doesn't affect the database
            con.rollback();

            con.setAutoCommit(true);  // End transaction
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

        return nextCustomerID;
    }
    
    public static void printResultSet(ResultSet rs) throws Exception {
        // Get the metadata of the result set
        ResultSetMetaData rsMeta = rs.getMetaData();
        int columnCount = rsMeta.getColumnCount();

        // Print column names
        for (int i = 1; i <= columnCount; i++) {
            System.out.print(rsMeta.getColumnName(i) + "\t");
        }
        System.out.println();

        // Print each row of the result set
        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setCustomerID(2);
        customer.selectDBByEmail("jason@yahoo.com");
        for (Order order : customer.getOrderList()) {
            // Access each order's details
            System.out.println("Order ID: " + order.getOrderID());
            System.out.println("Order Date: " + order.getOrderDate());
            System.out.println("Order Status: " + order.getOrderStatus());
            System.out.println("Address: " + order.getAddress().toString());
            System.out.println("Created At: " + order.getCreatedAt());
            System.out.println("Updated At: " + order.getUpdatedAt());
            System.out.println("Total Amount: " + order.getTotalAmount());
        }
        
        
        
        
        
        
        
        
        
//        // Testing selectDB
//        System.out.println("SELECT TESTING STARTED");
//        Customer customer = new Customer();
//        customer.setCustomerID(1); // Assuming there is a customer with ID 1 in the database
//        customer.selectDB();
//        customer.displayRecord();
//        System.out.println("SELECT TESTING DONE");
//
//        // Testing insertDB
//        System.out.println("INSERT TESTING STARTED");
//        customer = new Customer();
//        int nextAvailableCustomerID = getNextAutoIncrementIDWithRollback();
//        customer.setCustomerID(nextAvailableCustomerID);
//        System.out.println("NEXT AVAILABLE CUSTOMER ID = " + nextAvailableCustomerID);
//        customer.setFirstName("John");
//        customer.setLastName("Doe");
//        customer.setPassword("password123");
//        customer.setEmail("john.doe@example.com");
//        customer.setStreet("123 Elm Street");
//        customer.setCity("Springfield");
//        customer.setState("IL");
//        customer.setZip(62701);
//        customer.setPhoneNumber("555-1234");
//        customer.insertDB();
//        customer = new Customer();
//        customer.setCustomerID(nextAvailableCustomerID);
//        customer.selectDB();
//        customer.displayRecord();
//        System.out.println("INSERT TESTING DONE");
//        
//
//        // Testing updateDB
//        System.out.println("UPDATE TESTING STARTED");
//        customer = new Customer();
//        customer.setCustomerID(nextAvailableCustomerID);
//        customer.selectDB();
//        System.out.println("BEFORE UPDATING");
//        customer.displayRecord();
//        customer.setFirstName("Jane");
//        customer.setLastName("Smith");
//        customer.setPassword("newpassword");
//        customer.setEmail("jane.smith@example.com");
//        customer.setStreet("456 Oak Street");
//        customer.setCity("Capital City");
//        customer.setState("CA");
//        customer.setZip(90210);
//        customer.setPhoneNumber("555-5678");
//        customer.updateDB();
//        customer = new Customer();
//        customer.setCustomerID(nextAvailableCustomerID);
//        customer.selectDB();
//        System.out.println("AFTER UPDATING");
//        customer.displayRecord();
//        System.out.println("UPDATE TESTING DONE");
//
//        
//        // Testing deleteDB
//        System.out.println("DELETE TESTING STARTED");
//        customer = new Customer();
//        customer.setCustomerID(nextAvailableCustomerID);
//        customer.selectDB();
//        System.out.println("BEFORE DELETING");
//        customer.displayRecord();
//        customer.deleteDB();
//        System.out.println("AFTER DELETING");
//        customer = new Customer();
//        customer.setCustomerID(nextAvailableCustomerID);
//        customer.selectDB();
//        customer.displayRecord();

    }
}
