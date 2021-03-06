package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
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

    @MockBean
    private TaskMapper taskMapper;


/*
    @Test
    public void shouldCreateTasks() throws Exception {
        //Given
//        TaskMapper taskMapper = new TaskMapper();

        Task task = new Task(2L, "title2", "content2");
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        when(service.saveTask(ArgumentMatchers.any(Task.class))).thenReturn(task);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(task);

        mockMvc.perform(post("/v1/task/createTask")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))

                .andExpect(jsonPath("$.id", is(2)))
                .andExpect(jsonPath("$.title", is("title2")))
                .andExpect(jsonPath("$.content", is("content2")));
    }
*/


    @Test
    public void shouldFetchListTasks() throws Exception {
        //Given
//        TaskMapper taskMapper = new TaskMapper();

        List<Task> taskLists = new ArrayList<>();
        List<TaskDto> taskDtoLists = new ArrayList<>();
        taskLists.add(new Task(1L, "title1", "content1"));
        taskLists.add(new Task(3L, "title3", "content3"));
        taskDtoLists.add(new TaskDto(1L, "title1", "content1"));
        List<TaskDto> listTaskDto = taskMapper.mapToTaskDtoList(taskLists);

        when(service.getAllTasks()).thenReturn(taskLists);
        when(taskMapper.mapToTaskDtoList(ArgumentMatchers.anyList())).thenReturn(taskDtoLists);

//        when(taskMapper.mapToTaskDtoList(service.getAllTasks())).thenReturn(listTaskDto);

        //When & Then

        mockMvc.perform(get("/v1/task/getTasks").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect( jsonPath("$", hasSize(1)))
                .andExpect( jsonPath("$[0].id", is(1)))
                .andExpect( jsonPath("$[0].title", is("title1")))
                .andExpect( jsonPath("$[0].content", is("content1")));
    }


    @Test
    public void shouldFetchTask() throws Exception {
        //Given
//        TaskMapper taskMapper = new TaskMapper();

        Task task = new Task( 1L, "title1", "content1");
        TaskDto taskDto = new TaskDto(1L, "title1", "content1");


//        List<TaskDto> listTaskDto = taskMapper.mapToTaskDtoList(taskLists);

        when(service.getTask((long) 1)).thenReturn(java.util.Optional.ofNullable(task));
        when(taskMapper.mapToTaskDto(ArgumentMatchers.any())).thenReturn(taskDto);

//        when(taskMapper.mapToTaskDtoList(service.getAllTasks())).thenReturn(listTaskDto);

        //When & Then

        mockMvc.perform(get("/v1/task/getTask?taskId=1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
//                .andExpect( jsonPath("$", hasSize(1)))
                .andExpect( jsonPath("$.id", is(1)))
                .andExpect( jsonPath("$.title", is("title1")))
                .andExpect( jsonPath("$.content", is("content1")));
    }
}
