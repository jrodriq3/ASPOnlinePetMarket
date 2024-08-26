package Business;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.ResultSetMetaData;


/**
 *
 * @author jasonrodriguez
 */
public class Customer {
    private int customerID;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private Address address;
    private String phoneNumber;
    public Customer() {
        customerID = 0;
        firstName = "";
        lastName = "";
        password = "";
        email = "";
        address = new Address();
        phoneNumber = "";
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
    public void selectDB() {
        try {
            // loading driver and database file

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");


            String conURL = "jdbc:ucanaccess:///Users/jasonrodriguez/Dropbox/Desktop-JasonsMacBookAircopy/DESKDOCS/AdvancedSystemProject/Project/Database/PetStoreASPDatabase.accdb";


            Connection con = DriverManager.getConnection(conURL);
            Statement stmt = con.createStatement();
            String sql = "select * from Customers where CustomerID = '" + getCustomerID() + "';";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            customerID = Integer.parseInt(rs.getString(1));
            firstName = rs.getString(2);
            lastName = rs.getString(3);
            password = rs.getString(4);
            email = rs.getString(5);
            address.setStreetAddress(rs.getString(6));
            address.setCity(rs.getString(7));
            address.setState(rs.getString(8));
            address.setZipCode(Integer.parseInt(rs.getString(9)));
            phoneNumber = rs.getString(10);
            con.close();
            ///Users/jasonrodriguez/Dropbox/Desktop-JasonsMacBookAircopy/DESKDOCS/AdvancedSystemProject/Project/Database
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        
    }
    public void insertDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String conURL = "jdbc:ucanaccess:///Users/jasonrodriguez/Dropbox/Desktop-JasonsMacBookAircopy/DESKDOCS/AdvancedSystemProject/Project/Database/PetStoreASPDatabase.accdb";
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
            String conURL = "jdbc:ucanaccess:///Users/jasonrodriguez/Dropbox/Desktop-JasonsMacBookAircopy/DESKDOCS/AdvancedSystemProject/Project/Database/PetStoreASPDatabase.accdb";
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
            String conURL = "jdbc:ucanaccess:///Users/jasonrodriguez/Dropbox/Desktop-JasonsMacBookAircopy/DESKDOCS/AdvancedSystemProject/Project/Database/PetStoreASPDatabase.accdb";
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
    public static int getNextAvailableCustomerID() {
        int nextCustomerID = 1; // Default starting ID if the table is empty
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Load the JDBC driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            // Establish a connection to the database
            String conURL = "jdbc:ucanaccess:///Users/jasonrodriguez/Dropbox/Desktop-JasonsMacBookAircopy/DESKDOCS/AdvancedSystemProject/Project/Database/PetStoreASPDatabase.accdb";
            con = DriverManager.getConnection(conURL);

            // Create a statement to execute SQL queries
            stmt = con.createStatement();
            String sql = "SELECT MAX(CustomerID) AS maxID FROM Customers";
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                int maxID = rs.getInt("maxID");
                
                nextCustomerID = maxID + 1; // Increment by 1
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
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
        
        Customer billy = new Customer();

        billy.setCustomerID(2);
        billy.selectDB();
        billy.displayRecord();

    }
}
