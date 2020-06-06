package project.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import project.UserResponseDto;

@RestController
public class HelloController {

    @GetMapping("/")
    public String sayHello() {
        return "Hello";
    }
}
