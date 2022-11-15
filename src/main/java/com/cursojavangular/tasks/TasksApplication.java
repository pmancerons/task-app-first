package com.cursojavangular.tasks;

import com.cursojavangular.tasks.domain.Task;
import com.cursojavangular.tasks.service.TaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class TasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasksApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(TaskService taskService){
		return args-> {
			taskService.save(new Task(null, "task1", LocalDate.now(), false));
			taskService.save(new Task(null, "task2", LocalDate.now(), false));
			taskService.save(new Task(null, "task3", LocalDate.now(), false));
			taskService.save(new Task(null, "task4", LocalDate.now(), false));
			taskService.save(new Task(null, "task5", LocalDate.now(), false));
		};
	}
}
