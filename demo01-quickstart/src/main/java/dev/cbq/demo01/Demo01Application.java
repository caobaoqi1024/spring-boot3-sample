package dev.cbq.demo01;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@Slf4j
@SpringBootApplication
public class Demo01Application {

	public static void main(String[] args) {
//		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(Demo01Application.class, args);
	}

	@EventListener
	public void onApplicationReadyEvent(ApplicationReadyEvent event) {
		log.info("Demo01Application.onApplicationReadyEvent {}", event.getApplicationContext());
	}

}
