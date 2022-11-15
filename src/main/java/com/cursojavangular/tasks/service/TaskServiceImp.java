package com.cursojavangular.tasks.service;


import com.cursojavangular.tasks.domain.Task;
import com.cursojavangular.tasks.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TaskServiceImp implements TaskService {

    private TaskRepository taskRepository;

    @Override
    public Iterable<Task> list() {
        return this.taskRepository.findAll();
    }

    @Override
    public Task save(Task task) {
        return this.taskRepository.save(task);
    }
}
