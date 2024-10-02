<%-- 
    Document   : staff-manage-products
    Created on : Oct 1, 2024, 4:57:23 PM
    Author     : jason
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Business.Staff"%>
<%@page import="java.util.List"%>
<%@page import="Business.Product"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Staff Manage Products</title>
        <link rel="stylesheet" type="text/css" href="style.css"> 
    </head>
    <body>
        <div class="Banner">
            <a href="index.html"><img src="images/hppsl.png" alt="picalt"></a>  
            <div id="myLinks">
              <a href="sign-in.jsp">Sign In</a>
              <a href="ProductsServlet">Products</a>
              <a href="faq.jsp">FAQ</a>
            </div>
        </div>
        <div class="spacer"></div>
        <div class="product-container">
        <% 
            Staff staffMember = (Staff)session.getAttribute("staffMember");
            if (staffMember != null) {
                List<Product> allProducts = staffMember.getAllProducts();
        %>
            <div class="order-list">
                <h2>Product List</h2>
                <form action="EditProductServlet" method="POST">
                    <table class="product-table">
                        <thead>
                            <tr>
                                <th>Select</th>
                                <th>Product ID</th>
                                <th>Product Name</th>
                                <th>Product Description</th>
                                <th>Stock Quantity</th>
                                <th>Category</th>
                                <th>Product Price</th>
                            </tr>
                        </thead>
                        <tbody>
                        <% for (Product product: allProducts) { %>
                            <tr>
                                <td><input type="radio" name="productID" value="<%= product.getProductID() %>" required></td>
                                <td><%= product.getProductID() %></td>
                                <td><%= product.getProductName() %></td>
                                <td><%= product.getProductDescription() %></td>
                                <td><%= product.getStockQuantity() %></td>
                                <td><%= product.getCategory() %></td>
                                <td><%= product.getProductPrice() %></td>
                            </tr>
                        <% } %>
                        </tbody>
                    </table>
                    <!-- Submit button -->
                    <button type="submit" class="update-button">Edit Product</button> 
                </form>
            </div>
            <%
                }
            %>
        </div> 
    </body>
</html>
