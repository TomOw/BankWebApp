package com.app.controller;

import com.app.domain.Transfer;
import com.app.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
        model.addAttribute("transfer", transfer);
        return "transferForm";
    }

    @RequestMapping(value = "/make", method = RequestMethod.POST)
    public String processTransfer(@ModelAttribute("transfer") Transfer newTransfer) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        newTransfer.setDate(timeStamp);
        System.out.println(newTransfer.toString());
        clientService.makeTransfer(newTransfer);
        return "redirect:/clients/all";
    }
}
