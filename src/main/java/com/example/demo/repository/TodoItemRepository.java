package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.TodoItem;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {

}