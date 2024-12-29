package com.example.newProject;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class controller {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, AJAY BHAI!";
    }
}
