/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.FeedbackDTO;
import dto.FeedbackReplyDto;
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
public class FeedbackReplyDao {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private static final String REPLY_FEEDBACK = "INSERT INTO tblFeedbackReply(contentReply, username) "
            + "values (?,?)";
    private static final String VIEW_FEEDBACK_REPLY = "select id, contentReply "
            + "from tblFeedbackReply "
            + "where username like ?";

    public boolean replyFeedback(FeedbackReplyDto fb)
            throws SQLException, NamingException {
        boolean row = false;
        try {
            connection = DBHelper.makeConnection();
            if (connection != null) {
                preparedStatement = connection.prepareStatement(REPLY_FEEDBACK);
                preparedStatement.setString(1, fb.getContentReply());
                preparedStatement.setString(2, fb.getUsername());
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

    public List<FeedbackReplyDto> viewFeedback(String username)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<FeedbackReplyDto> list = new ArrayList();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(VIEW_FEEDBACK_REPLY);
                stm.setString(1, "%" + username + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String contentReply = rs.getString("contentReply");
                    list.add(new FeedbackReplyDto(id, contentReply, username));

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
