/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.RegulationDto;
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
public class RegulationDao {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    
    private static final String UPDATE = "update tblRegulation "
            + "set  regulationName = ? , regualtionDetail = ? "
            + "where regulationId = ? ";
    private static final String GET_ALL_REGULATION = "SELECT regulationId,regulationName,regualtionDetail FROM tblRegulation";
//    private static final String UPDATE_NOTIFICATION = "UPDATE tblNotification SET notificationName=?, detail=?, username=? where notificationId=?";
    private static final String DELETE = "delete tblRegulation where regulationId =? ";
    private static final String INSERT = "insert into tblRegulation( regulationName,  regualtionDetail ) "
            + "values (?,?) ";
    
    
       public boolean update(RegulationDto regu)
            throws SQLException, NamingException {
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(UPDATE);
                stm.setString(1, regu.getRegulationName());
                stm.setString(2, regu.getRegulationDetail());
                stm.setInt(3, regu.getRegulationId());
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
    
       public boolean create(RegulationDto regu)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean row = false;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(INSERT);
                stm.setString(1, regu.getRegulationName());
                stm.setString(2, regu.getRegulationDetail());
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
    public List<RegulationDto> getRegulations() throws SQLException {
        List<RegulationDto> list = new ArrayList();
        try {
            connection = DBHelper.makeConnection();
            if (connection != null) {
                preparedStatement = connection.prepareStatement(GET_ALL_REGULATION);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int regulationId = resultSet.getInt("regulationId");
                    String notificationName = resultSet.getString("regulationName");
                    String notificationDetail = resultSet.getString("regualtionDetail");
                    list.add(new RegulationDto(regulationId, notificationName, notificationDetail));
                }
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return list;
    }
    public boolean deleteRegulationById(int regulationId) throws SQLException, NamingException {
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(DELETE);
                stm.setInt(1, regulationId);
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
}
