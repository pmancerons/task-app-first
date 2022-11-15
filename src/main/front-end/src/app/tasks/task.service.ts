import { EventEmitter,Injectable } from "@angular/core";
import {HttpClient, HttpErrorResponse} from "@angular/common/http"
import { catchError, throwError } from "rxjs";
import { Task } from "./task.model";

@Injectable()
export class TaskService{
    
    onTaskAdded = new EventEmitter<Task>();

    constructor(private http: HttpClient){

    }

    getTasks(){
        return this.http.get<Task[]>('/api/tasks')
            .pipe(
                catchError(this.handleError)
            );
    }

    saveTask(task: Task, checked: boolean){
        task.completed = checked;
        return this.http.post<Task>('api/tasks/save',task)
            .pipe(
                catchError(this.handleError)
            );
    }

    addTask(task: Task){
        return this.http.post<Task>('api/tasks/save',task)
            .pipe(
                catchError(this.handleError)
            );
    }

    private handleError(error: HttpErrorResponse) {
        if (error.status === 0) {
          // A client-side or network error occurred. Handle it accordingly.
          console.error('An error occurred:', error.error);
        } else {
          // The backend returned an unsuccessful response code.
          // The response body may contain clues as to what went wrong.
          console.error(
            `Backend returned code ${error.status}, body was: `, error.error);
        }
        // Return an observable with a user-facing error message.
        return throwError(() => new Error('Something bad happened; please try again later.'));
      }
}
