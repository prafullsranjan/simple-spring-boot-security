# Spring Boot Security using JWT [![Build Status](https://github.com/prafullsranjan/simple-spring-boot-security-jwt/actions/workflows/maven.yml/badge.svg)](https://github.com/prafullsranjan/simple-spring-boot-security-jwt/actions/workflows/maven.yml) [![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)  ![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white) 

This is a simple Spring Boot 3.3.0 project with Spring Security 6.3.0 which demo the authentication of API using JWT. The user database has been managed using H2 database.

## Installation
You can import the project as a maven application to your favorite IDE. I made my tests by using IntelliJ.

## To run the application
Run this application as Spring Boot app.

## Test the service
1. Run the project
2. Create a new user in H2 database by making POST call to: `http://localhost:8080/user/add` using JSON:
   
   ```
   {
      "name": "prafull",
      "password": "pass",
      "roles": "USER,ADMIN"
   }
* The name, password and roles can be modified as per your choice.
3. Now generate the JWT token by making POST call to: `http://localhost:8080/api/authenticate` using JSON:
  
    ```
   {
      "username": "prafull",
      "password": "pass"
   }
* Use the username & password you've entered in step 2.
4. Once you've successfully generated the JWT, then make a GET call to: `http://localhost:8080/api/hello` with the generated token in authentication header. You'll receive the string "Hello World!" in response if the API is successfully authenticated.
