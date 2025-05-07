package dev.cbq.demo01.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hellos")
@RequiredArgsConstructor
public class HelloController {

	@GetMapping("/say-hello/{text}")
	public ResponseEntity<String> sayHello(@PathVariable("text") String text) {
		return ResponseEntity.ok("Hello World " + text);
	}

}
