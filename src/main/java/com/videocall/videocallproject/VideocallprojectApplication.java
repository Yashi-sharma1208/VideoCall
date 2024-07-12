package com.videocall.videocallproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.videocall.videocallproject.user.User;
import com.videocall.videocallproject.user.UserService;

@SpringBootApplication
public class VideocallprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideocallprojectApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			UserService service
	) {
		return args -> {
			service.register(User.builder()
							.username("Yashi")
							.email("yashi@mail.com")
							.password("123")
					.build());

			service.register(User.builder()
					.username("Shipra")
					.email("shipra@mail.com")
					.password("123")
					.build());

			service.register(User.builder()
					.username("Devansh")
					.email("devansh@mail.com")
					.password("123")
					.build());
		};
	}

}
