package com.example.jewete;

import com.example.jewete.model.Role;
import com.example.jewete.model.User;
import com.example.jewete.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

/**
 * https://www.youtube.com/watch?v=VVn9OG9nfH0&ab_channel=Amigoscode
 */
@SpringBootApplication
public class JeweteApplication {

	public static void main(String[] args) {
		SpringApplication.run(JeweteApplication.class, args);
	}

	@Bean
	public static PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "John Pantau", "john", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Will You Marry Me?", "will", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Jimmy Neutron", "jim", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Arnold Suasanaseger", "arnold", "1234", new ArrayList<>()));

			userService.addRoleToUser("john", "ROLE_USER");
			userService.addRoleToUser("john", "ROLE_MANAGER");
			userService.addRoleToUser("will", "ROLE_MANAGER");
			userService.addRoleToUser("jim", "ROLE_ADMIN");
			userService.addRoleToUser("arnold", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("arnold", "ROLE_ADMIN");
			userService.addRoleToUser("arnold", "ROLE_USER");
		};
	}
}
