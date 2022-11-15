export class Task{
  public id: number | null;
  public name: string;
  public completed: boolean;
  public dueDate: string;

  constructor( name:string, completed:boolean, dueDate: string){
    this.id = null;
    this.name = name;
    this.completed = completed;
    this.dueDate = dueDate;
  }

}
