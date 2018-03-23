package com.example.cobe.carapp.common;

/**
 * Created by cobe on 23/03/2018.
 */

public class ValidationUtils {

    public static boolean isPasswordValid(String password) {
        return password.length() < 6;
    }

    public static boolean isEmailValid(String email) {
        return email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
