package org.project.cinema;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.project.domain.User;
import org.project.dto.UserDTO;
import org.project.persistence.UserRepository;
import org.project.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserUnitTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetById () {
        User userReturned = new User();
        userReturned.setId(3L);
        userReturned.setFirstName("Sandor");
        userReturned.setLastName("Szucs");
        userReturned.setPassword("unitpass");
        userReturned.setEmail("szucslfc@gmail.com");
        userReturned.setTelephoneNumber("0740123456");

        Mockito.doReturn(userReturned).when(userRepository).findOne(3L);

        UserDTO userDTO = userService.getUserById(3L);

        Assert.assertNotNull(userDTO);
        Assert.assertEquals("Sandor", userDTO.getFirstName());
        Assert.assertEquals(3L, userDTO.getId());
    }

}
