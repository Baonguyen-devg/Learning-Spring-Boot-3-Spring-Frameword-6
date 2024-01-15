package com.example.myfirstwebapp.todo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

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
		String name = (String) model.get("name");
		Todo todo = new Todo(0, name, "", null, false);
		model.put("todo", todo);
		return "addTodo";
	}
	
	@RequestMapping(value = "/add-Todo", method = RequestMethod.POST)
	public String addNewTodo(ModelMap mode, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) return "addTodo";
		String name = (String) mode.get("name");
		todoService.addTodo(name, todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:list-Todos";
	}
	
	@RequestMapping(value = "/delete-Todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteByID(id);
		return "redirect:list-Todos";
	}
	
	@RequestMapping(value = "/update-Todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap mode) {
		Todo todo = todoService.findTodoByID(id);
		mode.addAttribute("todo", todo);
		return "addTodo";
	}
	
	@RequestMapping(value = "/update-Todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap mode, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) return "addTodo";
		String name = (String) mode.get("name");
		todo.setUsername(name);
		todoService.updateTodo(todo);
		return "redirect:list-Todos";
	}
}
