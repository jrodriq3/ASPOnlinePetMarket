
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import Business.Product;

@WebServlet(urlPatterns = {"/UpdateProductServlet"})
public class UpdateProductServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // Retrieve updated product details from the form
        String productID = request.getParameter("productID");
        String productName = request.getParameter("productName");
        String productDescription = request.getParameter("productDescription");
        String stockQuantity = request.getParameter("stockQuantity");
        String category = request.getParameter("category");
        String productPrice = request.getParameter("productPrice");
        try {
            // Create a new product object
            Product product = new Product();
            product.setProductID(Integer.parseInt(productID));

            product.selectDB();  // Load the current product details from the DB
            
            // Update the product object with new data
            product.setProductName(productName);
            product.setProductDescription(productDescription);
            product.setCategory(category);
            product.setProductPrice(Double.parseDouble(productPrice));
            product.setStockQuantity(Integer.parseInt(stockQuantity));

            
            // Update the product record in the database
            product.updateDB();
            request.setAttribute("message", "Product updated successfully");
            
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
