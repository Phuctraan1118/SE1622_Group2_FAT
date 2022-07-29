/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import dto.RevenueDTO;
import java.sql.SQLException;
import javax.naming.NamingException;
import utils.DBHelper;

/**
 *
 * @author Bitano
 */
public class RevenueDAO {
    private final String SHOW_REVENUE ="select b.billId,bd.roomId,bd.serviceId, bd.feeId ,  b.billName,  bd.date ,  s.waterPrice , s.electronicPrice, r.roomPrice "
            + "from tblBill b , tblBillDetail bd , tblService s , tblRoom  r "
            + "where b.billId = bd.billId and bd.roomId = r.roomId and s.serviceId = bd.serviceId ";
    private final String SHOW_REVENUE_1 ="select b.billName , b.detail ,bd.date , r.roomId , "
            + "s.electronicPrice, s.waterPrice ,   r.roomPrice ,( s.electronicPrice + s.waterPrice + r.roomPrice) as 'total' "
            + "from tblBill b, tblBillDetail bd , tblRoom r, tblBooking bk, tblBookingDetail bkd , tblService s "
            + "where b.billId = bd.billId and bd.roomId = r.roomId and r.roomId = bkd.roomId and bk.bookingId = bkd.bookingId "
            + "and bd.serviceId = s.serviceId and b.billName like 'BILL ROOM FEE' ";
     public List<RevenueDTO> showRevenue()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<RevenueDTO> list = new ArrayList();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(SHOW_REVENUE);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int billId = rs.getInt("billId");
                    int roomId = rs.getInt("roomId");
                    int serviceId = rs.getInt("serviceId");
                    int feeId = rs.getInt("feeId");
                    String billName = rs.getString("billName");
                    String date = rs.getString("date");
                    float electronicPrice = rs.getFloat("electronicPrice");
                    float waterPrice = rs.getFloat("waterPrice");
                    float roomPrice = rs.getFloat("roomPrice");
                    list.add(new RevenueDTO(billId, roomId, serviceId, feeId, billName, date, electronicPrice, waterPrice, roomPrice));

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
     public List<RevenueDTO> showRevenue1()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<RevenueDTO> list = new ArrayList();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(SHOW_REVENUE_1);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String billName = rs.getString("billName");
                    String detail = rs.getString("detail");
                    String date = rs.getString("date");
                    int roomId = rs.getInt("roomId");
                    float electronicPrice = rs.getFloat("electronicPrice");
                    float waterPrice = rs.getFloat("waterPrice");
                    float roomPrice = rs.getFloat("roomPrice");
                    double total = rs.getDouble("total");
                    list.add(new RevenueDTO(roomId, billName, detail, electronicPrice, waterPrice, roomPrice, total, date));

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
