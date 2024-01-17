package com.example.myfirstwebapp.todo;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {
	private TodoRepository todoRepository;
	private TodoService todoService;
	
	public TodoControllerJpa(TodoService todoService, TodoRepository todoRepository) {
		super();
		this.todoService = todoService;
		this.todoRepository = todoRepository;
	}

	@RequestMapping(value = "/list-Todos", method = RequestMethod.GET)
	public String listAllTodos(ModelMap model) {
		String name  = getLoggedInUsername(model);
		List<Todo> todos = todoRepository.findAllByUsername(name);
		//List<Todo> todos = todoService.findByUserName(name);
		model.addAttribute("todos", todos);
		return "listTodos";
	}
	
	@RequestMapping(value = "/add-Todo", method = RequestMethod.GET)
	public String showAddNewTodoPage(ModelMap model) {
		String name = getLoggedInUsername(model);
		Todo todo = new Todo(0, name, "", null, false);
		model.put("todo", todo);
		return "addTodo";
	}
	
	@RequestMapping(value = "/add-Todo", method = RequestMethod.POST)
	public String addNewTodo(ModelMap mode, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) return "addTodo";
		String name = getLoggedInUsername(mode);
		todo.setUsername(name);
		todoRepository.save(todo);
		//todoService.addTodo(name, todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:list-Todos";
	}
	
	@RequestMapping(value = "/delete-Todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		todoRepository.deleteById(id);
		//todoService.deleteByID(id);
		return "redirect:list-Todos";
	}
	
	@RequestMapping(value = "/update-Todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap mode) {
		//Todo todo = todoService.findTodoByID(id);
		Todo todo = todoRepository.findById(id).get();
		mode.addAttribute("todo", todo);
		return "addTodo";
	}
	
	@RequestMapping(value = "/update-Todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap mode, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) return "addTodo";
		String name = getLoggedInUsername(mode);
		todo.setUsername(name);
		todoRepository.save(todo);
		//todoService.updateTodo(todo);
		return "redirect:list-Todos";
	}

	private String getLoggedInUsername(ModelMap mode) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
