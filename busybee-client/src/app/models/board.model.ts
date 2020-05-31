import {ColumnModel} from './column.model';

export class BoardModel {
  id: number;
  name: string;
  columns: ColumnModel[];

  constructor()
  constructor(name: string, columns: ColumnModel[])
  constructor(name?: string, columns?: ColumnModel[]) {
    this.name = name
    this.columns = columns;
  }
}
