package com.app.domain.repository.impl;

import com.app.domain.Client;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * Created by Tomasz on 31.03.2016.
 */
public class mainTest {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        JsonClientRepository jsonClientRepository = new JsonClientRepository();
        jsonClientRepository.readFromFile();
        List<Client> list = jsonClientRepository.getListOfClients();
        System.out.println(list.toString());
        System.out.println(list.get(1).getAccount().getCurrency());
        System.out.println(jsonClientRepository.getListOfClients().toString());
        System.out.println("szukany klient:");
        System.out.println(new Client());
        System.out.println(new Client());
        System.out.println(new Client());
        System.out.println(new Client("JAMSON"));
        String s = "{\"name\":\"OLOYOLO\",\"account\":{\"balance\":1,\"currency\":\"PLN\"}}";
        String s2 = "{\"name\":\"ol\",\"id\":1,\"account\":{\"number\":1,\"balance\":1,\"currency\":\"PLN\"}}";
        ObjectMapper mapper = new ObjectMapper();
        Client x = mapper.readValue(s, Client.class);
        Client y = mapper.readValue(s2, Client.class);
        System.out.println(x);
        System.out.println(y);

    }
}
