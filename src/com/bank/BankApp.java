package com.bank;

import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankService bank = new BankService();
        int choice;

        do {
            System.out.println("\n🏦 === Bank Account Management System ===");
            System.out.println("1. Create Account");
            System.out.println("2. View Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer Funds");
            System.out.println("6. Delete Account");
            System.out.println("7. View All Accounts");
            System.out.println("0. Exit");
            System.out.print("➡ Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("❌ Invalid choice. Please enter a number.");
                sc.next(); // consume invalid input
                System.out.print("➡ Enter your choice: ");
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter Account Holder Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double bal = sc.nextDouble();
                    bank.createAccount(name, bal);
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    bank.viewAccount(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    int depAcc = sc.nextInt();
                    System.out.print("Enter Amount to Deposit: ");
                    double depAmt = sc.nextDouble();
                    bank.deposit(depAcc, depAmt);
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    int wAcc = sc.nextInt();
                    System.out.print("Enter Amount to Withdraw: ");
                    double wAmt = sc.nextDouble();
                    bank.withdraw(wAcc, wAmt);
                    break;

                case 5:
                    System.out.print("Enter FROM Account Number: ");
                    int from = sc.nextInt();
                    System.out.print("Enter TO Account Number: ");
                    int to = sc.nextInt();
                    System.out.print("Enter Amount to Transfer: ");
                    double amt = sc.nextDouble();
                    bank.transfer(from, to, amt);
                    break;

                case 6:
                    System.out.print("Enter Account Number to Delete: ");
                    bank.deleteAccount(sc.nextInt());
                    break;

                case 7:
                    bank.viewAllAccounts();
                    break;

                case 0:
                    System.out.println("👋 Thank you for using the system!");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}