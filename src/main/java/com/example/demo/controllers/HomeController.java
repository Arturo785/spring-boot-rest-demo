package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String sayHello(Model model){
        model.addAttribute("theDate", new java.util.Date());

        return "helloworld"; // the Thymeleaf template
    }

}
