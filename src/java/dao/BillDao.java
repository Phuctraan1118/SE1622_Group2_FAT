/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.BillDBDTO;
import dto.BillDTO;
import dto.BillDetailDTO;
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
 * @author hungp
 */
public class BillDao {

    private final String INSERT_BILL = "Insert Into tblBill("
            + "billName, detail"
            + ") Values (?, ?)";
    private final String FIND_BILL_BY_ID = "Select billId, billName, detail "
            + "From tblBill "
            + "Where detail = ? AND billName = ?";
    private final String INSERT_NEW_BILL_DETAIL = "Insert Into tblBillDetail("
            + "billId, roomId, date,serviceId"
            + ") Values (?, ?, ?, ?)";
   
    
    private final String VIEW_BILL_FOR_USER = "select b.billName , b.detail ,bd.date , r.roomId , r.roomPrice , s.electronicDetail , s.waterDetail, "
            + "s.electronicPrice, s.waterPrice "
            + "from tblBill b, tblBillDetail bd , tblRoom r, tblBooking bk, tblBookingDetail bkd , tblService s "
            + "where b.billId = bd.billId and bd.roomId = r.roomId and r.roomId = bkd.roomId and bk.bookingId = bkd.bookingId "
            + "and bd.serviceId = s.serviceId and b.billName like 'BILL ROOM FEE' and username like ? ";
    public boolean addBill(BillDBDTO dto) throws NamingException, SQLException {
        if (dto == null) {
            return false;
        }
        Connection con = null;
        PreparedStatement stm = null;

        try {
            //1. Connect to DB
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(INSERT_BILL);
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

    public BillDBDTO GetBillById(String detail, String billName) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Connect to DB
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(FIND_BILL_BY_ID);
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

    public boolean addBillDetail(BillDetailDTO dto) throws NamingException, SQLException {
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
                stm.setInt(4, dto.getServiceId());
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
    
    public List<BillDTO> viewBillForUser(String username)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<BillDTO> list = new ArrayList();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(VIEW_BILL_FOR_USER);
                stm.setString(1, "%" + username + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String billName = rs.getString("billName");
                    String detail = rs.getString("detail");
                    String date = rs.getString("date");
                    int roomId = rs.getInt("roomId");
                    float roomPrice = rs.getFloat("roomPrice");
                    String electronicDetail = rs.getString("electronicDetail");
                    String waterDetail = rs.getString("waterDetail");
                    float electronicPrice = rs.getFloat("electronicPrice");
                    float waterPrice = rs.getFloat("waterPrice");
                    list.add(new BillDTO(roomId, billName, detail, date, roomPrice, electronicDetail, waterDetail, electronicPrice, waterPrice, username));

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
