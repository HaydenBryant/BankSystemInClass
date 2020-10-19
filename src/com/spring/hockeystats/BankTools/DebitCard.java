package com.spring.hockeystats.BankTools;

// update debit card to connect with client so it has access to an account.

import com.spring.hockeystats.Accounts.Account;
import com.spring.hockeystats.Bank.Client;

import java.util.Calendar;

public class DebitCard {
    private String cardNum;
    private String pin;
    private Calendar expDate;
    private Account primary;
    private Client owner;
//    private List<Account> atmAccounts;


    public DebitCard(String cardNum, String pin, Account primary, Client owner) {
        this.cardNum = cardNum;
        this.pin = pin;
        this.primary = primary;
        this.owner = owner;
    }

    public Boolean charge(int amount, String pin) {
        if (this.pin == pin && primary.getBalance() >= amount) {
            primary.withdraw(amount);
            return true;
        }
        return false;
    }

    public int getPrimaryBalance(String pin) {
        if (this.pin == pin) {
            return primary.getBalance();
        }
        return 0;
    }

}
