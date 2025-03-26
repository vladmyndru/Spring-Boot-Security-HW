package com.example.Spring_Boot_Security_HW.service.user;

import com.example.Spring_Boot_Security_HW.dto.UserDto;
import com.example.Spring_Boot_Security_HW.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);
    User findByEmail (String email);
    List<UserDto> findAllUsers();
}
