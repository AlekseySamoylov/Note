package com.alekseysamoylov.note.dao;

import com.alekseysamoylov.note.entity.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alekseysamoylov on 8/20/16.
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    private final HibernateTemplate template;

    @Autowired
    public UserDaoImpl(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    public User getByName(String name) {
        List<User> list = new ArrayList<>();
        list = (List<User>) template
                .findByNamedParam("from User r " +
                                "where r.username = :name",
                        "name", name);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public Long add(User user) {
        return (Long) template.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User get(Long id) {
        return template.get(User.class, id);
    }

    @Override
    public void update(User user) {
        template.update(user);
    }

    @Override
    public void delete(Long id) {
        template.delete(get(id));
    }
}
