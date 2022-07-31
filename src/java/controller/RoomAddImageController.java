/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.RoomDAO;
import dto.RoomDTO;
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
import validator.Validate;

/**
 *
 * @author Bitano
 */
@WebServlet(name = "RoomAddImageController", urlPatterns = {"/RoomAddImageController"})
public class RoomAddImageController extends HttpServlet {

    private static final String ERROR = "MainController?btn=Display+Image+Room&txtRoomId=";
    private static final String SUCCESS = "MainController?btn=Display+Image+Room&txtRoomId=";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int roomId = Integer.parseInt(request.getParameter("txtRoomId1"));
        int id = Integer.parseInt(request.getParameter("txtId"));
        String image = request.getParameter("txtImage");
        String imageOld = request.getParameter("txtImageOld");
        String url = ERROR + roomId;
        try {
            if (image.equals("")) {
                image = imageOld;
            }
            RoomDAO dao = new RoomDAO();
            RoomDTO dto = new RoomDTO(roomId,id,image);
            boolean check = dao.updateImageRoom(dto);
            if (check) {
                url = SUCCESS + roomId;
            }

        } catch (NamingException | NumberFormatException | SQLException e) {
            log("Error at RoomAddImageController: " + e.toString());
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