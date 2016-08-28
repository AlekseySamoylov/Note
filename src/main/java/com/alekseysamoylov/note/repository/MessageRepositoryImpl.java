package com.alekseysamoylov.note.repository;

import com.alekseysamoylov.note.entity.text.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by alekseysamoylov on 8/20/16.
 */
@Repository
@Transactional
public class MessageRepositoryImpl implements MessageRepository{

    private final HibernateTemplate template;

    @Autowired
    public MessageRepositoryImpl(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    @Transactional(readOnly = true)
    public Message getMessage(Long id) {
        return template.get(Message.class, id);
    }

    @Override
    public void save(Message message) {
        template.save(message);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Message> getAllMessages() {
        return (List<Message>) template.find("from Message");
    }

    @Override
    public void update(Message message) {
        template.update(message);
    }

    @Override
    public void delete(Long id) {
        template.delete(getMessage(id));
    }
}
