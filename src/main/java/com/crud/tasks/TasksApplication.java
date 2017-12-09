package com.crud.tasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
public class TasksApplication /*extends SpringBootServletInitializer*/ {

	public static void main(String[] args) {
		SpringApplication.run(TasksApplication.class, args);
	}

	/*	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TasksApplication.class);
	}*/
}
