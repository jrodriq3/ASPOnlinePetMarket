<%-- 
    Document   : staff-manage-customers
    Created on : Sep 30, 2024, 9:24:07 AM
    Author     : jason
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Business.Staff"%>
<%@page import="java.util.List"%>
<%@page import="Business.Order"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Staff Manage Orders</title>
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
        <div class="order-container">
        <% 
            Staff staffMember = (Staff)session.getAttribute("staffMember");
            if (staffMember != null) {
                List<Order> allOrders = staffMember.getAllOrders();
        %>
            <div class="order-list">
                <h2>Order List</h2>
                <form action="EditOrderServlet" method="POST">
                    <table class="order-table">
                        <thead>
                            <tr>
                                <th>Select</th>
                                <th>Order ID</th>
                                <th>Customer ID</th>
                                <th>Order Date</th>
                                <th>Order Status</th>
                                <th>Address</th>
                                <th>Created At</th>
                                <th>Updated At</th>
                                <th>Total Amount</th>
                                <th>Name On Card</th>
                            </tr>
                        </thead>
                        <tbody>
                        <% for (Order order: allOrders) { %>
                            <tr>
                                <td><input type="radio" name="orderID" value="<%= order.getOrderID() %>" required></td>
                                <td><%= order.getOrderID() %></td>
                                <td><%= order.getCustomerID() %></td>
                                <td><%= order.getOrderDate() %></td>
                                <td><%= order.getOrderStatus() %></td>
                                <td><%= order.getAddress() %></td>
                                <td><%= order.getCreatedAt() %></td>
                                <td><%= order.getUpdatedAt() %></td>
                                <td><%= order.getTotalAmount() %></td>
                                <td><%= order.getNameOnCard() %></td>
                            </tr>
                        <% } %>
                        </tbody>
                    </table>
                    <!-- Submit button -->
                    <button type="submit" class="update-button">Edit Order</button> 
                </form>
            </div>
            <%
                }
            %>
        </div> 
    </body>
</html>
