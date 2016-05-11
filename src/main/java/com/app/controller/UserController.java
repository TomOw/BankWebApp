package com.app.controller;

import com.app.domain.Account;
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
import java.security.Principal;

/**
 * Created by Tomasz on 04.04.2016.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/{userName}")
    public String getUserProfile(Model model, @PathVariable("userName") String name) throws IOException {
        clientService.getAllClients();
        model.addAttribute("user", clientService.getClientByName(name));
        return "user";
    }

    @RequestMapping(value = "/{userName}/addAccount", method = RequestMethod.GET)
    public String getNewAccountForm(Model model, @PathVariable("userName") String name) throws IOException {
        clientService.getAllClients();
        Account newAccount = new Account();
        newAccount.setNumber(Account.accNumber.get() + 1);
        model.addAttribute("newAccount", newAccount);
        System.out.println("test debugowaniea");
        System.out.println(newAccount);
        return "addAccountForm";
    }

    @RequestMapping(value = "/{userName}/addAccount", method = RequestMethod.POST)
    public String processNewAccount(@ModelAttribute ("newAccount") Account newAccount, @PathVariable("userName") String name, Principal principal) throws IOException{
        String userNameFromUrl = name;
        if (name.equals("me")) {
            name = principal.getName();
        }
        System.out.println("_______________________________________________________________________________________________________________");
        clientService.getAllClients();
        System.out.println("imie klienta: " + name);
        Account.accNumber.incrementAndGet();
        Account accountToAdd = new Account(newAccount.getCurrency(), 0.0);
        System.out.println("konto tworzone w metodzie " + accountToAdd);
        System.out.println("konto z modelu " + newAccount);
        Client client = clientService.getClientByName(name);
        System.out.println(client);
        System.out.println("konto ktore chce dodac: " + accountToAdd);
        System.out.println(Account.accNumber.incrementAndGet());
        clientService.addAccount(name, accountToAdd);
        clientService.saveToFile();
        System.out.println("____________________________________________________________________________________________________________________");
        return "redirect:/user/" + userNameFromUrl;
    }

    @RequestMapping(value = "/me")
    public String myProfile(Model model, Principal principal) throws IOException {
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //String name = authentication.getName();
        String name = principal.getName();
        clientService.getAllClients();
        System.out.println("_____________________________---------------------_________________________");
        System.out.println("Clients name from authentication: " + name);
        Client client = clientService.getClientByName(name);
        System.out.println(client);
        model.addAttribute("user", client);
        return "user";
    }

}
