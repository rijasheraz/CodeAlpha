/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.bankingapplication;
import java.util.Scanner;
/**
 *
 * @author UNI-TECH
 */
public class BankingApplication {
 
    private static double balance = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Welcome to Banking Application");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option! Please choose again.\n\n");
            }
        }
        System.out.println("\nThank you for using Banking Application!");
    }

    private static void deposit() {
        System.out.print("Enter Amount to Deposit: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Current Balance: " + balance + "\n\n" );
        } else {
            System.out.println("Invalid amount! Please enter a positive value.\n\n");
        }
    }

    private static void withdraw() {
        System.out.print("Enter Amount to Withdraw: ");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance + "\n\n");
        } else if (amount <= 0) {
            System.out.println("Invalid amount! Please enter a positive value.\n\n");
        } else {
            System.out.println("Insufficient funds!\n\n");
        }
    }

    private static void checkBalance() {
        System.out.println("Your current balance is: " + balance + "\n\n");
    }

    
}

    
 
