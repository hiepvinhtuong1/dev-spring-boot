package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // expose "/" that return "Hello world"

    @GetMapping("/")
    public String sayHello(){
        System.out.println("coachName = " + coachName);
        System.out.println("teamName = " + teamName);
        return "Hello world";
    }
}
