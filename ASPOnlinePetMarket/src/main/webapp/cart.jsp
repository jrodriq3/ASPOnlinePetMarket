<!--
    Jason Rodriguez
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Business.Product" %>
<%@ page import="Business.ShoppingCart" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
    if (cart == null || cart.getProductList().isEmpty()) {
        out.println("<p>Your cart is empty.</p>");
    } else {
%>
    <h2>Your Shopping Cart</h2>
    <table>
        <tr>
            <th>Product ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Category</th>
            <th>Stock Quantity</th>
            <th>Price</th>
        </tr>
        <c:forEach var="product" items="${cart.productList}">
            <tr>
                <td>${product.productID}</td>
                <td>${product.productName}</td>
                <td>${product.productDescription}</td>
                <td>${product.category}</td>
                <td>${product.stockQuantity}</td>
                <td>${product.productPrice}</td>
            </tr>
        </c:forEach>
    </table>
    <form action="CheckoutRedirectServlet" method="POST">
        <button type="submit">Go to Checkout</button>
    </form>
<%
    }
%>