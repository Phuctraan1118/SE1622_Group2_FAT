/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.UserDao;
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
import javax.servlet.http.HttpSession;
import utils.MyApplicationConstants;

/**
 *
 * @author buikh
 */
@WebServlet(name = "UpdateAccountController", urlPatterns = {"/UpdateAccountController"})
public class UpdateAccountController extends HttpServlet {

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
        String url = siteMaps.getProperty(MyApplicationConstants.UpdateAccountFeatures.ERROR_PAGE);
        SignUpError errors = new SignUpError();
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String fullname = request.getParameter("txtFullname");
        String email = request.getParameter("txtEmail");
        String address = request.getParameter("txtAddress");
        String phone = request.getParameter("txtPhone");
        String citizenIdentification = request.getParameter("txtCitizenIdetification");
        String role = request.getParameter("txtRole");
        boolean status = Boolean.parseBoolean("txtStatus");
        String img = request.getParameter("txtImg");
        String confirm = request.getParameter("txtConfirm");
        try {
            boolean foundErr = false;
            if (password.trim().length() < 3 || password.trim().length() > 20) {
                foundErr = true;
                errors.setPasswordLengthError("Password is required from 3 to 20 chars");
            } else if (!confirm.trim().equals(password.trim())) {
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
            if (citizenIdentification.trim().length() != 12) {
                foundErr = true;
                errors.setCitizenIdentificationLengthError("CitizenIdetification is required 12 chars");
            }
            if (foundErr) {
                request.setAttribute("CREATEERRORS", errors);
            } else {
                UserDao dao = new UserDao();
                UserDTO dto = dao.updateAccount(username, password, fullname, email, address, phone, citizenIdentification, role, status, img);
                HttpSession session = request.getSession();
                if (dto != null) {
                    String authentication = dto.getRole();
                    if (authentication != null) {
                        switch (authentication) {
                            case MyApplicationConstants.AuthenticationFeatures.AD:
                                url = siteMaps.getProperty(MyApplicationConstants.UpdateAccountFeatures.ADMIN_PAGE);
                                session.setAttribute("USER", dto);
                                break;
                            case MyApplicationConstants.AuthenticationFeatures.US:
                                url = siteMaps.getProperty(MyApplicationConstants.UpdateAccountFeatures.USER_PAGE);
                                session.setAttribute("USER", dto);
                                break;
                            case MyApplicationConstants.AuthenticationFeatures.STAFF:
                                url = siteMaps.getProperty(MyApplicationConstants.UpdateAccountFeatures.STAFF_PAGE);
                                session.setAttribute("USER", dto);
                                break;
                            case MyApplicationConstants.AuthenticationFeatures.USGG:
                                url = siteMaps.getProperty(MyApplicationConstants.UpdateAccountFeatures.USER_GOOGLE_PAGE);
                                session.setAttribute("USER", dto);
                                break;
                        }
                    } else {
                        session.setAttribute("ERROR", "Your role is not valid to using this function");
                    }

                }

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
