package com.tringa.bankmanagementsystem.ConsoleApplication.models;


import java.util.ArrayList;

public class Bank {
    private String bankName;
    private ArrayList<Account> listOfAccounts;
    private double totalTransactionFeeAmount;
    private double transferAmount;
    private double transactionFlatFeeAmount;
    private double transactionPercentFeeValue;


    public Bank(String bankName) {
        this.bankName = bankName;
        this.listOfAccounts = new ArrayList<>();
        this.totalTransactionFeeAmount = 0.0;
        this.transferAmount = 0.0;
        this.transactionFlatFeeAmount = 10.0;
        this.transactionPercentFeeValue = 5.0;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public ArrayList<Account> getListOfAccounts() {
        return listOfAccounts;
    }

    public void setListOfAccounts(ArrayList<Account> listOfAccounts) {
        this.listOfAccounts = listOfAccounts;
    }

    public double getTotalTransactionFeeAmount() {
        return totalTransactionFeeAmount;
    }

    public void setTotalTransactionFeeAmount(double totalTransactionFeeAmount) {
        this.totalTransactionFeeAmount = totalTransactionFeeAmount;
    }

    public double getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(double transferAmount) {
        this.transferAmount = transferAmount;
    }

    public double getTransactionFlatFeeAmount() {
        return transactionFlatFeeAmount;
    }

    public void setTransactionFlatFeeAmount(double transactionFlatFeeAmount) {
        this.transactionFlatFeeAmount = transactionFlatFeeAmount;
    }

    public double getTransactionPercentFeeValue() {
        return transactionPercentFeeValue;
    }

    public void setTransactionPercentFeeValue(double transactionPercentFeeValue) {
        this.transactionPercentFeeValue = transactionPercentFeeValue;
    }

    //method to add an account to the list of accounts
    public void addAccount(Account account) {
        listOfAccounts.add(account);
    }
    //get an account by its ID
    public Account getAccountById(int accountId) {
        for (Account account : listOfAccounts) {
            if (account.getAccountId() == accountId) {
                return account;
            }
        }
        return null;
    }
}