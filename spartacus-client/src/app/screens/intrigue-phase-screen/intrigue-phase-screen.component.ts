import { Component, OnInit } from '@angular/core';
import {GameService} from "../../game.service";
import {GameDto} from "../../dto/game.dto";

@Component({
  selector: 'app-intrigue-phase-screen',
  templateUrl: './intrigue-phase-screen.component.html',
  styleUrls: ['./intrigue-phase-screen.component.css']
})
export class IntriguePhaseScreenComponent implements OnInit {
  game: GameDto;
  constructor(public gameService: GameService) {
    this.game = gameService.currentGame;
  }

  ngOnInit(): void {
    this.gameService.gameStateSubject.subscribe(value => {
      this.game = value;
    });
  }

}
