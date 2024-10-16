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
    <link rel="stylesheet" type="text/css" href="style.css"> 
    <style>
/*        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }*/
        h2 {
            color: #339933; 
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            max-width: 800px;
            margin-bottom: 20px;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            overflow: hidden;
        }

        th, td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #339933;
            color: #fff;
        }

        td {
            color: #333;
        }

        tr:last-child td {
            border-bottom: none;
        }
    </style>
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
    <div class="form-container">
        <center><h2>Product Search Results</h2></center>

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
                    <th></th>
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
    </div>
</body>
</html>
