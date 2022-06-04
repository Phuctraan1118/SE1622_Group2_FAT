/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import utils.DBHelper;
import utils.MySqlQueryConstants;

/**
 *
 * @author buikh
 */
public class UserDAO {
    public UserDTO checkLogin(String username, String password)
            throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        UserDTO dto = new UserDTO();
        try {
            con = DBHelper.makeConnection();
            if(con != null){
                stm = con.prepareStatement(MySqlQueryConstants.LoginFeature.AUTHENTICATION_QUERY);
                stm.setString(1, username);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if(rs.next()){
                     String UserName = rs.getString("UserName");
                    String Password = rs.getString("Password");
                    String FullName = rs.getString("FullName");
                    String Email = rs.getString("Email");
                    String Address = rs.getString("Address");
                    String Phone = rs.getString("Phone");
                    String CitizenIdetification = rs.getString("CitizenIdetification");
                    String Role = rs.getString("Role");
                    Boolean Status = rs.getBoolean("Status");
                    String Image = rs.getString("Image");
                    dto = new UserDTO(UserName, Password, Address, Phone, CitizenIdetification, Status, Role, FullName, Email, Image);
                } 
            }
        } finally {
            if(rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(con != null){
                con.close();
            }
        }
        return dto;
    }
    
    public UserDTO findByUsernameAndEmail(String userName, String email) 
            throws SQLException, NamingException {
        UserDTO account = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(MySqlQueryConstants.LoginFeature.FIND_BY_USERNAME_EMAIL);
                ptm.setString(1, userName);
                ptm.setString(2, email);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String UserName = rs.getString("UserName");
                    String Password = rs.getString("Password");
                    String FullName = rs.getString("FullName");
                    String Email = rs.getString("Email");
                    String Address = rs.getString("Address");
                    String Phone = rs.getString("Phone");
                    String CitizenIdetification = rs.getString("CitizenIdetification");
                    String Role = rs.getString("Role");
                    Boolean Status = rs.getBoolean("Status");
                    String Image = rs.getString("Image");
                    account = new UserDTO(UserName, Password, Address, Phone, CitizenIdetification, Status, Role, FullName, Email, Image);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
        return account;
    }
}
