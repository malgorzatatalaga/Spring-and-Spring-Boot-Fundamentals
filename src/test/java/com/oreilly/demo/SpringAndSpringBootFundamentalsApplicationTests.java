package com.oreilly.demo;

import com.oreilly.demo.json.Greeting;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringAndSpringBootFundamentalsApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void contextLoads() {
        assertNotNull(applicationContext);
        int count = applicationContext.getBeanDefinitionCount();
        System.out.println("Bean count: " + count);
        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
    }

    @Test @Disabled
    void notABean() {
        assertThrows(NoSuchBeanDefinitionException.class,
        () -> applicationContext.getBean(Greeting.class));
    }

    @Test
    void allBeansAreSigletons() { //by default
        Greeting greeting1 = applicationContext.getBean("defaultGreeting", Greeting.class);
        Greeting greeting2 = applicationContext.getBean("defaultGreeting", Greeting.class);
        assertSame(greeting1, greeting2);
    }

}
