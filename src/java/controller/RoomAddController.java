/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import Validation.Validate;
import dao.RoomDAO;
import dto.RoomDTO;
import dto.RoomInsertError;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
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
@WebServlet(name = "RoomAddController", urlPatterns = {"/RoomAddController"})
public class RoomAddController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ServletContext context = this.getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITEMAPS");
        boolean foundErr = false;
        int roomId = 0;
        String roomDescription = request.getParameter("txtCreateRoomDescription");
        String roomPrice = request.getParameter("txtCreateRoomPrice");
        float price = 0;
        String image = request.getParameter("txtCreateImage");
        String url = siteMaps.getProperty(MyApplicationConstants.AuthenticationFeatures.STAFF_PAGE);
        RoomInsertError errors = new RoomInsertError();
        try {

            if (roomDescription.trim().length() < 3 || roomDescription.trim().length() > 100) {
                foundErr = true;
                errors.setRoomDescriptionLengthError("3 - 100 chars");
            }
            if (!Validate.checkPrice(roomPrice)) {
                foundErr = true;
                errors.setPriceStringError("Number please");
            }
            if (foundErr) {
                request.setAttribute("CREATEERRORS", errors);
                url = "MainController?txtSearchValue=&btn=SEARCH+ROOM";
            } else {
                price = Float.parseFloat(roomPrice);
                RoomDAO dao = new RoomDAO();
                roomId = dao.getLastIdRoom() + 1;
                RoomDTO dto = new RoomDTO(roomId, roomDescription, price, image, "NB");
                boolean result = dao.create(dto);
                if (result) {
                    url = "MainController?txtSearchValue=&btn=SEARCH+ROOM";
                }
            }
        } catch (SQLException | NamingException ex) {
            ex.printStackTrace();
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
