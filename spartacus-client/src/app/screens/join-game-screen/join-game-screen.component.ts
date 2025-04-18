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

  async pasteFromClipboard(inputElement){
    if(inputElement.id === "playerName"){
      this.playerName = await navigator.clipboard.readText();
    }else if (inputElement.id === "gameId"){
      this.gameId = await navigator.clipboard.readText();
    }else if (inputElement.id === "gamePassword"){
      this.gamePassword = await navigator.clipboard.readText();
    }
  }
}
