/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author buikh
 */
public class MySqlQueryConstants {

    public class LoginFeature {

        public static final String AUTHENTICATION_QUERY = "Select IdUser, Address, Phone, CitizenIdetification, Status, Role, FullName, Email "
                + "From tblUser "
                + "Where Username = ? AND Password = ? AND Status = 1 ";
    }

}
