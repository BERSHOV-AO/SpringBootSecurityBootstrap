package ru.kata.springbootsecuritybootstrap.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.springbootsecuritybootstrap.dao.RoleRepository;
import ru.kata.springbootsecuritybootstrap.models.Role;

@Service
public class RoleServiceImp implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findByName(String name) {
        return (Role) roleRepository.findByName(name);
    }
}
