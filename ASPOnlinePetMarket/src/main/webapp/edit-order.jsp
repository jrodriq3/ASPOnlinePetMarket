<%-- 
    Document   : edit-order
    Created on : Oct 1, 2024, 3:55:16 PM
    Author     : jason rodriguez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Business.Order"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Edit Order</title>
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

        <div class="edit-customer-container">
            <h2>Edit Order Details</h2>
            
            <% 
                // Retrieve the order object from the request
                Order order = (Order) request.getAttribute("order");
                if (order != null) {
            %>
            <form action="UpdateOrderServlet" method="POST">
                <!-- Hidden input to store the order ID (unchangeable) -->
                <input type="hidden" name="orderID" value="<%= order.getOrderID() %>">

                <!-- Editable fields for order information -->
                <div class="form-group">
                    <label for="customerID">Customer ID:</label>
                    <input type="text" id="customerID" name="customerID" value="<%= order.getCustomerID() %>" required>
                </div>

                <div class="form-group">
                    <label for="orderDate">Order Date:</label>
                    <input type="text" id="orderDate" name="orderDate" value="<%= order.getOrderDate() %>" required>
                </div>

                <div class="form-group">
                    <label for="orderStatus">Order Status:</label>
                    <input type="orderStatus" id="orderStatus" name="orderStatus" value="<%= order.getOrderStatus() %>" required>
                </div>

                <div class="form-group">
                    <label for="street">Street:</label>
                    <input type="text" id="street" name="street" value="<%= order.getStreetAddress() %>" required>
                </div>
                <div class="form-group">
                    <label for="city">City:</label>
                    <input type="text" id="city" name="city" value="<%= order.getCity() %>" required>
                </div>
                <div class="form-group">
                    <label for="state">State:</label>
                    <input type="text" id="state" name="state" value="<%= order.getState() %>" required>
                </div>
                <div class="form-group">
                    <label for="zip">Zip:</label>
                    <input type="text" id="zip" name="zip" value="<%= order.getZip() %>" required>
                </div>
                <div class="form-group">
                    <label for="createdAt">Created At:</label>
                    <input type="text" id="createdAt" name="createdAt" value="<%= order.getCreatedAt() %>" required>
                </div>
                <div class="form-group">
                    <label for="updatedAt">Updated At:</label>
                    <input type="text" id="updatedAt" name="updatedAt" value="<%= order.getUpdatedAt() %>" required>
                </div>
                <div class="form-group">
                    <label for="totalAmount">Total Amount:</label>
                    <input type="totalAmount" id="totalAmount" name="totalAmount" value="<%= order.getTotalAmount() %>" required>
                </div>
                <div class="form-group">
                    <label for="nameOnCard">Name On Card:</label>
                    <input type="nameOnCard" id="nameOnCard" name="nameOnCard" value="<%= order.getNameOnCard() %>" required>
                </div>

                <!-- Submit button to update order details -->
                <button type="submit" class="submit-button">Update Order</button>
            </form>
            <% 
                } else {
                    // If no order object is found, display an error message
                    out.println("<p>No order data available for editing.</p>");
                }
            %>
        </div>
    </body>
</html>
