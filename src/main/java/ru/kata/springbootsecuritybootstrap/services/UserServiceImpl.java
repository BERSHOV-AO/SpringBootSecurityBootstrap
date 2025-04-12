package ru.kata.springbootsecuritybootstrap.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kata.springbootsecuritybootstrap.dao.UserRepository;
import ru.kata.springbootsecuritybootstrap.models.Role;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final RoleService roleService;

    @Autowired
    @Lazy
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleService roleService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public User getOne(Long id) {
        return null;
    }

    @Override
    public void update(Long id, User user) {

    }

    @Override
    public User oneUser() {
        return null;
    }

    @Override
    public User createUser(User user, Set<Role> roles) {
        return null;
    }

    @Override
    public User updateUser(User user, Set<Role> roles, Long id) {
        return null;
    }
}
