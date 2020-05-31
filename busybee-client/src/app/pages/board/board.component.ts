import { Component, OnInit } from '@angular/core';
import {CdkDragDrop, moveItemInArray, transferArrayItem} from '@angular/cdk/drag-drop';
import {BoardModel} from '../../models/board.model';
import {ColumnModel} from '../../models/column.model';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';

@Component({
  selector: 'app-board',
  templateUrl: './board.component.html',
  styleUrls: ['./board.component.scss']
})
export class BoardComponent implements OnInit {

  constructor(private http: HttpClient, private router: Router) { }

  todo = [
    'Get to work',
    'Pick up groceries',
    'Go home',
    'Fall asleep'
  ];

  done = [
    'Get up',
    'Brush teeth',
    'Take a shower',
    'Check e-mail',
    'Walk dog'
  ];

  research = [
    'research1',
    'research2'
  ];

  ideas = [
    'idea1',
    'idea2',
    'idea3'
  ];

  board: BoardModel = new BoardModel('Test board', [
    new ColumnModel('Ideas', this.ideas),
    new ColumnModel('Research', this.research),
    new ColumnModel('Todo', this.todo),
    new ColumnModel('Done', this.done)
  ]);

  task: string;

  list: ColumnModel = new ColumnModel();

  ngOnInit(): void {
  }

  logout() {
    this.router.navigateByUrl('');
  }

  back() {
    this.router.navigateByUrl('/boards');
  }

  drop(event: CdkDragDrop<string[]>) {
    if (event.previousContainer === event.container) {
      moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
    } else {
      transferArrayItem(event.previousContainer.data,
        event.container.data,
        event.previousIndex,
        event.currentIndex);
    }
  }

  display_modal() {
    const modal = document.getElementById('modal-page');
    modal.style.display = 'block';
  }

  close_modal() {
    const modal = document.getElementById('modal-page');
    modal.style.display = 'none';
  }

  add_task() {
  }

  add_list() {
  }

  display_list_modal() {
    const modal = document.getElementById('modal-list-page');
    modal.style.display = 'block';
  }

  close_list_modal() {
    const modal = document.getElementById('modal-list-page');
    modal.style.display = 'none';
  }

}
