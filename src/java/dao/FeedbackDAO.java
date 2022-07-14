/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.FeedbackDTO;
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
public class FeedbackDAO {

    private static final String ADD_FEEDBACK = "INSERT INTO tblFeedback(feedbackName,username,status) VALUES (?,?,?)";
    private static final String DELETE_FEEDBACK_AFTER_REPLY = "DELETE FROM tblFeedback WHERE feedbackId = ?";
    private static final String GET_FEEDBACK = "select feedbackId , feedbackName, username "
            + "from tblFeedback "
            + "where status = 1 "
            + "order by feedbackId desc ";

    private static final String VIEW_FEEDBACK = "select feedbackId, feedbackName, username, status "
            + "from tblFeedback "
            + "where username = ? ";

    public boolean deleteFeedbackAfterReply(String feedbackId)
            throws SQLException, NamingException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean row = false;
        try {
            connection = DBHelper.makeConnection();
            if (connection != null) {
                preparedStatement = connection.prepareStatement(DELETE_FEEDBACK_AFTER_REPLY);
                preparedStatement.setString(1, feedbackId);
                row = preparedStatement.executeUpdate() > 0;

            }//end if connection has opened
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return row;
    }

    public boolean createFeedback(FeedbackDTO fb)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean row = false;
        try {
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(ADD_FEEDBACK);
            stm.setString(1, fb.getFeedbackContent());
            stm.setString(2, fb.getUsername());
            stm.setBoolean(3, fb.isStatus());
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

    public List<FeedbackDTO> getFeedback()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<FeedbackDTO> list = new ArrayList();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(GET_FEEDBACK);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int feedbackId = rs.getInt("feedbackId");
                    String feedbackContent = rs.getString("feedbackName");
                    String username = rs.getString("username");
                    list.add(new FeedbackDTO(feedbackId, feedbackContent, username));
                }//End traverse Result Set
            }//end if connection has opened
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
        return list;

    }

    public List<FeedbackDTO> viewFeedback(String username)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<FeedbackDTO> list = new ArrayList();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(VIEW_FEEDBACK);
                stm.setString(1, "%" + username + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    int feedbackId = rs.getInt("feedbackId");
                    String feedbackContent = rs.getString("feedbackName");
                    String user = rs.getString("username");
                    boolean status = rs.getBoolean("status");
                    list.add(new FeedbackDTO(feedbackId, feedbackContent, username, status));

                }//End traverse Result Set
            }//end if connection has opened
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
        return list;

    }
}
