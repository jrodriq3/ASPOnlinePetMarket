import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.util.List;
import Business.Order;
import Business.Staff;
import java.util.ArrayList;
@WebServlet(urlPatterns = {"/UpdateOrderStatusServlet"})
public class UpdateOrderStatusServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        Staff staffMember = (Staff) session.getAttribute("staffMember");
        try {
            List<Order> allOrders = new ArrayList<>();
            if (staffMember != null) {
                allOrders = staffMember.getAllOrders();
            }
            if (allOrders != null) {
                for (Order order: allOrders) {
                    String newStatus = request.getParameter("orderStatus_" + order.getOrderID());
                    if (newStatus != null && !newStatus.equals(order.getOrderStatus())) {
                        order.setOrderStatus(newStatus);
                        order.updateDB();
                    }
                }
            }
            response.sendRedirect("staff-profile.jsp");
            

        } catch (Exception e) {
            // Handle exceptions and forward to an error page if needed
            request.setAttribute("errorMessage", "Error updating order statuses.");
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
