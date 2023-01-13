package com.example.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.login.dto.UsersDto;
import com.example.login.entity.Users;
import com.example.login.mapper.UsersMapper;
import com.example.login.repository.UsersRepository;
import com.example.login.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public UsersDto findByUsernameAndPassword(UsersDto usersDto) throws RuntimeException {
        Users users = usersRepository.findByUsernameAndPassword(usersDto.getUsername(), usersDto.getPassword());
        if (users == null) {
            throw new RuntimeException("User not found");
        }
        return usersMapper.toUsersDto(users);
    }

}
