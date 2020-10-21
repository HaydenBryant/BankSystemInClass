package com.spring.hockeystats.Bank;

import com.spring.hockeystats.Accounts.*;

import java.util.HashMap;
import java.util.Scanner;

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

    public void addAccount(int balance, String clientId, String accountType) {
        Client client = clients.get(clientId);
        if (client == null) {
            System.out.println("ERROR: Invalid ClientID");
            return;
        }
        int accountNumber = (++accountCount);
        Account newAccount = createAccount(balance, client, accountType, accountNumber);
        accounts.put(accountNumber, newAccount);
        client.addAccount(newAccount);
    }

    public Account createAccount(int balance, Client client, String type, int accountNumber) {
        Scanner scan = new Scanner(System.in);

        switch (type){
            case "checking":
                return new CheckingAccount(balance, accountNumber, client);

            case "cd":
                System.out.println("What is the timeframe?: ");
                int timeFrame = scan.nextInt();
                System.out.println("What is the time period?: ");
                String timePeriod = scan.nextLine();
                return new CDInvestment(balance, accountNumber, client, timeFrame, timePeriod);

            case "investment":
                System.out.println("What is the interest rate?: ");
                int investInterestRate = scan.nextInt();
                return new InvestmentAccount(balance, accountNumber, client, investInterestRate);

            case "savings":
                System.out.println("What is the interest rate?: ");
                int savingsInterestRate = scan.nextInt();
               return new SavingsAccount(balance, accountNumber, client, savingsInterestRate);

            default:
                System.out.println("Wrong");
                return null;
        }
    }

}
