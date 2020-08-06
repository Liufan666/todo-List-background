package com.example.todolist.service;

import com.example.todolist.entity.TodoItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TodoItemService {
    List<TodoItem> getTodoItems();

    TodoItem addTodoItem(TodoItem todoItem);

    void updateTodoItem(Integer id, TodoItem todoItem);

    void deleteTodoItem(Integer id);

    public void updateTodoItem(Integer id);
}
