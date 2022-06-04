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
    public class LoginFeature{
        public static final String AUTHENTICATION_QUERY = "Select UserName, Password, FullName, Email, Address, Phone , CitizenIdetification, Status, Role, Image "
                                                       + "From tblUser "
                                                       + "Where Username = ? AND Password = ? AND Status = 1 ";
        public static final String FIND_BY_USERNAME_EMAIL = "Select UserName, Password, FullName, Email, Address, Phone , CitizenIdetification, Status, Role, Image "
                                                        + "From tblUser "
                                                        + "Where Username = ? AND Email = ?";
    }
}
