package tech.ada.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //define como controller
@RequestMapping("/api/v1") //define como o endpoint principal
public class HelloWorldController {
    //o controller controla meus endpoints

    @GetMapping("/hello")
    public String hello() {
        System.out.println("Hello World!");
        return "Olá mundo!!";
    }
}
