package org.project.web;

import org.project.domain.User;
import org.project.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(path = {"/{userId}"}, method = RequestMethod.GET)
    public User findUser(@PathVariable("userId") long userId) {
        LOGGER.info("userId >> {}", userId);


        return userService.getUserbyId(userId);
    }
}