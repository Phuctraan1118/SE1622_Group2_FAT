/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author hungp
 */
public class FeedbackReplyDto {
    private int id;
    private String contentReply;
    private String username;

    public FeedbackReplyDto() {
    }

    public FeedbackReplyDto(int id, String contentReply, String username) {
        this.id = id;
        this.contentReply = contentReply;
        this.username = username;
    }

    public FeedbackReplyDto(String contentReply, String username) {
        this.contentReply = contentReply;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContentReply() {
        return contentReply;
    }

    public void setContentReply(String contentReply) {
        this.contentReply = contentReply;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

   
    
    
    
}
