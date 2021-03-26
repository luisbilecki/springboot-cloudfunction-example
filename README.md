# Spring Boot Cloud Function Example

This repository contains an example of a serverless function using Spring Boot.

See more at this [link](https://spring.io/projects/spring-cloud-function#overview).

## Requirements

- Java 11
- Maven

## How to run locally?

- Run server using:

```bash
    mvn spring-boot:run
```

- Test reverse string function using:
```bash
    curl localhost:8080/reverse -H "Content-Type: text/plain" -d "Luis"
```