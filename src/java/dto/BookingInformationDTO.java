/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author su
 */
public class BookingInformationDTO {
    private String bookingId;
    private String username;
    private String roomId;
    private String bookingDate;
    private String checkInDate;
    private String checkOutDate;

    public BookingInformationDTO() {
    }

    public BookingInformationDTO(String bookingId, String username, String roomId, String bookingDate, String checkInDate, String checkOutDate) {
        this.bookingId = bookingId;
        this.username = username;
        this.roomId = roomId;
        this.bookingDate = bookingDate;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    
    
    /**
     * @return the bookingId
     */
    public String getBookingId() {
        return bookingId;
    }

    /**
     * @param bookingId the bookingId to set
     */
    public void setBookingId(String bookingId) {
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

    /**
     * @return the roomId
     */
    public String getRoomId() {
        return roomId;
    }

    /**
     * @param roomId the roomId to set
     */
    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    /**
     * @return the bookingDate
     */
    public String getBookingDate() {
        return bookingDate;
    }

    /**
     * @param bookingDate the bookingDate to set
     */
    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    /**
     * @return the checkInDate
     */
    public String getCheckInDate() {
        return checkInDate;
    }

    /**
     * @param checkInDate the checkInDate to set
     */
    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    /**
     * @return the checkOutDate
     */
    public String getCheckOutDate() {
        return checkOutDate;
    }

    /**
     * @param checkOutDate the checkOutDate to set
     */
    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
    
    
    
}
