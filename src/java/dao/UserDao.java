/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.UserDTO;
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

    private final String AUTHENTICATION_QUERY = "Select username, password, fullName, email, address, phone , citizenIdentification, status, role, image "
            + "From tblUser "
            + "Where username = ? AND password = ? AND status = 1 ";

    private final String FIND_BY_USERNAME_EMAIL = "Select username, password, fullName, email, address, phone , citizenIdentification, status, role, image "
            + "From tblUser "
            + "Where username = ? AND email = ?";

    private final String INSERT_NEW_USER = "Insert Into tblUser("
            + "username, password, fullName, email, address, phone, citizenIdentification, status, role, image"
            + ") Values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String CHECKING_EMAIL_EXISTED = "Select username, email "
            + "From tblUser "
            + "Where username = ? AND email = ?";

    private static final String GET_LASTED_ID_QUERY = "SELECT top 1 idUser FROM tblUser order by idUser desc";
    private static final String ID_USER = "idUser";
    private static final String SEARCH_CUSTOMER_BY_FULLNAME = "SELECT idUser, username, fullName, email, address, phone, citizenIdentification,image FROM tblUser WHERE fullName like ? AND role like 'US'";
    private static final String REMOVE_BY_ID = "DELETE tblUser WHERE idUser=?";
    private static final String UPDATE_CUSTOMER = "UPDATE tblUser SET fullName=?, email=?, address=?, phone=?,citizenIdentification=? WHERE username=?";
    private static final String DUPLICATE = "SELECT username FROM tblUser WHERE username=?";

    private static final String ADD_USER_QUERY = "INSERT into tblUser (username, password, fullName, email, address, "
            + "phone, citizenIdentification, status, role,image) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static final String SEARCH_STAFF_BY_NAME = "SELECT idUser, username, fullName, email, address, phone, citizenIdentification,image FROM tblUser WHERE fullName like ? AND role like 'STAFF'";

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;


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

    public List<UserDisplayForm> getListOfCustomer(String searchedFullName) throws SQLException {
        List<UserDisplayForm> list = new ArrayList();
        try {
            connection = DBHelper.makeConnection();
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SEARCH_CUSTOMER_BY_FULLNAME);
                preparedStatement.setString(1, "%" + searchedFullName + "%");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String userId = resultSet.getString("idUser");
                    String username = resultSet.getString("username");
                    String fullName = resultSet.getString("fullName");
                    String address = resultSet.getString("address");
                    String phone = resultSet.getString("phone");
                    String cmnd = resultSet.getString("citizenIdentification");
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
                preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
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

    public int getNumberOfPage() {
        String query = "select count(*) from tblUser";
        try {
            connection = DBHelper.makeConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int total = resultSet.getInt(1);
                int countPage = total / 3;
                if (total % 3 != 0) {
                    countPage++;
                }
                return countPage;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public List<UserDisplayForm> getPaging(int index) {
        List<UserDisplayForm> list = new ArrayList();
        String query = "select * from tblUser\n"
                + "order by idUser\n"
                + "OFFSET ? ROWS\n"
                + "FETCH FIRST 3 ROW ONLY";
        try {
            connection = DBHelper.makeConnection();
            if (connection != null) {
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, (index - 1) * 3);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String userId = resultSet.getString("idUser");
                    String username = resultSet.getString("username");
                    String fullName = resultSet.getString("fullName");
                    String address = resultSet.getString("address");
                    String phone = resultSet.getString("phone");
                    String cmnd = resultSet.getString("citizenIdentification");
                    String email = resultSet.getString("email");
                    String img = resultSet.getString("image");
                    list.add(new UserDisplayForm(userId, username, fullName, address, phone, cmnd, email, img));
                }
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean addUser(UserCreateForm userCreateForm) throws NamingException, SQLException {
        boolean check = false;

        try {
            connection = DBHelper.makeConnection();
            preparedStatement = connection.prepareStatement(ADD_USER_QUERY);
            preparedStatement.setString(1, userCreateForm.getUsername());
            preparedStatement.setString(2, userCreateForm.getPassword());
            preparedStatement.setString(3, userCreateForm.getFullName());
            preparedStatement.setString(4, userCreateForm.getEmail());
            preparedStatement.setString(5, userCreateForm.getAddress());
            preparedStatement.setString(6, userCreateForm.getPhone());
            preparedStatement.setString(7, userCreateForm.getCitizenIdentification());
            preparedStatement.setBoolean(8, userCreateForm.getStatus());
            preparedStatement.setString(9, userCreateForm.getRole());
            preparedStatement.setString(10, userCreateForm.getImage());
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

    public List<UserDisplayForm> getListOfStaff(String searchedFullName) throws SQLException {
        List<UserDisplayForm> list = new ArrayList();
        try {
            connection = DBHelper.makeConnection();
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SEARCH_STAFF_BY_NAME);
                preparedStatement.setString(1, "%" + searchedFullName + "%");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String userId = resultSet.getString("idUser");
                    String username = resultSet.getString("username");
                    String fullName = resultSet.getString("fullName");
                    String address = resultSet.getString("address");
                    String phone = resultSet.getString("phone");
                    String cmnd = resultSet.getString("citizenIdentification");
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

    public UserDTO checkLogin(String username, String password)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        UserDTO dto = new UserDTO();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(AUTHENTICATION_QUERY);
                stm.setString(1, username);
                stm.setString(2, password);
                rs = stm.executeQuery();
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
                    dto = new UserDTO(UserName, Password, Address, Phone, CitizenIdetification, Status, Role, FullName, Email, Image);
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

                String sql = "Update tblUser "
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

    public boolean checkUsernameIsExisted(String username, String email) throws NamingException, SQLException {
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
        return flag;
    }
}
