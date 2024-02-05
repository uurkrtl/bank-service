package net.ugurkartal;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        //New Customer
        Client ugur = new Client("Ugur", "Kartal", "6552595");
        Client marcell = new Client("Marcell", "Dechant", "48456");
        Client reebal = new Client("Reebal", "Sami", "4564165");

        BankService bankService = new BankService();

        //New accaount
        System.out.println("The new account has been created successfully. Account number: " + bankService.openAccount(ugur));
        System.out.println("The new account has been created successfully. Account number: " + bankService.openAccount(marcell));
        System.out.println("The new account has been created successfully. Account number: " + bankService.openAccount(reebal));

        //Money transfer
        bankService.moneyTransfer("Ugur001", "Marcell001", new BigDecimal(100));
        bankService.moneyTransfer("Reebal001", "Marcell001", new BigDecimal(250));
    }
}