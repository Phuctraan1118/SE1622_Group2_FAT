/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.FeedbackDAO;
import dao.FeedbackReplyDao;
import dto.FeedbackReplyDto;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hungp
 */
//STAFF SEND FEEDBACK FOR USER
@WebServlet(name = "FeedbackReplyController", urlPatterns = {"/FeedbackReplyController"})
public class FeedbackReplyController extends HttpServlet {

    private static final String ERROR = "replyFeedback.jsp";
    private static final String SUCCESS = "replyFeedback.jsp?feedbackId=";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String content = request.getParameter("txtReplyFeedback");
        String username = request.getParameter("txtUsername");
        String feedbackId = request.getParameter("txtFeedbackId");
        String url = ERROR;
        try {
            FeedbackReplyDao dao = new FeedbackReplyDao();
            FeedbackReplyDto dto = new FeedbackReplyDto(content, username);
            boolean result = dao.replyFeedback(dto);
            FeedbackDAO feedbackDAO = new FeedbackDAO();
            feedbackDAO.deleteFeedbackAfterReply(feedbackId);

            if (result) {
                url = SUCCESS + feedbackId;
                request.setAttribute("REPLY_SUCCESS", dto.getUsername());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
        //user gui feedback toi staff (thong tin user, content, idfeedback , contentId )
        //staff nhan duoc feedback -> staff reply (thong tin cua staff , content 
        //user nhan dc feedback
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
