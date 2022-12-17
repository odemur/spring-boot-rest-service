package br.com.odemur.springboot.rest.example.person;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PersonRepository Interface
 * 
 * @author Odemur Marangoni
 * @version 1.0
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

}
