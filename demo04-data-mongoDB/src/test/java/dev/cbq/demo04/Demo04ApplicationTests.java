package dev.cbq.demo04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootTest
class Demo04ApplicationTests {

	@Autowired
	ApplicationContext context;

	@Test
	void contextLoads() {
		Assertions.assertNotNull(context);
		Assertions.assertNotNull(MongoTemplate.class);
	}

}
