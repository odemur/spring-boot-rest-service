package br.com.odemur.springboot.rest.example.person;

/**
 * PersonNotFoundException Class
 * 
 * @author Odemur Marangoni
 * @version 1.0
 */
public class PersonNotFoundException extends RuntimeException {

    public PersonNotFoundException(String exception) {
        super(exception);
    }

}
