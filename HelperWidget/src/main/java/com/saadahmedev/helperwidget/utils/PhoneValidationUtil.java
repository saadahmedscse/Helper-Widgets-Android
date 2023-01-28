package com.saadahmedev.helperwidget.utils;

public class PhoneValidationUtil {
    private static String phone;

    public static void setPhone(String phone) {
        PhoneValidationUtil.phone = phone;
    }

    public static boolean isValidPhone(Countries country) {
        switch (country) {
            case BANGLADESH: return phone.startsWith("+880") && phone.length() == 14 || phone.length() == 11;
            case USA: return phone.startsWith("+1") && phone.length() == 12 || phone.length() == 10;
        }

        return false;
    }
}
