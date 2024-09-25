
package Business;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductSearch {
    private String searchTerm;

    public ProductSearch(String searchTerm) {
        this.searchTerm = searchTerm;
    }
    public List<Product> searchProducts() {
        List<Product> productList = new ArrayList<>();
        
        try {
            // Database connection logic
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

            // SQL query to search for products containing the search term
            String sql = "SELECT * FROM Products WHERE productName LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);            
            ps.setString(1, "%" + searchTerm + "%"); // Search for products that contain the search term
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt("ProductID"));
                product.setProductName(rs.getString("ProductName"));
                product.setProductDescription(rs.getString("ProductDescription"));
                product.setStockQuantity(rs.getInt("StockQuantity"));
                product.setCategory(rs.getString("Category"));
                product.setProductPrice(rs.getDouble("ProductPrice"));

                productList.add(product);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productList;
    }
    public static void main(String[] args) {
        System.out.println("TESTING ProductSearch");

        ProductSearch search = new ProductSearch("dog");
        List<Product> products = search.searchProducts();

        // Print the products found for testing purposes
        if (products.isEmpty()) {
            System.out.println("No products found.");
        } else {
            for (Product product : products) {
                System.out.println("Product ID: " + product.getProductID());
                System.out.println("Product Name: " + product.getProductName());
                System.out.println("Product Description: " + product.getProductDescription());
                System.out.println("Stock Quantity: " + product.getStockQuantity());
                System.out.println("Category: " + product.getCategory());  
                System.out.println("Product Price: " + product.getProductPrice());
                System.out.println("");
            }
        }

        System.out.println("ENDING ProductSearch");
    }
}
