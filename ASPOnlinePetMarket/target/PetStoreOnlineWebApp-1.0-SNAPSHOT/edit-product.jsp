<%-- 
    Document   : edit-product
    Created on : Oct 1, 2024, 3:55:16 PM
    Author     : jason
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Business.Product"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Edit Product</title>
        <link rel="stylesheet" type="text/css" href="style.css"> 
    </head>
    <body>
        <div class="Banner">
            <a href="home.jsp"><img src="images/hppsl.png" alt="picalt"></a>  
            <div id="myLinks">
              <%
                  // Check if there is a customer or staffMember in the session
                  if (session.getAttribute("customer") != null || session.getAttribute("staffMember") != null) {
              %>
                  <a href="sign-out.jsp">Sign Out</a>
              <%
                  } else {
              %>
                  <a href="sign-in.jsp">Sign In</a>
              <%
                  }
              %>
              <a href="ProductsServlet">Products</a>
              <a href="faq.jsp">FAQ</a>
            </div>
        </div>
        <div class="spacer"></div>

        <div class="edit-product-container">
            <h2>Edit Product Details</h2>
            
            <% 
                // Retrieve the product object from the request
                Product product = (Product) request.getAttribute("product");
                if (product != null) {
            %>
            <form action="UpdateProductServlet" method="POST">
                <!-- Hidden input to store the product ID (unchangeable) -->
                <input type="hidden" name="productID" value="<%= product.getProductID() %>">

                <!-- Editable fields for product information -->
                <div class="form-group">
                    <label for="productName">Product Name:</label>
                    <input type="text" id="productName" name="productName" value="<%= product.getProductName() %>" required>
                </div>

                <div class="form-group">
                    <label for="productDescription">Product Description:</label>
                    <input type="text" id="productDescription" name="productDescription" value="<%= product.getProductDescription() %>" required>
                </div>

                <div class="form-group">
                    <label for="stockQuantity">Stock Quantity:</label>
                    <input type="text" id="stockQuantity" name="stockQuantity" value="<%= product.getStockQuantity() %>" required>
                </div>

                <div class="form-group">
                    <label for="category">Category:</label>
                    <input type="text" id="category" name="category" value="<%= product.getCategory() %>" required>
                </div>
                <div class="form-group">
                    <label for="productPrice">Product Price:</label>
                    <input type="text" id="productPrice" name="productPrice" value="<%= product.getProductPrice() %>" required>
                </div>
                

                <!-- Submit button to update product details -->
                <button type="submit" class="submit-button">Update Product</button>
            </form>
            <% 
                } else {
                    // If no product object is found, display an error message
                    out.println("<p>No product data available for editing.</p>");
                }
            %>
        </div>
    </body>
</html>