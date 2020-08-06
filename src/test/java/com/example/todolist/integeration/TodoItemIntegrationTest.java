package com.example.todolist.integeration;

import com.example.todolist.entity.TodoItem;
import com.example.todolist.repository.TodoItemRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TodoItemIntegrationTest {
    @Autowired
    TodoItemRepository todoItemRepository;

    @Autowired
    private MockMvc mockMvc;


    @AfterEach
    void tearDown() {
        todoItemRepository.deleteAll();
    }

    @Test
    void should_return_ok_when_get_all_todoItems_given_0_todoItem() throws Exception {
        //given
        mockMvc.perform(MockMvcRequestBuilders.get("/todoItem"))
                .andExpect(status().isOk());
        //when

        //then
    }

    @Test
    void should_add_one_todoItem_when_add_todoItem_given_one_todoItem() throws Exception {
        String employeeJsonPayload = "{\n" +
                "      \"content\": \"kevin\",\n" +
                "      \"status\": 0\n" +
                "     }";

        mockMvc.perform(post("/todoItem").contentType(MediaType.APPLICATION_JSON).content(employeeJsonPayload)).andExpect(status().isOk());

        List<TodoItem> todoItemList = todoItemRepository.findAll();
        assertEquals(1, todoItemList.size());
    }

}
