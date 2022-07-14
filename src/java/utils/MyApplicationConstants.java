/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author buikh
 */
public class MyApplicationConstants {

    public class MainControllerFeatures {

        public static final String HOME_PAGE = "";
        public static final String LOGOUT_CONTROLLER = "logoutController";
        public static final String FORGOT_PASSWORD_CONTROLLER = "forgotPasswordController";
        public static final String SIGN_UP_CONTROLLER = "signUpController";
        public static final String UDPATE_ACCOUNT_CONTROLLER = "updateAccountController";
        public static final String UDPATE_ACCOUNT_GOOGLE_CONTROLLER = "updateAccountGoogleController";
        public static final String CHECK_OUT_CONTROLLER = "authorizePaymentController";
        public static final String EXECUTE_PAYMENT_CONTROLLER = "executePaymentController";
        public static final String CHECK_OUT_CONTROLLER_USER = "authorizePaymentControllerUser";
        public static final String EXECUTE_PAYMENT_CONTROLLER_USER = "executePaymentControllerUser";
    }

    public class AuthenticationFeatures {

        public static final String LOGIN_CONTROLLER = "loginController";
        public static final String HOME_PAGE = "";
        public static final String USER_PAGE = "userPage";
        public static final String USER_GOOGLE_PAGE = "userGooglePage";
        public static final String ADMIN_PAGE = "adminPage";
        public static final String STAFF_PAGE = "staffPage";
        public static final String CUSTOMER_PAGE = "customerPage";
        public static final String STAFF = "STAFF";
        public static final String US = "US";
        public static final String AD = "AD";
        public static final String USGG = "USGOOGLE";
        public static final String MANAGEMENT_ROOM_PAGE = "managementRoomPage";
        
        
    }

    public class LoginGoogleController {

        public static final String LOGIN_CONTROLLER = "loginController";
        public static final String HOME_PAGE = "";
        public static final String USER_GOOGLE_PAGE = "userGoogle";

    }

    public class ForgotPasswordFeatures {

        public static final String FORGOT_PAGE = "forgotpasswordPage";
    }

    public class SignUpFeatures {

        public static final String ERROR_PAGE = "signUpErrorPage";
        public static final String LOGIN_PAGE = "loginPage";
    }

    public class UpdateAccountFeatures {

        public static final String ERROR_PAGE = "editProfilePage";
        public static final String USER_PAGE = "userPage";
        public static final String ADMIN_PAGE = "adminPage";
        public static final String STAFF_PAGE = "staffPage";
        public static final String USER_GOOGLE_PAGE = "userGooglePage";
        public static final String ERROR_GOOGLE_PAGE = "editProfileGooglePage";
    }

 public class ManageRooms {

        public static final String SEARCH_ROOM_CONTROLLER = "roomSearchController";
        public static final String SEARCH_BOOKED_ROOM_CONTROLLER = "roomSearchBookedController";
        public static final String SEARCH_ROOM_FOR_CUSTOMER_CONTROLLER = "roomSearchCustomerController";
        public static final String SEARCH_ROOM_FOR_CUSTOMER_GOOGLE_CONTROLLER = "searchRoomForCustomerGoogleController";
        public static final String SEARCH_SORT_ROOM_FOR_CUSTOMER_CONTROLLER = "roomSearchSortCustomerController";
        public static final String SEARCH_SORT_ROOM_FOR_CUSTOMER_GOOGLE_CONTROLLER = "roomSearchSortCustomerGoogleController";

        public static final String DELETE_ROOM_CONTROLLER = "roomDeleteController";
        public static final String DELETE_BOOKED_ROOM_CONTROLLER = "roomDeleteBookedController";

        public static final String UPDATE_ROOM_CONTROLLER = "roomUpdateController";
        public static final String UPDATE_BOOKED_ROOM_CONTROLLER = "roomUpdateBookedController";
        public static final String EDIT_ROOM_PAGE = "editRoomPage";
        public static final String EDIT_OWNED_ROOM_PAGE = "editOwnedRoomPage";

        public static final String ADD_ROOM_CONTROLLER = "roomAddController";
        public static final String ADD_ROOM_ERROR = "addRoomErrorPage";   
        public static final String VIEW_ONWED_ROOM_FOR_CUSTOMER = "roomOwnedViewController";
        public static final String VIEW_ONWED_ROOM_FOR_CUSTOMER_PAGE = "ownedRoomPage";
        public static final String VIEW_ONWED_ROOM_GOOGLE_FOR_CUSTOMER = "roomOwnedViewGoogleController";
        public static final String VIEW_ONWED_ROOM_GOOGLE_FOR_CUSTOMER_PAGE = "ownedRoomGooglePage";
    }
    public class BookingRoomUser {
        public static final String CHECK_OUT_PAGE = "checkOutPage";
        public static final String BOOKING_PAGE = "bookingPage";
        public static final String BOOKING_CONTROLLER = "bookingRoomController";
        public static final String SHOW_BOOKING = "showBookingController";
    }
    
    public class BookingRoom{
        public static final String BOOKING_PAGE = "bookingPageUser";
        public static final String BOOKING_CONTROLLER = "bookingRoomControllerUser";
        public static final String CHECK_OUT_PAGE = "checkOutPageUser";
    }
 
    public class ManageRevenue {
        public static final String REVENUE_PAGE="revenueManagementPage";
        public static final String VIEW_REVENUE_CONTROLLER="revenueShowController";
    }
    
    public class PaymentFeature{
        public static final String RECEIPT_PAGE = "receiptPage";
        public static final String ERROR_PAGE = "errorReceiptPage";
    }
    
    public class PaymentFeatureUser{
        public static final String RECEIPT_PAGE = "receiptPageUser";
        public static final String ERROR_PAGE = "errorReceiptPageUser";
    }
}
