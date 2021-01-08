import {Component, Input, OnInit} from '@angular/core';
import {DominusBoardDto} from "../../dto/dominus.board.dto";
import {GameService} from "../../game.service";
import {GameDto} from "../../dto/game.dto";

@Component({
  selector: 'app-lobby-screen',
  templateUrl: './lobby-screen.component.html',
  styleUrls: ['./lobby-screen.component.css']
})
export class LobbyScreenComponent implements OnInit {
  @Input()
  dominusBoards: DominusBoardDto[];

  @Input()
  game: GameDto;

  constructor(public gameService: GameService) {
    this.dominusBoards = gameService.dominusBoardsDto;
    this.game = gameService.currentGame;
  }

  public getPlayersName(dominusBoard: DominusBoardDto): string {
    for (let dominusDto of this.game.listDominus) {
      if (
        dominusDto.dominusBoard.id === dominusBoard.id) {
        return dominusDto.activePlayer.name
      }
    }
    return null
  }

  ngOnInit(): void {
  }

  copyToClipboard(inputElement) {
    inputElement.select();
    document.execCommand('copy');
    inputElement.setSelectionRange(0, 0);
  }
}
