package com.carlczarnetzki.bank;

import java.util.LinkedList;
import java.util.Scanner;

public class BankApplication {
    private int lastId;
    public BankApplication() {
        lastId = -1;
    }

    public int getLastId() {
        return lastId;
    }

    public void setLastId(int lastId) {
        this.lastId = lastId;
    }

    public BankAccount createAccount(){
        Scanner scCreate = new Scanner(System.in);
        System.out.println("......................");
        System.out.println("Enter name");
        System.out.println("......................");
        String name = scCreate.nextLine();
        System.out.println("\n");
        System.out.println("......................");
        System.out.println("Choose password");
        System.out.println("......................");
        String password = scCreate.nextLine();
        System.out.println("\n");
        BankAccount ba1 = new BankAccount(this.getLastId() + 1, name, password);
        this.setLastId(this.getLastId() + 1);
        return ba1;
    }

    public void menu() {
        Scanner scMain = new Scanner(System.in);
        char option;
        LinkedList<BankAccount> bankAccounts = new LinkedList<BankAccount>();
        System.out.println("\n");
        System.out.println("Welcome to our banking services");
        System.out.println("\n");
        do {
            System.out.println("1 --- Login");
            System.out.println("2 --- Create new account");
            System.out.println("3 --- Change password");
            System.out.println("4 --- Exit");
            System.out.println("********************************************");
            System.out.println("Choose an option");
            option = scMain.next().charAt(0);
            System.out.println("\n");
            switch (option){
                case '1':
                    System.out.println("......................");
                    System.out.println("Enter ID");
                    System.out.println("......................");
                    int id = scMain.nextInt();
                    scMain.nextLine();
                    System.out.println("\n");
                    System.out.println("......................");
                    System.out.println("Enter password");
                    System.out.println("......................");
                    String passwordInput = scMain.nextLine();
                    System.out.println("\n");
                    if(id <= this.lastId && id >= 0) {
                        String passwordUser = bankAccounts.get(id).getPassword();
                        if (passwordUser.equals(passwordInput)) {
                            bankAccounts.get(id).menu();
                        }
                        else{
                            System.out.println("********************************************");
                            System.out.println("Wrong ID or password");
                            System.out.println("\n");
                        }
                    }
                    else{
                        System.out.println("********************************************");
                        System.out.println("Wrong ID or password");
                        System.out.println("\n");
                    }
                    break;

                case '2':
                    bankAccounts.addLast(this.createAccount());
                    bankAccounts.getLast().menu();
                    break;
                case '3':
                    System.out.println("......................");
                    System.out.println("Enter ID");
                    System.out.println("......................");
                    int idChange = scMain.nextInt();
                    scMain.nextLine();
                    System.out.println("\n");
                    System.out.println("......................");
                    System.out.println("Enter password");
                    System.out.println("......................");
                    String passwordInputChange = scMain.nextLine();
                    System.out.println("\n");
                    if(idChange <= this.lastId && idChange >= 0) {
                        String passwordUser = bankAccounts.get(idChange).getPassword();
                        if (passwordUser.equals(passwordInputChange)) {
                            System.out.println("Welcome " + bankAccounts.get(idChange).getCustomerName());
                            System.out.println("\n");
                            System.out.println("......................");
                            System.out.println("Enter new password");
                            System.out.println("......................");
                            String passwordNew = scMain.nextLine();
                            System.out.println("\n");
                            bankAccounts.get(idChange).setPassword(passwordNew);
                            System.out.println("********************************************");
                            System.out.println("Password changed");
                            System.out.println("\n");
                        }
                        else{
                            System.out.println("********************************************");
                            System.out.println("Wrong ID or password");
                            System.out.println("\n");
                        }
                    }
                    else{
                        System.out.println("********************************************");
                        System.out.println("Wrong ID or password");
                        System.out.println("\n");
                    }
                    break;
                case '4':
                    System.out.println("********************************************");
                    System.out.println("Thank you for using our banking services");
                    System.out.println("\n");
                    break;
                default:
                    System.out.println("......................");
                    System.out.println("Choose a correct option to proceed");
                    System.out.println("......................");
                    System.out.println("\n");
                    break;
            }
        } while (option != '4');
    }
}
