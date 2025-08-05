package com.example.daohibernate.controller;

import com.example.daohibernate.entity.Person;
import com.example.daohibernate.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    
    private final PersonRepository personRepository;
    
    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    
    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return personRepository.getPersonsByCity(city);
    }
    
    @GetMapping
    public List<Person> getAllPersons() {
        return personRepository.getAllPersons();
    }
    
    @GetMapping("/by-age")
    public List<Person> getPersonsByAgeGreaterThan(@RequestParam(defaultValue = "27") int age) {
        return personRepository.getPersonsByAgeGreaterThan(age);
    }
} 