/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.RoomDTO;
import java.io.Serializable;
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
 * @author Bitano
 */
public class RoomDAO implements Serializable {
      
       private static final String VIEW_OWNED_ROOM_FOR_CUSTOMER = "select r.roomId, r.roomDescription , r.roomPrice , r.image ,b.bookingId, b.bookingDate "
            + ", bd.checkInDate,bd.checkOutDate , b.username, r.status "
            + "from tblRoom r , tblBooking b, tblBookingDetail bd "
            + "where r.roomId = bd.roomId and b.bookingId = bd.bookingId and username = ? "
                + "order by checkInDate , r.roomId asc ";
       
    private static final String SEARCH_NOT_BOOKED = "select roomId, roomDescription , roomPrice , image from tblRoom "
            + "where roomDescription like ? "
            + "and status like 'NB' ";
    private static final String SEARCH_ALL_NOT_BOOKED = "select roomId, roomDescription , roomPrice , image from tblRoom "
            + "where status like 'NB' ";

     private static final String SEARCH_BOOKED_BY_USERNAME = "select r.roomId, r.roomDescription , r.roomPrice , r.image ,b.bookingId, b.bookingDate "
        + ", bd.checkInDate,bd.checkOutDate , b.username, r.status "
        + "from tblBooking b	, tblBookingDetail bd, tblRoom r "
        + "where b.bookingId = bd.bookingId and r.roomId = bd.roomId and b.username like ?  ";


     
    private static final String SEARCH_ALL_BOOKED = "select r.roomId, r.roomDescription , r.roomPrice , r.image ,b.bookingId, b.bookingDate "
        + ", bd.checkInDate,bd.checkOutDate , b.username, r.status "
        + "from tblBooking b, tblBookingDetail bd, tblRoom r "
        + "where b.bookingId = bd.bookingId and r.roomId = bd.roomId ";
    private static final String SEARCH_SORT_BY_DESC_AND_PRICE = "select roomId, roomDescription , roomPrice , image from tblRoom "
            + "where roomPrice > ? and roomPrice < ? and roomDescription like ? "
            + "order by roomPrice ";
    private static final String SEARCH_SORT_BY_PRICE ="select roomId, roomDescription , roomPrice , image from tblRoom "
            + "where roomPrice > ? and roomPrice < ? "
            + "order by roomPrice ";
    
    private static final String SEARCH_SORT_BY_ID_ASC = "select roomId, roomDescription , roomPrice , image from tblRoom "
            + "order by roomId ";
    
    private static final String SEARCH_SORT_BY_ID_DESC = "select roomId, roomDescription , roomPrice , image from tblRoom "
            + "order by roomId desc ";
    
    private static final String DELETE = "DELETE tblRoom WHERE roomId = ? ";
    private static final String DELETE_BOOKED = "UPDATE tblRoom SET status = 'NB'"
            + "WHERE roomId = ? ";

    private static final String UPDATE = "UPDATE tblRoom "
            + "SET roomDescription = ?,  roomPrice = ? , image = ? "
            + "WHERE roomId = ? ";
    private static final String UPDATE_BOOKED = "UPDATE tblRoom "
            + "SET roomDescription = ?,  roomPrice = ? ,image = ? "
            + "WHERE roomId = ? "
            + "UPDATE tblBooking "
            + "SET bookingDate = ?, checkinDate = ? , checkoutDate = ? "
            + "WHERE bookingId = ? ";
    
