package com.gamtcode.ecommercespringbootjpa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RedirectController {

    @GetMapping("/")
    public RedirectView redirectToS3() {
        return new RedirectView("https://ecommerce.guilhermeteixeira.dev/");
    }
}
