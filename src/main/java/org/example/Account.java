package org.example;

import java.util.Scanner;

public class Account {

    // class variables
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    // class constructor
    Account(String customerName,String customerID){
        this.customerID = customerID;
        this.customerName =  customerName;
    }

    // function for depositing the money
    void deposit(int amount){
        if(amount != 0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }
    //function to withdraw the money
    void withdraw(int amount){
        if(amount!=0){
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }
    // function showing the previous transaction
    void getPreviousTransaction(){
        if(previousTransaction > 0){
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred");
        }
    }
    // function for calculating interest of the current funds after a number of years
    void calculateInterest(int years){
        double interestRate = .0185;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The current interest rate is " + (100 * interestRate) + "%");
        System.out.println("Aftter " + years + "years, your balance will be: " + newBalance);
    }
    // function showing th main menu
    void showMenu(){
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + " !");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E Calculate interest");
        System.out.println("F. Exit");

        do{
            System.out.println();
            System.out.println("Enter an option:");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch (option){
                // Case 'A' allows the user to check there account balance
                case 'A':
                    System.out.println("==================================");
                    System.out.println("Balance = $ " + balance);
                    System.out.println("===================================");
                    System.out.println();
                    break;
                // Case 'B' allows the user to deposit into there account using
                case 'B':
                    System.out.println("Enter an amount to deposit:");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;
                    //case 'C' allows the user to withdraw money from there account using
                case 'C':
                    System.out.println("Enter an amount to withdraw:");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;
                    // case 'D' allows the user to view there most recent transaction using
                case 'D':
                    System.out.println("======================================");
                    getPreviousTransaction();
                    System.out.println("=======================================");
                    System.out.println();
                    break;
                    // case 'E' calculate the accrued interest on the  account afer a number of years
                case 'E':
                    System.out.println("Enter how many years of accrued interest:");
                    int years = scanner.nextInt();
                    calculateInterest(years);
                    break;
                    // case 'F' exits the user from there account
                case 'F':
                    System.out.println("===========================================");
                    break;
                    // The default case lets the user know that they entterd an invalid choice
                default:
                    System.out.println("Error: Invalid option.Please enter A,B,C,D or E");
            }
        } while (option!='F');
        System.out.println("Thank you for banking with us!");
    }
}
