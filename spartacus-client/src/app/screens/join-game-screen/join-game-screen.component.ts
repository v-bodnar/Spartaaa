import {Component, Input, OnInit} from '@angular/core';
import {GameService} from '../../game.service';

@Component({
  selector: 'app-join-game-screen',
  templateUrl: './join-game-screen.component.html',
  styleUrls: ['./join-game-screen.component.css']
})
export class JoinGameScreenComponent implements OnInit {
  @Input()
  playerName: string;
  @Input()
  gameId: string;
  @Input()
  gamePassword: string;
  constructor(public gameService: GameService) {

  }
  ngOnInit(): void {
  }

  public onJoinBtnClicked(): void{
  }

  joinGame(playerName: string, gameId: string, gamePassword: string): void {
    this.gameService.joinGame(playerName, gameId, gamePassword);
  }
}
