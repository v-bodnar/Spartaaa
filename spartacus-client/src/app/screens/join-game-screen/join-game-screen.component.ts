import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-join-game-screen',
  templateUrl: './join-game-screen.component.html',
  styleUrls: ['./join-game-screen.component.css']
})
export class JoinGameScreenComponent implements OnInit {
  @Input()
  gameId: string;
  @Input()
  gamePassword: string;
  constructor() { }
  ngOnInit(): void {
  }

  public onJoinBtnClicked(): void{
  }
}
