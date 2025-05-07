package dev.cbq.demo04;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@Slf4j
@SpringBootApplication
public class Demo04Application {

	public static void main(String[] args) {
//		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(Demo04Application.class, args);
	}

	@EventListener
	public void onApplicationReadyEvent(ApplicationReadyEvent event) {
		log.info("Demo04Application.onApplicationReadyEvent {}", event.getApplicationContext());
	}

}
