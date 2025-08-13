package com.example.securityapp2.controllers;

import com.example.securityapp2.dao.Person;
import com.example.securityapp2.repositories.PeopleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class TestController {

    private final PeopleRepository peopleRepository;

    public TestController(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @GetMapping("/users")
    public List<Person> getAllUsers() {
        return peopleRepository.findAll();
    }

    @GetMapping("/users/{username}")
    public Person getUserByUsername(@PathVariable String username) {
        return peopleRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
