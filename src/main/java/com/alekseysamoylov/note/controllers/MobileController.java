package com.alekseysamoylov.note.controllers;

import com.alekseysamoylov.note.entity.price.PriceGroup;
import com.alekseysamoylov.note.repository.PriceGroupRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by alekseysamoylov on 10/1/16.
 * Mobile test class
 */
@Controller
public class MobileController {

    @Autowired
    PriceGroupRepository priceGroupRepository;

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

    @CrossOrigin
    @RequestMapping(value = "/prices")
    @ResponseBody
    public List<PriceGroup> getPrices() throws Exception {
        return priceGroupRepository.findAllFetchLazy();
    }


    @Getter
    @Setter
    private static class User {
        private Long id = 1L;
        private String username = "test-user";
        private String password = "test-password";

    }
}
