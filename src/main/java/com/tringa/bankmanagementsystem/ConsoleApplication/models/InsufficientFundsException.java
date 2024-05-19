package com.tringa.bankmanagementsystem.ConsoleApplication.models;


public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}