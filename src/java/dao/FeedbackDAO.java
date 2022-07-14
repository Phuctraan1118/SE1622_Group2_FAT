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

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private static final String ADD_FEEDBACK = "INSERT INTO tblFeedback(feedbackName,username,status) VALUES (?,?,?)";
    private static final String REPLY_FEEDBACK = "INSERT INTO tblFeedback1(contentReply, feedbackId) "
            + "values (?,?)"
            + "update tblFeedback set status = 0 where feedbackId = ? ";
    private static final String GET_FEEDBACK = "select feedbackId , feedbackName, username "
            + "from tblFeedback "
            + "where status = 1 "
            + "order by feedbackId desc ";

    private static final String VIEW_FEEDBACK = "select feedbackId, feedbackName, username, status "
            + "from tblFeedback "
            + "where username = ? ";

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

    public boolean replyFeedback(FeedbackDTO fb)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean row = false;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(REPLY_FEEDBACK);
                stm.setString(1, fb.getFeedbackContent());
                stm.setInt(2, fb.getFeedbackId());
                stm.setInt(3, fb.getFeedbackId());
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
