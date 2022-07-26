/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author hungp
 */
public class ServiceDto {

    private int id;
    private String electronicDetail;
    private String waterDetail;
    private float electronicPrice;
    private float waterPrice;
    private int roomId;
    private float roomPrice;

    public ServiceDto() {
    }

    public ServiceDto(int id, String electronicDetail, String waterDetail, float electronicPrice, float waterPrice, int roomId) {
        this.id = id;
        this.electronicDetail = electronicDetail;
        this.waterDetail = waterDetail;
        this.electronicPrice = electronicPrice;
        this.waterPrice = waterPrice;
        this.roomId = roomId;
    }

    public ServiceDto(String electronicDetail, String waterDetail, float electronicPrice, float waterPrice, int roomId) {
        this.electronicDetail = electronicDetail;
        this.waterDetail = waterDetail;
        this.electronicPrice = electronicPrice;
        this.waterPrice = waterPrice;
        this.roomId = roomId;
    }

    public ServiceDto(String electronicDetail, String waterDetail, float electronicPrice, float waterPrice, int roomId, float roomPrice) {
        this.electronicDetail = electronicDetail;
        this.waterDetail = waterDetail;
        this.electronicPrice = electronicPrice;
        this.waterPrice = waterPrice;
        this.roomId = roomId;
        this.roomPrice = roomPrice;
    }

    public ServiceDto(int id, String electronicDetail, String waterDetail, float electronicPrice, float waterPrice, int roomId, float roomPrice) {
        this.id = id;
        this.electronicDetail = electronicDetail;
        this.waterDetail = waterDetail;
        this.electronicPrice = electronicPrice;
        this.waterPrice = waterPrice;
        this.roomId = roomId;
        this.roomPrice = roomPrice;
    }

    public ServiceDto(float roomPrice) {
        this.roomPrice = roomPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getElectronicDetail() {
        return electronicDetail;
    }

    public void setElectronicDetail(String electronicDetail) {
        this.electronicDetail = electronicDetail;
    }

    public String getWaterDetail() {
        return waterDetail;
    }

    public void setWaterDetail(String waterDetail) {
        this.waterDetail = waterDetail;
    }

    public float getElectronicPrice() {
        return electronicPrice;
    }

    public void setElectronicPrice(float electronicPrice) {
        this.electronicPrice = electronicPrice;
    }

    public float getWaterPrice() {
        return waterPrice;
    }

    public void setWaterPrice(float waterPrice) {
        this.waterPrice = waterPrice;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
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

}
