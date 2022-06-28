/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validator;

/**
 *
 * @author hungp
 */
public class Validation {

     public static boolean checkUsername(String username) {
        return username.matches("[a-z0-9]{5,12}");
    }

    public static boolean checkPassword(String password) {
        return password.matches("[a-zA-Z0-9!@#$%^&*()_-]");
    }

    public static boolean checkFullname(String fullname) {
        return fullname.matches("[a-zA-Z\\s]{8,20}");
    }

    public static boolean checkAddress(String address) {
        return address.matches("[a-zA-Z0-9,\\s]{5,50}");
    }

    public static boolean checkEmail(String email) {
        return email.matches("[a-zA-Z0-9_-]{3,30}@{1}[a-zA-Z0-9]{5}[.][a-z0-9]{2,5}(.vn)?");
    }

    public static boolean checkPhoneNumber(String phoneNum) {
        return phoneNum.matches("[0-9]{10}");
    }

    public static boolean checkCitizenIndentification(String citizenIndentification) {
        return citizenIndentification.matches("^(\\d{9}|\\d{12})$");
    }
     
}
