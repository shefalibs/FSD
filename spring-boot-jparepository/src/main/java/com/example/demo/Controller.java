package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Todo;

import com.example.demo.repository.TodoRepository;
import com.example.demo.service.TodoService;

@RestController
@RequestMapping("/api")
public class Controller {
	@Autowired
	private TodoService todoService;
	@Autowired
	public Controller(TodoService todoService) {
		super();
		this.todoService = todoService;
	}
	
	@GetMapping("/todos")
	public List<Todo> list()

	{
		return todoService.getTodods();
	}
	@PostMapping("/todos")
	public Todo saveAlbum(@RequestBody Todo todo){
		return todoService.putTodo(todo);
		
	}
	@DeleteMapping("/todos")
	public void deleteImage(@PathVariable String id)
	{
		 todoService.deleteTodo(id);
	}

}
