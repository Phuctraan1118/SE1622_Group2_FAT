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

  
    private String roomDescriptionLengthError;
    private String priceStringError;


    public RoomInsertError() {
        
    }

    public RoomInsertError(String roomDescriptionLengthError, String priceStringError) {
        this.roomDescriptionLengthError = roomDescriptionLengthError;
        this.priceStringError = priceStringError;
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
    

  
}
