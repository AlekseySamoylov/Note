package com.alekseysamoylov.note.service.configuration;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by alekseysamoylov on 7/7/16.
 * Getting id for user role
 */
@Service
public class MyConfiguration {
    private final Logger LOGGER = Logger.getLogger(MyConfiguration.class);

    public String getAddressWelcomePage() {
        return getProperty("htmlpage");
    }

    public String getBeforeEntryDiv() {
        return getProperty("htmlelementstart");
    }

    public String getAfterEntryDiv() {
        return getProperty("htmlelementend");
    }

    public String getBeforeTitle() {
        return getProperty("htmltitlebefore");
    }

    public String getAfterTitle() {
        return getProperty("htmltitleafter");
    }

    public String getBeforeMessage() {
        return getProperty("htmlmessagebefore");
    }

    public String getAfterMessage() {
        return getProperty("htmlmessageafter");
    }

    public String getAuthorLabel() {
        return getProperty("htmlauthor");
    }

    private String getProperty(String propertyName) {
        String text = null;
        try (InputStream inputStream = getClass()
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            Properties properties = new Properties();
            if (inputStream != null) {
                properties.load(inputStream);
                text = properties.getProperty(propertyName);
            } else {
                LOGGER.warn("Exception from MyConfiguration  ");
//                throw new FileNotFoundException(propertyName + "property file not found in the classpath");
            }

        } catch (IOException ex) {
            LOGGER.warn("Exception: " + ex);
        }
        return text;
    }
}

