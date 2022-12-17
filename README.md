# Spring Boot REST Service
A REST service built on Java, Spring Boot and H2 database.

## Endpoint on Heroku
https://odemur-spring-boot-rest.herokuapp.com/person


## Technologies
  * Language: **Java**
  * Framework: **Spring Boot**
  * Build Automation Tool: **Apache Maven**
  * Database: **H2**
  * Service API: **REST**

## Getting Started
Clone this project and running on you local machine. <br />
Only for development and testing purposes.

## Prerequisites
   * Java SDK 17
   * Java IDE

## Running Application
Please follow carefully step by step instructions below:

### Open Terminal and clone this project
 ```
 git clone https://github.com/odemur/spring-boot-rest-service.git
 ```

#### Running this application with IDE:
   - Open this project folder with any Java IDE (IntelliJ IDEA, Eclipse, etc..)
   - Run the application using the IDE > Run Option
   
 ## API Documentation 
 **URL**<br />
 http://localhost:8080 
 
 To test API Endpoint is necessary an HTTP Client Tool. <br />
 I recommed the app **Postman** [https://www.postman.com/downloads]
 
### Create Person

Create a new Person from JSON structure.

* **Endpoint**

  /person

* **Method**

  `POST`

* **Body Data (application/json)**

  ```json
     {
         "firstName": "John",
         "lastName": "Doe",
         "email": "john@mail.com"
      }
   ```
* **Response**

  * **Code:** 201<br />
    **Content:** 
    
    ```json
     {
        "id": 1,
        "firstName": "John",
        "lastName": "Doe",
        "email": "john@mail.com"
      }
      ```

 ### List All Persons
 Returns JSON list of all persons data.
 
 * **Endpoint**
 
    /person
    
 * **Method**
    
    `GET`
    
 * **Response**

    * **Code**: 200<br />
    
      **Content:** 
      
      ```json
      [{
            "id": 1,
            "firstName": "John",
            "lastName": "Doe",
            "email": "john@mail.com"
       }, 
       {
            "..."
      }]
       ```
  
### List Person by Id
Returns JSON of a specific person by ID.
 
* **Endpoint**
 
   /person/:id
   
*  **URL Params**

   **Required**
 
   `id=[integer]`
    
* **Method**
    
   `GET`
    
* **Response**

   * **Code**: 200<br />
    
     **Content:** 
      
     ```json
     {
           "id": 1,
           "firstName": "John",
           "lastName": "Doe",
           "email": "john@mail.com"
      }
      ```

### Update Person

  Update person with the values sent as JSON.<br />
  Returns an updated JSON structure.

* **Endpoint**

  /person/:id

* **Method**

  `PUT`
  
* **URL Params**

  **Required:**
 
  `id=[integer]`

* **Body Data (application/json)**

  ```json
     {
        "firstName": "Mary",
        "lastName": "Jane",
        "email": "mary@mail.com"
     }
   ```
* **Success Response**

  * **Code:** 200<br />
  
    **Content:** 
    
    ```json
     {
        "id": 1,
        "firstName": "Mary",
        "lastName": "Jane",
        "email": "mary@mail.com"
     }
    ```
    
### Delete Person
Delete person by ID.
 
* **Endpoint**
 
   /person/:id
    
* **Method:**
    
   `DELETE`
   
* **URL Params**

  **Required:**
 
  `id=[integer]`
    
* **Success Response:**

   * **Code**: 200<br />
