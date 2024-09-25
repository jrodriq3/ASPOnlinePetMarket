<%-- 
    Document   : search-results
    Created on : Sep 10, 2024, 7:37:29 AM
    Author     : jason
--%>
<%@ page import="java.util.List" %>
<%@ page import="Business.Product" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Search Results</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
    </style>
</head>
<body>
    <h2>Product Search Results</h2>

    <%
        // Retrieve the list of products from the request attribute set by the servlet or business object
        List<Product> products = (List<Product>) request.getAttribute("products");

        if (products != null && !products.isEmpty()) {
    %>
        <table>
            <tr>
                <th>Product ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Category</th>
                <th>Stock Quantity</th>
                <th>Price</th>
            </tr>
            <%
                // Loop through the products and display them in a table
                for (Product product : products) {
            %>
                <tr>
                    <td><%= product.getProductID() %></td>
                    <td><%= product.getProductName() %></td>
                    <td><%= product.getProductDescription() %></td>
                    <td><%= product.getCategory() %></td>
                    <td><%= product.getStockQuantity() %></td>
                    <td>$<%= product.getProductPrice() %></td>
                    <td>
                        <form action="ShoppingCartServlet" method="POST">
                            <input type="hidden" name="productID" value="<%= product.getProductID() %>" />
                            <button type="submit">Add to Cart</button>
                        </form>
                    </td>
                </tr>
                <!-- Add to Cart Button -->
                
                
            <%
                }
            %>
        </table>
    <%
        } else {
    %>
        <p>No products found for the given search keyword.</p>
    <%
        }
    %>
</body>
</html>
