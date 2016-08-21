package com.alekseysamoylov.note.repository;

import com.alekseysamoylov.note.entity.text.Message;

import java.util.List;

/**
 * Created by alekseysamoylov on 8/20/16.
 */
public interface MessageRepository {
    Message getMessage(Long id);
    void save(Message message);
    List<Message> getAllMessages();
}
