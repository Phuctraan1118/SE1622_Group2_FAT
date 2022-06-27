/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.RoomDAO;
import dto.RoomDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.MyApplicationConstants;

/**
 *
 * @author Bitano
 */
@WebServlet(name = "RoomSearchBookedController", urlPatterns = {"/RoomSearchBookedController"})
public class RoomSearchBookedController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        request.setCharacterEncoding("UTF-8");
        String searchValue = request.getParameter("txtSearchValueBooked");
        ServletContext context = this.getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITEMAPS");
        String url = siteMaps.getProperty(MyApplicationConstants.AuthenticationFeatures.STAFF_PAGE);
        try {
            //SEARCH OWNED BOOKED
            RoomDAO dao = new RoomDAO();
            if (searchValue.trim().length() > 0) {
                List<RoomDTO> result = dao.searchBookedByUsername(searchValue); //SEARCH BOOKED BY USERNAME
                if (!result.isEmpty()) {
                    request.setAttribute("SEARCH_BOOKED", result);
                    url = siteMaps.getProperty(MyApplicationConstants.AuthenticationFeatures.STAFF_PAGE);
                }
            } else {
                List<RoomDTO> result = dao.searchAllBooked();
                if (result != null) {
                    request.setAttribute("SEARCH_BOOKED", result);
                    url = siteMaps.getProperty(MyApplicationConstants.AuthenticationFeatures.STAFF_PAGE);
                }

            }

        } catch (NamingException ex) {
            log("SearchServlet_SQL " + ex.getMessage());
        } catch (SQLException ex) {
            log("SearhServlet_Naming " + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RoomSearchBookedController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RoomSearchBookedController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
