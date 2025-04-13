package ru.kata.springbootsecuritybootstrap.services;


import ru.kata.springbootsecuritybootstrap.models.Role;
import ru.kata.springbootsecuritybootstrap.models.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    List<User> getAllUsers();

    void save(User user);

    void delete(Integer id);

    User getOne(Integer id);

    void update(Integer id, User user);

    User oneUser();

    User createUser(User user, Set<Role> roles);

    User updateUser(User user, Set<Role> roles, Integer id);
}
