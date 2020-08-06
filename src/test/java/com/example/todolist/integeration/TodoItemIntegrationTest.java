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
        mockMvc.perform(MockMvcRequestBuilders.get("/todoItems"))
                .andExpect(status().isOk());
        //when

        //then
    }

    @Test
    void should_add_one_todoItem_when_add_todoItem_given_one_todoItem() throws Exception {
        String todoItemJsonPayload = "{\n" +
                "      \"content\": \"kevin\",\n" +
                "      \"status\": 0\n" +
                "     }";

        mockMvc.perform(post("/todoItems").contentType(MediaType.APPLICATION_JSON).content(todoItemJsonPayload)).andExpect(status().isOk());

        List<TodoItem> todoItemList = todoItemRepository.findAll();
        assertEquals(1, todoItemList.size());
    }

    @Test
    void should_return_0_todoItem_when_delete_1_todoItem_given_1_todoItem() throws Exception {//todo

        String todoItemJsonPayload = "{\n" +
                "      \"content\": \"kevin\",\n" +
                "      \"status\": 0\n" +
                "     }";

        mockMvc.perform(post("/todoItems").contentType(MediaType.APPLICATION_JSON).content(todoItemJsonPayload)).andExpect(status().isOk());
        Integer id = todoItemRepository.findAll().get(0).getId();
        mockMvc.perform(MockMvcRequestBuilders.delete("/todoItems/"+id))
                .andExpect(status().is2xxSuccessful());
        List<TodoItem> todoItemList = todoItemRepository.findAll();
        assertEquals(0,todoItemList.size());
    }

//    @Test
//    void should_return_keven1113_when_update_employee_given_JSON() throws Exception {
//        String employeeJsonPayload = "{\n" +
//                "      \"name\": \"keven11111\",\n" +
//                "      \"age\": 20,\n" +
//                "      \"gender\": \"Male\",\n" +
//                "      \"companyId\" : 1\n" +
//                "     }";
//        mockMvc.perform(post("/employees").contentType(MediaType.APPLICATION_JSON).content(employeeJsonPayload)).andExpect(status().isCreated());
//        Integer id = employeeRepository.findAll().get(0).getId();//todo
//        String employeeJsonPayloadPut = "{\n" +
//                "      \"name\": \"keven1113\",\n" +
//                "      \"age\": 20,\n" +
//                "      \"gender\": \"Male\",\n" +
//                "      \"companyId\" : 1\n" +
//                "     }";
//
//        mockMvc.perform(MockMvcRequestBuilders.put("/employees/"+id).contentType(MediaType.APPLICATION_JSON).content(employeeJsonPayloadPut)).andExpect(status().is2xxSuccessful());
//        assertEquals("keven1113", employeeRepository.findAll().get(0).getName());
//    }



}
