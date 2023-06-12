package com.example.demo.userservice.repository;

import com.example.demo.userservice.entity.User;
import com.example.demo.userservice.model.UserSearchDTO;

import java.util.List;

public interface UserRepositoryCustom {
    List<User> searchUsers(UserSearchDTO searchDTO);
}

