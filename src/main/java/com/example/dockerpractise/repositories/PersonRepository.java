package com.example.dockerpractise.repositories;

import com.example.dockerpractise.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> getAllPersons() {
        String query = "select * from person";
        RowMapper rowMapper = new BeanPropertyRowMapper(Person.class);
        return jdbcTemplate.query(query, rowMapper);
    }

    public void createPerson(String name, int age) {
        String query = "insert into person (name, age) values (?, ?)";
        jdbcTemplate.update(query, name, age);
    }
}
