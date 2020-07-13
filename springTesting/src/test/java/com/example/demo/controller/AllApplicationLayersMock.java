package com.example.demo.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.demo.dto.ToDoSaveRequest;
import com.example.demo.dto.mapper.ToDoEntityToResponseMapper;
import com.example.demo.exception.ToDoNotFoundException;
import com.example.demo.model.ToDoEntity;
import com.example.demo.repository.ToDoRepository;
import com.example.demo.service.ToDoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AllApplicationLayersMock {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper jsonMapper;

    @Autowired
    private ToDoRepository toDoRepository;

    @BeforeEach
    void putData() {
        var first = new ToDoEntity( "This is a message").completeNow();
        var second = new ToDoEntity("What do you think about potato?").completeNow();
        toDoRepository.save(first);
        toDoRepository.save(second);
    }

    @AfterEach
    void deleteData() {
        toDoRepository.deleteAll();
    }

    @Order(1)
    @Test
    void whenGetAllAfterPost_thenReturnAllWithNewInput() throws Exception {

        Long secondId = 2L;

        var third = new ToDoSaveRequest();
        third.text = "TESTING";

        var jsonResult = jsonMapper.writeValueAsString(third);

        this.mockMvc.perform(post("/todos")
                .contentType(MediaType.APPLICATION_JSON)
        .content(jsonResult))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists());


        this.mockMvc.perform(get("/todos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[2].text").value("TESTING")) // added in post test
                .andExpect(jsonPath("$[2].id").isNumber())
                .andExpect(jsonPath("$[0].text").value("This is a message"))
                .andExpect(jsonPath("$[1].id").value(secondId));
    }

    @Test
    void whenGetAllCompleted_thenReturnCorrectResult() throws Exception{

        this.mockMvc.perform(get("/todos/completed"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].completedAt").exists())
                .andExpect(jsonPath("$[1].completedAt").exists());
    }


    @Test
    void whenGetIncorrectId_thenThrowException() throws Exception {
        this.mockMvc.perform(get("/todos/999"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Can not find todo with id 999"));
    }

}
