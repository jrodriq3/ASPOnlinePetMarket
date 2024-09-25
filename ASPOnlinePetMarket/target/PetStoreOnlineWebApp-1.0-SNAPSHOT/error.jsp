<%-- 
    Document   : error
    Created on : Sep 10, 2024, 7:27:32 PM
    Author     : Grace
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error</title>
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
    <div class="error-container">
        <h1 class="error-title">Oops! Something went wrong</h1>
        <p>We encountered an unexpected error. Please try again later or contact support if the problem persists.</p>
        <a href="index.html" class="back-button">Go Back to Home</a>
    </div>
</body>
</html>
