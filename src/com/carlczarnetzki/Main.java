package com.carlczarnetzki;

import com.carlczarnetzki.bank.BankApplication;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<BankApplication> banks = new LinkedList<BankApplication>();
        BankApplication commerzbank = new BankApplication();
        banks.addLast(commerzbank);
        banks.getLast().menu();
    }
}
