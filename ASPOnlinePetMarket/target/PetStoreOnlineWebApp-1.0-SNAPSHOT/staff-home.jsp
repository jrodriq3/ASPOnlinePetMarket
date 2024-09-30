<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Business.Staff"%>
<%@page import="Business.Order"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
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
        %>

        <!-- Staff Info -->
        <div class="account-info">
            <h2>Account Information</h2>
            <p><strong>First Name:</strong> <%= staffMember.getFirstName() %></p>
            <p><strong>Last Name:</strong> <%= staffMember.getLastName() %></p>
            <p><strong>Email:</strong> <%= staffMember.getEmail() %></p>
            <p><strong>Phone Number:</strong> <%= staffMember.getPhoneNumber() %></p>
        </div>
        <%
            }
        %>
        </div>
        <a href="ManageCustomersServlet">Manage Customers</a>
        <a href="ManageOrdersServlet">Manage Orders</a>
        <a href="ManageProductsServlet">Manage Products</a>
        
    </body>
</html>
