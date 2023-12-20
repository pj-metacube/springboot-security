package com.metacube.springsecurity.SpringSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/hello")
    public String printHello(){
        return "Hello I am here Lec-2";
    }

}
