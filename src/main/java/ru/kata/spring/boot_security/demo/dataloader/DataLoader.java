package ru.kata.spring.boot_security.demo.dataloader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;

import java.util.HashMap;
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
        roleSet.add(new Role(1L, "USER"));

        user.setId(1L);
        user.setEmail("user@mail.ru");
        user.setPassword("$2a$12$W5NyJlgtw0OgzLtgW/FZfOUotBdjsVWJDCcL2D7LcilWrtQp8Rgzq");
        user.setName("Ivan");
        user.setSurname("Ivanov");
        user.setAge(11);
        user.setRoles(roleSet);
        userRepository.save(user);

        user.setId(2L);
        user.setEmail("user1@mail.ru");
        user.setPassword("$2a$12$pIn0xng9NlEFVFZfKihKxO5CEGYMlCsUJKx1ZXvNI594cmBhp59zC");
        user.setName("Pavel");
        user.setSurname("Pavlov");
        user.setAge(22);
        user.setRoles(roleSet);
        userRepository.save(user);

        roleSet.clear();
        roleSet.add(new Role(2L, "ADMIN"));

        user.setId(3L);
        user.setEmail("admin@mail.ru");
        user.setPassword("$2a$12$s0/GVRlwBTvWqD1OCSUxaevBhFH0VgebDBX49yQaK8mWGXD/7yOoi");
        user.setName("Nikolay");
        user.setSurname("Nikolaev");
        user.setAge(33);
        user.setRoles(roleSet);
        userRepository.save(user);

        roleSet.add(new Role(1L, "USER"));

        user.setId(4L);
        user.setEmail("admin1@mail.ru");
        user.setPassword("$2a$12$.UHcTCcfhBhKk.xx3DtGGO.0FlUJGnDhXpjzpI5ihsSb0Ic1VPXfe");
        user.setName("Andrey");
        user.setSurname("Andreev");
        user.setAge(44);
        user.setRoles(roleSet);
        userRepository.save(user);
    }
}
