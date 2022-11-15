package com.cursojavangular.tasks.service;

import com.cursojavangular.tasks.domain.Task;
import org.springframework.stereotype.Service;

public interface TaskService {

    Iterable<Task> list();

    Task save(Task task);
}
