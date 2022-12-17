package br.com.odemur.springboot.rest.example;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.odemur.springboot.rest.example.person.Person;
import br.com.odemur.springboot.rest.example.person.PersonRepository;

@WebMvcTest
public class SpringBootRestServiceApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonRepository personRepository;

    private static ObjectMapper mapper = new ObjectMapper();

    /*
     * Test method to list Person
     */
    @Test
    public void listPersonTest() throws Exception {
        List<Person> persons = new ArrayList<>();
        Person person = new Person();
        person.setId(1L);
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setEmail("john@mail.com");
        persons.add(person);

        Mockito.when(personRepository.findAll()).thenReturn(persons);
        mockMvc.perform(get("/person")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].id", Matchers.equalTo(1)))
                .andExpect(jsonPath("$[0].firstName", Matchers.equalTo(person.getFirstName())))
                .andExpect(jsonPath("$[0].lastName", Matchers.equalTo(person.getLastName())))
                .andExpect(jsonPath("$[0].email", Matchers.equalTo(person.getEmail())));
    }

    /*
     * Test method to save Person
     */
    @Test
    public void savePersonTest() throws Exception {
        Person person = new Person();
        person.setId(1L);
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setEmail("john@mail.com");

        Mockito.when(personRepository.save(ArgumentMatchers.any())).thenReturn(person);
        String json = mapper.writeValueAsString(person);
        mockMvc.perform(post("/person").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.equalTo(1)))
                .andExpect(jsonPath("$.firstName", Matchers.equalTo(person.getFirstName())))
                .andExpect(jsonPath("$.lastName", Matchers.equalTo(person.getLastName())))
                .andExpect(jsonPath("$.email", Matchers.equalTo(person.getEmail())));
    }

}
