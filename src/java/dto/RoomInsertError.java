/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author Bitano
 */
public class RoomInsertError implements Serializable {

    private String roomNameLengthError;
    private String roomDescriptionLengthError;
    private String priceStringError;
    private String bookingDateLengthError;
    private String checkinDateLengthError;
    private String checkoutDateLengthError;


    public RoomInsertError() {
        
    }

    public RoomInsertError(String roomDescriptionLengthError, String priceStringError) {
        this.roomDescriptionLengthError = roomDescriptionLengthError;
        this.priceStringError = priceStringError;
    }

    public RoomInsertError(String roomDescriptionLengthError, String priceStringError, String bookingDateLengthError, String checkinDateLengthError, String checkoutDateLengthError) {
        this.roomDescriptionLengthError = roomDescriptionLengthError;
        this.priceStringError = priceStringError;
        this.bookingDateLengthError = bookingDateLengthError;
        this.checkinDateLengthError = checkinDateLengthError;
        this.checkoutDateLengthError = checkoutDateLengthError;
    }

    public RoomInsertError(String roomNameLengthError, String roomDescriptionLengthError, String priceStringError, String bookingDateLengthError, String checkinDateLengthError, String checkoutDateLengthError) {
        this.roomNameLengthError = roomNameLengthError;
        this.roomDescriptionLengthError = roomDescriptionLengthError;
        this.priceStringError = priceStringError;
        this.bookingDateLengthError = bookingDateLengthError;
        this.checkinDateLengthError = checkinDateLengthError;
        this.checkoutDateLengthError = checkoutDateLengthError;
    }
    

    public String getRoomNameLengthError() {
        return roomNameLengthError;
    }

    public void setRoomNameLengthError(String roomNameLengthError) {
        this.roomNameLengthError = roomNameLengthError;
    }
   
    /**
     * @return the roomDescriptionLengthError
     */
    public String getRoomDescriptionLengthError() {
        return roomDescriptionLengthError;
    }

    /**
     * @param roomDescriptionLengthError the roomDescriptionLengthError to set
     */
    public void setRoomDescriptionLengthError(String roomDescriptionLengthError) {
        this.roomDescriptionLengthError = roomDescriptionLengthError;
    }

    /**
     * @return the priceStringError
     */
    public String getPriceStringError() {
        return priceStringError;
    }

    /**
     * @param priceStringError the priceStringError to set
     */
    public void setPriceStringError(String priceStringError) {
        this.priceStringError = priceStringError;
    }

    /**
     * @return the bookingDateLengthError
     */
    public String getBookingDateLengthError() {
        return bookingDateLengthError;
    }

    /**
     * @param bookingDateLengthError the bookingDateLengthError to set
     */
    public void setBookingDateLengthError(String bookingDateLengthError) {
        this.bookingDateLengthError = bookingDateLengthError;
    }

    /**
     * @return the checkinDateLengthError
     */
    public String getCheckinDateLengthError() {
        return checkinDateLengthError;
    }

    /**
     * @param checkinDateLengthError the checkinDateLengthError to set
     */
    public void setCheckinDateLengthError(String checkinDateLengthError) {
        this.checkinDateLengthError = checkinDateLengthError;
    }

    /**
     * @return the checkoutDateLengthError
     */
    public String getCheckoutDateLengthError() {
        return checkoutDateLengthError;
    }

    /**
     * @param checkoutDateLengthError the checkoutDateLengthError to set
     */
    public void setCheckoutDateLengthError(String checkoutDateLengthError) {
        this.checkoutDateLengthError = checkoutDateLengthError;
    }
    

  
}
