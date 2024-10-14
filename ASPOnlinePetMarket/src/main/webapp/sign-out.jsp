<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Out</title>
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

        .signout-container {
            display: flex;
            justify-content: center;
            align-items: center;
            width: 100%;
            height: 100%;
        }

        .signout-box {
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

        .button-group {
            display: flex;
            justify-content: space-between;
            margin-top: 20px;
        }

        .signout-btn, .cancel-btn {
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            text-decoration: none;
            color: #fff;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .signout-btn {
            background-color: #339933; /* Green color */
        }

        .cancel-btn {
            background-color: #333;
        }

        .signout-btn:hover {
            background-color: #66cc66; /* Lighter green on hover */
        }

        .cancel-btn:hover {
            background-color: #555;
        }
    </style>
</head>
<body>
    <div class="signout-container">
        <div class="signout-box">
            <h1>Are you sure you want to sign out?</h1>
            <div class="button-group">
                <a href="SignOutServlet" class="signout-btn">Sign Out</a>
                <a href="home.jsp" class="cancel-btn">Cancel</a>
            </div>
        </div>
    </div>
</body>
</html>
