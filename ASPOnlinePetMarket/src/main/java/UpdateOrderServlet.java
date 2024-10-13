import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import Business.Order;
@WebServlet(urlPatterns = {"/UpdateOrderServlet"})
public class UpdateOrderServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // Retrieve updated order details from the form
        String orderID = request.getParameter("orderID");
        String customerID = request.getParameter("customerID");
        String orderDate = request.getParameter("orderDate");
        String orderStatus = request.getParameter("orderStatus");
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");
        String createdAt = request.getParameter("createdAt");
        String updatedAt = request.getParameter("updatedAt");
        String totalAmount = request.getParameter("totalAmount");
        String nameOnCard = request.getParameter("nameOnCard");

        try {
            // Create a new order object
            Order order = new Order();
            order.setOrderID(Integer.parseInt(orderID));
            order.selectDB();  // Load the current order details from the DB
            
            // Update the order object with new data
            order.setCustomerID(Integer.parseInt(customerID));
            order.setOrderDate(orderDate);
            order.setOrderStatus(orderStatus);
            order.setStreetAddress(street);
            order.setCity(city);
            order.setState(state);
            order.setZip(Integer.parseInt(zip));
            order.setCreatedAt(createdAt);
            order.setUpdatedAt(updatedAt);
            order.setTotalAmount(totalAmount);
            order.setNameOnCard(nameOnCard);
            
            // Update the order record in the database
            order.updateDB();
            request.setAttribute("message", "Order updated successfully");
            
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
