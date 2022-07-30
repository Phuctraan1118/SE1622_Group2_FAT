/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import dto.UserCreateDto;
import form.UserError;
import form.UserUpdateForm;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.UserService;
import service.UserValidationService;
import service.impl.UserServiceImpl;
import service.impl.UserValidationServiceImpl;

/**
 *
 * @author hungp
 */
@WebServlet(name = "UpdateCustomerController", urlPatterns = {"/UpdateCustomerController"})
public class UpdateCustomerController extends HttpServlet {

   private static final String ERROR = "editCustomer.jsp?userId=";
    private static final String SUCCESS = "SearchCustomerController?search=";
    private UserService userService;
    private UserValidationService userValidationService;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        boolean check = true;

        UserUpdateForm userUpdateForm = getUserForm(request);
        String userId = request.getParameter("userId");
        userValidationService = new UserValidationServiceImpl();
        UserError userError = userValidationService.UpdateUserValidation(userUpdateForm);
        if (userError != null) {
            check = false;
            url = ERROR + userId;
            request.setAttribute("USER_ERROR", userError);
            forwardToJsp(request, url, response);
        }
        if (check) {
            userService = new UserServiceImpl();
            UserCreateDto userDto = userService.updateUser(userUpdateForm);
            if (userDto != null) {
                request.setAttribute("UPDATED", userUpdateForm.getUsername());
                url = SUCCESS;
                forwardToJsp(request, url, response);
            }
        }

    }

    private void forwardToJsp(HttpServletRequest request, String url, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    private UserUpdateForm getUserForm(HttpServletRequest request) {
        String userId = request.getParameter("txtUserId");
        String fullName = request.getParameter("txtFullName");
        String address = request.getParameter("txtAddress");
        String phone = request.getParameter("txtPhone");
        String cmnd = request.getParameter("txtCmnd");
        String email = request.getParameter("txtEmail");
        return new UserUpdateForm(fullName, address, phone, cmnd, email,Integer.parseInt(userId));
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
