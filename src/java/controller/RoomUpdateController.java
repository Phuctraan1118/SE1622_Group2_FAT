/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import validator.Validate;
import dao.RoomDAO;
import dto.RoomDTO;
import dto.RoomInsertError;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.NamingException;
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
@WebServlet(name = "RoomUpdateController", urlPatterns = {"/RoomUpdateController"})
public class RoomUpdateController extends HttpServlet {

    private static final String ERROR = "MainController?txtSearchValue=&btn=SEARCH+ROOM";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ServletContext context = this.getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITEMAPS");
        boolean foundErr = false;
        int roomId = Integer.parseInt(request.getParameter("txtRoomId"));
        String roomName = request.getParameter("txtRoomName");
        String roomDes = request.getParameter("txtRoomDescription");
        String roomPrice = request.getParameter("txtRoomPrice");
        float price = 0;
        String image = request.getParameter("txtImage");
        RoomInsertError errors = new RoomInsertError();
      
        String url = siteMaps.getProperty(MyApplicationConstants.AuthenticationFeatures.MANAGEMENT_ROOM_PAGE);
        try {
            if (roomName.trim().length() < 3 || roomName.trim().length() > 100) {
                foundErr = true;
                errors.setRoomNameLengthError("3 - 100 chars");
            }
            if (roomDes.trim().length() < 3 || roomDes.trim().length() > 100) {
                foundErr = true;
                errors.setRoomDescriptionLengthError("3 - 100 chars");
            }
            if (!Validate.checkPrice(roomPrice)) {
                foundErr = true;
                errors.setPriceStringError("Number please");
            }
            if (foundErr) {
                request.setAttribute("CREATEERRORS1", errors);
            } else {
                price = Float.parseFloat(roomPrice);
                RoomDAO dao = new RoomDAO();
                RoomDTO dto = new RoomDTO(roomId, roomName, roomDes, price, image);
                boolean check = dao.updateNotBookedRoom(dto);
                if (check) {
                    url = siteMaps.getProperty(MyApplicationConstants.AuthenticationFeatures.MANAGEMENT_ROOM_PAGE);
                }
            }
        } catch (NamingException | NumberFormatException | SQLException e) {
            log("Error at UpdateController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
