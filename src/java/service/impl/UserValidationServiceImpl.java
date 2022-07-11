/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import form.UserCreateForm;
import form.UserError;
import form.UserUpdateForm;
import service.UserValidationService;
import static validator.Validation.checkAddress;
import static validator.Validation.checkCitizenIndentification;
import static validator.Validation.checkEmail;
import static validator.Validation.checkFullname;
import static validator.Validation.checkPhoneNumber;
import static validator.Validation.checkUsername;

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
            userError.setFullNameError("Full Name must be character [5,20]");
        }
        if (!checkPhoneNumber(userCreateForm.getPhone())) {
            if(userError == null) {
                userError = new UserError();
            }
            userError.setPhoneNumError("Phone number must be numeric and have 10 numbers! ");
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
            userError.setEmailError("Email must be follow format example@gmail.com");
        }
        if (!checkCitizenIndentification(userCreateForm.getCitizenIdentification())) {
            if(userError == null) {
                userError = new UserError();
            }
            userError.setCitizenIndentification("Citizen Indentification included 9 or 12 numbers");
        }
       
        return userError;
    }

    @Override
    public UserError UpdateUserValidation(UserUpdateForm userUpdateForm) {
       UserError userError = null;
        
       
        if (!checkFullname(userUpdateForm.getFullName())) {
            if(userError == null) {
                userError = new UserError();
            }
            userError.setFullNameError("Full Name must be character [5,20]");
        }
        if (!checkPhoneNumber(userUpdateForm.getPhone())) {
            if(userError == null) {
                userError = new UserError();
            }
            userError.setPhoneNumError("Phone number must be numeric and have 10 numbers! ");
        }
        if (!checkAddress(userUpdateForm.getAddress())) {
            if(userError == null) {
                userError = new UserError();
            }
            userError.setAddressError("Address invalid!!!");
        }
        if (!checkEmail(userUpdateForm.getEmail())) {
            if(userError == null) {
                userError = new UserError();
            }
            userError.setEmailError("Email must be follow format example@gmail.com");
        }
        if (!checkCitizenIndentification(userUpdateForm.getCitizenIdentification())) {
            if(userError == null) {
                userError = new UserError();
            }
            userError.setCitizenIndentification("Citizen Indentification included 9 or 12 numbers");
        }
       
        return userError;
    }
    
}
