package de.realzone.cloud.utils;

public class Utils {

    public static String[] dropFirstString(String[] array) {
        String[] strings = new String[array.length - 1];
        System.arraycopy(array, 1, strings, 0, array.length - 1);
        return strings;
    }
}
