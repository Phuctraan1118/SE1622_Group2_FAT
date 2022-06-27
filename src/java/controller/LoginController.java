/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.UserDao;
import dto.UserDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.MyApplicationConstants;

/**
 *
 * @author buikh
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

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
        String url = siteMaps.getProperty(MyApplicationConstants.AuthenticationFeatures.HOME_PAGE);
        try {
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            String remember = request.getParameter("txtRemember");

            UserDao dao = new UserDao();
            UserDTO dto = dao.checkLogin(username, password);
            HttpSession session = request.getSession();
            if (dto != null) {

                String role = dto.getRole();
                if (role != null) {
                    switch (role) {
                        case MyApplicationConstants.AuthenticationFeatures.AD:
                            if (remember != null) {
                                Cookie cookieUsername = new Cookie("USERNAME", username);
                                cookieUsername.setMaxAge(10);
                                Cookie cookiePassword = new Cookie("PASSWORD", password);
                                cookiePassword.setMaxAge(10);
                                Cookie cookieRemember = new Cookie("REMEMBER", remember);
                                cookieRemember.setMaxAge(10);
                                response.addCookie(cookieUsername);
                                response.addCookie(cookiePassword);
                                response.addCookie(cookieRemember);
                            }
                            url = siteMaps.getProperty(MyApplicationConstants.AuthenticationFeatures.ADMIN_PAGE);
                            session.setAttribute("USER", dto);
                            break;
                        case MyApplicationConstants.AuthenticationFeatures.US:
                            if (remember != null) {
                                Cookie cookieUsername = new Cookie("USERNAME", username);
                                cookieUsername.setMaxAge(10);
                                Cookie cookiePassword = new Cookie("PASSWORD", password);
                                cookiePassword.setMaxAge(10);
                                Cookie cookieRemember = new Cookie("REMEMBER", remember);
                                cookieRemember.setMaxAge(10);
                                response.addCookie(cookieUsername);
                                response.addCookie(cookiePassword);
                                response.addCookie(cookieRemember);
                            }
                            url = siteMaps.getProperty(MyApplicationConstants.AuthenticationFeatures.USER_PAGE);
                            session.setAttribute("CUSTOMER", dto);
                            break;
                        case MyApplicationConstants.AuthenticationFeatures.STAFF:
                            if (remember != null) {
                                Cookie cookieUsername = new Cookie("USERNAME", username);
                                cookieUsername.setMaxAge(10);
                                Cookie cookiePassword = new Cookie("PASSWORD", password);
                                cookiePassword.setMaxAge(10);
                                Cookie cookieRemember = new Cookie("REMEMBER", remember);
                                cookieRemember.setMaxAge(10);
                                response.addCookie(cookieUsername);
                                response.addCookie(cookiePassword);
                                response.addCookie(cookieRemember);
                            }
                            url = siteMaps.getProperty(MyApplicationConstants.AuthenticationFeatures.STAFF_PAGE);
                            session.setAttribute("USER", dto);
                            break;
                        case MyApplicationConstants.AuthenticationFeatures.USGG:
                            url = siteMaps.getProperty(MyApplicationConstants.AuthenticationFeatures.USER_GOOGLE_PAGE);
                            session.setAttribute("USER", dto);
                            break;
                    }
                } else {
                    request.setAttribute("ERROR", "Username or password is invalid");
                }
            } else {
                request.setAttribute("ERROR", "Username or password is invalid");
            }
        } catch (NamingException | SQLException ex) {
            log(ex + " at Login Controller" + ex.getMessage());
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
