/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.util.Properties;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.MyApplicationConstants;

/**
 *
 * @author buikh
 */
public class MainController extends HttpServlet {

    private static final String CREATE_CUSTOMER = "CreateCustomerController";
    private static final String SEARCH_CUSTOMER = "SearchCustomerController";
    private static final String UPDATE_CUSTOMER = "UpdateCustomerController";
    private static final String DELETE_CUSTOMER = "DeleteCustomerController";

    private static final String CREATE_STAFF = "CreateStaffController";
    private static final String SEARCH_STAFF = "SearchStaffController";
    private static final String UPDATE_STAFF = "UpdateStaffController";
    private static final String DELETE_STAFF = "DeleteStaffController";

    private static final String CREATE_NOTIFICATION = "NotificationCreateController";
    private static final String SEARCH_NOTIFICATION = "NotificationDisplayController";
    private static final String UPDATE_NOTIFICATION = "NotificationUpdateController";
    private static final String DELETE_NOTIFICATION = "NotificationDeleteController";
    private static final String SEARCH_NOTIFICATION_FOR_CUSTOMER = "NotificationDisplayForCustomer";

    private static final String SEARCH_REGULATION = "RegulationDisplayController";
    private static final String SEARCH_REGULATION_IN_SEND_NOTI_PAGE = "RegulationForSendNotiDisplayController";
    private static final String SEARCH_REGULATION_FOR_STAFF = "RegulationDisplayForStaffController";
    private static final String DELETE_REGULATION_CONTROLLER = "RegulationDeleteController";
    private static final String CREATE_REGULATION_CONTROLLER = "RegulationCreateController";
    private static final String EDIT_REGULATION_CONTROLLER = "RegulationUpdateController";

    private static final String CREATE_FEEDBACK = "FeedbackCreateController";
    private static final String REPLY_FEEDBACK = "FeedbackReplyController";

    private static final String CREATE_SERVICE = "ServiceCreateController";
    private static final String CREATE_BILL = "BillCreateController";
    private static final String VIEW_BILL = "BillViewForUserController";

