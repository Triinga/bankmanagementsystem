package com.tringa.bankmanagementsystem.ConsoleApplication;

import com.tringa.bankmanagementsystem.ConsoleApplication.models.Bank;
import com.tringa.bankmanagementsystem.ConsoleApplication.services.AccountManagementService;
import com.tringa.bankmanagementsystem.ConsoleApplication.services.BankCreationService;
import com.tringa.bankmanagementsystem.ConsoleApplication.services.TransactionService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        BankCreationService bankCreationService = new BankCreationService();
        bankCreationService.createBank();
        Bank bank = bankCreationService.getBank();
        AccountManagementService accountManagementService = new AccountManagementService(bank);
        TransactionService transactionService = new TransactionService(bank);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Create a new bank");
            System.out.println("2. Create a new account");
            System.out.println("3. Perform a transfer");
            System.out.println("4. Perform a withdraw");
            System.out.println("5. Perform a deposit");
            System.out.println("6. View transactions for an account");
            System.out.println("7. Check account balance");
            System.out.println("8. View list of accounts");
            System.out.println("9. Check total transaction fee amount");
            System.out.println("10. Check total transfer amount");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); //to consume newline character

                switch (choice) {
                    case 1:
                        bankCreationService.createBank();
                        break;
                    case 2:
                        accountManagementService.createAccount();
                        break;
                    case 3:
                        transactionService.performTransaction();
                        break;
                    case 4:
                        transactionService.withdrawMoney();
                        break;
                    case 5:
                        transactionService.depositMoney();
                        break;
                    case 6:
                        transactionService.viewTransactionsForAccount();
                        break;
                    case 7:
                        accountManagementService.checkAccountBalance();
                        break;
                    case 8:
                        accountManagementService.viewListOfAccounts();
                        break;
                    case 9:
                        transactionService.checkTotalTransactionFeeAmount();
                        break;
                    case 10:
                        transactionService.checkTotalTransferAmount();
                        break;
                    case 11:
                        running = false;
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {

                String invalidInput = scanner.next();
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        scanner.close();
    }
}
