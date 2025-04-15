package ru.kata.springbootsecuritybootstrap.services;

import ru.kata.springbootsecuritybootstrap.models.Role;

import java.util.List;

public interface RoleService {
    Role findByName(String name);

    List<Role> findAll();
}
