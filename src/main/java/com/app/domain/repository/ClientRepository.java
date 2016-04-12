package com.app.domain.repository;

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
public interface ClientRepository {

    List<Client> getListOfClients();

    void readFromFile() throws IOException;

    List<Client> findClient(String name);

    void addClient(Client client) throws IOException;

    Client getClientByName(String name) throws IllegalArgumentException;

    Client getClientByUsername(String login) throws IOException;

    void makeTransfer(Transfer transfer) throws IOException;

    void addAccount(String name, Account account);

    void saveToFile() throws IOException;
}
