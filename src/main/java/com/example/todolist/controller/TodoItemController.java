package com.example.todolist.controller;

import com.example.todolist.entity.TodoItem;
import com.example.todolist.service.TodoItemService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/todoItems")
@CrossOrigin("*")
public class TodoItemController {
    private final TodoItemService todoItemService;

    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    @GetMapping
    public List<TodoItem> getTodoItems() {
        return todoItemService.getTodoItems();
    }

    @PostMapping
    public void addTodoItem(@RequestBody TodoItem todoItem) {
        todoItemService.addTodoItem(todoItem);
    }

    @PutMapping("/{id}")
    public void updateTodoItem(@PathVariable Integer id) {
        todoItemService.updateTodoItem(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTodoItem(@PathVariable Integer id) {
        todoItemService.deleteTodoItem(id);
    }
}
