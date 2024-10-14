

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Password Reset Successful</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }

        body {
            background-color: #f4f4f4;
            color: #333;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background-color: #ffffff;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
            text-align: center;
        }

        h1 {
            color: #339933; /* Green color */
            margin-bottom: 20px;
        }

        p {
            margin-bottom: 20px;
            color: #666;
        }

        a {
            display: inline-block;
            padding: 10px 20px;
            background-color: #339933; /* Green */
            color: #fff;
            text-decoration: none;
            border-radius: 4px;
            margin-top: 20px;
            transition: background-color 0.3s ease;
        }

        a:hover {
            background-color: #66cc66; /* Lighter green on hover */
        }
    </style>
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
