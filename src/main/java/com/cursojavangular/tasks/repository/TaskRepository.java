package com.cursojavangular.tasks.repository;

import com.cursojavangular.tasks.domain.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task,Long> {

}
