/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import form.UserCreateForm;
import form.UserError;
import service.UserValidationService;
import static validation.Validator.checkAddress;
import static validation.Validator.checkCitizenIndentification;
import static validation.Validator.checkEmail;
import static validation.Validator.checkFullname;
import static validation.Validator.checkPhoneNumber;
import static validation.Validator.checkUsername;

/**
 *
 * @author hungp
 */
public class UserValidationServiceImpl implements UserValidationService{

    @Override
    public UserError createUserValidation(UserCreateForm userCreateForm) {
        UserError userError = null;
        
        if (!checkUsername(userCreateForm.getUsername())) {
            if(userError == null) {
                userError = new UserError();
            }
            userError.setUsernameError("Username lenght must be [5,10]");
        }
        if (!checkFullname(userCreateForm.getFullName())) {
            if(userError == null) {
                userError = new UserError();
            }
            userError.setFullNameError("Full Name lenght must be [5,20]");
        }
        if (!checkPhoneNumber(userCreateForm.getPhone())) {
            if(userError == null) {
                userError = new UserError();
            }
            userError.setPhoneNumError("Phone Number lenght must be [2,50]");
        }
        if (!checkAddress(userCreateForm.getAddress())) {
            if(userError == null) {
                userError = new UserError();
            }
            userError.setAddressError("Address invalid!!!");
        }
        if (!checkEmail(userCreateForm.getEmail())) {
            if(userError == null) {
                userError = new UserError();
            }
            userError.setEmailError("Email lenght must be follow format abcdef@gmail.com");
        }
        if (!checkCitizenIndentification(userCreateForm.getCitizenIdentification())) {
            if(userError == null) {
                userError = new UserError();
            }
            userError.setCitizenIndentification("Citizen Indentification lenght must be [9,12]");
        }
       
        return userError;
    }
    
}
