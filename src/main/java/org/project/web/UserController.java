package org.project.web;

import org.project.dto.UserDTO;
import org.project.dto.helper.Login;
import org.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public UserDTO getUser(@PathVariable("id") long id){
        return userService.getUserById(id);
    }

    @ResponseBody
    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public UserDTO getUser(@RequestParam("email") String email) {
        UserDTO userDTO = userService.getUserByEmail(email);
        return userDTO;
    }

    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public UserDTO saveUser(@RequestBody UserDTO userDTO) {
        userService.saveUser(userDTO);
        return userDTO;
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public Login checkLogin(@RequestBody Login login) {
        return userService.checkLogin(login);
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