package com.example.demo.userservice.service;

import com.example.demo.userservice.entity.User;
import com.example.demo.userservice.exception.UserAlreadyExistsException;
import com.example.demo.userservice.exception.UserNotFoundException;
import com.example.demo.userservice.model.UserDTO;
import com.example.demo.userservice.model.UserSearchDTO;
import com.example.demo.userservice.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    @Override
    public User createUser(UserDTO userDTO) {
        if (userRepository.findByEmail(userDTO.getEmail()).size() > 0) {
            throw new UserAlreadyExistsException("User with email " + userDTO.getEmail() + " already exists");
        }

        User user = new User();
        user.setRole(userDTO.getRole());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setMiddleName(userDTO.getMiddleName());
        user.setEmail(userDTO.getEmail());
        user.setGender(userDTO.getGender());

        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

        List<User> users = userRepository.findByEmail(userDTO.getEmail());
        if (users.size() > 0 && users.get(0).getId() != id) {
            throw new UserAlreadyExistsException("User with email " + userDTO.getEmail() + " already exists");
        }

        user.setRole(userDTO.getRole());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setMiddleName(userDTO.getMiddleName());
        user.setEmail(userDTO.getEmail());
        user.setGender(userDTO.getGender());

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        userRepository.delete(user);
    }

    @Override
    public List<User> searchUsers(UserSearchDTO searchDTO) {
        if (searchDTO.getQuery() != null) {
            return userRepository.findByQuery(searchDTO.getQuery());
        }

        List<User> users = new ArrayList<>();

        if (searchDTO.getRole() != null) {
            users.addAll(userRepository.findByRole(searchDTO.getRole()));
        }

        if (searchDTO.getEmail() != null) {
            users.addAll(userRepository.findByEmail(searchDTO.getEmail()));
        }

        if (searchDTO.getGender() != null) {
            users.addAll(userRepository.findByGender(searchDTO.getGender()));
        }

        return users;
    }
}

