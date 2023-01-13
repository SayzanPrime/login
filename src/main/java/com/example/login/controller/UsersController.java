package com.example.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.login.dto.UsersDto;
import com.example.login.service.UsersService;

@RestController
@RequestMapping("/auth")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/login")
    public UsersDto login(@RequestBody UsersDto usersDto) {
        return usersService.findByUsernameAndPassword(usersDto);
    }
}
