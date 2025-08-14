package com.example.securityapp2.cli;

import com.example.securityapp2.dao.Person;
import com.example.securityapp2.repositories.PeopleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final PeopleRepository peopleRepository;

    public DataInitializer(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//         Очищаем и добавляем тестовых пользователей
        peopleRepository.deleteAll();

        Person user1 = new Person();
        user1.setUsername("text_user1");
        user1.setPassword("111");
        peopleRepository.save(user1);

        Person user2 = new Person();
        user2.setUsername("text_user2");
        user2.setPassword("111");
        peopleRepository.save(user2);

        System.out.println("Добавлено тестовых пользователей: " + peopleRepository.count());
    }
}


