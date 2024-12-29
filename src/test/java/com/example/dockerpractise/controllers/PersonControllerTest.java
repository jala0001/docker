package com.example.dockerpractise.controllers;

import com.example.dockerpractise.models.Person;
import com.example.dockerpractise.services.PersonService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PersonControllerTest {

    @Test
    void testIndex() {
        // Arrange
        PersonService personService = mock(PersonService.class);
        PersonController controller = new PersonController();
        controller.personService = personService;

        Model model = mock(Model.class);

        when(personService.getAllPersons()).thenReturn(Arrays.asList(
                new Person() {{
                    setPersonId(1);
                    setName("Jamie");
                    setAge(23);
                }}
        ));

        // Act
        String viewName = controller.index(model);

        // Assert
        assertEquals("index", viewName);
        verify(model, times(1)).addAttribute(eq("persons"), anyList());
    }
}
