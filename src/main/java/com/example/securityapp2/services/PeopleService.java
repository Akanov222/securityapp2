package com.example.securityapp2.services;

import com.example.securityapp2.dao.Person;
import com.example.securityapp2.repositories.PeopleRepository;
import com.example.securityapp2.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PeopleService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public Optional<PersonDetails> checkupUserByUsername(String username) throws UsernameNotFoundException{
        Optional<Person> person = peopleRepository.findByUsername(username);

        if (person.isEmpty()) {
            throw new UsernameNotFoundException("User not found!");
        }
        return Optional.of(new PersonDetails(person.get()));
    }
}
