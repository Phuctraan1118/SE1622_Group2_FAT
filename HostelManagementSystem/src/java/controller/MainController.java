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
        ServletContext context = this.getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITEMAPS");
        String url = siteMaps.getProperty(MyApplicationConstants.AuthenticationFeatures.STAFF_PAGE);
    
        try {
            String button = request.getParameter("btn");
//            if(button.equals("login now")) {
//                url = siteMaps.getProperty(MyApplicationConstants.AuthenticationFeatures.LOGIN_CONTROLLER);
            if (button.equals("SEARCH ROOM")) {
                url = siteMaps.getProperty(MyApplicationConstants.ManageRooms.SEARCH_ROOM_CONTROLLER);
            }else if (button.equals("SEARCH OWNED ROOM")) {
                url = siteMaps.getProperty(MyApplicationConstants.ManageRooms.SEARCH_BOOKED_ROOM_CONTROLLER);
            }  else if (button.equals("Update Room")) {
                url = siteMaps.getProperty(MyApplicationConstants.ManageRooms.UPDATE_ROOM_CONTROLLER);
            } else if (button.equals("Delete Room")) {
                url = siteMaps.getProperty(MyApplicationConstants.ManageRooms.DELETE_ROOM_CONTROLLER);
            } else if (button.equals("ADD ROOM")) {
                url = siteMaps.getProperty(MyApplicationConstants.ManageRooms.ADD_ROOM_CONTROLLER);
            } else if (button.equals("Search room for customer")) {
                url = siteMaps.getProperty(MyApplicationConstants.ManageRooms.SEARCH_ROOM_FOR_CUSTOMER_CONTROLLER);
            } else if (button.equals("Update Booked Room")) {
                url = siteMaps.getProperty(MyApplicationConstants.ManageRooms.UPDATE_BOOKED_ROOM_CONTROLLER);
            } else if (button.equals("Delete Booked Room")) {
                url = siteMaps.getProperty(MyApplicationConstants.ManageRooms.DELETE_BOOKED_ROOM_CONTROLLER);
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
