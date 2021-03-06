package com.app.domain.repository.impl;

import com.app.domain.Account;
import com.app.domain.Client;
import com.app.domain.Transfer;
import com.app.domain.repository.ClientRepository;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Tomasz on 31.03.2016.
 */
@Repository
public class JsonClientRepository implements ClientRepository{

    private List<Client> listOfClients = new ArrayList<Client>();

    public JsonClientRepository() throws IOException {
    }

    public void addClient(Client client) throws IOException {
        this.listOfClients.add(client);
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("/Users/Tomasz/Documents/Java/AppInSpring/dataFiles/data.json");
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str = mapper.writeValueAsString(client);
        str += "\n";
        bufferedWriter.write(str);
        bufferedWriter.close();
    }

    public List<Client> getListOfClients() {
        return listOfClients;
    }

    public void readFromFile() throws IOException {
        File file = new File("/Users/Tomasz/Documents/Java/AppInSpring/dataFiles/data.json");
        Scanner in = new Scanner(file);
        listOfClients.clear();
        int numberOfClients = 0;
        while (in.hasNext()) {
            String one = in.nextLine();
            ObjectMapper mapper = new ObjectMapper();
            Client c = mapper.readValue(one, Client.class);
            this.listOfClients.add(c);
            numberOfClients++;
        }
        Account.accNumber = new AtomicLong(10000 + numberOfClients - 1);

    }

    public List<Client> findClient(String name) throws IllegalArgumentException{
        List<Client> foundList = new ArrayList<Client>();
        for (Client client :
                listOfClients) {
            if (client.getName().equals(name)) {
                foundList.add(client);
                return foundList;
            }
        }
        throw new IllegalArgumentException("nie znaleziono takiego klienta");
    }

    public Client getClientByName(String name) throws IllegalArgumentException{
        for (Client client:
             listOfClients) {
            if (client.getName().equals(name)) {
                return client;
            }
        }
        throw new IllegalArgumentException("nie znaleziono takiego klienta " + name);
    }

    public Client getClientByUsername(String username) throws IOException{
        for (Client client :
                listOfClients) {
            if (client.getUsername().equals(username)) {
                return client;
            }
        }
        throw new IllegalArgumentException("client with this username doesnt exist " + username);
    }

    public Account findAccount(int number) throws IllegalArgumentException{
        for (Client client:
             listOfClients) {
            if (client.getAccount().getNumber() == number) {
                return client.getAccount();
            }
        }
        throw new IllegalArgumentException("nie znaleziono takiego konta");
    }

    public void saveToFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("/Users/Tomasz/Documents/Java/AppInSpring/dataFiles/data.json");
        FileWriter fileWriter = new FileWriter(file, false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (Client client :
                listOfClients) {
            String str = mapper.writeValueAsString(client);
            str += "\n";
            bufferedWriter.write(str);
        }
        bufferedWriter.close();
    }

    public void makeTransfer(Transfer transfer) throws IOException {
        int from = transfer.getAccountFrom();
        int to = transfer.getAccountTo();
        double value = transfer.getValue();
        Account accFrom = findAccount(from);
        Account accTo = findAccount(to);
        accFrom.substractMoney(value);
        accTo.addMoney(value);
        accTo.addTransferToHistory(transfer);
        transfer.setValue(-value);
        accFrom.addTransferToHistory(transfer);
        transfer.setDate(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()));
        saveToFile();

    }

    public void addAccount(String userName, Account account) {
        getClientByName(userName).setAccount(account);
    }
}
