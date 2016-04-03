package com.app.domain.repository.impl;

import com.app.domain.Client;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by Tomasz on 04.04.2016.
 */
public class repoTestWUid {

    public static void main(String[] args) throws IOException{
        JsonClientRepository jsonClientRepository = new JsonClientRepository();
        ObjectMapper mapper = new ObjectMapper();
        Client client1 = new Client(true);
        System.out.println(client1);
        jsonClientRepository.addClient(client1);
        System.out.println(mapper.writeValueAsString(client1));
        jsonClientRepository.readFromFile();
    }
}
