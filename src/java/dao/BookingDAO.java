/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.BookingDTO;
import dto.BookingDetailDTO;
import dto.BookingInformationDTO;
import dto.RoomDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import utils.DBHelper;

/**
 *
 * @author buikh
 */
public class BookingDAO {

     private final String INSERT_NEW_BOOKING = "Insert Into tblBooking("
            + "username, bookingDate"
            + ") Values (?, ?)";
    private final String INSERT_NEW_BOOKING_DETAIL = "Insert Into tblBookingDetail("
            + "roomId, bookingId, checkInDate, checkOutDate"
            + ") Values (?, ?, ?, ?)";
    private static final String BOOKING_ROOM = "Update tblRoom "
            + "SET status = ? "
            + "WHERE roomId = ?";
    private static final String SHOW_BOOKING_ROOM = "Select b.bookingId, b.username, bd.roomId, b.bookingDate, bd.checkinDate, bd.checkoutDate "
            + "From tblBooking b, tblBookingDetail bd "
            + "Where b.bookingId = bd.bookingId";
    private static final String SHOW_OWN_BOOKING_ROOM = "Select b.bookingId, b.username, b.bookingDate "
            + "From tblBooking b, tblUser u "
            + "Where b.username = ? And b.bookingDate = ? And b.username = u.username";
    private static final String SHOW_CHECK_IN_OUT_DATE = "Select roomId, bookingId, checkInDate, checkOutDate "
            + "From tblBookingDetail "
            + "Where roomId = ?";
    private final String GET_ROOM_PRICE = "Select roomId, roomDescription, roomPrice, image, status "
            + "from tblRoom "
            + "Where roomId = ?";
    private List<BookingDTO> bookings;
    
    private List<BookingDetailDTO> bookingDetails;
    
    private List<BookingInformationDTO> bookingInformation;
    
    public List<BookingDTO> getBookings() {
        return bookings;
    }

    public List<BookingDetailDTO> getBookingDetails() {
        return bookingDetails;
    }

    public List<BookingInformationDTO> getBookingInformation() {
        return bookingInformation;
    }

    public RoomDTO GetRoomPrice(int roomId) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Connect to DB
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(GET_ROOM_PRICE);
                stm.setInt(1, roomId);
                rs = stm.executeQuery();
                if(rs.next()){
                    int roomIdDTO = rs.getInt("roomId");
                    String roomDescription = rs.getString("roomDescription");
                    float roomPrice = rs.getFloat("roomPrice");
                    String image = rs.getString("image");
                    String status = rs.getString("status");
                    RoomDTO dto = new RoomDTO(roomIdDTO, roomDescription, roomPrice, image, status);
                    return dto;
                }
            }
        } finally {
            if(rs != null){
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
    public boolean AddBooking(BookingDTO dto) throws NamingException, SQLException {
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
                stm.setString(1, dto.getUsername());
                stm.setString(2, dto.getBookingDate());
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
    
    public boolean AddBookingDetail(BookingDetailDTO dto) throws NamingException, SQLException {
        if (dto == null) {
            return false;
        }
        Connection con = null;
        PreparedStatement stm = null;

        try {
            //1. Connect to DB
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(INSERT_NEW_BOOKING_DETAIL);
                stm.setInt(1, dto.getRoomId());
                stm.setInt(2, dto.getBookingId());
                stm.setString(3, dto.getCheckInDate());
                stm.setString(4, dto.getCheckOutDate());
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
    
    public void showBooking()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {

                String sql = SHOW_BOOKING_ROOM;
                stm = con.prepareStatement(sql);

                rs = stm.executeQuery();

                while (rs.next()) {
                    String bookingId = rs.getString("bookingId");
                    String username = rs.getString("username");
                    String roomId = rs.getString("roomId");
                    String bookingDate = rs.getString("bookingDate");
                    String checkinDate = rs.getString("checkinDate");
                    String checkoutDate = rs.getString("checkoutDate");

                    BookingInformationDTO dto = new BookingInformationDTO(bookingId, username, roomId, bookingDate, checkinDate, checkoutDate);
                    if (this.bookingInformation == null) {
                        this.bookingInformation = new ArrayList<>();
                    }
                    
                    this.bookingInformation.add(dto);
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
    }
    
    
    
    public BookingDTO showBooking(String username, String bookingDate)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        BookingDTO dto = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {

                String sql = SHOW_OWN_BOOKING_ROOM;
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, bookingDate);
                rs = stm.executeQuery();

                if (rs.next()) {
                    int bookingId = rs.getInt("bookingId");
                    String usernameDTO = rs.getString("username");
                    String bookingDateDTO = rs.getString("bookingDate");
                    dto = new BookingDTO(bookingId, bookingDateDTO, usernameDTO);
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
        return dto;
    }
    
    public void showBookingDetail_CheckInDate_Or_CheckOutDate(String roomId)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        BookingDetailDTO dto = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {

                String sql = SHOW_CHECK_IN_OUT_DATE;
                stm = con.prepareStatement(sql);
                stm.setString(1, roomId);
                rs = stm.executeQuery();

                while(rs.next()) {
                    int roomIdDTO = rs.getInt("roomId");
                    int bookingId = rs.getInt("bookingId");
                    String checkInDate = rs.getString("checkInDate");
                    String checkOutDate = rs.getString("checkOutDate");
                    dto = new BookingDetailDTO(roomIdDTO, bookingId, checkInDate, checkOutDate);
                    if(this.bookingDetails == null){
                        this.bookingDetails = new ArrayList<>();
                    }
                    this.bookingDetails.add(dto);
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
    }
}
