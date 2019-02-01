package org.project.web;

import org.project.dto.UserDTO;
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
    public UserDTO findUser(@PathVariable("userId") long userId) {
        LOGGER.info("userId >> {}", userId);
        return userService.getUserById(userId);
    }

//    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
//    public UserDTO getUser(@PathVariable("id") long id){
//
//        return userService.getUserById(id);
//    }


    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public UserDTO getUser(@RequestParam("name") String email) {
        return userService.getUserByEmail(email);
    }

    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public void saveUser(@RequestBody UserDTO userDTO) {
        userService.saveUser(userDTO);
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.PUT)
    public UserDTO updateUser(@PathVariable long id, @RequestBody UserDTO dto) {
        return userService.updateUser(id, dto);
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") long id) {
        userService.deleteUserById(id);
    }

}