/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import form.UserCreateForm;
import form.UserDisplayForm;
import form.UserUpdateForm;
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
public class UserDao {

    private static final String GET_LASTED_ID_QUERY = "SELECT top 1 idUser FROM tblUser order by idUser desc";
    private static final String ADD_STAFF_QUERY = "INSERT into tblUser(idUser, username, password, fullName, email, address, "
            + "phone, citizenIndentification, status, role,image) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
    private static final String ID_USER = "idUser";
    private static final String SEARCH_STAFFUSER_BY_FULLNAME = "SELECT idUser, username, fullName, email, address, phone, citizenIndentification,image FROM tblUser WHERE fullName like ? AND role like 'STAFF'";
    private static final String REMOVE_BY_ID = "DELETE tblUser WHERE idUser=?";
    private static final String UPDATE_USER = "UPDATE tblUser SET fullName=?, email=?, address=?, phone=?,citizenIndentification=? WHERE username=?";
    private static final String DUPLICATE = "SELECT username FROM tblUser WHERE username=?";

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public boolean addStaff(UserCreateForm userCreateForm) throws NamingException, SQLException {
        boolean check = false;

        try {
            connection = DBHelper.makeConnection();
            preparedStatement = connection.prepareStatement(ADD_STAFF_QUERY);
            preparedStatement.setString(1, userCreateForm.getId());
            preparedStatement.setString(2, userCreateForm.getUsername());
            preparedStatement.setString(3, userCreateForm.getPassword());
            preparedStatement.setString(4, userCreateForm.getFullName());
            preparedStatement.setString(5, userCreateForm.getEmail());
            preparedStatement.setString(6, userCreateForm.getAddress());
            preparedStatement.setString(7, userCreateForm.getPhone());
            preparedStatement.setString(8, userCreateForm.getCitizenIdentification());
            preparedStatement.setBoolean(9, userCreateForm.getStatus());
            preparedStatement.setString(10, userCreateForm.getRole());
            preparedStatement.setString(11, userCreateForm.getImage());
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

    public int getlastedId() throws NamingException, SQLException {
        int lastedId = 0;
        try {
            connection = DBHelper.makeConnection();
            preparedStatement = connection.prepareStatement(GET_LASTED_ID_QUERY);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                lastedId = resultSet.getInt(ID_USER);
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

    public List<UserDisplayForm> getListUser(String searchedFullName) throws SQLException {
        List<UserDisplayForm> list = new ArrayList();
        try {
            connection = DBHelper.makeConnection();
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SEARCH_STAFFUSER_BY_FULLNAME);
                preparedStatement.setString(1, "%" + searchedFullName + "%");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String userId = resultSet.getString("idUser");
                    String username = resultSet.getString("username");
                    String fullName = resultSet.getString("fullName");
                    String address = resultSet.getString("address");
                    String phone = resultSet.getString("phone");
                    String cmnd = resultSet.getString("citizenIndentification");
                    String email = resultSet.getString("email");
                    String img = resultSet.getString("image");
                    list.add(new UserDisplayForm(userId, username, fullName, address, phone, cmnd, email, img));
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

    public boolean deleteUser(String userId) throws SQLException {
        boolean check = false;
        try {
            connection = DBHelper.makeConnection();
            if (connection != null) {
                preparedStatement = connection.prepareStatement(REMOVE_BY_ID);
                preparedStatement.setString(1, userId);
                check = preparedStatement.executeUpdate() > 0;
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

    public boolean updateUser(UserUpdateForm user) throws SQLException {
        boolean check = false;
        try {
            connection = DBHelper.makeConnection();
            if (connection != null) {
                preparedStatement = connection.prepareStatement(UPDATE_USER);
                preparedStatement.setString(1, user.getFullName());
                preparedStatement.setString(2, user.getEmail());
                preparedStatement.setString(3, user.getAddress());
                preparedStatement.setString(4, user.getPhone());
                preparedStatement.setString(5, user.getCitizenIdentification());
                preparedStatement.setString(6, user.getUsername());
                check = preparedStatement.executeUpdate() > 0;
            }
        } catch (Exception e) {
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

    public boolean checkDuplicate(String username) throws SQLException {
        boolean check = false;
        try {
            connection = DBHelper.makeConnection();
            if (connection != null) {
                preparedStatement = connection.prepareStatement(DUPLICATE);
                preparedStatement.setString(1, username);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
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
        return check;
    }

}
