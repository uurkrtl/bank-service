package net.ugurkartal;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Account {
    private String accountNumber;
    private BigDecimal accountBalance;
    private List<Client> client;


    public Account(String accountNumber, BigDecimal accountBalance, Client... clients) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.client = List.of(clients);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountNumber, account.accountNumber) && Objects.equals(accountBalance, account.accountBalance) && Objects.equals(client, account.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, accountBalance, client);
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setClient(Client... client) {
        this.client = List.of(client);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public List<Client> getClient() {
        return client;
    }

    public void depositMoney(BigDecimal amount){
        this.setAccountBalance(this.getAccountBalance().add(amount.setScale(2, BigDecimal.ROUND_HALF_EVEN)));
    }

    public void withdrawMoney(BigDecimal amount){ //Minus
        this.setAccountBalance(this.getAccountBalance().subtract(amount.setScale(2, BigDecimal.ROUND_HALF_EVEN)));
    }
}
