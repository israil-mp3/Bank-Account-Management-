package com.bank;

import java.util.HashMap;
import java.util.Map;

public class BankService {
    private Map<Integer, Account> accounts = new HashMap<>();

    // Create account (auto-generated number)
    public void createAccount(String name, double balance) {
        Account acc = new Account(name, balance);
        int accNo = acc.getAccountNumber();
        accounts.put(accNo, acc);

        System.out.println("✅ Account created successfully!");
        System.out.println("🆔 Your Account Number is: " + accNo);
    }

    public void viewAccount(int accNo) {
        Account acc = accounts.get(accNo);
        if (acc != null) {
            System.out.println(acc);
        } else {
            System.out.println("❌ Account not found.");
        }
    }

    public void deposit(int accNo, double amount) {
        Account acc = accounts.get(accNo);
        if (acc != null) {
            acc.deposit(amount);
            System.out.println("✅ Deposit successful. New Balance: ₹" + acc.getBalance());
        } else {
            System.out.println("❌ Account not found.");
        }
    }

    public void withdraw(int accNo, double amount) {
        Account acc = accounts.get(accNo);
        if (acc != null) {
            try {
                acc.withdraw(amount);
                System.out.println("✅ Withdrawal successful. New Balance: ₹" + acc.getBalance());
            } catch (Exception e) {
                System.out.println("❌ " + e.getMessage());
            }
        } else {
            System.out.println("❌ Account not found.");
        }
    }

    public void transfer(int fromAcc, int toAcc, double amount) {
        Account sender = accounts.get(fromAcc);
        Account receiver = accounts.get(toAcc);

        if (sender != null && receiver != null) {
            try {
                sender.withdraw(amount);
                receiver.deposit(amount);
                System.out.println("✅ Transfer successful.");
            } catch (Exception e) {
                System.out.println(" " + e.getMessage());
            }
        } else {
            System.out.println(" One or both accounts not found.");
        }
    }

    public void deleteAccount(int accNo) {
        Account removed = accounts.remove(accNo);
        if (removed != null) {
            System.out.println(" Account deleted.");
        } else {
            System.out.println("Account not found.");
        }
    }

    public void viewAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println(" No accounts available.");
        } else {
            for (Account acc : accounts.values()) {
                System.out.println(acc);
            }
        }
    }
}