/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.EmailDAO;
import dao.UserDao;
import dto.EmailDTO;
import dto.UserDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import javax.mail.MessagingException;
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
 * @author buikh
 */
@WebServlet(name = "ForgotPasswordController", urlPatterns = {"/ForgotPasswordController"})
public class ForgotPasswordController extends HttpServlet {

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
        String url = siteMaps.getProperty(MyApplicationConstants.ForgotPasswordFeatures.FORGOT_PAGE);
        try {
            String userName = request.getParameter("userName");
            String email = request.getParameter("email");
            UserDao dao = new UserDao();
            UserDTO account = dao.findByUsernameAndEmail(userName, email);
            if (account != null) {
                EmailDTO _email = new EmailDTO();
                _email.setFrom("nguyenbkse151446@fpt.edu.vn");
                _email.setFromPassword("khoinguyen712");
                _email.setTo(email);
                _email.setSubject("Forgot Password Funtion");
                StringBuilder sb = new StringBuilder();
                sb.append("Dear ").append(userName).append("<br>");
                sb.append("You are used the forgot password funtion. <br> ");
                sb.append("I am an adminstration in Hostel Management Company <br> ");
                sb.append("Your password is <b>").append(account.getPassword()).append("</b><br>");
                sb.append("Regards <br>");
                sb.append("Administrator.");

                _email.setContent(sb.toString());
                EmailDAO.send(_email);
                url = siteMaps.getProperty(MyApplicationConstants.ForgotPasswordFeatures.FORGOT_PAGE);
                request.setAttribute("ERROR", "Email send to the email Address."
                        + "Please check and get your password!");
            } else {
                request.setAttribute("ERROR", "UserName or Email are incorrect!");
            }
        }catch (NamingException | SQLException | MessagingException ex) {
            request.setAttribute("ERROR", ex.getMessage());
        }finally {
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
