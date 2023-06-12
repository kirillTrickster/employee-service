package com.example.demo.userservice.controller;

import com.example.demo.userservice.entity.User;
import com.example.demo.userservice.model.UserDTO;
import com.example.demo.userservice.model.UserSearchDTO;

import com.example.demo.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<com.example.demo.userservice.entity.User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public com.example.demo.userservice.entity.User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public com.example.demo.userservice.entity.User createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @PutMapping("/{id}")
    public com.example.demo.userservice.entity.User updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PostMapping("/search")
    public List<User> searchUsers(@RequestBody UserSearchDTO searchDTO) {
        return userService.searchUsers(searchDTO);
    }
}
