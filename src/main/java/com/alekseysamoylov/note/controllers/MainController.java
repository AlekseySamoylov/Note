package com.alekseysamoylov.note.controllers;

import com.alekseysamoylov.note.dao.UserDao;
import com.alekseysamoylov.note.entity.security.User;
import com.alekseysamoylov.note.entity.text.Message;
import com.alekseysamoylov.note.model.WebMessage;
import com.alekseysamoylov.note.repository.MessageRepository;
import com.alekseysamoylov.note.service.pages.CreateHtml;
import com.alekseysamoylov.note.service.pages.MessageStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        return "redirect:/user-messages";
    }

    @RequestMapping("/add-message")
    public String goCreateMessage(Model model) {
        WebMessage webMessage = new WebMessage();
        //webMessage.setUserId(((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
        model.addAttribute("messageBody", webMessage);
        return "add-message";
    }

    @RequestMapping("/update-message/{messageId}")
    public String goCreateMessage(Model model, @PathVariable Long messageId) {
        WebMessage webMessage = messageStorage.findMessage(messageId);
        //webMessage.setUserId(((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
        model.addAttribute("messageBody", webMessage);
        return "add-message";
    }

    @RequestMapping("/delete-message/{messageId}")
    public String deleteMessage(@PathVariable Long messageId) {
        messageStorage.delete(messageId);
        return "redirect:/user-messages";
    }

    @RequestMapping(value = "user-messages")
    public String goUserMessages(Model model) {
        model.addAttribute("messages", messageStorage.getUserMessageList());
        return "user-messages";
    }


    @RequestMapping("/admin-list")
    @ResponseBody
    public List<WebMessage> goAdminMessageList() {
        return messageStorage.getAllWebMessages();
    }

    @RequestMapping(value = "/save-message", method = RequestMethod.POST)
    public String saveMessage(@ModelAttribute WebMessage webMessage) {
        if (webMessage.getId() != null) {
            messageStorage.updateMessage(webMessage);
            createHtml.createWelcomePage();
            return "redirect:/user-messages";
        }
        messageStorage.saveMessage(webMessage);
        createHtml.createWelcomePage();
        return "redirect:/user-messages";
    }

    @RequestMapping(value = "/403")
    public String goErrorPage() throws Exception  {
        return "403";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String goLogin() {
        return "login";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }
}
