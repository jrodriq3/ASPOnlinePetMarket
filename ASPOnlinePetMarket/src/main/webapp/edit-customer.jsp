<%-- 
    Document   : edit-customer
    Created on : Oct 1, 2024, 8:33:39 AM
    Author     : jason
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Business.Customer"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Edit Customer</title>
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
            <h2 style="text-align: center;">Edit Customer Details</h2>
            
            <% 
                // Retrieve the customer object from the request
                Customer customer = (Customer) request.getAttribute("customer");
                if (customer != null) {
            %>
            <form action="UpdateCustomerServlet" method="POST">
                <!-- Hidden input to store the customer ID (unchangeable) -->
                <input type="hidden" name="customerID" value="<%= customer.getCustomerID() %>">

                <!-- Editable fields for customer information -->
                <div class="form-group">
                    <label for="firstName">First Name:</label>
                    <input type="text" id="firstName" name="firstName" value="<%= customer.getFirstName() %>" required>
                </div>

                <div class="form-group">
                    <label for="lastName">Last Name:</label>
                    <input type="text" id="lastName" name="lastName" value="<%= customer.getLastName() %>" required>
                </div>

                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" value="<%= customer.getPassword() %>" required>
                </div>

                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="text" id="email" name="email" value="<%= customer.getEmail() %>" required>
                </div>
                <div class="form-group">
                    <label for="street">Street:</label>
                    <input type="text" id="street" name="street" value="<%= customer.getStreet() %>" required>
                </div>
                <div class="form-group">
                    <label for="city">City:</label>
                    <input type="text" id="city" name="city" value="<%= customer.getCity() %>" required>
                </div>
                <div class="form-group">
                    <label for="state">State:</label>
                    <input type="text" id="state" name="state" value="<%= customer.getState() %>" required>
                </div>
                <div class="form-group">
                    <label for="zip">Zip:</label>
                    <input type="text" id="zip" name="zip" value="<%= customer.getZip() %>" required>
                </div>
                <div class="form-group">
                    <label for="phoneNumber">Phone Number:</label>
                    <input type="text" id="phoneNumber" name="phoneNumber" value="<%= customer.getPhoneNumber() %>" required>
                </div>

                <!-- Submit button to update customer details -->
                <button type="submit" class="submit-button">Update Customer</button>
            </form>
            <% 
                } else {
                    // If no customer object is found, display an error message
                    out.println("<p>No customer data available for editing.</p>");
                }
            %>
        </div>
    </body>
</html>
