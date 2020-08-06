package com.example.todolist.integeration;

import com.example.todolist.repository.TodoItemRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TodoItemIntegrationTest {
    @Autowired
    TodoItemRepository todoItemRepository;

    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    void tearDownFisrst() {
        todoItemRepository.deleteAll();
    }

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


}
