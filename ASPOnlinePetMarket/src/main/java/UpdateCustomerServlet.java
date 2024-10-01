
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import Business.Customer;

@WebServlet(urlPatterns = {"/UpdateCustomerServlet"})
public class UpdateCustomerServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // Retrieve updated customer details from the form
        String customerID = request.getParameter("customerID");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");
        String phoneNumber = request.getParameter("phoneNumber");

        try {
            // Create a new Customer object
            Customer customer = new Customer();
            customer.setCustomerID(Integer.parseInt(customerID));
            customer.selectDB();  // Load the current customer details from the DB
            
            // Update the customer object with new data
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setPassword(password);
            customer.setEmail(email);
            customer.setStreet(street);
            customer.setCity(city);
            customer.setState(state);
            customer.setZip(Integer.parseInt(zip));
            customer.setPhoneNumber(phoneNumber);
            
            // Update the customer record in the database
            customer.updateDB();
            request.setAttribute("message", "Customer updated successfully");
            
            // Forward the request and message to success.jsp
            request.getRequestDispatcher("staff-success.jsp").forward(request, response);

        } catch (Exception e) {
            // Handle any errors (e.g., DB connection issues)
            e.printStackTrace();
            // Forward to error page in case of exception
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
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
