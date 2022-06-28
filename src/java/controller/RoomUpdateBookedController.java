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
import java.io.PrintWriter;
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
@WebServlet(name = "RoomUpdateBookedController", urlPatterns = {"/RoomUpdateBookedController"})
public class RoomUpdateBookedController extends HttpServlet {

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
        int roomId = Integer.parseInt(request.getParameter("txtRoomId1"));
        String roomDescription = request.getParameter("txtRoomDescription1");
        String roomPrice = request.getParameter("txtRoomPrice1");
        float price = 0;
        String bookingDate = request.getParameter("txtBookingDate");
        String checkInDate = request.getParameter("txtCheckInDate");
        String checkOutDate = request.getParameter("txtCheckOutDate");
        String username = request.getParameter("txtUsername");
        String status = request.getParameter("txtStatus1");
        String image = request.getParameter("txtImage1");
        int bookingId = Integer.parseInt(request.getParameter("txtBookingId"));
        RoomInsertError errors = new RoomInsertError();
        boolean foundErr = false;
        String url = siteMaps.getProperty(MyApplicationConstants.ManageRooms.EDIT_OWNED_ROOM_PAGE);
        try {
            if (roomDescription.trim().length() < 3 || roomDescription.trim().length() > 100) {
                foundErr = true;
                errors.setRoomDescriptionLengthError("3 - 100 chars");
            }
            if (!Validate.checkPrice(roomPrice)) {
                foundErr = true;
                errors.setPriceStringError("Number please");
            }
            if (bookingDate.trim().length() < 3 || bookingDate.trim().length() > 100) {
                foundErr = true;
                errors.setBookingDateLengthError("3 - 100 chars");
            }
            if (checkInDate.trim().length() < 3 || bookingDate.trim().length() > 100) {
                foundErr = true;
                errors.setCheckinDateLengthError("3 - 100 chars");
            }
            if (checkOutDate.trim().length() < 3 || bookingDate.trim().length() > 100) {
                foundErr = true;
                errors.setCheckoutDateLengthError("3 - 100 chars");
            }
            if (foundErr) {
                request.setAttribute("ERROR2", errors);
            } else {
                price = Float.parseFloat(roomPrice);
                RoomDAO dao = new RoomDAO();
                RoomDTO dto = new RoomDTO(roomId, roomDescription, price, image, bookingId, bookingDate, checkInDate, checkOutDate, username, status);
                boolean check = dao.updateBookedRoom(dto);
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
