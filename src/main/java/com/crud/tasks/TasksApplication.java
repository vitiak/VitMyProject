package com.crud.tasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication/*(exclude = {ErrorMvcAutoConfiguration.class})*/
public class TasksApplication /*extends SpringBootServletInitializer */{

	public static void main(String[] args) {
//		TaskDto taskDto = new TaskDto((long) 1,	"Test title","I want to be a coder"	);
		SpringApplication.run(TasksApplication.class, args);

//		Long id = taskDto.getId();
//		String title = taskDto.getTitle();
//		String content = taskDto.getContent();
//		System.out.println(id + " " + title + " " + content);
	}

/*	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TasksApplication.class);
	}*/
}
