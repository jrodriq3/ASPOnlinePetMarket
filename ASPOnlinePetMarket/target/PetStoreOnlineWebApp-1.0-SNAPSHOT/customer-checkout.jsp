<%-- 
    Document   : customer-checkout
    Created on : Sep 10, 2024, 7:23:02 PM
    Author     : Grace
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Business.Product" %>
<%@ page import="Business.ShoppingCart" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Checkout</title>
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
    <div class="form-container">
        <br> <br>
        <h1 class="checkout-title">Customer Checkout</h1>
        
        <!-- Shopping Cart Summary -->
        <div class="checkout-section">
            <h2>Your Cart</h2>
            <table>
                <thead>
                    <tr>
                        <th>Product Name</th>
                        <th>Price</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
                        double total = 0.0;
                        if (cart != null) {
                            for (Product product : cart.getProductList()) {
                    %>
                    <tr>
                        <td><%= product.getProductName() %></td>
                        <td>$<%= product.getProductPrice() %></td>
                    </tr>
                    <%
                                total += product.getProductPrice();
                            }
                    %>
                    <tr>
                        <td><strong>Total:</strong></td>
                        <td><strong>$<%= total %></strong></td>
                    </tr>
                    <%
                        } else {
                    %>
                    <tr>
                        <td colspan="2">Your cart is empty.</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>

        <form action="CustomerCheckoutServlet" method="POST">
            <!-- Include the total amount as a hidden field -->
            <input type="hidden" name="totalAmount" value="<%= total %>">
            <!-- Shipping information -->
            <div class="checkout-section">
                <h2>Shipping Information</h2>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="text" id="email" name="email"  required>
                </div>
                <div class="form-group">
                    <label for="name-on-card">Name On Card:</label>
                    <input type="text" id="name-on-card" name="name-on-card"  required>
                </div>
                <div class="form-group">
                    <label for="address">Address:</label>
                    <input type="text" id="address" name="address"  required>
                </div>
                <div class="form-group">
                    <label for="city">City:</label>
                    <input type="text" id="city" name="city"  required>
                </div>
                <div class="form-group">
                    <label for="zipcode">Zip Code:</label>
                    <input type="text" id="zipcode" name="zipcode"  required>
                </div>
                <div class="form-group">
                    <label for="state">State:</label>
                    <input type="text" id="state" name="state" required>
                </div>
            </div>

            <!-- Payment Info -->
            <div class="checkout-section">
                <h2>Payment Information</h2>
                <div class="form-group">
                    <label for="cardnumber">Card Number:</label>
                    <input type="text" id="cardnumber" name="cardnumber" required>
                </div>
                <div class="form-group">
                    <label for="expiry">Expiry Date:</label>
                    <input type="text" id="expiry" name="expiry"  required>
                </div>
                <div class="form-group">
                    <label for="cvv">CVV:</label>
                    <input type="text" id="cvv" name="cvv" required>
                </div>
            </div>

            <button type="submit" class="checkout-button">Place Order</button>
        </form>
    </div>
</body>
</html>
