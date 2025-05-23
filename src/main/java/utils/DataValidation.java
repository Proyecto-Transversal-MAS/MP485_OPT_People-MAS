/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.regex.Pattern;

/**
 * @author Francesc Perez
 * @version 1.1.0
 */
public class DataValidation {

    public static boolean isNumber(char c) {
        return (48 <= c && c <= 57);
    }

    public static boolean isLetter(char c) {
        //The name can contain uppercase and lowercase letters, whitespace, 
        //hyphens and code control
//        return (97 <= c && c <= 122) || (65 <= c && c <= 90) || (c == 32) || (c == 45);
        return Character.isLetter(c) || c == 32 || c == 45;
    }

    public static String calculateNifLetter(String nifNoLetter) {
        String[] letter = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B",
            "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
        return nifNoLetter + letter[Integer.parseInt(nifNoLetter) % 23];
    }

    public static boolean checkEmailAddress(String email) {
        String emailRegex = "^(?=.{1,64}@)[\\p{L}0-9_-]+(\\.[\\p{L}0-9_-]+)*@"
                + "[^-][\\p{L}0-9-]+(\\.[\\p{L}0-9-]+)*(\\.[\\p{L}]{2,})$";
        Pattern p = Pattern.compile(emailRegex);
        if (email == null) {
            return false;
        }
        return p.matcher(email).matches();
    }

    public static boolean checkPhoneNumber(String phone) {
        String phoneRegex = "^\\+?[0-9]{1,4}?[-.\\s]?(\\d{1,3})?[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,9}$";
        Pattern p = Pattern.compile(phoneRegex);
        if (phone == null) {
            return false;
        }
        return p.matcher(phone).matches();
    }

    public static boolean checkZipCodeTyping(String zipCode) {
        String zipCodeRegexTyping = "^\\d{0,5}([-\\s]?\\d{0,4})?$";
        Pattern p = Pattern.compile(zipCodeRegexTyping);
        if (zipCode == null) {
            return false;
        }
        return p.matcher(zipCode).matches();
    }
    
    public static boolean checkZipCodeSubmission(String zipCode) {
        String zipCodeRegexSubmission = "^\\d{5}([-\\s]?\\d{4})?$";
        Pattern p = Pattern.compile(zipCodeRegexSubmission);
        if (zipCode == null) {
            return false;
        }
        return p.matcher(zipCode).matches();
    }
}
