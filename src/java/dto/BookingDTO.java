/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author buikh
 */
public class BookingDTO {
    private int bookingID;
    private String bookingDate;
    private String username;

    public BookingDTO() {
    }

    public BookingDTO(int bookingID, String bookingDate, String username) {
        this.bookingID = bookingID;
        this.bookingDate = bookingDate;
        this.username = username;
    }

    
    
    public BookingDTO(String bookingDate, String username) {
        this.bookingDate = bookingDate;
        this.username = username;
    }

    /**
     * @return the bookingID
     */
    public int getBookingID() {
        return bookingID;
    }

    /**
     * @param bookingID the bookingID to set
     */
    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
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
    
    
}
