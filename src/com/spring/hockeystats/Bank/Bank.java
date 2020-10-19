package com.spring.hockeystats.Bank;

import com.spring.hockeystats.Accounts.Account;
import com.spring.hockeystats.Accounts.CheckingAccount;

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

    public void addAccount(int balance, String clientId) {
        int accountNumber = (++accountCount);
        CheckingAccount account = new CheckingAccount(
                balance,
                accountNumber,
                clients.get(clientId)
        );
        accounts.put(accountNumber, account);
    }

//    private Account createCheckingAccount()
}
