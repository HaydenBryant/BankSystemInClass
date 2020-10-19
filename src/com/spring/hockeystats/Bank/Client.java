package com.spring.hockeystats.Bank;

import com.spring.hockeystats.Accounts.Account;
import com.spring.hockeystats.BankTools.DebitCard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Client {
    private String name;
    private String firstName;
    private String lastName;
    private String clientId;
    private HashMap<Integer, Account> accounts;
    private List<DebitCard> cards;
//    protected List<CheckingAccount> checkingAccounts;
//    protected List<SavingsAccount> savingsAccounts;
//    protected List<CDInvestment> cdAccounts;

    public Client(String firstName, String lastName, String clientId) {
        this.name = firstName + " " + lastName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.clientId = clientId;
        accounts = new HashMap<Integer, Account>();
        cards = new ArrayList<DebitCard>();
//        this.checkingAccounts = new ArrayList<CheckingAccount>();
//        this.savingsAccounts = new ArrayList<SavingsAccount>();
//        this.cdAccounts = new ArrayList<CDInvestment>();
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccountNum(), account);
    }

    public void addCard(int accountNum) {
        cards.add(new DebitCard("12341234", "1234", accounts.get(accountNum), this));
    }

//    public void addAccount(CheckingAccount account) {
//        checkingAccounts.add(account);
//    }
//
//    public void addAccount(SavingsAccount account) {
//        savingsAccounts.add(account);
//    }
//
//    public void addAccount(CDInvestment account) {
//        cdAccounts.add(account);
//    }

    public String getName() {
        return name;
    }

    public String getAccounts() {
        String output = "";
        for (var accountNum : accounts.keySet() ) {
            output += accounts.get(accountNum).accountDetails() + "cards: " + cards.size() +  "\n";
        }
        return output;
    }
}
