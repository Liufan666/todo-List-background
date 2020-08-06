package com.example.todolist.service;

import com.example.todolist.entity.TodoItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TodoItemService {
    List<TodoItem> getTodoItems();

    void addTodoItem(TodoItem todoItem);

    void updateTodoItem(Integer id, TodoItem todoItem);

    void deleteTodoItem(Integer id);
}
