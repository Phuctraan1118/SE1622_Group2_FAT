/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author hungp
 */
public class RegulationDto {
    private int regulationId;
    private String regulationName;
    private String regulationDetail;

    public RegulationDto() {
    }

    public RegulationDto(int regulationId, String regulationName, String regulationDetail) {
        this.regulationId = regulationId;
        this.regulationName = regulationName;
        this.regulationDetail = regulationDetail;
    }
     public RegulationDto(String regulationName, String regulationDetail) {
        this.regulationName = regulationName;
        this.regulationDetail = regulationDetail;
    }

    public int getRegulationId() {
        return regulationId;
    }

    public void setRegulationId(int regulationId) {
        this.regulationId = regulationId;
    }

    public String getRegulationName() {
        return regulationName;
    }

    public void setRegulationName(String regulationName) {
        this.regulationName = regulationName;
    }

    public String getRegulationDetail() {
        return regulationDetail;
    }

    public void setRegulationDetail(String regulationDetail) {
        this.regulationDetail = regulationDetail;
    }
    
}
