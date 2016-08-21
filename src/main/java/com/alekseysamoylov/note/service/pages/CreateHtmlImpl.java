package com.alekseysamoylov.note.service.pages;

import com.alekseysamoylov.note.repository.MessageRepository;
import com.alekseysamoylov.note.service.configuration.MyConfiguration;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Created by alekseysamoylov on 8/21/16.
 */
@Repository
@Transactional
public class CreateHtmlImpl implements CreateHtml {

    private final Logger LOGGER = Logger.getLogger(CreateHtmlImpl.class);
    private final CreateHtmlElementsList createHtmlElementsList;
    private final MyConfiguration configuration;

    @Autowired
    public CreateHtmlImpl(MyConfiguration configuration, CreateHtmlElementsList createHtmlElementsList) {
        this.createHtmlElementsList = createHtmlElementsList;
        this.configuration = configuration;
    }

    @Override
    @Transactional(readOnly = true)
    public void createWelcomePage() {
        List<String> htmlFragmentMessages = createHtmlElementsList.getMessageList();
        try (BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(configuration.getAddressWelcomePage()), "UTF-8"))) {
            bf.write("<%@ page contentType=\"text/html;charset=utf-8\" language=\"java\" %> " +
                    "<%@ taglib uri=\"http://www.springframework.org/tags\" prefix=\"spring\" %> " +
                    "<%@ taglib uri=\"http://www.springframework.org/security/tags\" prefix=\"sec\" %> " +
                    "<%@ taglib uri=\"http://java.sun.com/jsp/jstl/core\" prefix=\"c\" %>");
             for (String message : htmlFragmentMessages) {
                 bf.write(message);
             }
        } catch (IOException e) {
            LOGGER.warn("Can't write welcome.jsp file" + e.getMessage());
        }
    }
}
