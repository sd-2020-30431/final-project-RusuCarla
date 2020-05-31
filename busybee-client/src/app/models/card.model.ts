export class CardModel {
  name: string;
  tasks: string[];

  constructor()
  constructor(name: string, tasks: string[])
  constructor(name?: string, tasks?: string[]) {
    this.name = name
    this.tasks = tasks;
  }
}
