package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public static boolean isValidArea(String area) {
        if ( area.equalsIgnoreCase("Toan Quoc")) {
            return true;
        } else if (area.equalsIgnoreCase("Quoc Te")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValidCountry(String country) {
        if ( country.trim().equalsIgnoreCase("Viet Nam")) {
            return false;
        }
        return true;
    }

    public static boolean isValidStatus(String status) {
        if ( status.equalsIgnoreCase("Da sua chua")) {
            return true;
        } else if (status.equalsIgnoreCase("Chua sua chua")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValidNumber (String number) {
        Pattern pattern = Pattern.compile("^[+]?[0-9]*\\.?[0-9]+$");
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }

    public static boolean isValidTimeDate(String timeDate) {
        int time = Integer.parseInt(timeDate);
        if (time >= 0 && time <= 730) {
            return true;
        }
        return false;
    }
}
