/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dto.UserCreateDto;
import form.UserCreateForm;
import form.UserError;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
public class CreateStaffController extends HttpServlet {

    private static final String SUCCESS = "admin1.jsp";
    private static final String FAIL = "admin.jsp";
    private UserService userService;
    private UserValidationService userValidationService;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = FAIL;
        UserCreateForm userCreateForm = getUserForm(request);
        userValidationService = new UserValidationServiceImpl();
        UserError userError = userValidationService.createUserValidation(userCreateForm);
        if(userError != null){
            request.setAttribute("USER_ERROR", userError);
            forwardToJsp(request, url, response);
        }
        userService = new UserServiceImpl();
        if(userService.isDupplicated(userCreateForm.getUsername())){
            request.setAttribute("USER_DUPPLICATE", userCreateForm.getUsername());
            forwardToJsp(request, url, response);
        }
        UserCreateDto userCreateDto = userService.createUser(userCreateForm);
        if(userCreateDto != null){
            url = SUCCESS;
        }
        forwardToJsp(request, url, response);
    }

    private void forwardToJsp(HttpServletRequest request, String url, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    private UserCreateForm getUserForm(HttpServletRequest request) {
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String fullName = request.getParameter("txtFullName");
        String email = request.getParameter("txtEmail");
        String address = request.getParameter("txtAddress");
        String phone = request.getParameter("txtPhone");
        String citizenIdentification = request.getParameter("txtCitizenIdentification");
        String img = request.getParameter("txtImg");
        return new UserCreateForm(username, password, fullName, address, phone, citizenIdentification, true, "STAFF", email, img);
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
