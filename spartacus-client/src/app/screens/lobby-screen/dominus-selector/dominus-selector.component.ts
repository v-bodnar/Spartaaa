import {Component, Input, OnInit} from '@angular/core';
import {DominusBoardDto} from "../../../dto/dominus.board.dto";
import {GameService} from "../../../game.service";

@Component({
  selector: 'app-dominus-selector',
  templateUrl: './dominus-selector.component.html',
  styleUrls: ['./dominus-selector.component.css']
})
export class DominusSelectorComponent implements OnInit {
  @Input()
  dominusBoard: DominusBoardDto;

  @Input()
  playersName: string;

  @Input()
  currentPlayersName: string;

  constructor(private gameService: GameService) {
  }

  ngOnInit(): void {
  }

  public getAvatarPath(): string {
    if (this.dominusBoard.title == 'BATIATUS') {
      return '/../../assets/Batiatus.jpg';
    } else if (this.dominusBoard.title == 'TULLIUS') {
      return '/../../assets/Tullius.jpg';
    } else if (this.dominusBoard.title == 'GLABER') {
      return '/../../assets/Glaber.jpg';
    } else if (this.dominusBoard.title == 'SOLONIUS') {
      return '/../../assets/Solonius.jpg';
    }
  }

  public isDominusSelected(): boolean {
    return this.playersName !== null;
  }

  public getPlayersName(dominusBoard: DominusBoardDto): string {
    return this.playersName;
  }

  public getSelectedClass():string{
    return this.currentPlayersName === this.playersName ? "": "border border-danger";
  }

  public selectDominus(dominusBoard: DominusBoardDto): void {
    this.gameService.selectDominus(dominusBoard)
  }

}
