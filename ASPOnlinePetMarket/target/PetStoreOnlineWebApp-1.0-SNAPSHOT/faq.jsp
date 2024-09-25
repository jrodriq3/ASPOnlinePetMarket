<%-- 
    Document   : faq
    Created on : Sep 10, 2024, 5:11:42 PM
    Author     : Grace
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Frequently Asked Questions</title>
    
    <!-- CSS file -->
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
    <div class="faq-container">
        <h1 class="faq-title">Frequently Asked Questions</h1>

        <div class="faq-item">
            <button class="faq-question">What is Pet Store Online?</button>
            <div class="faq-answer">
                <p>We sell pet products, including food, toys, and accessories for all kinds of pets!</p>
            </div>
        </div>

        <div class="faq-item">
            <button class="faq-question">How do I sign up for an account?</button>
            <div class="faq-answer">
                <p>To sign up for an account, click on the "Sign In" link at the top of the page, then click "Create Account" and fill in your details.</p>
            </div>
        </div>

        <div class="faq-item">
            <button class="faq-question">What payment methods are accepted?</button>
            <div class="faq-answer">
                <p>We accept all major credit cards, PayPal, and other secure payment methods.</p>
            </div>
        </div>
        <!-- Add more questions/answers-->
    </div>  
<!-- JavaScript to handle FAQ collapsible -->
    <script>
        const questions = document.querySelectorAll('.faq-question');
        questions.forEach(question => {
            question.addEventListener('click', () => {
                const answer = question.nextElementSibling;
                answer.style.display = answer.style.display === 'block' ? 'none' : 'block';
            });
        });
    </script>
</body>
</html>
