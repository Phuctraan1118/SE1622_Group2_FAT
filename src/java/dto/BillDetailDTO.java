/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author buikh
 */
public class BillDetailDTO {
    private int billId;
    private int roomId;
    private String date;
    private int feeId;
    private int serviceId;

    public BillDetailDTO(int billId, int roomId, String date, int feeId, int serviceId) {
        this.billId = billId;
        this.roomId = roomId;
        this.date = date;
        this.feeId = feeId;
        this.serviceId = serviceId;
    }

    public BillDetailDTO(int billId, int roomId, String date) {
        this.billId = billId;
        this.roomId = roomId;
        this.date = date;
    }

    public BillDetailDTO(int billId, int roomId, String date, int feeId) {
        this.billId = billId;
        this.roomId = roomId;
        this.date = date;
        this.feeId = feeId;
    }
    
      public BillDetailDTO(int billId, int roomId, int serviceId, String date) {
        this.billId = billId;
        this.roomId = roomId;
        this.date = date;
        this.serviceId = serviceId;
    }

    /**
     * @return the billId
     */
    public int getBillId() {
        return billId;
    }

    /**
     * @param billId the billId to set
     */
    public void setBillId(int billId) {
        this.billId = billId;
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
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the feeId
     */
    public int getFeeId() {
        return feeId;
    }

    /**
     * @param feeId the feeId to set
     */
    public void setFeeId(int feeId) {
        this.feeId = feeId;
    }

    /**
     * @return the serviceId
     */
    public int getServiceId() {
        return serviceId;
    }

    /**
     * @param serviceId the serviceId to set
     */
    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }
    
    
    
}
