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

    private static final String GET_ALL_REGULATION = "SELECT regulationId,regulationName,regualtionDetail FROM tblRegulation";
    private static final String UPDATE_NOTIFICATION = "UPDATE tblNotification SET notificationName=?, detail=?, username=? where notificationId=?";
    private static final String DELETE = "DELETE tblNotification WHERE notificationId=?";

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

}
