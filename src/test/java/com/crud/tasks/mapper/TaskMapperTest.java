package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TaskMapperTest {

    @Test
    public void mapToTaskTest() throws URISyntaxException {
        TaskMapper taskMapper = new TaskMapper();
        TaskDto taskDto = new TaskDto(1L, "title1", "content1");
        Task task = taskMapper.mapToTask(taskDto);

        assertEquals("content1", task.getContent());
        assertEquals("title1", task.getTitle());
        assertEquals(java.util.Optional.of(1), task.getId());
    }

    @Test
    public void mapToTaskDtoTest() throws URISyntaxException {
        TaskMapper taskMapper = new TaskMapper();
        Task task = new Task(1L, "title1", "content1");
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        assertEquals("content1", taskDto.getContent());
        assertEquals("title1", taskDto.getTitle());
        assertEquals(java.util.Optional.of(1), taskDto.getId());
    }

    @Test
    public void mapToTaskDtoListTest() throws URISyntaxException {
        TaskMapper taskMapper = new TaskMapper();
        Task task1 = new Task(1L, "title1", "content1");
        Task task2 = new Task(2L, "title2", "content2");
        List<Task> listTasks = new ArrayList<>();
        listTasks.add(task1);
        listTasks.add(task2);

        List<TaskDto> listTaskDtos = taskMapper.mapToTaskDtoList(listTasks);

        assertEquals("content1", listTaskDtos.get(0).getContent());
        assertEquals("title2", listTaskDtos.get(1).getTitle());
        assertEquals(1, listTaskDtos.size());
    }



}
