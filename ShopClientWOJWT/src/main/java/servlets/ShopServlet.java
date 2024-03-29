/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.mycompany.shopclient.client.ProductClient;
import com.mycompany.stockresources.entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import model.Product;

import org.eclipse.microprofile.rest.client.inject.RestClient;

/**
 *
 * @author root
 */
@WebServlet(urlPatterns = "/ShopServlet")
public class ShopServlet extends HttpServlet {
    
    @Inject @RestClient ProductClient productclient;
Collection<Product> products;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShopServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShopServlet at " + request.getContextPath() + "</h1>");
             out.println("<table width='100%'><tr><td align='left'><a href='Logout'>Log Out</a></td></tr></table><br/><br/>");
          
            out.println("<table border ='1'>");
            out.println("<tr><td>Product Name</td><td>Description</td><td>Price</td>");
           try{
            products = productclient.getAvailableProducts();
           
            for(Product p : products)
            {
             out.println("<tr><td>"+p.getProductname()+"</td><td>"+p.getDescription()+"</td><td>"+p.getPrice()+"</td></tr>");   
            }
            out.println("</table>");
                    
            }
           catch(Exception e)
           {
               out.println("<tr><td colspan='3'> You are not Authorized to view the Shop</td><tr>");
           }
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e)
        {
            
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
