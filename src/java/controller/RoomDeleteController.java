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
@WebServlet(name = "RoomDeleteController", urlPatterns = {"/RoomDeleteController"})
public class RoomDeleteController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int roomId = Integer.parseInt(request.getParameter("txtRoomId"));
        ServletContext context = this.getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITEMAPS");
        String url = siteMaps.getProperty(MyApplicationConstants.ManageRooms.SEARCH_ROOM_CONTROLLER);
        try {
            RoomDAO dao = new RoomDAO();
            List<RoomDTO> dto = dao.getImageV2(roomId);
            if (dto == null) {
                boolean check = dao.deleteNotBookedRoom(roomId);
                if (check) {
                    request.setAttribute("DELETE_SUCCESS", "Delete Success");
                    url = siteMaps.getProperty(MyApplicationConstants.ManageRooms.SEARCH_ROOM_CONTROLLER);
                } else {
                    request.setAttribute("DELETE_FAIL", "Can not delete because room have booked");
                     url = siteMaps.getProperty(MyApplicationConstants.ManageRooms.SEARCH_ROOM_CONTROLLER);
                }
            } else if(dto != null){
                boolean check = dao.deleteImageV2(roomId);
                boolean checkTmp = dao.deleteNotBookedRoom(roomId);
                if (check == true && checkTmp == true) {
                    request.setAttribute("DELETE_SUCCESS", "Delete Success");
                    url = siteMaps.getProperty(MyApplicationConstants.ManageRooms.SEARCH_ROOM_CONTROLLER);
                }else {
                    request.setAttribute("DELETE_FAIL", "Can not delete because room have booked");
                     url = siteMaps.getProperty(MyApplicationConstants.ManageRooms.SEARCH_ROOM_CONTROLLER);
                }
            }

        } catch (NamingException | SQLException ex) {
            log("Error at DeleteRoomController: " + ex.toString());
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
