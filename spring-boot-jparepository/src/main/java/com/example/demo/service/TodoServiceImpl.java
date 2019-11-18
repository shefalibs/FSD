package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Todo;
import com.example.demo.repository.TodoRepository;
@Service
public class TodoServiceImpl implements TodoService {
	@Autowired
	private TodoRepository todoRepository;
	@Autowired
	public TodoServiceImpl(TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	} 
	@Override
	public List<Todo> getTodods() {
		// TODO Auto-generated method stub
		
		return todoRepository.findAll();
	}
	@Override
	public Todo putTodo(Todo todo) {
		// TODO Auto-generated method stub
		return todoRepository.insert(todo);
	}
	public void deleteTodo(String id) {
		 todoRepository.deleteById(id);
	}
	

}
