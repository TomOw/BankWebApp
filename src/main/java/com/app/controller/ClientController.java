package com.app.controller;

import com.app.domain.Client;
import com.app.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

/**
 * Created by Tomasz on 31.03.2016.
 */
@Controller
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/all")
    public String list(Model model) throws IOException {
        model.addAttribute("clients", clientService.getAllClients());
        return "clients";
    }

    @RequestMapping(value = "/{clientName}")
    public String findClient(Model model, @PathVariable("clientName") String name) {
        model.addAttribute("clients", clientService.findClient(name));
        return "clients";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewClientForm(Model model) throws IOException {
        Client client = new Client(false);
        model.addAttribute("newClient", client);
        return "addClientForm";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewClientForm(@ModelAttribute("newClient") Client newClient) throws IOException {
        Client client = new Client(newClient.getName());
        System.out.println(client.toString());
        clientService.addClient(client);
        return "redirect:/clients/all";
    }
}
