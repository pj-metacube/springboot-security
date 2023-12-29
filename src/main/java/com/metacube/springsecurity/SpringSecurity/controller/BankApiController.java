package com.metacube.springsecurity.SpringSecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class BankApiController {

    @GetMapping("/get-amount")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String printHello() {
        return "Your acc balance is: Rs.223082.21";
    }


    @GetMapping("/get-account")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String printHellocc() {
        return "Your acc balance is: Rs.223082.21";
    }

}
