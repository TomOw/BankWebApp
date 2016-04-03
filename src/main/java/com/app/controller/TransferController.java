package com.app.controller;

import com.app.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Tomasz on 03.04.2016.
 */

@Controller
@RequestMapping(value = "/transfer")
public class TransferController {

    @Autowired
    ClientService clientService;
}
