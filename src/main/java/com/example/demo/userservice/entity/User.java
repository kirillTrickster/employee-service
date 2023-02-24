package com.example.demo.userservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Table;
import jakarta.persistence.Id;

import javax.management.relation.Role;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    // constructors, getters, setters, toString
}
