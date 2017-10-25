package com.civica.grads.boardgames.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.civica.grads.boardgames.model.Board;
import com.civica.grads.boardgames.model.Position;

@SpringBootApplication
@EnableAutoConfiguration
public class DraughtsServiceGamelogicApplication {

	public static void main(String[] args) {
		SpringApplication.run(DraughtsServiceGamelogicApplication.class, args);
	}

	@Bean
	Board board() {
		return new Board(10);
	}

	@Bean
	Position newPosition() {
		return new Position(0, 0);
	}

}
