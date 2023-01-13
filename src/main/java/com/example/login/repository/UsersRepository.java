package com.example.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.login.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByUsernameAndPassword(String username, String password);
}
