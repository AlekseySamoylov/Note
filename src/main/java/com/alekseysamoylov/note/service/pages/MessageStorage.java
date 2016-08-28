package com.alekseysamoylov.note.service.pages;

import com.alekseysamoylov.note.model.WebMessage;

import java.util.List;

/**
 * Created by alekseysamoylov on 8/21/16.
 */
public interface MessageStorage {
    void saveMessage(WebMessage message);
    List<WebMessage> getAllWebMessages();
    void updateMessage(WebMessage message);
    List<WebMessage> getUserMessageList();
    WebMessage findMessage(Long messageId);
    void delete(Long messageId);
}
