package org.project.service;

import org.project.domain.User;
import org.project.dto.UserDTO;
import org.project.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;


@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public void saveUser(UserDTO userDTO) {
        String firstName = userDTO.getFirstName();
        String lastName = userDTO.getLastName();
        String email = userDTO.getEmail();

        if (firstName == null) {
            throw new IllegalArgumentException("First name cannot be null.");
        }
        if (lastName == null) {
            throw new IllegalArgumentException("Last name cannot be null");
        }
        if (email == null) {
            throw new IllegalArgumentException("You have to give your email address");
        }

        boolean mailTaken = false;

        try {
            getUserByEmail(email);
        } catch (Exception e) {
            User userObject = convert(userDTO);
            try {
                userRepository.save(userObject);
            } catch (Exception e2) {
                System.out.println("Your user could NOT be saved! Please, try again! " + e2);
            }
            mailTaken = true;
            if (mailTaken == false) {
                throw new IllegalArgumentException("This E-mail is already taken.");
            }
        }
        try {
            getUserByFirstName(firstName);
        } catch (Exception e) {
            User userFirstName = convert(userDTO);
            try {
                userRepository.save(userFirstName);
            } catch (Exception firstNameError) {
                System.out.println("No such First Name was found in the system");
            }
        }
        try {
            getUserByLastName(lastName);
        } catch (Exception e) {
            User userLastName = convert(userDTO);
            try {
                userRepository.save(userLastName);
            } catch (Exception lastNameError) {
                System.out.println("No such Last Name was found in the system");
            }
        }
    }


    public UserDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return convertToDto(user);
    }

    public UserDTO getUserByFirstName(String firstName) {
        User user = userRepository.findByFirstName(firstName);
        return convertToDto(user);
    }

    public UserDTO getUserByLastName(String lastName) {
        User user = userRepository.findByLastName(lastName);
        return convertToDto(user);
    }

    private UserDTO convertToDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setPassword(user.getPassword());
        userDTO.setTelephoneNumber(user.getTelephoneNumber());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

    private User convert(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPassword(userDTO.getPassword());
        user.setTelephoneNumber(userDTO.getTelephoneNumber());
        user.setEmail(userDTO.getEmail());
        return user;
    }

    public UserDTO getUserById(long id) {
        User user = userRepository.findOne(id);
        if (user == null) {
            throw new IllegalArgumentException("No such ID found in the DataBase");
        }
        return convertToDto(user);
    }

    public UserDTO updateUser(long id, UserDTO dto) {

        User user = userRepository.findOne(id);
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPassword(dto.getPassword());
        user.setTelephoneNumber(dto.getTelephoneNumber());
        user.setEmail(dto.getEmail());
        User savedObject = userRepository.save(user);

        return convertToDto(savedObject);
    }

    public boolean deleteUserById(long id) {
        if (userRepository.findOne(id) != null) {
            userRepository.delete(id);
            return true;
        }
        return false;
    }

//    public Page<User> getAllUsers ( int page, int size){         DO I NEED THIS?
//        Pageable pageable = new PageRequest(page, size);         I NEED THIS?
//        return userRepository.findAll(pageable);                 DO I NEED THIS?
//    }
}