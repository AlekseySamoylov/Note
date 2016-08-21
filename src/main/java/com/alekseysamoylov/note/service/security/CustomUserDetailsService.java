package com.alekseysamoylov.note.service.security;

import com.alekseysamoylov.note.dao.UserDao;
import com.alekseysamoylov.note.entity.security.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by alekseysamoylov on 7/15/16.
 */
@Component("customUserDetailsService")
@Transactional
public class CustomUserDetailsService implements UserDetailsService{

    private final UserDao userDao;

    @Autowired
    public CustomUserDetailsService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.getByName(s);
        if (user == null) {
            throw new UsernameNotFoundException("User " + s + " not found");
        }
        return user;
    }


}
