package com.metacube.springsecurity.SpringSecurity.controller;

import com.metacube.springsecurity.SpringSecurity.entity.AppUser;
import com.metacube.springsecurity.SpringSecurity.service.AppUserService;
import com.metacube.springsecurity.SpringSecurity.utils.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank")
public class BankController {
    @Autowired
    JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    AppUserService appUserService;

    @GetMapping("/welcome")
    public String printHello() {
        return "Welcome to HDFC Bank ...";
    }

    @PostMapping("/new")
    public String addNewUser(@RequestBody AppUser appUser) {
        return appUserService.addNewUser(appUser);
    }

    @PostMapping("/authenticate")
    public String authenticateAndGenerateToken(@RequestBody AppUser appUser) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(appUser.getUserName(), appUser.getPassword()));
        if (authenticate.isAuthenticated()) {
            return jwtService.generateToken(appUser.getUserName());
        } else {
            return "Bad Credentials";
        }
    }
}
