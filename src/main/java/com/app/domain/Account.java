package com.app.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Tomasz on 30.03.2016.
 */
public class Account {

    private long number;
    private double balance;
    private String currency;
    private List<Transfer> transferHistory;

    public static AtomicLong accNumber = new AtomicLong(100000);

    public Account(long number, double balance, String currency) {
        this.number = number;
        this.balance = balance;
        this.currency = currency;
        transferHistory = new ArrayList<Transfer>();
    }

    public Account(String currency, double balance) {
        this.currency = currency;
        this.number = accNumber.incrementAndGet();
        this.balance = balance;
        transferHistory = new ArrayList<Transfer>();
    }

    public Account() {
        transferHistory = new ArrayList<Transfer>();
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addTransferToHistory(Transfer transfer) {
        this.transferHistory.add(transfer);
    }

    public List<Transfer> getTransferHistory() {
        return transferHistory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        return getNumber() == account.getNumber();

    }

    @Override
    public String toString() {
        return "Account{" +
                "number=" + number +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                ", transferHistory=" + transferHistory +
                '}';
    }

    public void addMoney(double money) {
        this.balance += money;
    }

    public void substractMoney(double money) {
        this.balance -= money;
    }
}
