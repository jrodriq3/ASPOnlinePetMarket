
<!-- testing-->

<%-- 
    Document   : confirmation
    Created on : Sep 11, 2024, 2:57:15 PM
    Author     : jason
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Business.Order" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Confirmation</title>
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
    <div class="confirmation-container">
        <h1 class="confirmation-title">Thank You for Your Order!</h1>
        
        <p>Your order has been successfully placed. Here are the details:</p>
        <%Order order = (Order) session.getAttribute("order");%>

        <!-- Order Summary -->
        <div class="confirmation-section">
            <h2>Order Summary</h2>
            <p><strong>Order Number:</strong> <%= order.getOrderID() %></p>
            <p><strong>Name On Card:</strong> <%= order.getNameOnCard() %></p>
            <p><strong>Shipping Address:</strong></p>
            <p><%= order.getStreetAddress() %>, <%= order.getCity() %>, 
               <%= order.getState() %> - <%= order.getZip() %></p>
            <p><strong>Total Amount:</strong> $<%= order.getTotalAmount() %></p>
        </div>

        

        <!-- Call to Action -->
        <div class="confirmation-actions">
            <p>You will receive a confirmation email shortly. If you have any questions, feel free to <a href="contact.jsp">contact us</a>.</p>
            <a href="index.html" class="confirmation-button">Continue Shopping</a>
        </div>
    </div>
</body>
</html>
