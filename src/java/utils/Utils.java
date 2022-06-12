/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author buikh
 */
public class Utils {
    public static boolean checkFormat(String check, int lowerBound, int upperBound){
        boolean flag = false;
        if(check.trim().length() < lowerBound && check.trim().length() > upperBound){
            flag = true;
        }
        return flag;
    }
    
    public static boolean checkFormatOneBound(String check, int bound){
        boolean flag = false;
        if(check.trim().length() != bound){
            flag = true;
        }
        return flag;
    }
}
