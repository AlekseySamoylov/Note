package com.alekseysamoylov.note.controllers;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by alekseysamoylov on 10/1/16.
 * Mobile test class
 */
@Controller
public class MobileController {

    @CrossOrigin
    @RequestMapping(value = "/ios-get-user")
    @ResponseBody
    public User sendTestUser() throws Exception {
        return new User();
    }

    @CrossOrigin
    @RequestMapping(value = "/ios-send-user", method = RequestMethod.POST)
    public
    @ResponseBody
    User saveTestUser(@RequestBody User user) {
        user.setUsername("Hello " + user.getUsername());
        return user;
    }


    @Getter
    @Setter
    private static class User {
        private Long id = 1L;
        private String username = "test-user";
        private String password = "test-password";

    }
}
