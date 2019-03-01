package com.epam.learnspring.dao;

import com.epam.learnspring.entity.User;

public interface UserDao extends BasicDao<User>{
    public User getByLogin(String login);
}
