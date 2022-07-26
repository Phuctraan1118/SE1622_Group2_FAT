/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.ServiceDto;
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
public class ServiceDao {

    private static final String ADD_SERVICE = "INSERT INTO tblService(electronicDetail,waterDetail,electronicPrice,waterPrice,roomId) VALUES (?,?,?,?,?)";
    private static final String GET_SERVICE_ID = "SELECT TOP 1 serviceId from tblService where roomId = ? Order by serviceId desc ";
    private static final String SERVICE_ID = "serviceId";
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private static final String GET_SERVICE = "select electronicDetail,waterDetail,electronicPrice,waterPrice,roomId "
            + "from tblService "
            + "where serviceId = ? ";
    private static final String GET_ROOM_PRICE = "select roomPrice "
            + "from tblRoom "
            + "where roomId = ? ";

    public boolean createService(ServiceDto serviceDto)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean row = false;
        try {
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(ADD_SERVICE);
            stm.setString(1, serviceDto.getElectronicDetail());
            stm.setString(2, serviceDto.getWaterDetail());
            stm.setFloat(3, serviceDto.getElectronicPrice());
            stm.setFloat(4, serviceDto.getWaterPrice());
            stm.setInt(5, serviceDto.getRoomId());
            row = stm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
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

    public int getlastedId(int roomId) throws NamingException, SQLException {
        int lastedId = 0;
        try {
            connection = DBHelper.makeConnection();
            preparedStatement = connection.prepareStatement(GET_SERVICE_ID);
            preparedStatement.setInt(1, roomId);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                lastedId = resultSet.getInt(SERVICE_ID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return lastedId;
    }

    public List<ServiceDto> getService(int serviceId)
            throws SQLException, NamingException {
        List<ServiceDto> list = new ArrayList();
        try {
            connection = DBHelper.makeConnection();
            if (connection != null) {
                preparedStatement = connection.prepareStatement(GET_SERVICE);
                preparedStatement.setInt(1, serviceId);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String electronicDetail = resultSet.getString("electronicDetail");
                    String waterDetail = resultSet.getString("waterDetail");
                    float electronicPrice = resultSet.getFloat("electronicPrice");
                    float waterPrice = resultSet.getFloat("waterPrice");
                    int roomID = resultSet.getInt("roomId");
                    list.add(new ServiceDto(serviceId, electronicDetail, waterDetail, electronicPrice, waterPrice, roomID));
                }
            }
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

    public List<ServiceDto> getRoomPrice(int roomId)
            throws SQLException, NamingException {
        List<ServiceDto> list = new ArrayList();
        try {
            connection = DBHelper.makeConnection();
            if (connection != null) {
                preparedStatement = connection.prepareStatement(GET_ROOM_PRICE);
                preparedStatement.setInt(1, roomId);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    float roomPrice = resultSet.getFloat("roomPrice");
                    list.add(new ServiceDto(roomPrice));
                }
            }
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

}
