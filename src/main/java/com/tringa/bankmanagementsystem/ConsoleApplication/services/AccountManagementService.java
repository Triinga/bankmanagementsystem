    package com.tringa.bankmanagementsystem.ConsoleApplication.services;

    import com.tringa.bankmanagementsystem.ConsoleApplication.models.Account;
    import com.tringa.bankmanagementsystem.ConsoleApplication.models.Bank;
    import com.tringa.bankmanagementsystem.ConsoleApplication.utils.AccountUtils;
    import com.tringa.bankmanagementsystem.ConsoleApplication.utils.FormatterUtil;

    import java.util.List;
    import java.util.Scanner;

    public class AccountManagementService {
        private Bank bank;
        private FormatterUtil formatterUtil;

        public AccountManagementService(Bank bank) {
            this.bank = bank;
            this.formatterUtil = new FormatterUtil();
        }

        //method to create an account
        public void createAccount() {
            Scanner scanner = new Scanner(System.in);

            try {
                if (bank == null) {
                    throw new NullPointerException("Cannot create account without creating a bank first.");
                }

                System.out.println("Creating a new account...");
                System.out.print("Enter account holder name: ");
                String accountHolderName = scanner.nextLine();

                // Generate a unique account ID
                int accountId = AccountUtils.generateAccountId();

                // Create a new account instance
                Account account = new Account(accountId, accountHolderName, 0.0);

                // Add the account to the bank
                bank.addAccount(account);
                System.out.println("Account created successfully with id " + accountId);
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }


        //method to check the account balance for any account
        public void checkAccountBalance() {
            Scanner scanner = new Scanner(System.in);

            try {
               if (bank == null) {
                System.out.println("No bank created yet. Please create a bank first.");
                return;
            }

                System.out.println("Checking account balance...");
                System.out.print("Enter account ID: ");
                int accountId = scanner.nextInt();

                Account account = bank.getAccountById(accountId);

                if (account == null) {
                    System.out.println("Account not found.");
                    return;
                }

                String formattedBalance = formatterUtil.formatAmount(account.getAccountBalance());
                System.out.println("Account Balance: " + formattedBalance);
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }
        //method to view a list of bank accounts
        public void viewListOfAccounts() {
            if (bank == null) {
                System.out.println("No bank created yet. Please create a bank first.");
                return;
            }

            List<Account> accounts = bank.getListOfAccounts();
            if (accounts.isEmpty()) {
                System.out.println("No accounts found.");
                return;
            }

            System.out.println("List of Bank Accounts:");
            for (Account account : accounts) {
                System.out.println("Account ID: " + account.getAccountId() + ", Account Holder Name: " + account.getNameOfUser());
            }
        }


    }
