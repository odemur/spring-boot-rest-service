package br.com.odemur.springboot.rest.example.person;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * PersonController Class
 * 
 * @author Odemur Marangoni
 * @version 1.0
 */
@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/person")
    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable long id) {
        Optional<Person> person = personRepository.findById(id);

        if (person.isEmpty())
            throw new PersonNotFoundException("id-" + id);

        return person.get();
    }

    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable long id) {
        personRepository.deleteById(id);
    }

    @PostMapping("/person")
    public Person createPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @PutMapping("/person/{id}")
    public ResponseEntity<Object> updatePerson(@RequestBody Person person, @PathVariable long id) {

        Optional<Person> personOptional = personRepository.findById(id);

        if (personOptional.isEmpty())
            return ResponseEntity.notFound().build();

        person.setId(id);

        personRepository.save(person);

        return ResponseEntity.noContent().build();
    }

}
