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
            <a href="index.html"><img src="images/hppsl.png" alt="picalt"></a>  
            <div id="myLinks">
              <a href="sign-in.jsp">Sign In</a>
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
            <form action="UpdateOrderStatusServlet" method="POST"> <!-- Form to submit checkbox actions -->
                <table class="order-table">
                    <thead>
                        <tr>
                            <th>Order ID</th>
                            <th>Date</th>
                            <th>Status</th>
                            <th>Total</th>
                            <th>Fulfill/Undo</th>
                        </tr>
                    </thead>
                    <tbody>
                    <% for (Order order : allOrders) { %>
                        <tr>
                            <td><%= order.getOrderID() %></td>
                            <td><%= order.getOrderDate() %></td>
                            <td id="status-<%= order.getOrderID() %>"><%= order.getOrderStatus() %></td>
                            <td>$<%= order.getTotalAmount() %></td>
                            <td><input type="checkbox" name="fulfilledOrders" value="<%= order.getOrderID() %>" onclick="toggleStatus(<%= order.getOrderID() %>)"></td>
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

    <!-- JavaScript to change status between Fulfilled and pending -->
    <script>
        function toggleStatus(orderId) {
            const statusCell = document.getElementById('status-' + orderId);
            const checkbox = document.querySelector('input[value="' + orderId + '"]');
            
            if (checkbox.checked) {
                statusCell.innerHTML = "Fulfilled"; // Mark as Fulfilled
            } else {
                statusCell.innerHTML = "Pending"; // Undo and mark as Pending
            }
        }
    </script>
</body>
</html>
