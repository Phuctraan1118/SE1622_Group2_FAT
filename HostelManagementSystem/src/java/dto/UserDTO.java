/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author buikh
 */
public class UserDTO extends Entity {

    private String username;
    private String password;
    private String address;
    private String phone;
    private String citizenIdentification;
    private boolean status;
    private String role;
    private String email;
    private String img;

    public UserDTO() {
        super();
    }

    public UserDTO(String username, String password, String address, String phone, String citizenIdentification, boolean status, String role, String id, String name, String email) {
        super(id, name);
        this.username = username;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.citizenIdentification = citizenIdentification;
        this.status = status;
        this.role = role;
        this.email = email;
//        this.img = img;
    }

    public UserDTO(String address, String phone, String citizenIdentification, boolean status, String role, String id, String name, String email) {
        super(id, name);
        this.address = address;
        this.phone = phone;
        this.citizenIdentification = citizenIdentification;
        this.status = status;
        this.role = role;
        this.email = email;
//        this.img = img;
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

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the citizenIdentification
     */
    public String getCitizenIdentification() {
        return citizenIdentification;
    }

    /**
     * @param citizenIdentification the citizenIdentification to set
     */
    public void setCitizenIdentification(String citizenIdentification) {
        this.citizenIdentification = citizenIdentification;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public String getId() {
        return super.getId();
    }

}
