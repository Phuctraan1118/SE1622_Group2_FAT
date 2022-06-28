/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validator;

/**
 *
 * @author Bitano
 */
public class Validate {
    public static boolean checkPrice(String price) {
        return price.matches("^([+-]?\\d*\\.?\\d*)$");
    }
}
