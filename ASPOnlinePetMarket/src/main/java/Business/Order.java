package Business;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import net.ucanaccess.jdbc.UcanaccessSQLException;
import java.util.List;

public class Order {
    private int orderID;
    private int customerID;
    private String orderDate;
    private String orderStatus;
    private Address address;
    private String createdAt;
    private String updatedAt;
    private String totalAmount;
    private String nameOnCard;
    private List<OrderItem> orderItems;
    public Order() {
        orderID = 0;
        customerID = 0;
        orderDate = "2000-01-01";
        orderStatus = "";
        address = new Address();
        createdAt = "2000-01-01";
        updatedAt = "2000-01-01";
        totalAmount = "0.0";
        nameOnCard = "";
        orderItems = new ArrayList<>();
        
    }

    public Order(int orderID, int customerID, String orderDate, String orderStatus, Address address, String createdAt, String updatedAt, String totalAmount, String nameOnCard) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.address = address;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.totalAmount = totalAmount;
        this.nameOnCard = nameOnCard;

    }
    public String getNameOnCard() {
        return nameOnCard;
    }
    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }
    public String getStreetAddress() {
        return address.getStreetAddress();
    }
    public void setStreetAddress(String streetAddress) {
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
    public void addOrderItem(int productID) {
        Product product = new Product();
        product.setProductID(productID);
        product.selectDB();
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderItemID(OrderItem.getNextAutoIncrementIDWithRollback());
        orderItem.setOrderID(getOrderID());
        orderItem.setPrice(product.getProductPrice());
        orderItem.setProductID(productID);
        orderItem.setQuantity(1);
        orderItem.setCreatedAt("2000-01-01");
        orderItem.setUpdatedAt("2000-01-01");
        orderItem.setProductName();
        
        
    }
    public void setOrderItems() {
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
            String sql = "select * from OrderItems where OrderID = '" + getOrderID() + "';";
            ResultSet rs = stmt.executeQuery(sql);
            // Loop through the result set and create Order objects
            while (rs.next()) {
                OrderItem orderItem = new OrderItem();
                orderItem.setOrderItemID(rs.getInt("OrderItemID"));
                orderItem.selectDB();
                orderItems.add(orderItem);
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
            String sql = "select * from Orders where OrderID = '" + getOrderID() + "';";
            ResultSet rs = stmt.executeQuery(sql);
            
            rs.next();
            
            orderID = Integer.parseInt(rs.getString("OrderID"));
            customerID = Integer.parseInt(rs.getString("CustomerID"));
            orderDate = rs.getString("OrderDate");
            orderStatus = rs.getString("OrderStatus");
            
            address.setStreetAddress(rs.getString("ShippingStreet"));
            
            address.setState(rs.getString("ShippingState"));
            address.setZipCode(Integer.parseInt(rs.getString("ShippingZip")));
            address.setCity(rs.getString("ShippingCity"));
            createdAt = rs.getString("CreatedAt");
            updatedAt = rs.getString("UpdatedAt");
            
            totalAmount = rs.getString("TotalAmount");
            
            
            nameOnCard = rs.getString("NameOnCard");
            setOrderItems();
            
            
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
            String sql = "insert into Orders "
                        +"VALUES ( '" + getOrderID() + "', '" + getCustomerID()+ "', '" + getOrderDate()+ "', '" + getOrderStatus()+ "', '" 
                    + this.address.getStreetAddress() + "', '" + this.address.getState() + "', '" + this.address.getZipCode()+ "', '" + getCreatedAt() + "', '" + getUpdatedAt() + "', '" + getTotalAmount() + "', '" + this.address.getCity() + "', '" + getNameOnCard() + "');";
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
            String sql = "UPDATE Orders " +
                              "SET CustomerID = " + "'" + getCustomerID()+ "', " +
                              "OrderDate = " + "'" + getOrderDate()+ "', " +
                              "OrderStatus = " + "'" + getOrderStatus()+ "', " +
                              "ShippingStreet = " + "'" + getStreetAddress()+ "', " +
                              "ShippingCity = " + "'" + getCity()+ "', " +
                              "ShippingState = " + "'" + getState()+ "', " +
                              "ShippingZip = " + "'" + getZip()+ "', " +
                              "CreatedAt = " + "'" + getCreatedAt() + "', " +
                              "UpdatedAt = " + "'" + getUpdatedAt()+ "', " +
                              "NameOnCard = " + "'" + getNameOnCard() + "', " +
                              "TotalAmount = " + "'" + getTotalAmount()+ "' " +
                              "WHERE OrderID = '" + getOrderID() + "';";
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
            String sql = "delete from Orders where OrderID = '" + getOrderID() + "';";
            stmt.executeUpdate(sql);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void displayRecord() {
        System.out.println("OrderID: " + getOrderID());
        System.out.println("CustomerID: " + getCustomerID());
        System.out.println("OrderDate: " + getOrderDate());
        System.out.println("OrderStatus: " + getOrderStatus());
        System.out.println("Address: " + this.address.toString());
        
        System.out.println("CreatedAt: " + getCreatedAt());
        System.out.println("UpdatedAt: " + getUpdatedAt());
        System.out.println("TotalAmount: " + getTotalAmount());
        System.out.println("NameOnCard: " + getNameOnCard());
        
        
    }
    public static int getNextAutoIncrementIDWithRollback() {
        int nextOrderID = -1;
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
            String insertSQL = "INSERT INTO Orders (CustomerID, OrderStatus) VALUES ('1', 'Pending')";
            stmt.executeUpdate(insertSQL, Statement.RETURN_GENERATED_KEYS);

            // Fetch the auto-incremented ID
            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                nextOrderID = rs.getInt(1);  // Get the auto-increment value
            }

            // Rollback the insert so it doesn't affect the database
            con.rollback();

            con.setAutoCommit(true);  // End transaction
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

        return nextOrderID;
    }
    public static void main(String[] args) {
        Order order = new Order();
        order.setOrderID(1);
        order.selectDB();
        for (OrderItem orderItem : order.getOrderItems()) {
            // Access each order's details
            System.out.println("Order Item ID: " + orderItem.getOrderItemID());
            System.out.println("Order ID: " + orderItem.getOrderID());
            System.out.println("ProductID: " + orderItem.getProductID());
            System.out.println("ProductName: " + orderItem.getProductName());
            System.out.println("Price: " + orderItem.getPrice());
            System.out.println("Created At: " + orderItem.getCreatedAt());
            System.out.println("Updated At: " + orderItem.getUpdatedAt());

        }
        
        
        
        
        
        
        
//        // Testing selectDB
//        System.out.println("SELECT TESTING STARTED");
//        Order order = new Order();
//        order.setOrderID(1);
//        order.selectDB();
//        order.displayRecord();
//        System.out.println("SELECT TESTING DONE");
//
//        System.out.println("");
//        System.out.println("");
//        
//        
//        // Testing insertDB
//        System.out.println("INSERT TESTING STARTED");
//        order = new Order();
//        int nextAvailableOrderID = getNextAutoIncrementIDWithRollback();
//        order.setOrderID(nextAvailableOrderID);
//        System.out.println("NEXT AVAILABLE ORDER ID = " + nextAvailableOrderID);
//        order.setCustomerID(1);
//        order.setOrderDate("2024-09-08");
//        order.setOrderStatus("Pending");
//        order.setStreetAddress("123 Pet Street");
//        order.setCity("Petville");
//        order.setState("CA");
//        order.setZip(90210);
//        order.setCreatedAt("2024-09-08");
//        order.setUpdatedAt("2024-09-08");
//        order.setTotalAmount("150.00");
//        order.insertDB();
//        order = new Order();
//        order.setOrderID(nextAvailableOrderID);
//        order.selectDB();
//        order.displayRecord();
//        System.out.println("INSERT TESTING DONE");
//        
//        System.out.println("");
//        System.out.println("");
//
//        // Testing updateDB
//        System.out.println("UPDATE TESTING STARTED");
//        order = new Order();
//        order.setOrderID(nextAvailableOrderID);
//        order.selectDB();
//        System.out.println("BEFORE UPDATING");
//        order.displayRecord();
//        order.setOrderStatus("Shipped");
//        order.updateDB();
//        order = new Order();
//        order.setOrderID(nextAvailableOrderID);
//        order.selectDB();
//        System.out.println("AFTER UPDATING");
//        order.displayRecord();
//        System.out.println("UPDATE TESTING DONE");
//        
//        System.out.println("");
//        System.out.println("");
//
//        // Testing deleteDB
//        System.out.println("DELETE TESTING STARTED");
//        order = new Order();
//        order.setOrderID(nextAvailableOrderID);
//        order.selectDB();
//        System.out.println("BEFORE DELETING");
//        order.displayRecord();
//        order.deleteDB();
//        System.out.println("AFTER DELETING");
//        order = new Order();
//        order.setOrderID(nextAvailableOrderID);
//        order.selectDB();
//        order.displayRecord();
//        System.out.println("DELETE TESTING DONE");
        
        
    }
}
