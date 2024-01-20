package com.oreilly.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String sayHello(
            @RequestParam(value = "name", required = false, defaultValue = "World")
            String name, Model model) {
        model.addAttribute("user", name);
        /*
        the key is an arbitrary string user and the value is the name that was passed
         */
        return "hello"; /*thymeleaf - view resolver:
        look for hello.html in src/main/java/resources/templates
        */
    }
}
