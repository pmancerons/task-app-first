import { Component, OnInit } from '@angular/core';
import {Task} from "../task.model"
import { TaskService } from '../task.service';

@Component({
  selector: 'app-tasks-list',
  templateUrl: './tasks-list.component.html',
  styleUrls: ['./tasks-list.component.css']
})
export class TasksListComponent implements OnInit {

  tasks: Task[] = [];

  constructor(private taskService: TaskService) { }

  ngOnInit(): void {
    this.taskService.getTasks()
      .subscribe(
          (tasks: any[]) => {
            this.tasks = tasks
          }
        );

    this.taskService.onTaskAdded.subscribe(
      (task : Task) => {
        this.tasks.push(task);
      }
    )
  }

  getDueDateLabel(task: Task){
    return task.completed ? 'badge text-bg-success' : 'badge text-bg-primary';
  }

  onTaskChange(event:any , task:Task){
    console.log('changed');
    this.taskService.saveTask(task, event.target.checked).subscribe();
  }
}
