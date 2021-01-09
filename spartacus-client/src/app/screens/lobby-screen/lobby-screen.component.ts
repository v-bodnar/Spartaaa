import {Component, OnInit} from '@angular/core';
import {DominusBoardDto} from "../../dto/dominus.board.dto";
import {GameService} from "../../game.service";
import {GameDto} from "../../dto/game.dto";

@Component({
  selector: 'app-lobby-screen',
  templateUrl: './lobby-screen.component.html',
  styleUrls: ['./lobby-screen.component.css']
})
export class LobbyScreenComponent implements OnInit {
  dominusBoards: DominusBoardDto[];
  game: GameDto;
  playersName: string;

  constructor(public gameService: GameService) {
    this.dominusBoards = gameService.dominusBoardsDto;
    this.game = gameService.currentGame;
    this.playersName = gameService.playersName;
  }

  ngOnInit(): void {
    this.gameService.playersNameSubject.subscribe(value => {
      this.playersName = value
    })
    // this.game = gameService.currentGame
    this.gameService.gameStateSubject.subscribe(value => {
      this.game = value
    });
  }

  public getPlayersName(dominusBoard: DominusBoardDto): string {
    if (this.game) {
      for (let dominusDto of this.game.dominusList) {
        if (dominusDto.dominusBoard.id === dominusBoard.id) {
          return dominusDto.player.name
        }
      }
    }
    return null
  }


  copyToClipboard(inputElement) {
    inputElement.select();
    document.execCommand('copy');
    inputElement.setSelectionRange(0, 0);
  }
}
