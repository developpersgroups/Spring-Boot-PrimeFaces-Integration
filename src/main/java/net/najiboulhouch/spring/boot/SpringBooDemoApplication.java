package net.najiboulhouch.spring.boot;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import net.najiboulhouch.spring.boot.entities.Group;
import net.najiboulhouch.spring.boot.entities.User;
import net.najiboulhouch.spring.boot.repositories.GroupeRepository;
import net.najiboulhouch.spring.boot.repositories.UserRepository;


/**
 * @author NAJIB
 * @version 1.0 
 */
@SpringBootApplication
public class SpringBooDemoApplication extends SpringBootServletInitializer {


	
	public static void main(String[] args) {
		SpringApplication.run(SpringBooDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner init( UserRepository userRepository,GroupeRepository groupeRepository, PasswordEncoder passwordEncoder ){
		return args -> {
			Group group = new Group("Administrator" , "ADM");
			groupeRepository.save(group);
			User user = new User("+212000000000", "NAJIB", "OULHOUCH", new Date(), "Mr", passwordEncoder.encode("najib")
					, true, "najib", group);
			userRepository.save(user);
		};
	}
}
