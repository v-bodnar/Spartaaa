import {Component, OnInit} from '@angular/core';
import {GameService} from "../../game.service";

@Component({
  selector: 'start-screen',
  templateUrl: './start-screen.component.html',
  styleUrls: ['./start-screen.component.css']
})
export class StartScreenComponent implements OnInit {

  constructor(private gameService: GameService) {

  }

  public ngOnInit(): void {
  }

  public onStartBtnClicked(): void {
    this.gameService.createNewGame()
      .subscribe({
        onComplete: (newGame) => {
          console.log('New game started: %s', JSON.stringify(newGame))
        },
        onError: error => {
          console.error('Failed to start new game' + error)
        }
      });
  }
}
