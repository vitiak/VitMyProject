package com.kodilla.patterns2;

/*
@SpringBootApplication*/
/*(exclude = {ErrorMvcAutoConfiguration.class})*//*

public class Pattern2Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
//		TaskDto taskDto = new TaskDto((long) 1,	"Test title","I want to be a coder"	);
		SpringApplication.run(Pattern2Application.class, args);

//		Long id = taskDto.getId();
//		String title = taskDto.getTitle();
//		String content = taskDto.getContent();
//		System.out.println(id + " " + title + " " + content);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Pattern2Application.class);
	}
}
*/
