package com.example.hibernatepostgress.controller;

import com.example.hibernatepostgress.dao.PersonDao;
import com.example.hibernatepostgress.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orm")
public class PersonController {

    @Autowired
    private PersonDao dao;

    @PostMapping("/savePerson")
    public String save(@RequestBody Person person) {
        dao.savePerson(person);
        return "success";
    }
}
