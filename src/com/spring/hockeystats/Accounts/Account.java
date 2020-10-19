package com.spring.hockeystats.Accounts;

public interface Account {
    public void deposit(int amt);
    public void withdraw(int amt);
    public String getOwner();
    public int getBalance();
    public String accountDetails();
    public int getAccountNum();
}