/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form;

/**
 *
 * @author hungp
 */
public class UserError {
    
    private String usernameError;
    private String fullNameError;
    private String roleIdError;
    private String passwordError;
    private String addressError;
    private String citizenIndentification;
    private String emailError;
    private String phoneNumError;
    private String confirmError;
    private String messageError;

    public UserError() {
    }

    public UserError(String usernameError, String fullNameError, String roleIdError, String passwordError, String addressError, String citizenIndentification, String emailError, String phoneNumError, String confirmError, String messageError) {
        this.usernameError = usernameError;
        this.fullNameError = fullNameError;
        this.roleIdError = roleIdError;
        this.passwordError = passwordError;
        this.addressError = addressError;
        this.citizenIndentification = citizenIndentification;
        this.emailError = emailError;
        this.phoneNumError = phoneNumError;
        this.confirmError = confirmError;
        this.messageError = messageError;
    }

    public String getFullNameError() {
        return fullNameError;
    }

    public void setFullNameError(String fullNameError) {
        this.fullNameError = fullNameError;
    }
    
    public String getUsernameError() {
        return usernameError;
    }

    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    public String getRoleIdError() {
        return roleIdError;
    }

    public void setRoleIdError(String roleIdError) {
        this.roleIdError = roleIdError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getAddressError() {
        return addressError;
    }

    public void setAddressError(String addressError) {
        this.addressError = addressError;
    }

    public String getCitizenIndentification() {
        return citizenIndentification;
    }

    public void setCitizenIndentification(String citizenIndentification) {
        this.citizenIndentification = citizenIndentification;
    }

    public String getEmailError() {
        return emailError;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    public String getPhoneNumError() {
        return phoneNumError;
    }

    public void setPhoneNumError(String phoneNumError) {
        this.phoneNumError = phoneNumError;
    }

    public String getConfirmError() {
        return confirmError;
    }

    public void setConfirmError(String confirmError) {
        this.confirmError = confirmError;
    }

    public String getMessageError() {
        return messageError;
    }

    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }
    
    
    
}
