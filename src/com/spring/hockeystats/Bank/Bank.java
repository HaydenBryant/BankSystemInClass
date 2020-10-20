package com.spring.hockeystats.Bank;

import com.spring.hockeystats.Accounts.*;

import java.util.HashMap;

public class Bank {
    private HashMap<String, Client> clients;
    private HashMap<Integer, Account> accounts;
    private Integer clientCount = 0;
    private Integer accountCount = 0;
    private String name;
    // private HashMap<String, Employee> employees;
    private String authCode;
    // private HashMap<Integer, String> authCodes;

    public void addClient(String fname, String lname) {
        String clientId = (++clientCount).toString();
        clients.put(clientId, new Client(fname, lname, clientId));
    }

    public void addAccount(int balance, String clientId, String type) {
        int accountNumber = (++accountCount);
        Account account;
        switch (type){
            case "checking":
                account = createCheckingAccount(balance, accountNumber, clientId);
                break;
            case "bank":
                account = createBankAccount(balance, accountNumber, clientId);
                break;
            case "cd":
                account = createCDAccount(balance, accountNumber, clientId);
                break;
            case "investment":
                account = createInvestmentAccount(balance, accountNumber, clientId);
                break;
            case "savings":
                account = createSavingsAccount(balance, accountNumber, clientId);
                break;
        }
        accounts.put(accountNumber, account);
    }

    private Account createCheckingAccount(int balance, int accountNumber, String clientId){
        CheckingAccount account = new CheckingAccount(
                balance,
                accountNumber,
                clients.get(clientId)
        );
        return account;
    }
    private Account createBankAccount(int balance, int accountNumber, String clientId){
        Account account = new BankAccount(
                balance,
                accountNumber,
                clients.get(clientId)
        );
        return account;
    }
    private Account createCDAccount(int balance, int accountNumber, String clientId){
        Account account = new CDInvestment(
                balance,
                accountNumber,
                clients.get(clientId)
        );
        return account;
    }
    private Account createInvestmentAccount(int balance, int accountNumber, String clientId){
        Account account = new InvestmentAccount(
                balance,
                accountNumber,
                clients.get(clientId)
        );
        return account;
    }
    private Account createSavingsAccount(int balance, int accountNumber, String clientId){
        Account account = new SavingsAccount(
                balance,
                accountNumber,
                clients.get(clientId)
        );
        return account;
    }
}
