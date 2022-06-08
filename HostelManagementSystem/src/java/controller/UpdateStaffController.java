/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import dao.UserDao;
import dto.UserCreateDto;
import form.UserCreateForm;
import form.UserUpdateForm;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.UserService;
import service.impl.UserServiceImpl;

/**
 *
 * @author hungp
 */
@WebServlet(name = "UpdateStaffController", urlPatterns = {"/UpdateStaffController"})
public class UpdateStaffController extends HttpServlet {

    private static final String ERROR = "StaffDisplayController";
    private static final String SUCCESS = "StaffDisplayController";
    private UserService userService;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;

        UserUpdateForm userUpdateForm = getUserForm(request);

        userService = new UserServiceImpl();
        UserCreateDto userDto = userService.updateUser(userUpdateForm);
        if (userDto != null) {
            url = SUCCESS;
        }
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    private UserUpdateForm getUserForm(HttpServletRequest request) {
        String username = request.getParameter("txtUsername");
        String fullName = request.getParameter("txtFullName");
        String address = request.getParameter("txtAddress");
        String phone = request.getParameter("txtPhone");
        String cmnd = request.getParameter("txtCmnd");
        String email = request.getParameter("txtEmail");
        return new UserUpdateForm(username, fullName, address, phone, cmnd, email);
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