    private static final String VIEW_ROOM_DETAIL = "RoomViewDetailController";
    private static final String VIEW_ROOM_DETAIL_GOOGLE = "RoomViewDetailForGoogleController";
    private static final String EDIT_ROOM_DETAIL = "RoomViewDetailStaffController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ServletContext context = this.getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITEMAPS");
        String url = siteMaps.getProperty(MyApplicationConstants.MainControllerFeatures.HOME_PAGE);
        String button = request.getParameter("btn");
        try {
            if (button == null) {

            } else if (button.equals("login now")) {
                url = siteMaps.getProperty(MyApplicationConstants.AuthenticationFeatures.LOGIN_CONTROLLER);
            } else if (button.equals("Logout")) {
                url = siteMaps.getProperty(MyApplicationConstants.MainControllerFeatures.LOGOUT_CONTROLLER);
            } else if (button.equals("Retrieve")) {
                url = siteMaps.getProperty(MyApplicationConstants.MainControllerFeatures.FORGOT_PASSWORD_CONTROLLER);
            } else if (button.equals("Sign Up")) {
                url = siteMaps.getProperty(MyApplicationConstants.MainControllerFeatures.SIGN_UP_CONTROLLER);
            } else if (button.equals("Save Changes")) {
                url = siteMaps.getProperty(MyApplicationConstants.MainControllerFeatures.UDPATE_ACCOUNT_CONTROLLER);
            } else if (button.equals("Save")) {
                url = siteMaps.getProperty(MyApplicationConstants.MainControllerFeatures.UDPATE_ACCOUNT_GOOGLE_CONTROLLER);
            } else if (button.equals("SEARCH ROOM")) {
                url = siteMaps.getProperty(MyApplicationConstants.ManageRooms.SEARCH_ROOM_CONTROLLER);
            } else if (button.equals("SEARCH OWNED ROOM")) {
                url = siteMaps.getProperty(MyApplicationConstants.ManageRooms.SEARCH_BOOKED_ROOM_CONTROLLER);
            } else if (button.equals("Update Room")) {
                url = siteMaps.getProperty(MyApplicationConstants.ManageRooms.UPDATE_ROOM_CONTROLLER);
            } else if (button.equals("Delete Room")) {
                url = siteMaps.getProperty(MyApplicationConstants.ManageRooms.DELETE_ROOM_CONTROLLER);
            } else if (button.equals("ADD ROOM")) {
                url = siteMaps.getProperty(MyApplicationConstants.ManageRooms.ADD_ROOM_CONTROLLER);
            } else if (button.equals("Search room for customer")) {
                url = siteMaps.getProperty(MyApplicationConstants.ManageRooms.SEARCH_ROOM_FOR_CUSTOMER_CONTROLLER);
            } else if (button.equals("Search room for customer google")) {
                url = siteMaps.getProperty(MyApplicationConstants.ManageRooms.SEARCH_ROOM_FOR_CUSTOMER_GOOGLE_CONTROLLER);
            } else if (button.equals("Sort Room")) {
                url = siteMaps.getProperty(MyApplicationConstants.ManageRooms.SEARCH_SORT_ROOM_FOR_CUSTOMER_CONTROLLER);
            } else if (button.equals("Sort Room For Google")) {
                url = siteMaps.getProperty(MyApplicationConstants.ManageRooms.SEARCH_SORT_ROOM_FOR_CUSTOMER_GOOGLE_CONTROLLER);
            } else if (button.equals("Update Owned Room")) {
                url = siteMaps.getProperty(MyApplicationConstants.ManageRooms.UPDATE_BOOKED_ROOM_CONTROLLER);
            } else if (button.equals("Delete Booked Room")) {
                url = siteMaps.getProperty(MyApplicationConstants.ManageRooms.DELETE_BOOKED_ROOM_CONTROLLER);
            } else if (button.equals("Booking")) {
                url = siteMaps.getProperty(MyApplicationConstants.BookingRoomUser.BOOKING_PAGE);
            } else if (button.equals("Booking Room")) {
                url = siteMaps.getProperty(MyApplicationConstants.BookingRoom.BOOKING_PAGE);
            } else if (button.equals("Confirm Room")) {
                url = siteMaps.getProperty(MyApplicationConstants.BookingRoom.BOOKING_CONTROLLER);
            } else if (button.equals("CompletedUser")) {
                url = siteMaps.getProperty(MyApplicationConstants.MainControllerFeatures.EXECUTE_PAYMENT_CONTROLLER_USER);
            } else if (button.equals("Confirm")) {
                url = siteMaps.getProperty(MyApplicationConstants.BookingRoomUser.BOOKING_CONTROLLER);
            } else if (button.equals("ViewBooking")) {
                url = siteMaps.getProperty(MyApplicationConstants.BookingRoomUser.SHOW_BOOKING);
            } else if (button.equals("Search Customer")) {
                url = SEARCH_CUSTOMER;
            } else if (button.equals("Add Customer")) {
                url = CREATE_CUSTOMER;
            } else if (button.equals("Update Customer")) {
                url = UPDATE_CUSTOMER;
            } else if (button.equals("Delete Customer")) {
                url = DELETE_CUSTOMER;
            } else if (button.equals("Search Staff")) {
                url = SEARCH_STAFF;
            } else if (button.equals("Add Staff")) {
                url = CREATE_STAFF;
            } else if (button.equals("Update Staff")) {
                url = UPDATE_STAFF;
            } else if (button.equals("Delete Staff")) {
                url = DELETE_STAFF;
            } else if (button.equals("Add Notification")) {
                url = CREATE_NOTIFICATION;
            } else if (button.equals("Search Notification")) {
                url = SEARCH_NOTIFICATION;
            } else if (button.equals("Search Regulation")) {
                url = SEARCH_REGULATION;
            } else if (button.equals("Display Regulation In SendNotiPage")) {
                url = SEARCH_REGULATION_IN_SEND_NOTI_PAGE;
            } else if (button.equals("Search Regulation Staff")) {
                url = SEARCH_REGULATION_FOR_STAFF;
            } else if (button.equals("Delete Regulation")) {
                url = DELETE_REGULATION_CONTROLLER;
            } else if (button.equals("Add new regulation")) {
                url = CREATE_REGULATION_CONTROLLER;
            } else if (button.equals("Update Regulation")) {
                url = EDIT_REGULATION_CONTROLLER;
            } else if (button.equals("Update Notification")) {
                url = UPDATE_NOTIFICATION;
            } else if (button.equals("Remove Notification")) {
                url = DELETE_NOTIFICATION;
            } else if (button.equals("Send Feedback")) {
                url = CREATE_FEEDBACK;
            } else if (button.equals("Send Feedback Reply")) {
                url = REPLY_FEEDBACK;
            } else if (button.equals("Add Service")) {
                url = CREATE_SERVICE;
            } else if (button.equals("Create Bill")) {
                url = CREATE_BILL;
            } else if (button.equals("View Revenue")) {
                url = siteMaps.getProperty(MyApplicationConstants.ManageRevenue.VIEW_REVENUE_CONTROLLER);
            } else if (button.equals("View Owned Room")) {
                url = siteMaps.getProperty(MyApplicationConstants.ManageRooms.VIEW_ONWED_ROOM_FOR_CUSTOMER);
            } else if (button.equals("View Owned Room For Google")) {
                url = siteMaps.getProperty(MyApplicationConstants.ManageRooms.VIEW_ONWED_ROOM_GOOGLE_FOR_CUSTOMER);
            } else if (button.equals("Check Out PayPal")) {
                url = siteMaps.getProperty(MyApplicationConstants.MainControllerFeatures.CHECK_OUT_CONTROLLER);
            } else if (button.equals("Check Out")) {
                url = siteMaps.getProperty(MyApplicationConstants.MainControllerFeatures.CHECK_OUT_CONTROLLER_USER);
            } else if (button.equals("Completed")) {
                url = siteMaps.getProperty(MyApplicationConstants.MainControllerFeatures.EXECUTE_PAYMENT_CONTROLLER);
            } else if (button.equals("View Bill Of You")) {
                url = VIEW_BILL;
            } else if (button.equals("View Room Detail")) {
                url = VIEW_ROOM_DETAIL;
            } else if (button.equals("View Room Detail Google")) {
                url = VIEW_ROOM_DETAIL_GOOGLE;
            } else if (button.equals("Edit Room Detail")) {
                url = EDIT_ROOM_DETAIL;
            }

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