    private static final String INSERT = "INSERT into tblRoom(roomDescription,roomPrice,image,status) VALUES (?,?,?,?) ";
    private static final String LAST_ID_ROOM = " select top 1 roomId from tblRoom order by roomId desc ";

    
    public List<RoomDTO> viewOwnedRoom(String user)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<RoomDTO> list = new ArrayList();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(VIEW_OWNED_ROOM_FOR_CUSTOMER);
                 stm.setString(1,  user);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int roomId = rs.getInt("roomId");
                    String roomDescription = rs.getString("roomDescription");
                    float roomPrice = rs.getFloat("roomPrice");
                    String image = rs.getString("image");
                    int bookingId = rs.getInt("bookingId");
                    String bookingDate = rs.getString("bookingDate");
                    String checkinDate = rs.getString("checkinDate");
                    String checkoutDate = rs.getString("checkoutDate");
                    String username = rs.getString("username");
                    String status = rs.getString("status");
                    list.add(new RoomDTO(roomId, roomDescription, roomPrice, image, bookingId, bookingDate,
                            checkinDate, checkoutDate, username, status));
                }//End traverse Result Set
            }//end if connection has opened
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
        return list;

    }
    
    public List<RoomDTO> searchNotBooked(String searchValue)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<RoomDTO> list = new ArrayList();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(SEARCH_NOT_BOOKED);
                stm.setString(1, "%" + searchValue + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    int roomId = rs.getInt("roomId");
                    String roomDescription = rs.getString("roomDescription");
                    float roomPrice = rs.getFloat("roomPrice");
                    String image = rs.getString("image");
                    list.add(new RoomDTO(roomId, roomDescription, roomPrice, image));

                }//End traverse Result Set
            }//end if connection has opened
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
        return list;

    }

    public List<RoomDTO> searchAllNotBooked()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<RoomDTO> list = new ArrayList();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(SEARCH_ALL_NOT_BOOKED);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int roomId = rs.getInt("roomId");
                    String roomDescription = rs.getString("roomDescription");
                    float roomPrice = rs.getFloat("roomPrice");
                    String image = rs.getString("image");
                    list.add(new RoomDTO(roomId, roomDescription, roomPrice, image));

                }//End traverse Result Set
            }//end if connection has opened
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
        return list;

    }

    public List<RoomDTO> searchAllBooked()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<RoomDTO> list = new ArrayList();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(SEARCH_ALL_BOOKED);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int roomId = rs.getInt("roomId");
                    String roomDescription = rs.getString("roomDescription");
                    float roomPrice = rs.getFloat("roomPrice");
                    String image = rs.getString("image");
                    int bookingId = rs.getInt("bookingId");
                    String bookingDate = rs.getString("bookingDate");
                    String checkinDate = rs.getString("checkinDate");
                    String checkoutDate = rs.getString("checkoutDate");
                    String username = rs.getString("username");
                    String status = rs.getString("status");
                    list.add(new RoomDTO(roomId, roomDescription, roomPrice, image, bookingId, bookingDate,
                            checkinDate, checkoutDate, username, status));
                }//End traverse Result Set
            }//end if connection has opened
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
        return list;

    }

    public List<RoomDTO> searchBookedByUsername(String searchValue)
            throws SQLException, NamingException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<RoomDTO> list = new ArrayList();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(SEARCH_BOOKED_BY_USERNAME);
                stm.setString(1, "%" + searchValue + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    int roomId = rs.getInt("roomId");
                    String roomDescription = rs.getString("roomDescription");
                    float roomPrice = rs.getFloat("roomPrice");
                    String image = rs.getString("image");
                    int bookingId = rs.getInt("bookingId");
                    String bookingDate = rs.getString("bookingDate");
                    String checkinDate = rs.getString("checkinDate");
                    String checkoutDate = rs.getString("checkoutDate");
                    String username = rs.getString("username");
                    String status = rs.getString("status");
                    list.add(new RoomDTO(roomId, roomDescription, roomPrice, image, bookingId, bookingDate,
                            checkinDate, checkoutDate, username, status));

                }//End traverse Result Set
            }//end if connection has opened
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
        return list;

    }

    public boolean updateNotBookedRoom(RoomDTO room)
            throws SQLException, NamingException {
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(UPDATE);
                stm.setString(1, room.getRoomDescription());
                stm.setFloat(2, room.getRoomPrice());
                stm.setString(3, room.getImage());
                stm.setInt(4, room.getRoomId());
                int value = stm.executeUpdate();
                check = value > 0;

            }
        } finally {

            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }
    
    
    
    public boolean updateBookedRoom(RoomDTO room)
            throws SQLException, NamingException {
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(UPDATE_BOOKED);
                stm.setString(1, room.getRoomDescription());
                stm.setFloat(2, room.getRoomPrice());
                stm.setString(3, room.getImage());
                stm.setInt(4, room.getRoomId());
                stm.setString(5, room.getBookingDate());
                stm.setString(6, room.getCheckinDate());
                stm.setString(7, room.getCheckoutDate());
                stm.setInt(8, room.getBookingId());
                int value = stm.executeUpdate();
                check = value > 0;

            }
        } finally {

            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

    public boolean deleteNotBookedRoom(int roomId) throws SQLException, NamingException {
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(DELETE);
                stm.setInt(1, roomId);
                int value = stm.executeUpdate();
                check = value > 0;

            }
        } finally {

            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

    public boolean deleteBookedRoom(RoomDTO room) throws SQLException, NamingException {
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(DELETE_BOOKED);
                stm.setInt(1, room.getRoomId());
                int value = stm.executeUpdate();
                check = value > 0;

            }
        } finally {

            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

    public int getLastIdRoom() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int roomId = 0;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(LAST_ID_ROOM);
                rs = stm.executeQuery();
                if (rs.next()) {
                    roomId = rs.getInt("roomId");
                    return roomId;
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
        return roomId;
    }

    public boolean create(RoomDTO room)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean row = false;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(INSERT);
                stm.setString(1, room.getRoomDescription());
                stm.setFloat(2, room.getRoomPrice());
                stm.setString(3, room.getImage());
                stm.setString(4, room.getStatus());
                row = stm.executeUpdate() > 0;

            }//end if connection has opened
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return row;
    }
    
     public List<RoomDTO> searchSortByPrice(float priceMin, float priceMax)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<RoomDTO> list = new ArrayList();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(SEARCH_SORT_BY_PRICE);
                stm.setFloat(1, priceMin);
                stm.setFloat(2, priceMax);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int roomId = rs.getInt("roomId");
                    String roomDescription = rs.getString("roomDescription");
                    float roomPrice = rs.getFloat("roomPrice");
                    String image = rs.getString("image");
                    list.add(new RoomDTO(roomId, roomDescription, roomPrice, image));

                }//End traverse Result Set
            }//end if connection has opened
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
        return list;

    }
     
    public List<RoomDTO> searchSortById()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<RoomDTO> list = new ArrayList();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(SEARCH_SORT_BY_ID_ASC);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int roomId = rs.getInt("roomId");
                    String roomDescription = rs.getString("roomDescription");
                    float roomPrice = rs.getFloat("roomPrice");
                    String image = rs.getString("image");
                    list.add(new RoomDTO(roomId, roomDescription, roomPrice, image));

                }//End traverse Result Set
            }//end if connection has opened
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
        return list;

    }
    
     public List<RoomDTO> searchSortByIdDesc()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<RoomDTO> list = new ArrayList();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(SEARCH_SORT_BY_ID_DESC);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int roomId = rs.getInt("roomId");
                    String roomDescription = rs.getString("roomDescription");
                    float roomPrice = rs.getFloat("roomPrice");
                    String image = rs.getString("image");
                    list.add(new RoomDTO(roomId, roomDescription, roomPrice, image));

                }//End traverse Result Set
            }//end if connection has opened
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
        return list;

    }
     
     public List<RoomDTO> searchSortByDescAndPrice(String size ,float priceMin, float priceMax)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<RoomDTO> list = new ArrayList();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(SEARCH_SORT_BY_DESC_AND_PRICE);
                stm.setFloat(1, priceMin);
                stm.setFloat(2, priceMax);
                stm.setString(3, "%" + size + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    int roomId = rs.getInt("roomId");
                    String roomDescription = rs.getString("roomDescription");
                    float roomPrice = rs.getFloat("roomPrice");
                    String image = rs.getString("image");
                    list.add(new RoomDTO(roomId, roomDescription, roomPrice, image));

                }//End traverse Result Set
            }//end if connection has opened
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
        return list;

    }
}
