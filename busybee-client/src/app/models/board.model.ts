import {ColumnModel} from './column.model';

export class BoardModel {
  constructor(public name: string, public columns: ColumnModel[]) {
  }
}
