package com.alekseysamoylov.note.service.pages;

import com.alekseysamoylov.note.model.WebMessage;

/**
 * Created by alekseysamoylov on 8/21/16.
 */
public interface MessageStorage {
    void saveMessage(WebMessage message);
}
