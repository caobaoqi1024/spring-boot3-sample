package dev.cbq.demo01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class Sample01ApplicationTests {

	@Autowired
	ApplicationContext context;

	@Test
	void contextLoads() {
		Assertions.assertNotNull(context);
	}

}
