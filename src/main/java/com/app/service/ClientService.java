package com.app.service;

import com.app.domain.Account;
import com.app.domain.Client;
import com.app.domain.Transfer;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

/**
 * Created by Tomasz on 31.03.2016.
 */
@Repository
public interface ClientService {

    List<Client> getAllClients() throws IOException;

    List<Client> findClient(String name);

    void addClient(Client client) throws IOException;

    Client getClientByName(String name) throws IllegalArgumentException;

    void makeTransfer(Transfer transfer) throws IOException;

    void addAccount(String name, Account account);

    void saveToFile() throws IOException;
}
