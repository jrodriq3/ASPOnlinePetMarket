<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Business.Product" %>
<%@ page import="Business.ShoppingCart" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Shopping Cart</title>
    <link rel="stylesheet" type="text/css" href="style.css"> 
    <style>
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

        .empty-cart {
            color: #999;
            font-size: 18px;
        }

        form {
            margin-top: 20px;
        }
        .button-link {
            margin-top: 5px;
            background-color: #339933; 
            color: #fff;
            padding: 12px 25px;
            border: none;
            border-radius: 4px;
            text-decoration: none;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button {
            background-color: #339933; 
            color: #fff;
            padding: 12px 25px;
            border: none;
            border-radius: 4px;
            text-decoration: none;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #66cc66; 
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
    <%
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        if (cart == null || cart.getProductList().isEmpty()) {
    %>
        <p class="empty-cart">Your cart is empty.</p>
    <%
        } else {
    %>
        <h2>Your Shopping Cart</h2>
        <table>
            <tr>
                <th>Product ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Category</th>
                <th>Stock Quantity</th>
                <th>Price</th>
            </tr>
            <c:forEach var="product" items="${cart.productList}">
                <tr>
                    <td>${product.productID}</td>
                    <td>${product.productName}</td>
                    <td>${product.productDescription}</td>
                    <td>${product.category}</td>
                    <td>${product.stockQuantity}</td>
                    <td>$${product.productPrice}</td>
                </tr>
            </c:forEach>
        </table>
        <form action="CheckoutRedirectServlet" method="POST">
            <button type="submit">Go to Checkout</button>
        </form>
        <a href="ProductsServlet" class="button-link">Continue Shopping</a>
        <a href="javascript:history.back()" class="button-link">Go Back</a>
    <%
        }
    %>
</body>
</html>
