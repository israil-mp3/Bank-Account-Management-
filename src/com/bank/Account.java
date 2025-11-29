package com.bank;

public class Account {
    // Static counter for account number
    private static int nextAccountNumber = 1001;

    private int accountNumber;
    private String holderName;
    private double balance;

    // Constructor: auto-generate account number
    public Account(String holderName, double balance) {
        this.accountNumber = nextAccountNumber++;
        this.holderName = holderName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        if (amount > balance) {
            throw new Exception("Insufficient balance!");
        }
        this.balance -= amount;
    }

    @Override
    public String toString() {
        return "Account No: " + accountNumber +
               ", Name: " + holderName +
               ", Balance: ₹" + String.format("%.2f", balance);
    }
}