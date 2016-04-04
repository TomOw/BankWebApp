package com.app.controller;

import com.app.domain.Transfer;
import com.app.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Tomasz on 03.04.2016.
 */

@Controller
@RequestMapping(value = "/transfer")
public class TransferController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/make", method = RequestMethod.GET)
    public String getTransferForm(Model model) {
        Transfer transfer = new Transfer();
        return "home";
    }
}
