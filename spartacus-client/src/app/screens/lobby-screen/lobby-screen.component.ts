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
  private dominusBoards: DominusBoardDto[];

  @Input()
  private game:GameDto;

  constructor(private gameService: GameService) {
    this.dominusBoards = gameService.dominusBoardsDto;
    this.game = gameService.currentGame;
  }

  ngOnInit(): void {
  }

  copyToClipboard(inputElement) {
    inputElement.select();
    document.execCommand('copy');
    inputElement.setSelectionRange(0, 0);
  }
}
