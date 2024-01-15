package com.example.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@SessionAttributes("name")
public class TodoController {
	
	private TodoService todoService;
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping(value = "/list-Todos", method = RequestMethod.GET)
	public String listAllTodos(ModelMap model) {
		List<Todo> todos = todoService.findByUserName("Task 1");
		model.addAttribute("todos", todos);
		return "listTodos";
	}
	
	@RequestMapping(value = "/add-Todo", method = RequestMethod.GET)
	public String showAddNewTodoPage(ModelMap model) {
		return "addTodo";
	}
	
	@RequestMapping(value = "/add-Todo", method = RequestMethod.POST)
	public String AddNewTodo(@RequestParam String name,
							 @RequestParam String description,
							 @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate targetDate) {
		todoService.addTodo(name, description, targetDate, false);
		return "redirect:list-Todos";
	}
}
