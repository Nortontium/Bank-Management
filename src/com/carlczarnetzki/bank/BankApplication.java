package com.carlczarnetzki.bank;

import java.util.Scanner;

public class BankApplication {
    private int lastId;
    public BankApplication() {
        lastId = 63292438;
    }

    public int getLastId() {
        return lastId;
    }

    public void setLastId(int lastId) {
        this.lastId = lastId;
    }

    /*
    public void createAccount(){
        Scanner scCreate = new Scanner(System.in);
        System.out.println("......................");
        System.out.println("Enter your name: ");
        System.out.println("......................");
        String name = scCreate.nextLine();

        System.out.println("......................");
        System.out.println("Choose a password: ");
        System.out.println("......................");
        String password = scCreate.nextLine();

        BankAccount ba1 = new BankAccount(this.getLastId() + 1, name, password);
    }

     */

    public void run() {
        Scanner scMain = new Scanner(System.in);
        System.out.println("********************************************");
        System.out.println("Welcome to our banking services");
        System.out.println("\n");
        System.out.println("......................");
        System.out.println("Enter your name: ");
        System.out.println("......................");
        String name = scMain.nextLine();
        System.out.println("......................");
        System.out.println("Enter your password: ");
        System.out.println("......................");
        String password = scMain.nextLine();
        BankAccount ba1 = new BankAccount(this.getLastId() + 1, name, password);
        ba1.menu();
    }
}
