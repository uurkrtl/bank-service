
## Coding: BankService Setup

Create a new Java project in IntelliJ and implement the following task to model a simple BankService and a customer account.

* Create a record 'Client' with the properties First Name, Last Name, and Customer Number (choose suitable English field names).
* Create a class 'Account' (not a record, should initially be mutable) with the properties Account Number (String), Account Balance (BigDecimal), and the associated customer.
* Please post the link to your GitHub repository here, where you share your solutions.
  `inputfield`

## Coding: Account Balance

Now we will implement convenience methods to retrieve and modify the account balance.

* Implement a method to deposit money into the account.
* Implement a method to withdraw money from the account.

## Coding: Management

Now we will implement a class that manages a list of customers and their accounts.

* Create a class 'BankService' that manages a set of accounts.
* Implement a method in BankService to open an account. It should only require a customer as an argument and should return the new account number.
* Implement a method in BankService to transfer a specific amount (as BigDecimal) from one account number (as String) to another account number (as String).

## Coding: Joint Accounts and Separations

What happens when 3 cents are divided between two people?

* Modify your records and classes so that an account can have multiple account holders (two or more account holders).
* Write a method `public List<String> split(String accountNumber)` in the service that splits an account equally. From a joint account, individual accounts should be created for each account holder. It should return the newly created account numbers. Each account should receive the same amount of money after the split (+- 1 cent). Make sure that the bank does not incur any cent gains or losses during the process.
* PS: as usual, our bank does not deal with half cents ;)
* Tip: Test Driven Development is also very useful for solving this task! (applies to the following tasks as well)