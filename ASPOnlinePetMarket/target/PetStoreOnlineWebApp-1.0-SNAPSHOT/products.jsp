<%@page import="java.util.List"%>
<%@page import="Business.Product"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Our Products</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <h1>Available Products</h1>
        
        <div class="products-container">
            <%
                // Retrieve the list of products passed from the servlet
                List<Product> products = (List<Product>) request.getAttribute("productList");
                
                // Check if the product list is not empty
                if (products != null && !products.isEmpty()) {
                    for (Product product : products) {
            %>
                        <div class="product-item">
                            <h2><%= product.getProductName() %></h2>
                            <p><strong>Description:</strong> <%= product.getProductDescription() %></p>
                            <p><strong>Category:</strong> <%= product.getCategory() %></p>
                            <p><strong>Price:</strong> $<%= product.getProductPrice() %></p>
                            <p><strong>In Stock:</strong> <%= product.getStockQuantity() %> units</p>
                        </div>
            <%
                    }
                } else {
            %>
                <p>No products available at this moment. Please check back later!</p>
            <%
                }
            %>
        </div>
        
        <a href="home.jsp">Continue Shopping</a>
    </body>
</html>