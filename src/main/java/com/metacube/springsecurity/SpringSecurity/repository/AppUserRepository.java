package com.metacube.springsecurity.SpringSecurity.repository;

import com.metacube.springsecurity.SpringSecurity.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

    Optional<AppUser> findByUserName(String name);

}
