package com.app.domain;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Tomasz on 30.03.2016.
 */
public class Client {

    private int id;
    private String name;
    private Account account;

    private static AtomicInteger nextID = new AtomicInteger(1000);

    public Client(int id, Account account, String name) {
        this.id = id;
        this.account = account;
        this.name = name;
    }

    public Client() {
    }

    public Client(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Client(String name) {
        this.id = nextID.incrementAndGet();
        this.name = name;
        this.account = new Account();
    }

    public Client(String name, Account account) {
        this.id = nextID.incrementAndGet();
        this.name = name;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        return getId() == client.getId();

    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account=" + account +
                '}' + "\n";
    }

    public void addMoney(int money) {
        this.getAccount().addMoney(money);
    }

    public void substractMoney(int money) {
        this.getAccount().substractMoney(money);
    }



}
