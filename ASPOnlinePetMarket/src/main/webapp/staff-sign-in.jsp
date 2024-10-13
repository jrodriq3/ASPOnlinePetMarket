<%-- 
    Document   : staff-sign-in
    Created on : Sep 24, 2024, 3:22:37 PM
    Author     : jason
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Staff Sign In</title>
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
    <!-- Sign-In Form -->
    <div class="form-container">
        <h2 class="form-title">Staff Sign In</h2>
        <!-- Form action -->
        <form action="StaffSignInServlet" method="POST">
            <div class="form-group">
                <label for="staff-id">Staff ID: </label>
                <input type="text" id="staff-id" name="staff-id" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="form-group">
                <button type="submit">Sign In</button>
            </div>
        </form>
    </div>
</body>
</html>
