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


    // with this method you can directly save a user in DB
    @Test
    public void testSave() {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName("Sandor");
        userDTO.setLastName("Szucs");
        userDTO.setPassword("firstpass");
        userDTO.setTelephoneNumber("0740611695");
        userDTO.setEmail("szucs_sandor_lma@yahoo.com");
        User savedUser = userService.saveUser(userDTO);
    }

    //with this method after you enter an ID you can delete a user from the DB
    @Test
    public void testDelete() {
        userService.deleteUserById(1);
    }

    // this method shows you the user with the id given
    @Test
    public void testGetUserById () {
        System.out.println(userService.getUserById(1));
    }

    // with this method you can update the info of a user
    @Test
    public void testUpdate (){

        UserDTO savedUser = userService.getUserById(1);
        savedUser.setLastName("Boda");
        savedUser.setFirstName("Patrick");
        userService.updateUser(savedUser.getId(),savedUser);
    }
}
