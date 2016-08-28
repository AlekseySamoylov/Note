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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    @Transactional(readOnly = true)
    public List<WebMessage> getAllWebMessages() {
        List<WebMessage> messages = new ArrayList<>();
        List<Message> dbMessages = messageRepository.getAllMessages();
        fillMessageList(messages, dbMessages);
        return messages;
    }

    @Override
    @Transactional(readOnly = true)
    public List<WebMessage> getUserMessageList() {
        List<WebMessage> webMessages = new ArrayList<>();
        Long userId = ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        List<Message> dbMessages =
                messageRepository.getAllMessages().stream()
                .filter(message -> userId.equals(message.getUser()
                        .getId())).collect(Collectors.toList());
        fillMessageList(webMessages, dbMessages);
        return webMessages;
    }

    @Override
    @Transactional(readOnly = true)
    public WebMessage findMessage(Long messageId) {
        Message dbMessage = messageRepository.getMessage(messageId);
        WebMessage webMessage = new WebMessage();
        fillWebMessage(dbMessage, webMessage);
        return webMessage;
    }

    @Override
    public void delete(Long messageId) {
        messageRepository.delete(messageId);
    }

    @Override
    public void updateMessage(WebMessage message) {
        Message messageDB = messageRepository.getMessage(message.getId());
        messageDB.setText(message.getTextBody());
        messageDB.setTitle(message.getTitle());
        messageRepository.update(messageDB);
    }

    @Transactional(readOnly = true)
    private void fillMessageList(List<WebMessage> list, List<Message> dbList) {
        dbList.forEach(dbMessage -> {
            WebMessage webMessage = new WebMessage();
            fillWebMessage(dbMessage, webMessage);
            list.add(webMessage);
        });
    }


    @Transactional(readOnly = true)
    private void fillWebMessage(Message dbMessage, WebMessage webMessage) {
        webMessage.setId(dbMessage.getId());
        webMessage.setUserId(dbMessage.getUser().getId());
        webMessage.setUserName(dbMessage.getUser().getFirstName() + " "
                + dbMessage.getUser().getLastName());
        webMessage.setTitle(dbMessage.getTitle());
        webMessage.setTextBody(dbMessage.getText());
    }

}
