package com.example.demo.controllers;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.models.TodoItem;
import com.example.demo.repository.TodoItemRepository;

@RestController
@RequestMapping("/api/todo-items")
public class TodoItemsController {

	private final TodoItemRepository repository;
	
	public TodoItemsController(TodoItemRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public Iterable<TodoItem> getTodoItems() {
		return repository.findAll();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getTodoItem(@PathVariable Long id) {
		TodoItem todoItem = repository.findById(id).orElse(null);
		
		if (todoItem == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(todoItem);
	}
	
	@PostMapping
	public ResponseEntity<?> postTodoItem(@RequestBody TodoItem todoItem) {
		TodoItem savedItem = repository.save(todoItem);
		
		URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("{id}")
						.buildAndExpand(savedItem.getId())
						.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> putTodoItem(@RequestBody TodoItem todoItem, @PathVariable Long id) {
		if (id != todoItem.getId()) {
			return ResponseEntity.badRequest().build();
		}
		
		TodoItem item = repository.save(todoItem);
		
		if (repository.existsById(id)) {
			return ResponseEntity.noContent().build();
		} else {			
			URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("{id}")
					.buildAndExpand(item.getId())
					.toUri();
			
			return ResponseEntity.created(location).build();
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteTodoItem(@PathVariable Long id) {
		TodoItem item = repository.findById(id).orElse(null);
		
		if (item == null) {
			return ResponseEntity.notFound().build();
		}
		
		repository.delete(item);
		return ResponseEntity.ok().build();
	}
}
