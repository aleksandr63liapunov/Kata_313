package ru.kata.spring.boot_security.demo.dataloader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements ApplicationRunner {

    private final UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void run(ApplicationArguments args) {
        User user = new User();
        Set<Role> roleSet = new HashSet<>();
        Role adminRole = new Role();
        Role userRole = new Role();
        adminRole.setRole("ADMIN");
        userRole.setRole("USER");

        user.setId(1L);
        user.setLogin("user");
        user.setPassword("$2a$12$W5NyJlgtw0OgzLtgW/FZfOUotBdjsVWJDCcL2D7LcilWrtQp8Rgzq");
        user.setName("Ivan");
        user.setSurname("Ivanov");
        user.setAge(11);
        roleSet.clear();
        roleSet.add(userRole);
        user.setRoles(roleSet);
        userRepository.save(user);

        user.setId(2L);
        user.setLogin("user1");
        user.setPassword("$2a$12$pIn0xng9NlEFVFZfKihKxO5CEGYMlCsUJKx1ZXvNI594cmBhp59zC");
        user.setName("Pavel");
        user.setSurname("Pavlov");
        user.setAge(22);
        roleSet.clear();
        roleSet.add(userRole);
        user.setRoles(roleSet);
        userRepository.save(user);

        user.setId(3L);
        user.setLogin("admin");
        user.setPassword("$2a$12$s0/GVRlwBTvWqD1OCSUxaevBhFH0VgebDBX49yQaK8mWGXD/7yOoi");
        user.setName("Nikolay");
        user.setSurname("Nikolaev");
        user.setAge(33);
        roleSet.clear();
        roleSet.add(adminRole);
        user.setRoles(roleSet);
        userRepository.save(user);

        user.setId(4L);
        user.setLogin("admin1");
        user.setPassword("$2a$12$.UHcTCcfhBhKk.xx3DtGGO.0FlUJGnDhXpjzpI5ihsSb0Ic1VPXfe");
        user.setName("Andrey");
        user.setSurname("Andreev");
        user.setAge(44);
        roleSet.clear();
        roleSet.add(adminRole);
        roleSet.add(userRole);
        user.setRoles(roleSet);
        userRepository.save(user);
    }
}
