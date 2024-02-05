package net.ugurkartal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankService {
    List<Account> accounts;

    public BankService() {
        this.accounts = new ArrayList<>();
    }

    public String openAccount(Client client){
        Account account = new Account(client.firstName() + "001", BigDecimal.ZERO, client);
        accounts.add(account);
        return account.getAccountNumber();
    }

    public void moneyTransfer (String senderAccountNumber, String recipientAccountNumber, BigDecimal amount){
        Account senderAccount = findAccount(senderAccountNumber);
        Account recipientAccount = findAccount(recipientAccountNumber);

        if (senderAccount == null){
            System.out.println("Sender account number is incorrect");
        } else if (recipientAccount == null) {
            System.out.println("Recipient account number is incorrect");
        }else {
            senderAccount.withdrawMoney(amount);
            recipientAccount.depositMoney(amount);
            System.out.println("Money transfer was completed successfully");
            System.out.println("Current sender balance: " + senderAccount.getAccountBalance());
            System.out.println("Current recipient balance: " + recipientAccount.getAccountBalance());
        }
    }

    public Account findAccount (String accountNumber){
        for (Account account : accounts){
            if (account.getAccountNumber().equals(accountNumber) ){
                return account;
            }
        }
        return null;
    }

}
