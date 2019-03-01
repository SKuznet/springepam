package com.epam.learnspring.security.details;

import com.epam.learnspring.dao.UserDao;
import com.epam.learnspring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User byLogin = userDao.getByLogin(username);
        if (byLogin == null) {
            throw new UsernameNotFoundException(username);
        } else {
            return new UserDetailsImpl(byLogin);
        }
    }
}
