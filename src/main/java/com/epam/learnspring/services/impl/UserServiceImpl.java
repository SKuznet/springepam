package com.epam.learnspring.services.impl;

import com.epam.learnspring.dao.UserDao;
import com.epam.learnspring.dao.dto.UserDto;
import com.epam.learnspring.entity.User;
import com.epam.learnspring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final UserDto userDto;

    @Autowired
    public UserServiceImpl(UserDao userDao, UserDto userDto) {
        this.userDao = userDao;
        this.userDto = userDto;
    }

    @Override
    public User add(User user) {
        return userDao.add(user);
    }

    @Override
    public User update(User user) {
        return userDao.update(user);
    }

    @Override
    public User delete(long id) {
        return userDao.delete(userDao.getById(id));
    }

    @Override
    public UserDto getUserById(long id) {
        return userDto.getUserDtoFromUser(userDao.getById(id));
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAll();
    }
}
