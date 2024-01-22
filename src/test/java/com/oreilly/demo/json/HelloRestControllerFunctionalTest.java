package com.oreilly.demo.json;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //testing with a running server
public class HelloRestControllerFunctionalTest {
    @Test
    public void greetWithName(@Autowired TestRestTemplate restTemplate) {
        Greeting response = restTemplate.getForObject("/rest?name=Adam", Greeting.class);
        assertEquals("Hello, Adam!", response.getMessage());
    }

    @Test
    public void greetWithoutName(@Autowired TestRestTemplate restTemplate) {
        ResponseEntity<Greeting> entity = restTemplate.getForEntity("/rest", Greeting.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, entity.getHeaders().getContentType());
        Greeting response = entity.getBody();
        if (response != null) {
            assertEquals("Hello, World!", response.getMessage());
        }
    }
}
