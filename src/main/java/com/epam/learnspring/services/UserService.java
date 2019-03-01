package com.epam.learnspring.services;

import com.epam.learnspring.dao.dto.UserDto;
import com.epam.learnspring.entity.User;

import java.util.List;

public interface UserService {

    User add (User user);
    User update (User user);
    User delete (long id);
    UserDto getUserById (long id);
    List<User> getAllUsers();
}
