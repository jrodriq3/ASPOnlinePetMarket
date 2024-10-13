<%-- 
    Document   : staff-profile
    Created on : Sep 10, 2024, 7:13:31 PM
    Author     : Grace
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Business.Staff"%>
<%@page import="Business.Order"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Staff Profile</title>
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
    <div class="profile-container">
        <h1 class="profile-title">Staff Profile</h1>
        <% 
            Staff staffMember = (Staff)session.getAttribute("staffMember");
            if (staffMember != null) {
                staffMember.setAllOrders(); // Populate the list of all orders
                List<Order> allOrders = staffMember.getAllOrders();
                session.setAttribute("allOrders", allOrders);
        %>

        <!-- Staff Info -->
        <div class="account-info">
            <h2>Account Information</h2>
            <p><strong>First Name:</strong> <%= staffMember.getFirstName() %></p>
            <p><strong>Last Name:</strong> <%= staffMember.getLastName() %></p>
            <p><strong>Email:</strong> <%= staffMember.getEmail() %></p>
            <p><strong>Phone Number:</strong> <%= staffMember.getPhoneNumber() %></p>
        </div>
        
        <!-- Orders -->
        <div class="order-history">
            <h2>Orders to Fulfill</h2>
            <form action="UpdateOrderStatusServlet" method="POST">
                <table class="order-table">
                    <thead>
                        <tr>
                            <th>Order ID</th>
                            <th>Date</th>
                            <th>Total</th>
                            <th>Status</th>
                            <th>Change Status</th>
                        </tr>
                    </thead>
                    <tbody>
                    <% for (Order order : allOrders) { %>
                        <tr>
                            <td><%= order.getOrderID() %></td>
                            <td><%= order.getOrderDate() %></td>
                            <td>$<%= order.getTotalAmount() %></td>
                            <td><%= order.getOrderStatus() %></td>
                            <td>
                                <select name="orderStatus_<%= order.getOrderID() %>">
                                    <option value="Pending"
                                        <% if (order.getOrderStatus().equals("Pending")) { %>
                                            selected
                                        <% } %>
                                    >Pending</option>
                                    <option value="Fulfilled"
                                        <% if (order.getOrderStatus().equals("Fulfilled")) { %>
                                            selected
                                        <% } %>
                                    >Fulfilled</option>
                                </select>
                            </td>
                        </tr>
                    <% } %>
                    </tbody>
                </table>
                <!-- Submit button -->
                <button type="submit" class="update-button">Update Order Status</button> 
            </form>
        </div>
        <%
            }
        %>
    </div>
</body>
</html>
