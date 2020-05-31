import { Component, OnInit } from '@angular/core';
import {CdkDragDrop, moveItemInArray, transferArrayItem} from '@angular/cdk/drag-drop';
import {BoardModel} from '../../models/board.model';
import {CardModel} from '../../models/card.model';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Router} from '@angular/router';

@Component({
  selector: 'app-board',
  templateUrl: './board.component.html',
  styleUrls: ['./board.component.scss']
})
export class BoardComponent implements OnInit {

  constructor(private http: HttpClient, private router: Router) { }

  board: BoardModel = new BoardModel();

  task: string;

  card: CardModel = new CardModel();

  ngOnInit(): void {
    this.getBoard();
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

  display_task_modal() {
    const modal = document.getElementById('modal-page');
    modal.style.display = 'block';
  }

  close_task_modal() {
    const modal = document.getElementById('modal-page');
    modal.style.display = 'none';
  }

  add_task() {
    const modal = document.getElementById('modal-page');
    modal.style.display = 'none';
  }

  getBoard() {
    const httpOptions = {
      headers: new HttpHeaders({
        boardId: window.localStorage.getItem('boardId')
      })
    };

    this.http.get<BoardModel>('http://localhost:8080/boards/getBoard',
      httpOptions).subscribe(result => {
        this.board = result;
        console.table(this.board);
      },
      error => console.log(error));
  }

  add_card() {
    const httpOptions = {
      headers: new HttpHeaders({
        boardId: window.localStorage.getItem('boardId')
      })
    };

    this.http.post<string>('http://localhost:8080/cards/addCard', this.card, httpOptions).subscribe(
      result => {
        console.log(result);
        alert('Successfully created board.');
        window.localStorage.setItem('boardId', String(this.board.id));
      },
      error => {
        console.log(error);
        alert('ERROR: Wrong input.');
      });
    setTimeout(() => {
      this.getBoard();
      console.log('GOD FUCKING DAMNIT');
    }, 2000);

    const modal = document.getElementById('modal-list-page');
    modal.style.display = 'none';
  }

  display_card_modal() {
    const modal = document.getElementById('modal-list-page');
    modal.style.display = 'block';
  }

  close_card_modal() {
    const modal = document.getElementById('modal-list-page');
    modal.style.display = 'none';
  }
}
