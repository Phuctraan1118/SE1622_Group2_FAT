/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author buikh
 */
public class BillDTO {
    private String roomId;
    private String total;
    private String checkInDate;
    private String checkOutDate;
    
    private int roomId1;
    private String billName;
    private String detail;
    private String date;
    private float roomPrice;
    private String electronicDetail;
    private String waterDetail;
    private float electronicPrice;
    private float waterPrice;
    private String username;

    public BillDTO(int roomId1, String billName, String detail, String date, float roomPrice, String electronicDetail, String waterDetail, float electronicPrice, float waterPrice, String username) {
        this.roomId1 = roomId1;
        this.billName = billName;
        this.detail = detail;
        this.date = date;
        this.roomPrice = roomPrice;
        this.electronicDetail = electronicDetail;
        this.waterDetail = waterDetail;
        this.electronicPrice = electronicPrice;
        this.waterPrice = waterPrice;
        this.username = username;
    }

    public int getRoomId1() {
        return roomId1;
    }

    public void setRoomId1(int roomId1) {
        this.roomId1 = roomId1;
    }
      
     
    

    public BillDTO(String roomId, String total, String checkInDate, String checkOutDate) {
        this.roomId = roomId;
        this.total = total;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
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
     * @return the total
     */
    public String getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(String total) {
        this.total = total;
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
     * @return the detail
     */
    public String getDetail() {
        return detail;
    }

    /**
     * @param detail the detail to set
     */
    public void setDetail(String detail) {
        this.detail = detail;
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
     * @return the electronicDetail
     */
    public String getElectronicDetail() {
        return electronicDetail;
    }

    /**
     * @param electronicDetail the electronicDetail to set
     */
    public void setElectronicDetail(String electronicDetail) {
        this.electronicDetail = electronicDetail;
    }

    /**
     * @return the waterDetail
     */
    public String getWaterDetail() {
        return waterDetail;
    }

    /**
     * @param waterDetail the waterDetail to set
     */
    public void setWaterDetail(String waterDetail) {
        this.waterDetail = waterDetail;
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
