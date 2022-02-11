package ru.kata.spring.boot_security.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Sql(statements = {
		"INSERT INTO `kata231`.`users` VALUES ('1', '10', 'user', 'Ivan', '$2a$12$W5NyJlgtw0OgzLtgW/FZfOUotBdjsVWJDCcL2D7LcilWrtQp8Rgzq', 'Ivanov');",
		"INSERT INTO `kata231`.`users` VALUES ('2', '11', 'user1', 'Nikolay', '$2a$12$pIn0xng9NlEFVFZfKihKxO5CEGYMlCsUJKx1ZXvNI594cmBhp59zC', 'Nikolaev');",
		"INSERT INTO `kata231`.`users` VALUES ('3', '51', 'admin', 'Andrey', '$2a$12$s0/GVRlwBTvWqD1OCSUxaevBhFH0VgebDBX49yQaK8mWGXD/7yOoi', 'Andreev');",
		"INSERT INTO `kata231`.`users` VALUES ('4', '52', 'admin1', 'Pavel', '$2a$12$.UHcTCcfhBhKk.xx3DtGGO.0FlUJGnDhXpjzpI5ihsSb0Ic1VPXfe', 'Pavlov');",

		"INSERT INTO `kata231`.`roles` VALUES ('1', 'USER');",
		"INSERT INTO `kata231`.`roles` VALUES ('2', 'ADMIN');",

		"INSERT INTO `kata231`.`users_roles` VALUES ('1', '1');",
		"INSERT INTO `kata231`.`users_roles` VALUES ('2', '1');",
		"INSERT INTO `kata231`.`users_roles` VALUES ('3', '2');",
		"INSERT INTO `kata231`.`users_roles` VALUES ('4', '1');",
		"INSERT INTO `kata231`.`users_roles` VALUES ('4', '2');",
}
)
class SpringBootSecurityDemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
