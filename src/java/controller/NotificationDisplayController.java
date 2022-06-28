/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import form.NotificationCreateForm;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.NotificationService;
import service.impl.NotificationServerImpl;

/**
 *
 * @author hungp
 */
@WebServlet(name = "NotificationDisplayController", urlPatterns = {"/NotificationDisplayController"})
public class NotificationDisplayController extends HttpServlet {

    private static final String ERROR = "notifi.jsp";
    private static final String SUCCESS = "notifi.jsp";
    private NotificationService notificationService;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        HttpSession session = request.getSession(true);

        String notificationName = getNotificationName(request);
        notificationService = new NotificationServerImpl();
        List<NotificationCreateForm> notificationForms = notificationService.searchNoti(notificationName);
        sortNotificationDisplay(notificationForms);
        if (!notificationForms.isEmpty()) {
            session.setAttribute("LIST_NOTIFICATION", notificationForms);
        }
        url = SUCCESS;
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    private String getNotificationName(HttpServletRequest request) {
        String notificationName = request.getParameter("search");
        return notificationName;
    }

    private void sortNotificationDisplay(List<NotificationCreateForm> notificationForms) {
        notificationForms.stream().sorted(Comparator.comparing(NotificationCreateForm::getName)).collect(Collectors.toList());
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
