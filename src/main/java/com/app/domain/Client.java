package com.app.domain;

import java.util.UUID;

/**
 * Created by Tomasz on 30.03.2016.
 */
public class Client {

    private String id;
    private String name;
    private Account account;


    public Client() {
    }

    public Client(boolean useUUID){
        if (useUUID) {
            this.id = UUID.randomUUID().toString();
        }else {

        }
    }

    public Client(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.account = new Account();
    }

    public Client(String name, Account account) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.account = account;
    }

    public Client(Account account) {
        this.account = account;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
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
