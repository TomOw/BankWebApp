package com.app.controller;

import com.app.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

/**
 * Created by Tomasz on 31.03.2016.
 */
@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping("/all")
    public String list(Model model) throws IOException {
        model.addAttribute("clients", clientService.getAllClients());
        return "clients";
    }

    @RequestMapping("/{clientID}")
    public String findClient(Model model, @PathVariable("clientID") int clientID) {
        model.addAttribute("clients", clientService.findClient(clientID));
        return "clients";
    }
}
