package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Todo;

public interface TodoService {
	public List<Todo> getTodods(); 
	public Todo putTodo(Todo todo);
	public void deleteTodo(String id);
}
