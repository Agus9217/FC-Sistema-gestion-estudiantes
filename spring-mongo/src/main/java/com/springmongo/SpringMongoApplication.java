package com.springmongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class SpringMongoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringMongoApplication.class, args);
		StudentRepository repository = context.getBean(StudentRepository.class);
		MongoTemplate mongoTemplate = context.getBean(MongoTemplate.class);

		Address address = new Address("Argentina", "Buenos Aires", "CP1716");

		String email = "justinibarrola92@gmail.com";
		Student student = new Student(
				null,
				"Agustin",
				"Ibarrola",
				email,
				Gender.MALE,
				address,
				List.of("Computer Science", "Maths", "Justin"),
				BigDecimal.TEN,
				LocalDateTime.now());


		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email) );



		repository.insert(student);
	}

}
