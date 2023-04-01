package com.carlczarnetzki.bank;

import java.util.Scanner;

public class BankAccount {
    private final int id;
    private final String customerName;
    private String password;
    private double balance;
    private double prevTrans;

    public BankAccount(int id, String customerName, String password) {
        this.id = id;
        this.customerName = customerName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public double getPrevTrans() {
        return prevTrans;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setPrevTrans(double prevTrans) {
        this.prevTrans = prevTrans;
    }

    public void deposit(double amount){
        if(amount > 0){
            this.setBalance(this.getBalance() + amount);
            this.setPrevTrans(amount);
        }
    }

    public void withdraw(double amount){
        if(amount > 0 && this.getBalance() >= amount){
            this.setBalance(this.getBalance() - amount);
            this.setPrevTrans(-amount);
        }
    }

    public void printPrevTrans(){
        if(this.getPrevTrans() > 0){
            System.out.println("Deposited: " + this.getPrevTrans());
        } else if (this.getPrevTrans() < 0){
            System.out.println("Withdrawn: " + this.getPrevTrans());
        }
        else{
            System.out.println("No transaction occurred");
        }
    }

    public void menu(){
        char option;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome " + this.getCustomerName());
        System.out.println("Your ID: " + this.getId());
        System.out.println("\n");
        System.out.println("1 --- Check balance");
        System.out.println("2 --- Deposit amount");
        System.out.println("3 --- Withdraw amount");
        System.out.println("4 --- Previous transactions");
        System.out.println("5 --- Exit");

        do {
            System.out.println("********************************************");
            System.out.println("Choose an option");
            option=sc.next().charAt(0);
            System.out.println("\n");

            switch (option){
                case '1':
                    System.out.println("......................");
                    System.out.println("Balance: " + this.getBalance());
                    System.out.println("......................");
                    System.out.println("\n");
                    break;
                case '2':
                    System.out.println("......................");
                    System.out.println("Enter amount to deposit: ");
                    System.out.println("......................");
                    double amountDeposit = sc.nextDouble();
                    this.deposit(amountDeposit);
                    System.out.println("\n");
                    break;
                case '3':
                    System.out.println("......................");
                    System.out.println("Enter amount to withdraw: ");
                    System.out.println("......................");
                    double amountWithdraw = sc.nextDouble();
                    this.withdraw(amountWithdraw);
                    System.out.println("\n");
                    break;
                case '4':
                    System.out.println("......................");
                    System.out.println("Previous transaction: ");
                    this.printPrevTrans();
                    System.out.println("......................");
                    System.out.println("\n");
                    break;
                case '5':
                    System.out.println("Thank you for using our banking services");
                    System.out.println("********************************************");
                default:
                    System.out.println("Choose a correct option to proceed");
                    System.out.println("\n");
            }
        } while (option != 5);
    }
}
