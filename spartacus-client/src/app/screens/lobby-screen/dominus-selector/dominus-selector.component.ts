import {Component, Input, OnInit} from '@angular/core';
import {DominusBoardDto} from "../../../dto/dominus.board.dto";

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

  constructor() {
  }

  ngOnInit(): void {
  }

  public getAvatarPath():string{
    if(this.dominusBoard.title == 'BATIATUS'){
      return '/../../assets/Batiatus.jpg';
    }else if(this.dominusBoard.title == 'TULLIUS') {
      return '/../../assets/Tullius.jpg';
    }else if(this.dominusBoard.title == 'GLABER') {
      return '/../../assets/Glaber.jpg';
    }else if(this.dominusBoard.title == 'SOLONIUS') {
      return '/../../assets/Solonius.jpg';
    }
  }

  public isDominusSelected():boolean{
    return this.playersName!==null;
  }

  public getPlayersName(dominusBoard:DominusBoardDto):string{
    return this.playersName;
  }

}
