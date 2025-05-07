package dev.cbq.demo03;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class Demo03ApplicationTests {

	@Autowired
	ApplicationContext context;


	@Test
	void contextLoads() {
		assertNotNull(context);
		assertNotNull(context.getBean("redisTemplate", RedisTemplate.class));
		assertNotNull(context.getBean("stringRedisTemplate", RedisTemplate.class));
	}


}
