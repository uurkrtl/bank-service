package net.ugurkartal;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        //New Customer
        Client ugur = new Client("Ugur", "Kartal", "6552595");
        Client marcell = new Client("Marcell", "Dechant", "48456");
        Client reebal = new Client("Reebal", "Sami", "4564165");
        Client markus = new Client("Markus", "Hambach", "4564564564");

        BankService bankService = new BankService();


        //New accaount
        System.out.println("The new account has been created successfully. Account number: " + bankService.openAccount(ugur));
        System.out.println("The new account has been created successfully. Account number: " + bankService.openAccount(marcell));
        System.out.println("The new account has been created successfully. Account number: " + bankService.openAccount(reebal, markus));

        //Money transfer
        bankService.moneyTransfer("1", "2", new BigDecimal(100));
        bankService.moneyTransfer("1", "2", new BigDecimal(250));
        bankService.moneyTransfer("1", "3", new BigDecimal(0.3));

        //Split account
        System.out.println("The new account has been created successfully. Account number: " + bankService.split("3"));
        for (Account account : bankService.accounts){
            System.out.println(account.getAccountNumber() + " " + account.getAccountBalance());
        }
    }
}