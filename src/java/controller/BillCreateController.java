/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.BillDao;
import dao.FeedbackDAO;
import dto.BillDBDTO;
import dto.BillDetailDTO;
import dto.FeedbackDTO;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "BillCreateController", urlPatterns = {"/BillCreateController"})
public class BillCreateController extends HttpServlet {

    private static final String FAIL = "bill.jsp";
    private static final String SUCCESS = "bill.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String total = request.getParameter("txtTotal");
        String roomId = request.getParameter("txtRoomId");
        String serviceId = request.getParameter("txtServiceId");
        String url = FAIL;
        try {

            Date date = new Date();
            String billDate = new SimpleDateFormat("dd/MM/yyyy").format(date);
            BillDBDTO bill = new BillDBDTO("BILL ROOM FEE", "BILL ROOM " + roomId + " FROM " + billDate + " IS " + total + "$");
            BillDao dao = new BillDao();
            boolean result = dao.addBill(bill);
            if (result) {
                BillDBDTO billChecking = dao.GetBillById(bill.getDetail(), bill.getBillName());
                if (billChecking != null) {
                    BillDetailDTO billDetaildto = new BillDetailDTO(billChecking.getBillId(),Integer.parseInt(roomId), Integer.parseInt(serviceId), billDate);
                    result = dao.addBillDetail(billDetaildto);
                    if (result) {
                        request.setAttribute("CREATE_SUCCESS", billChecking.getBillName());
                        url = SUCCESS;
                    }
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
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
