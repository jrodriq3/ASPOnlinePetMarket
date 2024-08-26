/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
    public void selectDB() {
        try {
            // loading driver and database file

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");


            String conURL = "jdbc:ucanaccess:///Users/jasonrodriguez/Dropbox/Desktop-JasonsMacBookAircopy/DESKDOCS/AdvancedSystemProject/Project/Database/PetStoreASPDatabase.accdb";


            Connection con = DriverManager.getConnection(conURL);
            Statement stmt = con.createStatement();
            String sql = "select * from Products where ProductID = '" + getProductID() + "';";
            System.out.println("this ran");
            ResultSet rs = stmt.executeQuery(sql);

            rs.next();
            
            productID = Integer.parseInt(rs.getString(1));
            
            productName = rs.getString(2);
            productDescription = rs.getString(3);
            
            stockQuantity = Integer.parseInt(rs.getString(4));
            category = rs.getString(5);
            productPrice = Double.parseDouble(rs.getString(6));
            con.close();
            ///Users/jasonrodriguez/Dropbox/Desktop-JasonsMacBookAircopy/DESKDOCS/AdvancedSystemProject/Project/Database
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        
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
        Product p = new Product();
        p.setProductID(1);
        p.selectDB();
        p.displayRecord();
    }
            
}
