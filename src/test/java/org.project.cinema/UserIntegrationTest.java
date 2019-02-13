package org.project.cinema;

import org.project.CinemaApplication;
import org.project.domain.User;
import org.project.dto.UserDTO;
import org.project.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration (classes = CinemaApplication.class,
        loader = SpringApplicationContextLoader.class,
        initializers = ConfigFileApplicationContextInitializer.class)

public class UserIntegrationTest {

    @Autowired
    private UserService userService;

    @Test
    public void testSave() {
        //save
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName("Smith");
        userDTO.setLastName("George");
        userDTO.setPassword("firstpass");
        userDTO.setTelephoneNumber("0740611695");
        userDTO.setEmail("smith_george@gmail.com");
        User savedUser = userService.saveUser(userDTO);
        //update
//        savedUser.setLastName("Bela");
//        savedUser.setFirstName("Andras");
//        userService.updateUser(userService.convertToDto(savedUser));
//
//        //delete
//        userService.deleteUserById(savedUser.getId());
    }
}
