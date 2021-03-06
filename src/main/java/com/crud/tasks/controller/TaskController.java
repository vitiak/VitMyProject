package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController /*wystawienie publiczne*/
//@RequestMapping("/v1/task")/*definiuje adres na jaki jest wystawione*/
@RequestMapping("/v1")/*definiuje adres na jaki jest wystawione*/
public class TaskController {
    @Autowired
    private DbService service;
    @Autowired
    private TaskMapper taskMapper;

//    @RequestMapping(method = RequestMethod.GET, value = "/getTasks") /**/
    @RequestMapping(method = RequestMethod.GET, value = "/tasks") /**/
    public List<TaskDto> getTasks() {
        List<Task> listTask = service.getAllTasks();
        List<TaskDto> listTaskDto = taskMapper.mapToTaskDtoList(listTask);
        return listTaskDto;
    }

//    @RequestMapping(method = RequestMethod.GET, value = "/getTask")
    @RequestMapping(method = RequestMethod.GET, value = "/tasks/{}taskId")
    public TaskDto getTask(@RequestParam Long taskId) throws TaskNotFoundException {
//        return new TaskDto((int)1, "test title", "test_content");
        Optional<Task> optionalTask = service.getTask(taskId);
        Task task = optionalTask.orElseThrow(TaskNotFoundException::new);
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        return taskDto;
    }

    //@RequestMapping(method = RequestMethod.DELETE, value = "/deleteTask")
    @RequestMapping(method = RequestMethod.DELETE, value = "/tasks/{taskId}")
    public void deleteTask(@RequestParam Long taskId) throws TaskNotFoundException {
        service.deleteTask(taskId);
    }

    //@RequestMapping(method = RequestMethod.POST, value = "/createTask", consumes = APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/tasks", consumes = APPLICATION_JSON_VALUE)
    public void createTask(@RequestBody TaskDto taskDto) {
        service.saveTask(taskMapper.mapToTask(taskDto));
    }


//    @RequestMapping(method = RequestMethod.PUT, value = "/updateTask", consumes = APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.PUT, value = "/tasks")
    public void updateTask(@RequestBody TaskDto taskDto) {
        service.saveTask(taskMapper.mapToTask(taskDto));
    }


}
