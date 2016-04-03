package com.app.domain;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Tomasz on 30.03.2016.
 */
public class Account {

    private long number;
    private int balance;
    private String currency;

    static AtomicLong accNumber = new AtomicLong(100000);

    public Account(long number, int balance, String currency) {
        this.number = number;
        this.balance = balance;
        this.currency = currency;
    }

    public Account(String currency, int balance) {
        this.currency = currency;
        this.number = accNumber.incrementAndGet();
        this.balance = balance;
    }

    public Account() {

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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
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
                '}';
    }

    public void addMoney(int money) {
        this.balance += money;
    }

    public void substractMoney(int money) {
        this.balance -= money;
    }
}
