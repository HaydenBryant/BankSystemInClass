package com.spring.hockeystats.Accounts;

import com.spring.hockeystats.Bank.Client;

public class CheckingAccount extends BankAccount implements Account {
    public CheckingAccount(int balance, int accountNumber, Client owner){
        super(balance, accountNumber, owner, "Checking");
    }
}
