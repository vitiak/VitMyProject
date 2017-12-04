package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DbService service;

    @Autowired
    private TaskMapper taskMapper;


    @Test
    public void shouldFetchListTasks() throws Exception {
        //Given
//        TaskMapper taskMapper = new TaskMapper();

        List<Task> taskLists = new ArrayList<>();
        taskLists.add(new Task(1, "title1", "content1"));
        List<TaskDto> listTaskDto = taskMapper.mapToTaskDtoList(taskLists);

        when(taskMapper.mapToTaskDtoList(service.getAllTasks())).thenReturn(listTaskDto);

        //When & Then

        mockMvc.perform(get("/v1/Task/getTasks").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect( jsonPath("$", hasSize(1)))
                .andExpect( jsonPath("$[0].id", is(1)))
                .andExpect( jsonPath("$[0].title", is("title1")))
                .andExpect( jsonPath("$[0].content", is("content1")));
    }
}
