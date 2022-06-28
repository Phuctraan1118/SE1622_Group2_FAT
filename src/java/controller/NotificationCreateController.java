/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dto.NotificationDto;
import form.NotificationCreateForm;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.NotificationService;
import service.impl.NotificationServerImpl;

/**
 *
 * @author hungp
 */
@WebServlet(name = "NotificationCreateController", urlPatterns = {"/NotificationCreateController"})
public class NotificationCreateController extends HttpServlet {

    private static final String FAIL = "notifi.jsp";
    private NotificationService notificationService;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = FAIL;
        
        NotificationCreateForm notificationForm = getNotificationForm(request);
        notificationService = new NotificationServerImpl();
        NotificationDto notificationDto = notificationService.createNoti(notificationForm);
        if (notificationDto != null) {
            request.setAttribute("CREATED", notificationDto.getName());
            url = "notifi.jsp";
            forwardToJsp(request, url, response);
        }
        
    }

    private void forwardToJsp(HttpServletRequest request, String url, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    private NotificationCreateForm getNotificationForm(HttpServletRequest request) {
        String notificationName = request.getParameter("txtNotificationName");
        String notificationDetail = request.getParameter("txtNotificationDetail");
        String username = request.getParameter("txtUsername");
        return new NotificationCreateForm(notificationName, notificationDetail, username);
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
