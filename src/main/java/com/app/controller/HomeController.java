package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Tomasz on 28.03.2016.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }
}
