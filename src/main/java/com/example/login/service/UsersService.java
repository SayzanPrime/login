package com.example.login.service;

import com.example.login.dto.UsersDto;

public interface UsersService {

    UsersDto findByUsernameAndPassword(UsersDto usersDto) throws RuntimeException;
}
