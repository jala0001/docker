package com.example.dockerpractise.controllers;

import com.example.dockerpractise.models.Person;
import com.example.dockerpractise.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonController {

    @Autowired
    PersonService personService;


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("persons", personService.getAllPersons());
        return "index";
    }

    @PostMapping("/createPerson")
    public String createPerson(@RequestParam String name, @RequestParam int age) {
        personService.createPerson(name, age);
        return "redirect:/";
    }
}
