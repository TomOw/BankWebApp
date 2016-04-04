package com.app.domain.repository;

import com.app.domain.Client;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

/**
 * Created by Tomasz on 31.03.2016.
 */
@Repository
public interface ClientRepository {

    List<Client> getListOfClients();

    void readFromFile() throws IOException;

    List<Client> findClient(String name);

    void addClient(Client client) throws IOException;

    Client getClientByName(String name) throws IllegalArgumentException;

}
