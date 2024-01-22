package com.oreilly.demo.services;

import com.oreilly.demo.json.Assignment;
import com.oreilly.demo.json.AstroResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AstroServiceTest {
    @Autowired
    private AstroService service;

    @Test
    void getAstronauts() {
        AstroResult result = service.getAstronauts();
        int number = result.number();
        System.out.println("There are " + number + " people in space");
        List<Assignment> people = service.getAstronauts().people();
        people.forEach(System.out::println);
        assertAll(
                () -> assertTrue(number >= 0),
                () -> assertEquals(number, people.size())
        );
    }

    @Test
    void getAstronautsWebFlux() {
        AstroResult result = service.getAstronautsWebFlux();
        int number = result.number();
        System.out.println("There are " + number + " people in space");
        List<Assignment> people = service.getAstronauts().people();
        people.forEach(System.out::println);
        assertAll(
                () -> assertTrue(number >= 0),
                () -> assertEquals(number, people.size())
        );
    }
}
