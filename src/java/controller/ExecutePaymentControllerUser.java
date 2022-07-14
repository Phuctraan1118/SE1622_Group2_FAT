/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.PayPalRESTException;
import dao.PaymentDAO;
import dto.BillDBDTO;
import dto.BillDetailDTO;
import dto.BookingDTO;
import dto.BookingDetailDTO;
import dto.FeeDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.impl.PaymentService;
import utils.MyApplicationConstants;

/**
 *
 * @author buikh
 */
@WebServlet(name = "ExecutePaymentControllerUser", urlPatterns = {"/ExecutePaymentControllerUser"})
public class ExecutePaymentControllerUser extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        String paymentId = request.getParameter("paymentId");
        String payerId = request.getParameter("PayerID");
        String userId = request.getParameter("txtUserId");
        String roomId = request.getParameter("txtRoomId");
        String checkInDate = request.getParameter("txtCheckInDate");
        String checkOutDate = request.getParameter("txtCheckOutDate");
        String totalPrice = request.getParameter("txtTotalPrice");
        ServletContext context = this.getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITEMAPS");
        String url = siteMaps.getProperty(MyApplicationConstants.PaymentFeatureUser.ERROR_PAGE);
        try {
            PaymentService paymentService = new PaymentService();
            Payment payment = paymentService.executePayment(paymentId, payerId);
            PayerInfo payerInfo = payment.getPayer().getPayerInfo();
            Transaction transaction = payment.getTransactions().get(0);
            Date date = new Date();
            String bookingDate = new SimpleDateFormat("dd/MM/yyyy").format(date);
            PaymentDAO dao = new PaymentDAO();
            BookingDTO dto = dao.GetBookingId(userId, bookingDate);
            if (dto != null) {
                BookingDetailDTO bookingDetails = new BookingDetailDTO(Integer.parseInt(roomId), dto.getBookingID(), checkInDate, checkOutDate);
                BookingDetailDTO bookingDetailsChecking = dao.GetBookingDetail(bookingDetails);
                if (bookingDetailsChecking != null) {
                    BillDBDTO bill = new BillDBDTO("Bill booking", "Bill booking room no " + roomId + "from " + checkInDate + "to " + checkOutDate + " is " + totalPrice + "$");
                    boolean result = dao.AddBill(bill);
                    if (result) {
                        BillDBDTO billChecking = dao.GetBillById(bill.getDetail(), bill.getBillName());
                        if (billChecking != null) {
                            FeeDTO fee = new FeeDTO("Fee booking room no " + roomId + "from " + checkInDate + "to " + checkOutDate, Double.parseDouble(totalPrice));
                            result = dao.AddFee(fee);
                            if (result) {
                                FeeDTO feeChecking = dao.GetFeeById(fee.getDetail());
                                if (feeChecking != null) {
                                    BillDetailDTO billDetaildto = new BillDetailDTO(billChecking.getBillId(), bookingDetailsChecking.getRoomId(), bookingDate, feeChecking.getFeeId());
                                    result = dao.AddBillDetail(billDetaildto);
                                    if (result) {
                                        request.setAttribute("PAYER", payerInfo);
                                        request.setAttribute("transaction", transaction);
                                        url = siteMaps.getProperty(MyApplicationConstants.PaymentFeatureUser.RECEIPT_PAGE);
                                    }
                                }
                            }
                        }
                    }
                }
            }

        } catch (SQLException ex) {
            log("ExecutePaymentController_SQLException" + ex.toString());
        } catch (NamingException ex) {
            log("ExecutePaymentController_SQLException" + ex.getMessage());
        } catch (PayPalRESTException ex) {
            log("ExecutePaymentController_PayPalRESTException" + ex.getMessage());
        } finally {
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
