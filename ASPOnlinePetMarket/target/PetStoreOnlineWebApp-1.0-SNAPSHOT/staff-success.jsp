<%-- 
    Document   : staff-success
    Created on : Oct 1, 2024, 10:21:46 AM
    Author     : jason
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- Display the success message forwarded from the servlet -->
        <p>
            <%= request.getAttribute("message") %>
        </p>
    </body>
</html>
