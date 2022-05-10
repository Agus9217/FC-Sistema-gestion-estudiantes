package com.springmongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringMongoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringMongoApplication.class, args);
		StudentRepository repository = context.getBean(StudentRepository.class);
		Address address = new Address("Argentina", "Buenos Aires", "CP1716");
		Student student = new Student(
				null,
				"Agustin",
				"Ibarrola",
				"justinibarrola92@gmail.com",
				Gender.MALE,
				address,
				List.of("Computer Science"), );
	}

}
