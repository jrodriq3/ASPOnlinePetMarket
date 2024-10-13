<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Business.Customer"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Profile</title>
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
        <h2 class="form-title">Edit Profile</h2>
        <%-- Check if customer is logged in --%>
        <%
            Customer customer = (Customer) session.getAttribute("customer");
            if (customer == null) {
        %>
            <p>You are not logged in. Please <a href="sign-in.jsp">sign in</a>.</p>
        <%
                return; // Stops further execution of the JSP
            }
        %>
        <form action="EditProfileServlet" method="POST">
            <div class="form-group">
                <label for="first-name">First Name:</label>
                <input type="text" id="first-name" name="first-name"  required>
            </div>
            <div class="form-group">
                <label for="last-name">Last Name:</label>
                <input type="text" id="last-name" name="last-name"  required>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="text" id="email" name="email"  required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password"  required>
            </div>
            <div class="form-group">
                <label for="repeat-password">Repeat Password:</label>
                <input type="password" id="repeat-password" name="repeat-password"  required>
            </div>
            <div class="form-group">
                <label for="address">Address:</label>
                <input type="text" id="address" name="address"  required>
            </div>
            <div class="form-group">
                <label for="city">City:</label>
                <input type="text" id="city" name="city"  required>
            </div>
            <div class="form-group">
                <label for="zipcode">Zip Code:</label>
                <input type="text" id="zipcode" name="zipcode"  required>
            </div>
            <div class="form-group">
                <label for="phone-number">Phone Number:</label>
                <input type="text" id="phone-number" name="phone-number"  required>
            </div>

            <button type="submit" class="submit-button">Save Changes</button>
        </form>
    </div>
</body>
</html>
