<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <h1>Password Reset Successful</h1>
            <!-- Dynamically display the message passed from the servlet -->
            <p>${message}</p>
            <p>If you don't receive the email within a few minutes, please check your spam folder or try again later.</p>
            <a href="sign-in.jsp">Go to Sign In</a>
        </div>
    </body>
</html>
