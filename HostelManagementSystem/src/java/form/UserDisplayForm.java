/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form;

/**
 *
 * @author hungp
 */
public class UserDisplayForm {
    private String id;
    private String username;
    private String fullName;
    private String address;
    private String phone;
    private String citizenIdentification;
    private String email;
    private String image;

    public UserDisplayForm() {
    }

    public UserDisplayForm(String id, String username, String fullName, String address, String phone, String citizenIdentification, String email, String image) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.citizenIdentification = citizenIdentification;
        this.email = email;
        this.image = image;
    }

  

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCitizenIdentification() {
        return citizenIdentification;
    }

    public void setCitizenIdentification(String citizenIdentification) {
        this.citizenIdentification = citizenIdentification;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
    
    
}
