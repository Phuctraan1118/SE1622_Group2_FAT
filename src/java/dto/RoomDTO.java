/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.io.Serializable;
//import java.util.Date;
////import java.sql.Date;

/**
 *
 * @author Bitano
 */
public class RoomDTO implements Serializable {

    private int roomId;
    private String roomDescription;
    private float roomPrice;
    private String image;

    private int bookingId;
    private String bookingDate;
    private String checkinDate;
    private String checkoutDate;

    private String username;
    private String status;
   
    private String roomName;
    private String categoryName;
    private String imageTmp;
    
    public RoomDTO() {
    }

    public RoomDTO(int roomId) {
        this.roomId = roomId;
    }

    public RoomDTO(int roomId, String roomDescription, float roomPrice, String image, String status) {
        this.roomId = roomId;
        this.roomDescription = roomDescription;
        this.roomPrice = roomPrice;
        this.image = image;
        this.status = status;
    }

    public RoomDTO(int roomId, String roomDescription, float roomPrice, String image,
            int bookingId, String bookingDate, String checkinDate, String checkoutDate, String username, String status) {
        this.roomId = roomId;
        this.roomDescription = roomDescription;
        this.roomPrice = roomPrice;
        this.image = image;
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.username = username;
        this.status = status;
    }

    public RoomDTO(int roomId, String roomDescription, float roomPrice, String image) {
        this.roomId = roomId;
        this.roomDescription = roomDescription;
        this.roomPrice = roomPrice;
        this.image = image;
    }
    
    public RoomDTO(int roomId, float roomPrice, String image, String roomName) {
        this.roomId = roomId;
        this.roomPrice = roomPrice;
        this.image = image;
        this.roomName = roomName;
    }

    public RoomDTO(String roomDescription, float roomPrice, String image, String status) {

        this.roomDescription = roomDescription;
        this.roomPrice = roomPrice;
        this.image = image;
        this.status = status;
    }

    public RoomDTO(int roomId, String roomDescription, float roomPrice, String image, String roomName, String categoryName) {
        this.roomId = roomId;
        this.roomDescription = roomDescription;
        this.roomPrice = roomPrice;
        this.image = image;
        this.roomName = roomName;
        this.categoryName = categoryName;
       
    }
     public RoomDTO(String imageTmp){
     this.imageTmp = imageTmp;
     }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getImageTmp() {
        return imageTmp;
    }

    public void setImageTmp(String imageTmp) {
        this.imageTmp = imageTmp;
    }
   
    
    
    
    /**
     * @return the roomId
     */
    public int getRoomId() {
        return roomId;
    }

    /**
     * @param roomId the roomId to set
     */
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    /**
     * @return the roomDescription
     */
    public String getRoomDescription() {
        return roomDescription;
    }

    /**
     * @param roomDescription the roomDescription to set
     */
    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    /**
     * @return the roomPrice
     */
    public float getRoomPrice() {
        return roomPrice;
    }

    /**
     * @param roomPrice the roomPrice to set
     */
    public void setRoomPrice(float roomPrice) {
        this.roomPrice = roomPrice;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the bookingId
     */
    public int getBookingId() {
        return bookingId;
    }

    /**
     * @param bookingId the bookingId to set
     */
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(String checkinDate) {
        this.checkinDate = checkinDate;
    }

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
