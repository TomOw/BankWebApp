package com.app.service.impl;

import com.app.domain.Account;
import com.app.domain.Client;
import com.app.domain.Transfer;
import com.app.domain.repository.ClientRepository;
import com.app.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomasz on 31.03.2016.
 */
@Service
public class ClientServiceImpl implements ClientService, UserDetailsService {

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

    public void makeTransfer(Transfer transfer) throws IOException {
        clientRepository.makeTransfer(transfer);
    }

    public void addAccount(String name, Account account) {
        clientRepository.addAccount(name, account);
    }

    public void saveToFile() throws IOException {
        clientRepository.saveToFile();
    }

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Client client = null;
        try {
            client = clientRepository.getClientByUsername(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (client != null) {
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            return new User(client.getUsername(), client.getPassword(), true, true, true, true, authorities);
        }
        throw new UsernameNotFoundException("User with this username: " + s + "not found");
    }
}
