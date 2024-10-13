<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="style.css" type="text/css"/>

        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

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
        <div class="topnav">
            <form action="SearchServlet" method="post">
                <input type="text" maxlength="10" size="20" name="searchTerm" placeholder="Search for products...">
                <button type="submit" value="Search">Search</button>
            </form>

        </div>


    </body>
</html>
