package com.example.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	
	private static int countID = 1;
	private static List<Todo> todos = new ArrayList<>();
	static {
		todos.add(new Todo(countID++, "baonguyen", "Learn Spring Framework", 
				LocalDate.now().plusYears(0), false));
		
		todos.add(new Todo(countID++, "baonguyen", "Learn Spring Boot", 
				LocalDate.now().plusYears(1), false));
		
		todos.add(new Todo(countID++, "baonguyen", "Learn Web Application", 
				LocalDate.now().plusYears(2), false));
	}
	
	public List<Todo> findByUserName(String username) {
		System.out.println(username);
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String name, String description, LocalDate targetDate, boolean isDone) {
		Todo newTodo = new Todo(countID++, name, description, targetDate, isDone);
		todos.add(newTodo);
	}
	
	public void deleteByID(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}
	
	public Todo findTodoByID(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		deleteByID(todo.getId());
		todos.add(todo);
	}
}
