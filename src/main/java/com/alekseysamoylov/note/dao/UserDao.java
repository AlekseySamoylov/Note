package com.alekseysamoylov.note.dao;

import com.alekseysamoylov.note.entity.security.User;

/**
 * Created by alekseysamoylov on 8/20/16.
 */
public interface UserDao {
    User getByName(String name);
    Long add(User user);
    User get(Long id);
    void update(User user);
    void delete(Long id);

}
