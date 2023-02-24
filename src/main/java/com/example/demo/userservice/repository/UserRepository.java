package com.example.demo.userservice.repository;

import com.example.demo.userservice.entity.User;
import com.example.demo.userservice.entity.Role;
import com.example.demo.userservice.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByRole(Role role);

    List<User> findByEmail(String email);

    List<User> findByGender(Gender gender);

    @Query("select u from User u where lower(u.firstName) like lower(concat('%', :query, '%')) or lower(u.lastName) like lower(concat('%', :query, '%'))")
    List<User> findByQuery(@Param("query") String query);

}
