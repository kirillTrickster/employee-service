package com.example.demo.userservice.model;

import com.example.demo.userservice.entity.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;

    @NotNull
    @Size(min = 1, max = 255)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 255)
    private String lastName;

    @NotNull
    @Size(min = 1, max = 255)
    private String middleName;

    @NotNull
    @Size(min = 1, max = 255)
    @Email
    private String email;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;

    // getters, setters, toString
}
