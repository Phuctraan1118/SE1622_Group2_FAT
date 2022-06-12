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

/**
 *
 * @author buikh
 */
public class UserDAO {
    private final String AUTHENTICATION_QUERY = "Select username, password, fullName, email, address, phone , citizenIdentification, status, role, image "
                                                       + "From tblUsers "
                                                       + "Where username = ? AND password = ? AND status = 1 ";
    
    private final String FIND_BY_USERNAME_EMAIL = "Select username, password, fullName, email, address, phone , citizenIdentification, status, role, image "
                                                        + "From tblUsers "
                                                        + "Where username = ? AND email = ?";
    
    private final String INSERT_NEW_USER = "Insert Into tblUsers("
                                            + "username, password, fullName, email, address, phone, citizenIdentification, status, role, image"
                                            + ") Values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String CHECKING_EMAIL_EXISTED = "Select username, email "
                                                         + "From tblUsers "
                                                         + "Where username = ? AND email = ?";

    public UserDTO checkLogin(String username, String password)
            throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        UserDTO dto = new UserDTO();
        try {
            con = DBHelper.makeConnection();
            if(con != null){
                stm = con.prepareStatement(AUTHENTICATION_QUERY);
                stm.setString(1, username);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if(rs.next()){
                     String UserName = rs.getString("username");
                    String Password = rs.getString("password");
                    String FullName = rs.getString("fullName");
                    String Email = rs.getString("email");
                    String Address = rs.getString("address");
                    String Phone = rs.getString("phone");
                    String CitizenIdetification = rs.getString("citizenIdentification");
                    String Role = rs.getString("role");
                    Boolean Status = rs.getBoolean("status");
                    String Image = rs.getString("image");
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
                ptm = conn.prepareStatement(FIND_BY_USERNAME_EMAIL);
                ptm.setString(1, userName);
                ptm.setString(2, email);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String UserName = rs.getString("username");
                    String Password = rs.getString("password");
                    String FullName = rs.getString("fullName");
                    String Email = rs.getString("email");
                    String Address = rs.getString("address");
                    String Phone = rs.getString("phone");
                    String CitizenIdetification = rs.getString("citizenIdentification");
                    String Role = rs.getString("role");
                    Boolean Status = rs.getBoolean("status");
                    String Image = rs.getString("image");
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
    
    public boolean createNewAccount(UserDTO dto) throws NamingException, SQLException {
        if (dto == null) {
            return false;
        }
        Connection con = null;
        PreparedStatement stm = null;

        try {
            //1. Connect to DB
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(INSERT_NEW_USER);
                stm.setString(1, dto.getId());
                stm.setString(2, dto.getPassword());
                stm.setString(3, dto.getName());
                stm.setString(4, dto.getEmail());
                stm.setString(5, dto.getAddress());
                stm.setString(6, dto.getPhone());
                stm.setString(7, dto.getCitizenIdentification());
                stm.setBoolean(8, dto.isStatus());
                stm.setString(9, dto.getRole());
                stm.setString(10, dto.getImg());
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
    
    public UserDTO updateAccount(String username, String password, String fullname, String email, String address, String phone, String citizenIdentification, String role, boolean status, String img) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        UserDTO user = new UserDTO();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {

                String sql = "Update tblUsers "
                        + "SET password = ? "
                        + ", fullName = ? "
                        + ", email = ? "
                        + ", address = ? "
                        + ", phone = ? "
                        + ", citizenIdentification = ? "
                        + "WHERE username = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, password);
                stm.setString(2, fullname);
                stm.setString(3, email);
                stm.setString(4, address);
                stm.setString(5, phone);
                stm.setString(6, citizenIdentification);
                stm.setString(7, username);
                int effectRow = stm.executeUpdate();
                if (effectRow > 0) {
                    user = new UserDTO(username, password, address, phone, citizenIdentification, status, role, fullname, email, img);
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
        return user;
    }
    public boolean checkUsernameIsExiste(String username, String email) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean flag = false;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {

                String sql = CHECKING_EMAIL_EXISTED;
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                stm.setString(2, username);
                rs = stm.executeQuery();
                if (rs.next()) {
                    flag = true;
                }
            }
        } finally {
            if(rs != null){
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return flag;
    }
}
