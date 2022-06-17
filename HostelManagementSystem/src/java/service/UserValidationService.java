/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import form.UserCreateForm;
import form.UserError;

/**
 *
 * @author hungp
 */
public interface UserValidationService {
    
    UserError createUserValidation(UserCreateForm createForm);
}
