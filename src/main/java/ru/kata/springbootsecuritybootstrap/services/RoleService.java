package ru.kata.springbootsecuritybootstrap.services;

import ru.kata.springbootsecuritybootstrap.models.Role;

public interface RoleService {
    Role findByName(String name);
}
