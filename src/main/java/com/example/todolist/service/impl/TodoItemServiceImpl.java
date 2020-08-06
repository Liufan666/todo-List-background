package com.example.todolist.service.impl;

import com.example.todolist.entity.TodoItem;
import com.example.todolist.repository.TodoItemRepository;
import com.example.todolist.service.TodoItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoItemServiceImpl implements TodoItemService {

    private final TodoItemRepository todoItemRepository;

    public TodoItemServiceImpl(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    @Override
    public List<TodoItem> getTodoItems() {
        return todoItemRepository.findAll();
    }

    @Override
    public TodoItem addTodoItem(TodoItem todoItem) {

        return todoItemRepository.save(todoItem);
    }

    @Override
    public void updateTodoItem(Integer id, TodoItem todoItem) {

    }

    @Override
    public void deleteTodoItem(Integer id) {
        todoItemRepository.deleteById(id);
    }
}
