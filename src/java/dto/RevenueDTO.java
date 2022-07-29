/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Bitano
 */
public class RevenueDTO {
    private int billId;
    private int roomId;
    private int serviceId;
    private int feeId;
    private String billName;
    private String billDate;
    private float electronicPrice;
    private float waterPrice;
    private float roomPrice;
    private float feesPrice;
    private double total;
    private String detail;
    private String date;
    
    
    public RevenueDTO(int billId, int roomId, int serviceId, int feeId, String billName, String billDate, float electronicPrice, float waterPrice, float roomPrice, float feesPrice) {
        this.billId = billId;
        this.roomId = roomId;
        this.serviceId = serviceId;
        this.feeId = feeId;
        this.billName = billName;
        this.billDate = billDate;
        this.electronicPrice = electronicPrice;
        this.waterPrice = waterPrice;
        this.roomPrice = roomPrice;
        this.feesPrice = feesPrice;
        
    }
    
    public RevenueDTO(int billId, int roomId, int serviceId, int feeId, String billName, String billDate, float electronicPrice, float waterPrice, float roomPrice) {
        this.billId = billId;
        this.roomId = roomId;
        this.serviceId = serviceId;
        this.feeId = feeId;
        this.billName = billName;
        this.billDate = billDate;
        this.electronicPrice = electronicPrice;
        this.waterPrice = waterPrice;
        this.roomPrice = roomPrice;
        
    }

    public RevenueDTO() {
    }

    public RevenueDTO(int roomId, String billName,String detail, float electronicPrice, float waterPrice, float roomPrice, double total, String date) {
        this.roomId = roomId;
        this.billName = billName;
        this.detail = detail;
        this.electronicPrice = electronicPrice;
        this.waterPrice = waterPrice;
        this.roomPrice = roomPrice;
        this.total = total;
        this.date = date;
    }

    

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

           
    
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
    
    

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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
     * @return the billName
     */
    public String getBillName() {
        return billName;
    }

    /**
     * @param billName the billName to set
     */
    public void setBillName(String billName) {
        this.billName = billName;
    }

    /**
     * @return the billDate
     */
    public String getBillDate() {
        return billDate;
    }

    /**
     * @param billDate the billDate to set
     */
    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    /**
     * @return the electronicPrice
     */
    public float getElectronicPrice() {
        return electronicPrice;
    }

    /**
     * @param electronicPrice the electronicPrice to set
     */
    public void setElectronicPrice(float electronicPrice) {
        this.electronicPrice = electronicPrice;
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
     * @return the feesPrice
     */
    public float getFeesPrice() {
        return feesPrice;
    }

    /**
     * @param feesPrice the feesPrice to set
     */
    public void setFeesPrice(float feesPrice) {
        this.feesPrice = feesPrice;
    }

    /**
     * @return the waterPrice
     */
    public float getWaterPrice() {
        return waterPrice;
    }

    /**
     * @param waterPrice the waterPrice to set
     */
    public void setWaterPrice(float waterPrice) {
        this.waterPrice = waterPrice;
    }
    
     
}
