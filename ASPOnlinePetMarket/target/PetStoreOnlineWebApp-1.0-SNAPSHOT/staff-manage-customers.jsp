<%-- 
    Document   : staff-manage-customers
    Created on : Sep 30, 2024, 9:24:07 AM
    Author     : jason
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Business.Staff"%>
<%@page import="java.util.List"%>
<%@page import="Business.Customer"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Staff Manage Customers</title>
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
        <div class="customer-container">
        <% 
            Staff staffMember = (Staff)session.getAttribute("staffMember");
            if (staffMember != null) {
                List<Customer> allCustomers = staffMember.getAllCustomers();
        %>
            <div class="customer-list">
                <h2>Customer List</h2>
                <form action="EditCustomerServlet" method="POST">
                    <table class="customer-table">
                        <thead>
                            <tr>
                                <th>Select</th>
                                <th>Customer ID</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Password</th>
                                <th>Email</th>
                                <th>Address</th>
                                <th>Phone Number</th>
                            </tr>
                        </thead>
                        <tbody>
                        <% for (Customer customer: allCustomers) { %>
                            <tr>
                                <td><input type="radio" name="customerID" value="<%= customer.getCustomerID() %>" required></td>
                                <td><%= customer.getCustomerID() %></td>
                                <td><%= customer.getFirstName() %></td>
                                <td><%= customer.getLastName() %></td>
                                <td><%= customer.getPassword() %></td>
                                <td><%= customer.getEmail() %></td>
                                <td><%= customer.getAddress() %></td>
                                <td><%= customer.getPhoneNumber() %></td>
                            </tr>
                        <% } %>
                        </tbody>
                    </table>
                    <!-- Submit button -->
                    <button type="submit" class="update-button">Edit Customer</button> 
                </form>
            </div>
            <%
                }
            %>
        </div> 
    </body>
</html>
