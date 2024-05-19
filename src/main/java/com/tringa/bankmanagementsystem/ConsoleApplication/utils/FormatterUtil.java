package com.tringa.bankmanagementsystem.ConsoleApplication.utils;


import java.text.DecimalFormat;
import java.util.Locale;

public class FormatterUtil {
    public static String formatAmount(double amount) {
        DecimalFormat df = (DecimalFormat) DecimalFormat.getCurrencyInstance(Locale.US);
        return df.format(amount);
    }
}

