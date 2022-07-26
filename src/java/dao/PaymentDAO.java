/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.BillDBDTO;
import dto.BillDetailDTO;
import dto.BookingDTO;
import dto.BookingDetailDTO;
import dto.FeeDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import utils.DBHelper;

/**
 *
 * @author buikh
 */
public class PaymentDAO {

    private final String FIND_USER_BY_USERNAME = "Select bookingId, username, bookingDate "
            + "From tblBooking "
            + "Where username = ? AND bookingDate = ?";
    private final String FIND_BOOKING_ID_USERNAME = "Select roomId, bookingId, checkInDate, checkOutDate "
            + "From tblBookingDetail "
            + "Where bookingId = ? AND roomId = ? AND checkInDate = ? AND checkOutDate = ?";
    private final String INSERT_NEW_BOOKING = "Insert Into tblBill("
            + "billName, detail"
            + ") Values (?, ?)";
    private final String FIND_BILL_BOOKING_BY_BILL_ID = "Select billId, billName, detail "
            + "From tblBill "
            + "Where detail = ? AND billName = ?";
    private final String INSERT_NEW_FEES = "Insert Into tblFees("
            + "detail, feesPrice"
            + ") Values (?, ?)";
    private final String INSERT_NEW_BILL_DETAIL = "Insert Into tblBillDetail("
            + "billId, roomId, date, feeId"
            + ") Values (?, ?, ?, ?)";
    private final String FIND_FEE_BY_FEE_ID = "Select feeId, detail, feesPrice "
            + "From tblFees "
            + "Where detail = ?";
    public boolean AddBillDetail(BillDetailDTO dto) throws NamingException, SQLException {
        if (dto == null) {
            return false;
        }
        Connection con = null;
        PreparedStatement stm = null;

        try {
            //1. Connect to DB
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(INSERT_NEW_BILL_DETAIL);
                stm.setInt(1, dto.getBillId());
                stm.setInt(2, dto.getRoomId());
                stm.setString(3, dto.getDate());
                stm.setInt(4, dto.getFeeId());
                int effectRow = stm.executeUpdate();
                if (effectRow > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    public FeeDTO GetFeeById(String feeId) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Connect to DB
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(FIND_FEE_BY_FEE_ID);
                stm.setString(1, feeId);
                rs = stm.executeQuery();
                if (rs.next()) {
                    int feeIdDTO = rs.getInt("feeId");
                    String detail = rs.getString("detail");
                    double feePrice = rs.getDouble("feesPrice");
                    FeeDTO dto = new FeeDTO(feeIdDTO, detail, feePrice);
                    return dto;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }
    public boolean AddFee(FeeDTO dto) throws NamingException, SQLException {
        if (dto == null) {
            return false;
        }
        Connection con = null;
        PreparedStatement stm = null;

        try {
            //1. Connect to DB
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(INSERT_NEW_FEES);
                stm.setString(1, dto.getDetail());
                stm.setDouble(2, dto.getFeesPrice());
                int effectRow = stm.executeUpdate();
                if (effectRow > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    
    public boolean AddBill(BillDBDTO dto) throws NamingException, SQLException {
        if (dto == null) {
            return false;
        }
        Connection con = null;
        PreparedStatement stm = null;

        try {
            //1. Connect to DB
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(INSERT_NEW_BOOKING);
                stm.setString(1, dto.getBillName());
                stm.setString(2, dto.getDetail());
                int effectRow = stm.executeUpdate();
                if (effectRow > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public BookingDTO GetBookingId(String username, String bookingDate) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Connect to DB
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(FIND_USER_BY_USERNAME);
                stm.setString(1, username);
                stm.setString(2, bookingDate);
                rs = stm.executeQuery();
                if (rs.next()) {
                    int bookingId = rs.getInt("bookingId");
                    String usernameDTO = rs.getString("username");
                    String bookingDateDTO = rs.getString("bookingDate");
                    BookingDTO dto = new BookingDTO(bookingId, bookingDateDTO, usernameDTO);
                    return dto;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public BillDBDTO GetBillById(String detail, String billName) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Connect to DB
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(FIND_BILL_BOOKING_BY_BILL_ID);
                stm.setString(1, detail);
                stm.setString(2, billName);
                rs = stm.executeQuery();
                if (rs.next()) {
                    int billIdDTO = rs.getInt("billId");
                    String billNameDTO = rs.getString("billName");
                    String detailDTO = rs.getString("detail");
                    BillDBDTO dto = new BillDBDTO(billIdDTO, billNameDTO, detailDTO);
                    return dto;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public BookingDetailDTO GetBookingDetail(BookingDetailDTO booking) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Connect to DB
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(FIND_BOOKING_ID_USERNAME);
                stm.setInt(1, booking.getBookingId());
                stm.setInt(2, booking.getRoomId());
                stm.setString(3, booking.getCheckInDate());
                stm.setString(4, booking.getCheckOutDate());
                rs = stm.executeQuery();
                if (rs.next()) {
                    int bookingId = rs.getInt("bookingId");
                    int roomId = rs.getInt("roomId");
                    String checkInDate = rs.getString("checkInDate");
                    String checkOutDate = rs.getString("checkOutDate");
                    BookingDetailDTO dto = new BookingDetailDTO(roomId, bookingId, checkInDate, checkOutDate);
                    return dto;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }
}
