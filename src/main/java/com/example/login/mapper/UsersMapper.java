package com.example.login.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.login.dto.UsersDto;
import com.example.login.entity.Users;

@Component
public class UsersMapper {

    public UsersDto toUsersDto(Users users) {
        return new UsersDto(
                users.getId(),
                users.getUsername(),
                users.getPassword());
    }

    public Users toUsers(UsersDto usersDto) {
        return new Users(
                usersDto.getId(),
                usersDto.getUsername(),
                usersDto.getPassword());
    }

    public List<UsersDto> toUsersDtoList(List<Users> usersList) {
        return usersList.stream()
                .map(this::toUsersDto)
                .collect(Collectors.toList());
    }

    public List<Users> toUsersList(List<UsersDto> usersDtoList) {
        return usersDtoList.stream()
                .map(this::toUsers)
                .collect(Collectors.toList());
    }
}
