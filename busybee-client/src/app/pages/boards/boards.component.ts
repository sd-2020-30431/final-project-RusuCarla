import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {BoardModel} from '../../models/board.model';

@Component({
  selector: 'app-boards',
  templateUrl: './boards.component.html',
  styleUrls: ['./boards.component.scss']
})
export class BoardsComponent implements OnInit {

  board: BoardModel
  username: string;

  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit(): void {
    this.username = window.localStorage.getItem('username');
  }

  logout() {
    this.router.navigateByUrl('');
  }

  display_modal() {
    const modal = document.getElementById('modal-page');
    modal.style.display = 'block';
  }

  close_modal() {
    const modal = document.getElementById('modal-page');
    modal.style.display = 'none';
  }

  create_board() {
  }

}
