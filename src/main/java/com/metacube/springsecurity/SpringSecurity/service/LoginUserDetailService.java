package com.metacube.springsecurity.SpringSecurity.service;

import com.metacube.springsecurity.SpringSecurity.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginUserDetailService implements UserDetailsService {

    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return new LoginUser(appUserRepository.findByUserName(username)
                .orElseThrow(()-> new UsernameNotFoundException("User Not Found Exception")));
    }
}
