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
    private final String SHOW_REVENUE ="select b.billId,bd.roomId,bd.serviceId, bd.feeId ,  b.billName,  bd.date ,  s.waterPrice , s.electronicPrice, r.roomPrice, f.feesPrice "
            + "from tblBill b , tblBillDetail bd , tblService s , tblRoom  r , tblFees f "
            + "where b.billId = bd.billId and bd.roomId = r.roomId and s.serviceId = bd.serviceId and f.feeId = bd.feeId  ";
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
                    float feesPrice = rs.getFloat("feesPrice");
                    list.add(new RevenueDTO(billId, roomId, serviceId, feeId, billName, date, electronicPrice, waterPrice, roomPrice, feesPrice));

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
