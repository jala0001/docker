package com.example.dockerpractise.services;

import com.example.dockerpractise.models.Person;
import com.example.dockerpractise.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.getAllPersons();
    }

    public void createPerson(String name, int age) {
        personRepository.createPerson(name, age);
    }
}
