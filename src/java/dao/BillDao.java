/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.BillDBDTO;
import dto.BillDetailDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}
