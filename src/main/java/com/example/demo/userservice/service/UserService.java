package com.example.demo.userservice.service;

import com.example.demo.userservice.entity.User;
import com.example.demo.userservice.model.UserDTO;
import com.example.demo.userservice.model.UserSearchDTO;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Long id);

    User createUser(UserDTO userDTO);

    User updateUser(Long id, UserDTO userDTO);

    void deleteUser(Long id);

    List<User> searchUsers(UserSearchDTO searchDTO);
}
