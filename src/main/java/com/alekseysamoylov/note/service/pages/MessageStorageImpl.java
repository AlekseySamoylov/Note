package com.alekseysamoylov.note.service.pages;

import com.alekseysamoylov.note.dao.UserDao;
import com.alekseysamoylov.note.entity.security.User;
import com.alekseysamoylov.note.entity.text.Message;
import com.alekseysamoylov.note.model.WebMessage;
import com.alekseysamoylov.note.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by alekseysamoylov on 8/21/16.
 */
@Repository
@Transactional
public class MessageStorageImpl implements MessageStorage {

    private final MessageRepository messageRepository;
    private final UserDao userDao;

    @Autowired
    public MessageStorageImpl(MessageRepository messageRepository, UserDao userDao) {
        this.messageRepository = messageRepository;
        this.userDao = userDao;
    }

    @Override
    public void saveMessage(WebMessage webMessage) {
        Message message = new Message();
        message.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        message.setTitle(webMessage.getTitle());
        message.setText(webMessage.getTextBody());
        messageRepository.save(message);
    }
}
