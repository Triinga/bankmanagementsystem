package com.tringa.bankmanagementsystem.ConsoleApplication.services;

import com.tringa.bankmanagementsystem.ConsoleApplication.models.Bank;

import java.util.Scanner;

public class BankCreationService {
    private Bank bank;
    public BankCreationService(){
        this.bank = null;
    }
    public Bank getBank() {
        return bank;
    }

    //method to create bank
    public void createBank() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Creating a new bank...");
        System.out.print("Enter bank name: ");
        String bankName = scanner.nextLine();


        this.bank = new Bank(bankName);

        System.out.println("Bank created successfully.");
    }
}
