<%-- 
    Document   : customer-profile
    Created on : Sep 10, 2024, 6:59:22 PM
    Author     : Grace
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Business.Customer"%>
<%@page import="Business.Order"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Profile</title>
    <link rel="stylesheet" type="text/css" href="style.css"> <!-- Link to CSS file -->
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
        <h1 class="form-title">Customer Profile</h1>
        <%
            Customer customer = (Customer)session.getAttribute("customer");
            if (customer != null) {
            
        %>
        <!-- temporary customer info-->
        <div class="account-info">
            <h2>Account Information</h2>
            <p><strong>First Name:</strong> <%= customer.getFirstName() %></p>
            <p><strong>Last Name:</strong> <%= customer.getLastName() %></p>
            <p><strong>Email:</strong> <%= customer.getEmail() %></p>
            <p><strong>Address:</strong> <%= customer.getAddress().toString() %></p>
            <p><strong>Phone:</strong> <%= customer.getPhoneNumber() %></p>
        </div>
        <!-- Order History: ID, Date, status, and total-->
        <div class="order-history">
            <h2>Order History</h2>
            <table class="common-table">
                <thead>
                    <tr>
                        <th>Order ID</th>
                        <th>Date</th>
                        <th>Status</th>
                        <th>Total</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        // Assuming you have a method in Customer class that returns a list of orders
                        List<Order> orders = customer.getOrderList();
                        for (Order order : orders) {
                    %>
                    <tr>
                        <td><%= order.getOrderID() %></td>
                        <td><%= order.getCreatedAt() %></td>
                        <td><%= order.getOrderStatus() %></td>
                        <td>$<%= order.getTotalAmount() %></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
        <!-- Link to edit profile page -->
        <a href="edit-profile.jsp" class="edit-button">Edit Profile</a> 
        <%
            } else {
        %>
        <p>Customer information is not available. Please sign in again.</p>
        <%
            }
        %>
    </div>
</body>
</html>
