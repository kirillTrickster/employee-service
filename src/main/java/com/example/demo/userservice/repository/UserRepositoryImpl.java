package com.example.demo.userservice.repository;

import com.example.demo.userservice.entity.User;

import com.example.demo.userservice.model.UserSearchDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.criteria.Predicate;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> searchUsers(UserSearchDTO searchDTO) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);

        List<Predicate> predicates = new ArrayList<>();

        if (searchDTO.getRole() != null) {
            predicates.add((Predicate) builder.equal(root.get("role"), searchDTO.getRole()));
        }

        if (searchDTO.getEmail() != null) {
            predicates.add((Predicate) builder.equal(root.get("email"), searchDTO.getEmail()));
        }

        if (searchDTO.getGender() != null) {
            predicates.add((Predicate) builder.equal(root.get("gender"), searchDTO.getGender()));
        }

        if (searchDTO.getQuery() != null) {
            predicates.add((Predicate) builder.or(builder.like(builder.lower(root.get("firstName")), "%" + searchDTO.getQuery().toLowerCase() + "%"),
                    builder.like(builder.lower(root.get("lastName")), "%" + searchDTO.getQuery().toLowerCase() + "%")));
        }

        query.where(predicates.toArray(new Predicate[predicates.size()]));

        return entityManager.createQuery(query).getResultList();
    }

}
