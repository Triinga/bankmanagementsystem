package com.tringa.bankmanagementsystem.ConsoleApplication.utils;


public class AccountUtils {
    private static int lastAccountId = 0;

    //method to generate a unique account ID
    public static int generateAccountId() {
        return ++lastAccountId; // Increment and return the last generated account ID
    }
}
