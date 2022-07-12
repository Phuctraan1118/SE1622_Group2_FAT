/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author buikh
 */
public class FeeDTO {
    private int feeId;
    private String detail;
    private double feesPrice;

    public FeeDTO(int feeId, String detail, double feesPrice) {
        this.feeId = feeId;
        this.detail = detail;
        this.feesPrice = feesPrice;
    }

    public FeeDTO(String detail, double feesPrice) {
        this.detail = detail;
        this.feesPrice = feesPrice;
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
     * @return the feesPrice
     */
    public double getFeesPrice() {
        return feesPrice;
    }

    /**
     * @param feesPrice the feesPrice to set
     */
    public void setFeesPrice(double feesPrice) {
        this.feesPrice = feesPrice;
    }
    
    
}
