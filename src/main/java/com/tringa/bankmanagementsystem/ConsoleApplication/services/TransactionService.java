package com.tringa.bankmanagementsystem.ConsoleApplication.services;

import com.tringa.bankmanagementsystem.ConsoleApplication.models.Account;
import com.tringa.bankmanagementsystem.ConsoleApplication.models.Bank;
import com.tringa.bankmanagementsystem.ConsoleApplication.models.Transaction;
import com.tringa.bankmanagementsystem.ConsoleApplication.utils.FormatterUtil;

import java.util.List;
import java.util.Scanner;

public class TransactionService {
    private FormatterUtil formatterUtil;
    private Bank bank;

    public TransactionService(Bank bank) {
        this.bank = bank;
        this.formatterUtil = new FormatterUtil();
    }

    //method to perform a transaction (transfer)
    public void performTransaction() {
        Scanner scanner = new Scanner(System.in);

        try {
            if (bank == null) {
                throw new NullPointerException("Cannot perform transaction without creating a bank first.");
            }

            System.out.println("Performing a transaction...");
            System.out.print("Enter originating account ID: ");
            int fromAccountId = scanner.nextInt();
            System.out.print("Enter resulting account ID: ");
            int toAccountId = scanner.nextInt();
            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline character


            System.out.print("Choose fee type (flat/percent): ");
            String feeType = scanner.nextLine();

            Account fromAccount = bank.getAccountById(fromAccountId);
            Account toAccount = bank.getAccountById(toAccountId);

            if (fromAccount == null || toAccount == null) {
                System.out.println("One or both accounts not found.");
                return;
            }

            Transaction.performTransfer(bank, fromAccount, toAccount, amount);
            String formattedAmount = formatterUtil.formatAmount(amount);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    //method to withdraw money from an account
    public void withdrawMoney() {
        Scanner scanner = new Scanner(System.in);

        try {
            if (bank == null) {
                throw new NullPointerException("Cannot perform withdrawal without creating a bank first.");
            }

            System.out.println("Withdrawing money...");
            System.out.print("Enter account ID: ");
            int accountId = scanner.nextInt();
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();

            //consume newline character
            scanner.nextLine();

            Account account = bank.getAccountById(accountId);

            if (account == null) {
                System.out.println("Account not found.");
                return;
            }

            System.out.print("Choose fee type (flat/percent): ");
            String feeType = scanner.nextLine();

            Transaction.performWithdrawal(bank, account, amount, feeType);

            String formattedAmount = formatterUtil.formatAmount(amount);
            System.out.println("Withdrawal amount: " + formattedAmount);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }


    //method to deposit money to an account
    public void depositMoney() {
        Scanner scanner = new Scanner(System.in);

        try {
            if (bank == null) {
                throw new NullPointerException("Cannot perform deposit without creating a bank first.");
            }

            System.out.println("Depositing money...");
            System.out.print("Enter account ID: ");
            int accountId = scanner.nextInt();
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();

            Account account = bank.getAccountById(accountId);

            if (account == null) {
                System.out.println("Account not found.");
                return;
            }

            scanner.nextLine(); //consume newline character
            System.out.print("Choose fee type (flat/percent): ");
            String feeType = scanner.nextLine();

            Transaction.performDeposit(bank, account, amount, feeType);

            String formattedAmount = formatterUtil.formatAmount(amount);
            System.out.println("Deposit amount: " + formattedAmount);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }



    //method to view transactions for an account
    public void viewTransactionsForAccount() {
        Scanner scanner = new Scanner(System.in);

        try {
            if (bank == null) {
                throw new NullPointerException("Cannot view transactions without creating a bank first.");
            }

            System.out.println("Viewing transactions for an account...");
            System.out.print("Enter account ID: ");
            int accountId = scanner.nextInt();

            Account account = bank.getAccountById(accountId);

            if (account == null) {
                System.out.println("Account not found.");
                return;
            }

            List<Transaction> transactions = account.getTransactions();
            if (transactions.isEmpty()) {
                System.out.println("No transactions found for this account.");
            } else {
                System.out.println("Transactions for account ID " + accountId + ":");
                for (Transaction transaction : transactions) {
                    System.out.println("Amount: " + transaction.getAmount() + ", Transaction Reason: " + transaction.getTransactionReason());
                }
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    //method to check the bank's total transaction fee amount
    public void checkTotalTransactionFeeAmount() {
        if (bank == null) {
            System.out.println("No bank created yet. Please create a bank first.");
            return;
        }

        double totalTransactionFeeAmount = bank.getTotalTransactionFeeAmount();
        String formattedTransactionFeeAmount = formatterUtil.formatAmount(totalTransactionFeeAmount);
        System.out.println("Total Transaction Fee Amount: " + formattedTransactionFeeAmount);
    }

    //check the bank's total transfer amount
    public void checkTotalTransferAmount() {
        if (bank == null) {
            System.out.println("No bank created yet. Please create a bank first.");
            return;
        }
        double totalTransferAmount = bank.getTransferAmount();
        String formattedTransferAmount = formatterUtil.formatAmount(totalTransferAmount);
        System.out.println("Total Transfer Amount: " + formattedTransferAmount);
    }

}
