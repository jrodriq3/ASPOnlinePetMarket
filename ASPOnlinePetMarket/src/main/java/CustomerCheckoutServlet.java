
import Business.Customer;
import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.PrintWriter;
import Business.Order;
import Business.OrderItem;
import Business.ShoppingCart;
import Business.Product;
import Business.MailSender;

@WebServlet(urlPatterns = {"/CustomerCheckoutServlet"})
public class CustomerCheckoutServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // 1. Gather form parameters
        String email = request.getParameter("email");
        String nameOnCard = request.getParameter("name-on-card");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zipCode = request.getParameter("zipcode");
        
        // 2. Get totalAmount from hidden field
        String totalAmount = request.getParameter("totalAmount");
        
        // 3. Create a new Order object
        Order order = new Order();
        int nextAvailableOrderID = Order.getNextAutoIncrementIDWithRollback();
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        order.setCustomerID(customer.getCustomerID());
        order.setOrderID(nextAvailableOrderID);
        order.setNameOnCard(nameOnCard);
        order.setStreetAddress(address);
        order.setCity(city);
        order.setState(state);
        order.setZip(Integer.parseInt(zipCode));
        order.setTotalAmount(totalAmount);
        ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");
        
        // Loop through the list of Products in the ShoppingCart
        for (Product product : cart.getProductList()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderItemID(OrderItem.getNextAutoIncrementIDWithRollback());
            orderItem.setProductID(product.getProductID());
            orderItem.setOrderID(order.getOrderID());
            orderItem.setPrice(product.getProductPrice());
            orderItem.setQuantity(1);
            orderItem.setCreatedAt("2000-01-01");
            orderItem.setUpdatedAt("2000-01-01");
            orderItem.setProductName();
            orderItem.insertDB();
        }
        
        
        
        // 4. Insert the order into the database
        order.insertDB();
        session.removeAttribute("cart");
        // Add the order to the session (or request)
        request.getSession().setAttribute("order", order);
        
        // Send email with the order details
        String subject = "OnlinePetStore Order Confirmation";
        String message = "Your order has been placed.\n ";
        message = message + "Order ID: " + order.getOrderID() + "\n";
        message = message + "Total Amount: " + totalAmount + "\n";
        message = message + "Address: " + order.getAddress() + "\n";
        MailSender.sendEmail(email, subject, message); // Reusing the MailSender logic

        // 6. Redirect or display confirmation page
        response.sendRedirect("confirmation.jsp");
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
