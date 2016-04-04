package com.app.domain.repository.impl;

import com.app.domain.Client;
import com.app.domain.Transfer;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by Tomasz on 04.04.2016.
 */
public class TransferTest {

    public static void main(String[] args) throws IOException {
        JsonClientRepository repository = new JsonClientRepository();
        ObjectMapper mapper = new ObjectMapper();
        Transfer transfer = new Transfer(100001, 100002, 100.99, "Bond", "James", "testowy");
        transfer.toString();
        repository.readFromFile();
        repository.makeTransfer(transfer);
        for (Client client :
                repository.getListOfClients()) {
            System.out.println(client.toString());
        }
        repository.saveToFile();
        Client test = repository.getClientByName("Bonf");
        String s = mapper.writeValueAsString(test);
        System.out.println("_____________________");
        System.out.println(test.getAccount().getTransferHistory().toString());
        System.out.println(test.getAccount().getTransferHistory().getClass());
        System.out.println(s);
        Client watchOut = mapper.readValue(s, Client.class);
        System.out.println(watchOut);

    }
}
