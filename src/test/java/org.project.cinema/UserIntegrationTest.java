package org.project.cinema;

import org.project.CinemaApplication;
import org.project.domain.User;
import org.project.service.UserService;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.data.domain.Page;
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

        User user = new User();
        user.setFirstName("Szucs");
        user.setLastName("Sandor");
        userService.saveUser(user);
    }
}
