/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author buikh
 */
public class UserGoogleDTO {
    private String id;
    private String email;
    private boolean vertified_email;
    private String name;
    private String given_name;
    private String family_name;
    private String picture;

    public UserGoogleDTO() {
    }
    
    
    
    public UserGoogleDTO(String id, String email, boolean vertified_email, String name, String given_name, String family_name, String picture) {
        this.id = id;
        this.email = email;
        this.vertified_email = vertified_email;
        this.name = name;
        this.given_name = given_name;
        this.family_name = family_name;
        this.picture = picture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isVertified_email() {
        return vertified_email;
    }

    public void setVertified_email(boolean vertified_email) {
        this.vertified_email = vertified_email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGiven_name() {
        return given_name;
    }

    public void setGiven_name(String given_name) {
        this.given_name = given_name;
    }

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "UserGoogleDTO{" + "id=" + id + ", email=" + email + ", vertified_email=" + vertified_email + ", name=" + name + ", given_name=" + given_name + ", family_name=" + family_name + ", picture=" + picture + '}';
    }
    
    
    
}
