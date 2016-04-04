package com.app.domain;

/**
 * Created by Tomasz on 04.04.2016.
 */
public class Transfer {

    private int accountFrom;
    private int accountTo;
    private double value;
    private String sender;
    private String receiver;
    private String title;

    public Transfer(int accountFrom, int accountTo, double value, String sender, String receiver, String title) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.value = value;
        this.sender = sender;
        this.receiver = receiver;
        this.title = title;
    }

    public Transfer() {
    }

    public Transfer(String sender, int accountFrom) {
        this.sender = sender;
        this.accountFrom = accountFrom;
    }

    public int getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(int accountFrom) {
        this.accountFrom = accountFrom;
    }

    public int getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(int accountTo) {
        this.accountTo = accountTo;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "accountFrom=" + accountFrom +
                ", accountTo=" + accountTo +
                ", value=" + value +
                ", sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
