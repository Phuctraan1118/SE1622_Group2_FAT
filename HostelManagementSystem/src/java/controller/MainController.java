/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.util.Properties;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.MyApplicationConstants;

/**
 *
 * @author buikh
 */
public class MainController extends HttpServlet {

    private static final String CREATE_STAFF = "CreateStaffController";
    private static final String SEARCH_STAFF = "SearchStaffController";
    private static final String UPDATE_STAFF = "UpdateStaffController";
    private static final String DELETE_STAFF = "DeleteStaffController";
    private static final String VIEW_ALL_STAFF = "StaffDisplayController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ServletContext context = this.getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITEMAPS");
        String url = siteMaps.getProperty(MyApplicationConstants.MainControllerFeatures.HOME_PAGE);
        String button = request.getParameter("btn");
        try {
            if (button.equals("login now")) {
                url = siteMaps.getProperty(MyApplicationConstants.AuthenticationFeatures.LOGIN_CONTROLLER);
            } else if (button.equals("Search Customer")) {
                url = SEARCH_STAFF;
            } else if (button.equals("Add Customer")) {
                url = CREATE_STAFF;
            } else if (button.equals("Update Customer")) {
                url = UPDATE_STAFF;
            } else if (button.equals("Delete Customer")) {
                url = DELETE_STAFF;
            } else if (button.equals("View All")) {
                url = VIEW_ALL_STAFF;
            }
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
