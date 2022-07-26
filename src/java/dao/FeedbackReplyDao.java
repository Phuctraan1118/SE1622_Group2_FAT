/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.FeedbackReplyDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}
