package com.alekseysamoylov.note.controllers;

import com.alekseysamoylov.note.dao.UserDao;
import com.alekseysamoylov.note.entity.security.User;
import com.alekseysamoylov.note.entity.text.Message;
import com.alekseysamoylov.note.model.WebMessage;
import com.alekseysamoylov.note.repository.MessageRepository;
import com.alekseysamoylov.note.service.pages.CreateHtml;
import com.alekseysamoylov.note.service.pages.MessageStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by alekseysamoylov on 8/20/16.
 */
@Controller
public class MainController {

    private final CreateHtml createHtml;
    private final MessageStorage messageStorage;

    @Autowired
    public MainController(CreateHtml createHtml, MessageStorage messageStorage) {
        this.createHtml = createHtml;
        this.messageStorage = messageStorage;
    }

    @RequestMapping("/")
    public String goWelcome () {
        return "welcome";
    }

    @RequestMapping("/refresh")
    public String refresh () {
        createHtml.createWelcomePage();
        return "redirect:/";
    }

    @RequestMapping("/add-message")
    public String goCreateMessage(Model model) {
        WebMessage webMessage = new WebMessage();
        //webMessage.setUserId(((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
        model.addAttribute("messageBody", webMessage);
        return "add-message";
    }


    @RequestMapping(value = "/save-message", method = RequestMethod.POST)
    public String saveMessage(@ModelAttribute WebMessage webMessage) {
        System.out.println(webMessage);
        messageStorage.saveMessage(webMessage);
        createHtml.createWelcomePage();
        return "redirect:/";
    }
}
