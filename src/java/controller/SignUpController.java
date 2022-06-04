/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.UserDAO;
import dto.SignUpError;
import dto.UserDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "SignUpController", urlPatterns = {"/SignUpController"})
public class SignUpController extends HttpServlet {

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
        ServletContext context = this.getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITEMAPS");
        
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String confirm = request.getParameter("txtConfirm");
        String fullname = request.getParameter("txtFullname");
        String email = request.getParameter("txtEmail");
        String address = request.getParameter("txtAddress");
        String phone = request.getParameter("txtPhone");
        String CitizenIdetification = request.getParameter("txtCitizenIdetification");  
        
        SignUpError errors = new SignUpError();
        boolean foundErr = false;
        String url = siteMaps.getProperty(MyApplicationConstants.SignUpFeatures.ERROR_PAGE);
        try {
            if (username.trim().length() < 6 ||
                    username.trim().length() > 20) {
                foundErr = true;
                errors.setUsernameLengthError("Username is required from 6 to 20 chars");
            }
            if (password.trim().length() < 3 ||
                    username.trim().length() > 20) {
                foundErr = true;
                errors.setPasswordLengthError("Password is required from 3 to 20 chars");
            }else if (!confirm.trim().equals(password.trim())) {
                foundErr = true;
                errors.setConfirmNotMatched("Confirm must match password");
            }
            if (fullname.trim().length() < 2 || fullname.trim().length() > 50) {
                foundErr = true;
                errors.setFullnameLengthError("Fullname is required from 2 to 50 chars");
            }
            if (email.trim().length() < 6 || email.trim().length() > 400) {
                foundErr = true;
                errors.setEmailLengthError("Email is required from 6 to 400 chars");
            }
            if (address.trim().length() < 3 || address.trim().length() > 50) {
                foundErr = true;
                errors.setAddressLengthError("Address is required from 3 to 50 chars");
            }
            if (phone.trim().length() != 10) {
                foundErr = true;
                errors.setPhoneLengthError("Phone is required 10 chars");
            }
            if (CitizenIdetification.trim().length() != 12) {
                foundErr = true;
                errors.setCitizenIdentificationLengthError("CitizenIdetification is required 12 chars");
            }
            if (foundErr) {
                request.setAttribute("CREATEERRORS", errors);
            } else {
                UserDAO dao = new UserDAO();
                UserDTO dto = new UserDTO(username, password, address, phone, CitizenIdetification, true, "US", fullname, email, "assets/images/userImage/user-default.png");
                boolean result = dao.createNewAccount(dto);
                if (result){
                    url = siteMaps.getProperty(MyApplicationConstants.SignUpFeatures.HOME_PAGE);
                }
            }
        }catch(SQLException ex){
            String msg = ex.getMessage();
            log("SignUpController _ SQL " + msg);
            if (msg.contains("duplicate")) {
                errors.setUsernameIsExisted(username + " is existed");
                request.setAttribute("CREATEERRORS", errors);
            }
        }catch(NamingException ex){
            log("CreateAccountServlet _ Naming " + ex.getMessage());
        } finally{
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
