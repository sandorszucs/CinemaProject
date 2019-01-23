package org.project.service;

import org.project.domain.User;
import org.project.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) throws IllegalArgumentException {
        if (user.getFirstName() == null) {
            throw new IllegalArgumentException("First name cannot be null");
        }

        if (user.getLastName() == null) {
            throw new IllegalArgumentException("Last name cannot be null");
        }


        try {
            userRepository.save(user);
        } catch (Exception e) {
            System.out.println("Error when saving user " + e);
        }
    }

    public Page<User> getAllUsers(int page, int size) {

        Pageable pageable = new PageRequest(page, size);
        return userRepository.findAll(pageable);
    }



    public User getUserbyId(long userId) {
        if (userId == 0){
            throw new IllegalArgumentException("No SUCH ID found");
        }

        return userRepository.findOne(userId);
    }

    public void deleteUser(long userId) {

        userRepository.delete(userId);
    }
}