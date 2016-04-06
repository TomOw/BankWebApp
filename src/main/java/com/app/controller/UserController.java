package com.app.controller;

import com.app.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

/**
 * Created by Tomasz on 04.04.2016.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ClientService clientService;

    @RequestMapping("/{userName}")
    public String getUserProfile(Model model, @PathVariable("userName") String name) throws IOException {
        clientService.getAllClients();
        model.addAttribute("user", clientService.getClientByName(name));
        return "user";
    }

}
