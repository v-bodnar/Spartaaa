import {Component, Input, OnInit} from '@angular/core';
import {DominusBoardDto} from "../../dto/dominus.board.dto";
import {GameService} from "../../game.service";

@Component({
  selector: 'app-lobby-screen',
  templateUrl: './lobby-screen.component.html',
  styleUrls: ['./lobby-screen.component.css']
})
export class LobbyScreenComponent implements OnInit {
  @Input()
  dominusBoardsDto: DominusBoardDto[];

  constructor(private gameService: GameService) {
    this.dominusBoardsDto = gameService.dominusBoardsDto;
  }

  ngOnInit(): void {
  }

}
