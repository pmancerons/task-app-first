package com.cursojavangular.tasks.controller;

import com.cursojavangular.tasks.domain.Task;
import com.cursojavangular.tasks.service.TaskService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
@AllArgsConstructor
@Slf4j
public class TaskController {

    private TaskService taskService;

    @GetMapping(value = {"", "/"})
    public Iterable<Task> list(){
        return this.taskService.list();
    }

    @PostMapping("/save")
    public Task saveTask(@RequestBody Task task){
        log.info("saving " + task);
        return this.taskService.save(task);
    }

}
