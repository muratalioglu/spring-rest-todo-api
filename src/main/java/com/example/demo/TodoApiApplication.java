package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.models.TodoItem;
import com.example.demo.repository.TodoItemRepository;

@SpringBootApplication
public class TodoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(TodoItemRepository repository) throws Exception {
		return (args) -> {
			TodoItem todoItem = new TodoItem(1L, "learn web development", false);
			repository.save(todoItem);
		};
	}
}
