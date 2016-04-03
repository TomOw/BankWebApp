package com.app.service;

import com.app.domain.Client;

import java.io.IOException;
import java.util.List;

/**
 * Created by Tomasz on 31.03.2016.
 */
public interface ClientService {

    List<Client> getAllClients() throws IOException;

    List<Client> findClient(int id);
}
