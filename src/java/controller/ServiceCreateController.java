/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.ServiceDao;
import dto.ServiceDto;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hungp
 */
@WebServlet(name = "ServiceCreateController", urlPatterns = {"/ServiceCreateController"})
public class ServiceCreateController extends HttpServlet {

    private static final String SUCCESS = "BillManagementController?roomId=";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String electronicDetail = request.getParameter("txtElectronicDetail");
        String waterDetail = request.getParameter("txtWaterDetail");
        String tmpElectronicPrice = request.getParameter("txtElectronicPrice");
        String tmpWaterPrice = request.getParameter("txtWaterPrice");
        String roomId = request.getParameter("txtRoomId");
        String url = null;

        try {
            float ePrice = Float.parseFloat(tmpElectronicPrice);
            ePrice *= 0.1;
            float wPrice = Float.parseFloat(tmpWaterPrice);
            wPrice *= 0.4;
            ServiceDao dao = new ServiceDao();
//            ServiceDto dto = new ServiceDto(electronicDetail, waterDetail, ePrice, wPrice, Integer.parseInt(roomId));

            ServiceDto dto = new ServiceDto(electronicDetail, waterDetail, ePrice, wPrice, Integer.parseInt(roomId));
            boolean result = dao.createService(dto);
            if (result) {
                url = SUCCESS + roomId;
            }

        } catch (Exception ex) {
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
