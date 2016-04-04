package com.app.service.impl;

import com.app.domain.Client;
import com.app.domain.Transfer;
import com.app.domain.repository.ClientRepository;
import com.app.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by Tomasz on 31.03.2016.
 */
@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    ClientRepository clientRepository;

    public List<Client> getAllClients() throws IOException {
        clientRepository.readFromFile();
        return clientRepository.getListOfClients();
    }

    public List<Client> findClient(String name) {
        return clientRepository.findClient(name);

    }

    public void addClient(Client client) throws IOException {
        clientRepository.addClient(client);
    }

    public Client getClientByName(String name) throws IllegalArgumentException {
        return clientRepository.getClientByName(name);
    }

    public void makeTransfer(Transfer transfer) throws IOException{
        clientRepository.makeTransfer(transfer);
    }
}
