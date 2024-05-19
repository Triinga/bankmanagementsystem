package com.tringa.bankmanagementsystem.ConsoleApplication.models;


public class Transaction {
    private double amount;
    private int originatingAccountId;
    private int resultingAccountId;
    private String transactionReason;


    public Transaction(double amount, int originatingAccountId, int resultingAccountId, String transactionReason) {
        this.amount = amount;
        this.originatingAccountId = originatingAccountId;
        this.resultingAccountId = resultingAccountId;
        this.transactionReason = transactionReason;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getOriginatingAccountId() {
        return originatingAccountId;
    }

    public void setOriginatingAccountId(int originatingAccountId) {
        this.originatingAccountId = originatingAccountId;
    }

    public int getResultingAccountId() {
        return resultingAccountId;
    }

    public void setResultingAccountId(int resultingAccountId) {
        this.resultingAccountId = resultingAccountId;
    }

    public String getTransactionReason() {
        return transactionReason;
    }

    public void setTransactionReason(String transactionReason) {
        this.transactionReason = transactionReason;
    }

    //method to calculate transaction fee based on bank configuration
    private static double calculateFee(Bank bank, double amount, String feeType) {
        if ("flat".equalsIgnoreCase(feeType)) {
            return bank.getTransactionFlatFeeAmount();
        } else if ("percent".equalsIgnoreCase(feeType)) {
            return amount * (bank.getTransactionPercentFeeValue() / 100);
        } else {
            return 0; // No fee configured
        }
    }


    public static void performTransfer(Bank bank, Account fromAccount, Account toAccount, double amount) {
        double flatFeeAmount = bank.getTransactionFlatFeeAmount();
        double percentFeeValue = bank.getTransactionPercentFeeValue();

        double flatFee = flatFeeAmount > 0 ? flatFeeAmount : 0;

        double percentFee = percentFeeValue > 0 ? (amount * (percentFeeValue / 100)) : 0;

        double totalFee = flatFee + percentFee;

        try {
            double totalAmount = amount + totalFee;
            fromAccount.withdraw(totalAmount);
            toAccount.deposit(amount);
            System.out.println("Transfer successful.");

            Transaction withdrawalTransaction = new Transaction(amount, fromAccount.getAccountId(), toAccount.getAccountId(), "Transfer to " + toAccount.getAccountId());
            fromAccount.addTransaction(withdrawalTransaction);

            Transaction depositTransaction = new Transaction(amount, fromAccount.getAccountId(), toAccount.getAccountId(), "Transfer from " + fromAccount.getAccountId());
            toAccount.addTransaction(depositTransaction);

            bank.setTotalTransactionFeeAmount(bank.getTotalTransactionFeeAmount() + totalFee);
            bank.setTransferAmount(bank.getTransferAmount() + amount);
        } catch (InsufficientFundsException e) {
            System.out.println("Insufficient funds in the originating account.");
        }
    }



    public static void performWithdrawal(Bank bank, Account account, double amount, String feeType) {
        double feeAmount = calculateFee(bank, amount, feeType);

        try {
            account.withdraw(amount + feeAmount); // Withdraw the total amount including the fee
            Transaction withdrawalTransaction = new Transaction(amount, account.getAccountId(), 0, "Withdrawal");
            account.addTransaction(withdrawalTransaction); // Add the withdrawal transaction to the account's list of transactions
            System.out.println("Withdrawal successful.");
            bank.setTotalTransactionFeeAmount(bank.getTotalTransactionFeeAmount() + feeAmount); // Update total transaction fee amount
        } catch (InsufficientFundsException e) {
            System.out.println("Insufficient funds in the account.");
        }
    }



    public static void performDeposit(Bank bank, Account account, double amount, String feeType) {
        double feeAmount = calculateFee(bank, amount, feeType);
        double totalAmount = amount - feeAmount;
        try {
            account.deposit(totalAmount);
            Transaction depositTransaction = new Transaction(totalAmount, 0, account.getAccountId(), "Deposit");
            account.addTransaction(depositTransaction);
            System.out.println("Deposit successful.");
            bank.setTotalTransactionFeeAmount(bank.getTotalTransactionFeeAmount() + feeAmount); // Update total transaction fee amount
        } catch (Exception e) {
            System.out.println("Error occurred during deposit: " + e.getMessage());
        }
    }



}
