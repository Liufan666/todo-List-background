package com.example.todolist.service;

import com.example.todolist.entity.TodoItem;
import com.example.todolist.repository.TodoItemRepository;
import com.example.todolist.service.impl.TodoItemServiceImpl;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith(MockitoExtension.class)
public class TodoItemServiceTest {

    @Mock
    private TodoItemRepository todoItemRepository;
    @InjectMocks
    private TodoItemServiceImpl todoItemService;

    @Test
    void should_return_1_todoItem_when_get_todoItem_given_1_todoItem(){
        //given
        TodoItem todoItem = new TodoItem();
        List<TodoItem> todoItemList = new ArrayList<>();
        todoItemList.add(todoItem);
        //when
        Mockito.when(todoItemRepository.findAll()).thenReturn(todoItemList);
        List<TodoItem> todoItemListGet = todoItemService.getTodoItems();
        //then
        assertEquals(1,todoItemListGet.size());
    }

    @Test
    void should_return_1_todoItem_when_add_todoItem_given_1_todoItem() {
        //given
        TodoItem todoItem = new TodoItem(1,"content",false);
        Mockito.when(todoItemRepository.save(todoItem)).thenReturn(todoItem);
        //when
        TodoItem result = todoItemService.addTodoItem(todoItem);
        //then
        assertEquals(todoItem.getContent(),result.getContent());
    }


}
