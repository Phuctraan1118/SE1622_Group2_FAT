/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dto.RegulationDto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.RegulationService;
import service.impl.RegulationServiceImpl;

/**
 *
 * @author hungp
 */
@WebServlet(name = "RegulationForSendNotiDisplayController", urlPatterns = {"/RegulationForSendNotiDisplayController"})
public class RegulationForSendNotiDisplayController extends HttpServlet {

    private static final String ERROR = "sendNotification.jsp";
    private static final String SUCCESS = "sendNotification.jsp?username=";
    private RegulationService regulationService;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;

        String username = request.getParameter("txtUsername");
        regulationService = new RegulationServiceImpl();
        List<RegulationDto> regulationDtos = regulationService.getAllRegulationInSendNotiPage();
        if (!regulationDtos.isEmpty()) {
            request.setAttribute("LIST_REGULATION_FOR_SEND_NOTI", regulationDtos);
        }
        url = SUCCESS + username;
        request.setAttribute("username", username);
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
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
