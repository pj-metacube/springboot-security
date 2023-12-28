package com.metacube.springsecurity.SpringSecurity.service;

import com.metacube.springsecurity.SpringSecurity.entity.AppUser;
import com.metacube.springsecurity.SpringSecurity.repository.AppUserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public void saveUserOnStartup() {
        List<AppUser> appUserList = List.of(
                new AppUser(101, "Prakash", passwordEncoder.encode("123"), "ROLE_ADMIN"),
                new AppUser(102, "Rahul", passwordEncoder.encode("123"), "ROLE_USER,ROLE_ADMIN"),
                new AppUser(103, "Aakash", passwordEncoder.encode("123"), "ROLE_USER"),
                new AppUser(104, "Suresh", passwordEncoder.encode("123"), "ROLE_USER")
        );
        appUserRepository.saveAll(appUserList);
    }

    public String addNewUser(AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUserRepository.save(appUser);
        return "User Added Successfully!!!";
    }
}
