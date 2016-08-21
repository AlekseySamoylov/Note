package com.alekseysamoylov.note.service.pages;

import com.alekseysamoylov.note.entity.text.Message;
import com.alekseysamoylov.note.repository.MessageRepository;
import com.alekseysamoylov.note.service.configuration.MyConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alekseysamoylov on 8/21/16.
 */
@Service
@Transactional
public class CreateHtmlElementsListImpl implements CreateHtmlElementsList {

    private final MessageRepository messageRepository;
    private final MyConfiguration configuration;
    private String beforeDiv;
    private String afterDiv;
    private String beforeTitle;
    private String afterTitle;
    private String beforeMessage;
    private String afterMessage;

    @Autowired
    public CreateHtmlElementsListImpl(MessageRepository messageRepository, MyConfiguration configuration) {
        this.messageRepository = messageRepository;
        this.configuration = configuration;
        this.beforeDiv = configuration.getBeforeEntryDiv();
        this.afterDiv = configuration.getAfterEntryDiv();
        this.beforeTitle = configuration.getBeforeTitle();
        this.afterTitle = configuration.getAfterTitle();
        this.beforeMessage = configuration.getBeforeMessage();
        this.afterMessage = configuration.getAfterMessage();
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> getMessageList() {
        List<String> messageHtmlFragment = new ArrayList<>();
        messageRepository.getAllMessages().forEach(message -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder
                    .append(beforeDiv)
                    .append(beforeTitle)
                    .append(message.getTitle())
                    .append(afterTitle)
                    .append(beforeMessage)
                    .append(message.getText())
                    .append(afterMessage)
                    .append(beforeMessage)
                    .append(configuration.getAuthorLabel()).append(message.getUser().getFirstName())
                    .append(" ").append(message.getUser().getLastName())
                    .append(afterMessage)
                    .append(afterDiv)
                    .append("<hr/>");
            messageHtmlFragment.add(stringBuilder.toString());
        });
        return messageHtmlFragment;
    }
}
