package net.ugurkartal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankService {
    List<Account> accounts;

    public BankService() {
        this.accounts = new ArrayList<>();
    }

    public String openAccount(Client... client){
        String  accountNumber = String.valueOf(accounts.size() + 1).formatted("%03d");
        Account account = new Account(accountNumber, BigDecimal.ZERO, client);
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

    //Write a method `public List<String> split(String accountNumber)` in the service that splits an account equally.
    // From a joint account, individual accounts should be created for each account holder.
    // It should return the newly created account numbers.
    // Each account should receive the same amount of money after the split (+- 1 cent).
    // Make sure that the bank does not incur any cent gains or losses during the process.

    public List<String> split(String accountNumber){
        Account jointAccount = findAccount(accountNumber);
        List<Client> clients = jointAccount.getClient();
        BigDecimal amount = jointAccount.getAccountBalance().divide(new BigDecimal(clients.size()), 2, BigDecimal.ROUND_HALF_EVEN);
        List<String> newAccountNumbers = new ArrayList<>();
        for (Client client : clients){
            newAccountNumbers.add(openAccount(client));
            this.moneyTransfer(jointAccount.getAccountNumber(), newAccountNumbers.get(newAccountNumbers.size()-1), amount);
        }
        return newAccountNumbers;
    }
}