/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.UserDTO;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DBHelper;
import utils.MySqlQueryConstants;

/**
 *
 * @author buikh
 */
public class UserDAO {

    public UserDTO checkLogin(String username, String password)
            throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        UserDTO dto = new UserDTO();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(MySqlQueryConstants.LoginFeature.AUTHENTICATION_QUERY);
                stm.setString(1, username);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String idUser = rs.getString("IdUser");
                    String address = rs.getString("Address");
                    String phone = rs.getString("Phone");
                    String citizenIdetification = rs.getString("CitizenIdetification");
                    boolean status = rs.getBoolean("Status");
                    String role = rs.getString("Role");
                    String fullName = rs.getString("FullName");
                    String email = rs.getString("Email");
                    dto = new UserDTO(address, phone, citizenIdetification, status, role, idUser, fullName, email);
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
        return dto;
    }
}
