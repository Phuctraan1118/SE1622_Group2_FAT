/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author hungp
 */
public class FeedbackDTO implements Serializable{

    private int feedbackId;
    private String feedbackContent;
    private String username;
    private boolean status;

    public FeedbackDTO(String feedbackName, String username, boolean status) {
        this.feedbackContent = feedbackName;
        this.username = username;
        this.status = status;
    }
    

    public FeedbackDTO(int feedbackId, String feedbackName, String username, boolean status) {
   
     this.feedbackId = feedbackId;
        this.feedbackContent = feedbackName;
        this.username = username;
        this.status = status;
    }

    public FeedbackDTO(String feedbackContent, String username) {
        this.feedbackContent = feedbackContent;
        this.username = username;
    }

    public FeedbackDTO(int feedbackId, String feedbackContent, String username) {

        this.feedbackId = feedbackId;
        this.feedbackContent = feedbackContent;
        this.username = username;

    }
    
    public FeedbackDTO(int feedbackId, String feedbackContent) {
   
        this.feedbackId = feedbackId;
        this.feedbackContent = feedbackContent;
    }

    public FeedbackDTO() {
    }

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getFeedbackContent() {
        return feedbackContent;
    }

    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
