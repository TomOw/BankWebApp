package com.app.domain.repository.impl;

import com.app.domain.Client;
import com.app.domain.repository.ClientRepository;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        while (in.hasNext()) {
            String one = in.nextLine();
            ObjectMapper mapper = new ObjectMapper();
            Client c = mapper.readValue(one, Client.class);
            this.listOfClients.add(c);
        }

    }

    public List<Client> findClient(int id) throws IllegalArgumentException{
        List<Client> foundList = new ArrayList<Client>();
        for (Client client :
                listOfClients) {
            if (client.getId() == id) {
                foundList.add(client);
                return foundList;
            }
        }
        throw new IllegalArgumentException("nie znaleziono takiego klienta");
    }
}
