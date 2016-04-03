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

    @RequestMapping(value = "/{clientID}")
    public String findClient(Model model, @PathVariable("clientID") int clientID) {
        model.addAttribute("clients", clientService.findClient(clientID));
        return "clients";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewClientForm(Model model) throws IOException {
        Client newClient = new Client(true);
        model.addAttribute("clientId", newClient.getId());
        model.addAttribute("newClient", newClient);
        return "addClientForm";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewClientForm(@ModelAttribute("newClient") Client newClient,
                                          @ModelAttribute("clientId") int id) throws IOException {
        newClient.setId(id);
        System.out.println(newClient.toString());
        return "redirect:/clients/all";
    }
}
