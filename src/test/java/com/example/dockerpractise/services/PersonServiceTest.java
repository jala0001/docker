package com.example.dockerpractise.services;

import com.example.dockerpractise.models.Person;
import com.example.dockerpractise.repositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PersonServiceTest {

    @Test
    void testGetAllPersons() {
        // Arrange
        PersonRepository personRepository = mock(PersonRepository.class);
        PersonService personService = new PersonService();
        personService.personRepository = personRepository;

        List<Person> mockPersons = Arrays.asList(
                new Person() {{
                    setPersonId(1);
                    setName("Jamie");
                    setAge(23);
                }},
                new Person() {{
                    setPersonId(2);
                    setName("Viktor");
                    setAge(30);
                }}
        );

        when(personRepository.getAllPersons()).thenReturn(mockPersons);

        // Act
        List<Person> result = personService.getAllPersons();

        // Assert
        assertEquals(2, result.size());
        assertEquals("Jamie", result.get(0).getName());
        verify(personRepository, times(1)).getAllPersons();
    }

    @Test
    void testCreatePersonWithoutAgeIncrement() {
        // Arrange
        PersonRepository personRepository = mock(PersonRepository.class);
        PersonService personService = new PersonService();
        personService.personRepository = personRepository;

        // Act
        personService.createPerson("Jamie", 23);

        // Assert
        verify(personRepository, times(1)).createPerson("Jamie", 23); // Expect no age increment
    }

}
