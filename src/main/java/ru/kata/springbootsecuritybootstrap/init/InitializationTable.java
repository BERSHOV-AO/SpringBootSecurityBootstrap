package ru.kata.springbootsecuritybootstrap.init;

import org.springframework.stereotype.Component;
import ru.kata.springbootsecuritybootstrap.dao.RoleRepository;
import ru.kata.springbootsecuritybootstrap.dao.UserRepository;
import ru.kata.springbootsecuritybootstrap.models.Role;
import ru.kata.springbootsecuritybootstrap.models.User;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class InitializationTable {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;


    public InitializationTable(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    User admin = new User("Admin",
            "Admin",
            "admin@bk.ru",
            "$2a$12$Y03tCK62VmaaZLeWlU8cnelB.m/Y4LOMgnC24UpxsJzOv2UE/Uc0K");  //key -> admin
    User user = new User("User",
            "User",
            "user@bk.ru",
            "$2a$12$oQKP9KHR5an3eHvvK2sGcOEW5Z0zomeLv2mopUN5DqOCJ7u5R9qCa");  //key -> user

    Role roleAdmin = new Role("ROLE_ADMIN");
    Role roleUser = new Role("ROLE_USER");
    Set<Role> setAdmin = new HashSet<>();
    Set<Role> setUser = new HashSet<>();

    @PostConstruct
    public void initializationTable() {
        roleRepository.save(roleAdmin);
        roleRepository.save(roleUser);

        setAdmin.add(roleAdmin);
        setAdmin.add(roleUser);
        admin.setRoles(setAdmin);
        userRepository.save(admin);

        setUser.add(roleUser);
        user.setRoles(setUser);
        userRepository.save(user);
    }
}
