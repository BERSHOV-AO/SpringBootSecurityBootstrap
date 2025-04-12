package ru.kata.springbootsecuritybootstrap.services;

import org.springframework.security.core.userdetails.User;
import ru.kata.springbootsecuritybootstrap.models.Role;

import java.util.List;
import java.util.Set;

public interface UserService {
    List<User> getAllUsers();

    void save(User user);

    void delete(Long id);

    User getOne(Long id);

    void update(Long id, User user);

    User oneUser();

    User createUser(User user, Set<Role> roles);

    User updateUser(User user, Set<Role> roles, Long id);
}
