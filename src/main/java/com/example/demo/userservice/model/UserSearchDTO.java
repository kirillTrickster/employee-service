package com.example.demo.userservice.model;

import com.example.demo.userservice.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSearchDTO {

    private Role role;

    private String email;

    private Gender gender;

    private String query;
}
