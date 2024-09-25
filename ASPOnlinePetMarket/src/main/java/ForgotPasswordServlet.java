

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.util.Random;
import Business.Customer;
import Business.MailSender;
import java.util.logging.Logger;
import java.util.logging.Level;

@WebServlet(urlPatterns = {"/ForgotPasswordServlet"})
public class ForgotPasswordServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(ForgotPasswordServlet.class.getName());

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        try {
//            response.setContentType("text/html;charset=UTF-8");
//            // Your email sending logic here
//            LOGGER.info("Attempting to send email.");
//            String recipient = "jasonwrodriguez@gmail.com";
//            String subject = "Test Email";
//            String message = "This is a simple test email.";
//            MailSender.sendEmail(recipient, subject, message);
//            LOGGER.info("Email sent successfully.");
//        } catch (Exception e) {
//            LOGGER.log(Level.SEVERE, "Failed to send email.", e);
//        }
        
        
        
        String email = request.getParameter("email");
        try {
        // 1. Retrieve user by email
        Customer customer = new Customer();
        customer.selectDBByEmail(email); // Assuming this method exists to find the user

        // 2. Generate a new password
        String newPassword = generateRandomPassword();

        // 3. Update the password in the database
        customer.setPassword(newPassword); // Assuming setter exists
        customer.updateDB(); // Assuming this updates the DB

        // 4. Send the email with the new password
        String subject = "Password Reset";
        String message = "Your new password is: " + newPassword;
        MailSender.sendEmail(email, subject, message); // Reusing the MailSender logic

        // 5. Forward to confirmation page
        request.setAttribute("message", "A new password has been sent to your email.");
        request.getRequestDispatcher("/password-reset-confirmation.jsp").forward(request, response);

    } catch (Exception e) {
        // Handle exception and forward to an error page
        request.setAttribute("error", "Failed to reset password. Please try again.");
        request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
    }
    private String generateRandomPassword() {
        // You can customize the password length and characters here
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder password = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 8; i++) {  // 8-character password
            password.append(chars.charAt(random.nextInt(chars.length())));
        }
        return password.toString();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
