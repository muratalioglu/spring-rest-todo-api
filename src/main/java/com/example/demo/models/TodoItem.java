package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TodoItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private boolean isComplete;
	
	public TodoItem() {}
	
	public TodoItem(Long id, String name, boolean isComplete) {
		this.id = id;
		this.name = name;
		this.isComplete = isComplete;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isComplete() {
		return isComplete;
	}
	
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	@Override
	public String toString() {
		return "TodoItem [id=" + id + ", name=" + name + ", isComplete=" + isComplete + "]";
	}
}
