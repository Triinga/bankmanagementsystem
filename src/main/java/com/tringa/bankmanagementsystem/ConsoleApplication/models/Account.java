package com.tringa.bankmanagementsystem.ConsoleApplication.models;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private int accountId;
    private String nameOfUser;
    private double accountBalance;

    private static int lastAccountId = 0; //keep track of the last generated account ID for account creation
    private List<Transaction> transactions; //list to store transactions

    public Account(int accountId, String nameOfUser, double accountBalance) {
        this.accountId = accountId;
        this.nameOfUser = nameOfUser;
        this.accountBalance = accountBalance;
        transactions = new ArrayList<>(); // Initialize the transactions list
    }

    private static final DecimalFormat currencyFormat = new DecimalFormat("$0.00");

    //method to format amount as currency
    private String formatAmount(double amount) {
        return currencyFormat.format(amount);
    }


    //method to add a transaction to the account's transaction list
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    //method to retrieve the list of transactions
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getNameOfUser() {
        return nameOfUser;
    }

    public void setNameOfUser(String nameOfUser) {
        this.nameOfUser = nameOfUser;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    //to withdraw money from account
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > accountBalance) {
            throw new InsufficientFundsException("Insufficient funds in the account.");
        }
        accountBalance -= amount;
    }

    //to deposit funds into the account
    public void deposit(double amount) {
        accountBalance += amount;
    }


}


