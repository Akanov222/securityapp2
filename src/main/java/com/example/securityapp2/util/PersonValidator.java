package com.example.securityapp2.util;

import com.example.securityapp2.dao.Person;
import com.example.securityapp2.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

    private final PeopleService peopleService;

    @Autowired
    public PersonValidator(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;
        try {
        peopleService.checkupUserByUsername(person.getUsername());
        errors.rejectValue("username", "", "This user already exist");
        } catch (UsernameNotFoundException e) {

        }
    }
}
