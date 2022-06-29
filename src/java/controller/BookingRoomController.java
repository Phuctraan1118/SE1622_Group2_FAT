/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.BookingDAO;
import dto.BookingDTO;
import dto.BookingDetailDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Properties;
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
@WebServlet(name = "BookingRoomController", urlPatterns = {"/BookingRoomController"})
public class BookingRoomController extends HttpServlet {

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
        String url = siteMaps.getProperty(MyApplicationConstants.BookingRoomUser.BOOKING_PAGE);
        String roomID = request.getParameter("txtRoomId");
        String username = request.getParameter("txtUsername");
        String checkInDate = request.getParameter("txtCheckInDate");
        String checkOutDate = request.getParameter("txtCheckOutDate");
        String notification = "Can not skip checkInDate or checkOutDate!";
        boolean flag = false;
        try {
            if (checkInDate.trim().length() > 0 && checkOutDate.trim().length() > 0) {
                if (LocalDate.parse(checkOutDate).compareTo(LocalDate.parse(checkInDate)) > 0) {
                    Date date = new Date();
                    String bookingDate = new SimpleDateFormat("dd/MM/yyyy").format(date);
                    if (LocalDate.parse(checkInDate).compareTo(java.time.LocalDate.now()) < 0
                            || LocalDate.parse(checkOutDate).compareTo(java.time.LocalDate.now()) < 0) {
                        request.setAttribute("ERROR", "Add room Failed");
                        url = siteMaps.getProperty(MyApplicationConstants.BookingRoomUser.BOOKING_PAGE);
                    } else {
                        BookingDAO dao = new BookingDAO();
                        BookingDTO bookingDTO = dao.showBooking(username, bookingDate);
                        if (bookingDTO != null) {
                            dao.showBookingDetail_CheckInDate_Or_CheckOutDate(roomID);
                            List<BookingDetailDTO> bookingDetailDTO1 = dao.getBookingDetails();
                            if (bookingDetailDTO1 != null) {
                                for (BookingDetailDTO b : bookingDetailDTO1) {
                                    flag = false;
                                    if (LocalDate.parse(b.getCheckInDate()).getMonthValue() == LocalDate.parse(checkInDate).getMonthValue()
                                            && LocalDate.parse(b.getCheckOutDate()).getMonthValue() == LocalDate.parse(checkOutDate).getMonthValue()) {
                                        if (LocalDate.parse(checkInDate).compareTo(LocalDate.parse(b.getCheckInDate())) >= 0
                                                && LocalDate.parse(checkOutDate).compareTo(LocalDate.parse(b.getCheckOutDate())) <= 0) {
                                            request.setAttribute("ERROR", "Add room Failed");
                                            url = siteMaps.getProperty(MyApplicationConstants.BookingRoomUser.BOOKING_PAGE);
                                            break;
                                        }
                                        if (LocalDate.parse(checkInDate).isAfter(LocalDate.parse(b.getCheckOutDate()))) {
                                            flag = true;
                                        }
                                    }
                                    if (LocalDate.parse(b.getCheckInDate()).getMonthValue() != LocalDate.parse(checkInDate).getMonthValue()
                                            || LocalDate.parse(b.getCheckOutDate()).getMonthValue() != LocalDate.parse(checkOutDate).getMonthValue()) {
                                        if (LocalDate.parse(checkInDate).compareTo(LocalDate.parse(b.getCheckInDate())) >= 0
                                                && LocalDate.parse(checkOutDate).compareTo(LocalDate.parse(b.getCheckOutDate())) <= 0) {
                                            request.setAttribute("ERROR", "Add room Failed");
                                            url = siteMaps.getProperty(MyApplicationConstants.BookingRoomUser.BOOKING_PAGE);
                                            break;
                                        }
                                        if (LocalDate.parse(checkInDate).isAfter(LocalDate.parse(b.getCheckOutDate()))) {
                                            flag = true;
                                        }
                                    }
                                }
                                if (flag) {
                                    BookingDetailDTO dto = new BookingDetailDTO(Integer.parseInt(roomID), bookingDTO.getBookingID(), checkInDate, checkOutDate);
                                    boolean result = dao.AddBookingDetail(dto);
                                    if (result) {
                                        request.setAttribute("SUCCESS", "Booking room " + roomID + "successfully");
                                        url = siteMaps.getProperty(MyApplicationConstants.BookingRoomUser.BOOKING_PAGE);
                                    } else {
                                        request.setAttribute("ERROR", "Add room Failed");
                                    }
                                }
                            } else {
                                BookingDetailDTO dto = new BookingDetailDTO(Integer.parseInt(roomID), bookingDTO.getBookingID(), checkInDate, checkOutDate);
                                boolean result = dao.AddBookingDetail(dto);
                                if (result) {
                                    request.setAttribute("SUCCESS", "Booking room " + roomID + "successfully");
                                    url = siteMaps.getProperty(MyApplicationConstants.BookingRoomUser.BOOKING_PAGE);
                                } else {
                                    request.setAttribute("ERROR", "Add room Failed");
                                }
                            }

                        } else {
                            dao.showBookingDetail_CheckInDate_Or_CheckOutDate(roomID);
                            List<BookingDetailDTO> bookingDetailDTO2 = dao.getBookingDetails();
                            if (bookingDetailDTO2 != null) {
                                for (BookingDetailDTO b : bookingDetailDTO2) {
                                    flag = false;
                                    if (LocalDate.parse(b.getCheckInDate()).getMonthValue() == LocalDate.parse(checkInDate).getMonthValue()
                                            && LocalDate.parse(b.getCheckOutDate()).getMonthValue() == LocalDate.parse(checkOutDate).getMonthValue()) {
                                        if (LocalDate.parse(checkInDate).compareTo(LocalDate.parse(b.getCheckInDate())) >= 0
                                                && LocalDate.parse(checkOutDate).compareTo(LocalDate.parse(b.getCheckOutDate())) <= 0) {
                                            request.setAttribute("ERROR", "Add room Failed");
                                            url = siteMaps.getProperty(MyApplicationConstants.BookingRoomUser.BOOKING_PAGE);
                                            request.getRequestDispatcher(url).forward(request, response);

                                        }
                                        if (LocalDate.parse(checkInDate).isAfter(LocalDate.parse(b.getCheckOutDate()))) {
                                            flag = true;
                                        }
                                    }
                                    if (LocalDate.parse(b.getCheckInDate()).getMonthValue() != LocalDate.parse(checkInDate).getMonthValue()
                                            || LocalDate.parse(b.getCheckOutDate()).getMonthValue() != LocalDate.parse(checkOutDate).getMonthValue()) {
                                        if (LocalDate.parse(checkInDate).compareTo(LocalDate.parse(b.getCheckInDate())) >= 0
                                                && LocalDate.parse(checkOutDate).compareTo(LocalDate.parse(b.getCheckOutDate())) <= 0) {
                                            request.setAttribute("ERROR", "Add room Failed");
                                            url = siteMaps.getProperty(MyApplicationConstants.BookingRoomUser.BOOKING_PAGE);
                                            request.getRequestDispatcher(url).forward(request, response);

                                        }
                                        if (LocalDate.parse(checkInDate).isAfter(LocalDate.parse(b.getCheckOutDate()))) {
                                            flag = true;
                                        }
                                    }
                                }
                                if (flag) {
                                    boolean resultBooking = dao.AddBooking(new BookingDTO(bookingDate, username));
                                    if (resultBooking) {
                                        BookingDTO dto = dao.showBooking(username, bookingDate);
                                        if (dto != null) {
                                            resultBooking = dao.AddBookingDetail(new BookingDetailDTO(Integer.parseInt(roomID), dto.getBookingID(), checkInDate, checkOutDate));
                                            if (resultBooking) {
                                                request.setAttribute("SUCCESS", "Booking room " + roomID + "successfully");
                                                url = siteMaps.getProperty(MyApplicationConstants.BookingRoomUser.BOOKING_PAGE);
                                            } else {
                                                request.setAttribute("ERROR", "Add room Failed");
                                            }
                                        } else {
                                            request.setAttribute("ERROR", "Add room Failed");
                                        }
                                    } else {
                                        request.setAttribute("ERROR", "Add room Failed");
                                    }
                                }
                            } else {
                                boolean resultBooking = dao.AddBooking(new BookingDTO(bookingDate, username));
                                if (resultBooking) {
                                    BookingDTO dto = dao.showBooking(username, bookingDate);
                                    if (dto != null) {
                                        resultBooking = dao.AddBookingDetail(new BookingDetailDTO(Integer.parseInt(roomID), dto.getBookingID(), checkInDate, checkOutDate));
                                        if (resultBooking) {
                                            request.setAttribute("SUCCESS", "Booking room " + roomID + "successfully");
                                            url = siteMaps.getProperty(MyApplicationConstants.BookingRoomUser.BOOKING_PAGE);
                                        } else {
                                            request.setAttribute("ERROR", "Add room Failed");
                                        }
                                    } else {
                                        request.setAttribute("ERROR", "Add room Failed");
                                    }
                                } else {
                                    request.setAttribute("ERROR", "Add room Failed");
                                }
                            }
                        }
                    }
                } else {
                    notification = "CheckInDate need to smaller than CheckOutDate ";
                    request.setAttribute("ERROR", notification);
                }
            } else {
                request.setAttribute("ERROR", notification);
            }

        } catch (NamingException ex) {
            log("BookingRoomController _ NamingException " + ex.getMessage());
        } catch (SQLException ex) {
            log("BookingRoomController _ SQLException " + ex.getMessage());
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
