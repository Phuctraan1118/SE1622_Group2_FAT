/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import form.NotificationCreateForm;
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
public class NotificationDao {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private static final String ADD_NOTIFICATION = "INSERT INTO tblNotification(notificationName,detail,username) VALUES (?,?,?)";
    private static final String GET_NOTIFICATION = "SELECT notificationId,notificationName,detail,username FROM tblNotification WHERE notificationName like ?";
    private static final String UPDATE_NOTIFICATION = "UPDATE tblNotification SET notificationName=?, detail=?, username=? where notificationId=?";
    private static final String DELETE = "DELETE tblNotification WHERE notificationId=?";

    public boolean addNewNotification(NotificationCreateForm notificationForm) throws NamingException, SQLException {
        boolean check = false;

        try {
            connection = DBHelper.makeConnection();
            preparedStatement = connection.prepareStatement(ADD_NOTIFICATION);
            preparedStatement.setString(1, notificationForm.getName());
            preparedStatement.setString(2, notificationForm.getDetail());
            preparedStatement.setString(3, notificationForm.getUsername());
            check = preparedStatement.executeUpdate() > 0;
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
        return check;
    }

    public List<NotificationCreateForm> getNotifications(String searchedNotificationName) throws SQLException {
        List<NotificationCreateForm> list = new ArrayList();
        try {
            connection = DBHelper.makeConnection();
            if (connection != null) {
                preparedStatement = connection.prepareStatement(GET_NOTIFICATION);
                preparedStatement.setString(1, "%" + searchedNotificationName + "%");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int notificationId = resultSet.getInt("notificationId");
                    String notificationName = resultSet.getString("notificationName");
                    String notificationDetail = resultSet.getString("detail");
                    String username = resultSet.getString("username");
                    list.add(new NotificationCreateForm(notificationId, notificationName, notificationDetail, username));
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

    public int updateNotification(int id, String name, String detail, String username) throws SQLException, NamingException, NamingException {

        try {
            connection = DBHelper.makeConnection();
            preparedStatement = connection.prepareStatement(UPDATE_NOTIFICATION);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, detail);
            preparedStatement.setString(3, username);
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return 0;
    }

    public boolean deleteNotification(String notificationId) throws SQLException {
        boolean check = false;
        try {
            connection = DBHelper.makeConnection();
            if (connection != null) {
                preparedStatement = connection.prepareStatement(DELETE);
                preparedStatement.setString(1, notificationId);
                int value = preparedStatement.executeUpdate();
                check = value > 0;
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return check;
    }
}
