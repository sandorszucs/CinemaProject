package org.project.service;

import org.project.domain.User;
import org.project.dto.UserDTO;
import org.project.dto.helper.Login;
import org.project.helper.ConverterHelper;
import org.project.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ConverterHelper converterHelper;

    public void setConverterHelper(ConverterHelper converterHelper) {
        this.converterHelper = converterHelper;
    }


    public User saveUser(UserDTO userDTO) {
        String firstName = userDTO.getFirstName();
        String lastName = userDTO.getLastName();
        String email = userDTO.getEmail();
        String password = userDTO.getPassword();
        String telephoneNumber = userDTO.getTelephoneNumber();

        if (firstName == null) {
            throw new IllegalArgumentException("First name cannot be null.");
        }
        if (lastName == null) {
            throw new IllegalArgumentException("Last name cannot be null");
        }
        if (email == null ) {
            throw new IllegalArgumentException("You have to give your email address");
        }
        if (password == null) {
            throw new IllegalArgumentException("Entering a password is mandatory!");
        }
        if (telephoneNumber == null) {
            throw new IllegalArgumentException("Please provide your telephone number!");
        }

       if(getUserByEmail(email) == null){
            User userObject = converterHelper.convertUser(userDTO, 0);
            return userRepository.save(userObject);
        }
        throw new IllegalArgumentException("Please provide info!");
   }

    public UserDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if(user!= null) {
            return convertToDto(user);
        }
        return null;
    }

    public UserDTO convertToDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setPassword(user.getPassword());
        userDTO.setTelephoneNumber(user.getTelephoneNumber());
        userDTO.setEmail(user.getEmail());
        return userDTO;
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
        user.setId(dto.getId());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPassword(dto.getPassword());
        user.setTelephoneNumber(dto.getTelephoneNumber());
        user.setEmail(dto.getEmail());
        User savedUser = userRepository.save(user);

        return convertToDto(savedUser);
    }

    public boolean deleteUserById(long id) {
        if (userRepository.findOne(id) != null) {
            userRepository.delete(id);
            return true;
        }
        return false;
    }

    public Login checkLogin(Login login)
    {
        User usr = userRepository.findByEmail(login.getEmail());
        if (usr != null){
            if(usr.getPassword().equals(login.getPassword())){
                return login;
            }
        }
        return null;
    }
}