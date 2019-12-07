package main.utils;

public class NumberUtils {
    public static boolean isStringADigit(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
