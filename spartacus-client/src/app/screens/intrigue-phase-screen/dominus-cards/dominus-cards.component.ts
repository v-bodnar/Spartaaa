import {ChangeDetectionStrategy, Component, Input, OnInit} from '@angular/core';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import {GameService} from "../../../game.service";
import {DominusDto} from "../../../dto/dominus.dto";
import {GameDto} from "../../../dto/game.dto";
import {NgForOf} from "@angular/common";
import {MatGridListModule} from '@angular/material/grid-list';

@Component({
  selector: 'app-dominus-cards',
  standalone: true,
  imports: [MatCardModule, MatButtonModule, NgForOf, MatGridListModule],
  templateUrl: './dominus-cards.component.html',
  styleUrl: './dominus-cards.component.css',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class DominusCardsComponent implements OnInit {
  @Input()
  dominus: DominusDto;
  constructor() {
  }
  ngOnInit(): void {
  }

  public getAvatarPath(): string {
    if (this.dominus.dominusBoard.title == 'BATIATUS') {
      return '/../../assets/Batiatus.jpg';
    } else if (this.dominus.dominusBoard.title == 'TULLIUS') {
      return '/../../assets/Tullius.jpg';
    } else if (this.dominus.dominusBoard.title == 'GLABER') {
      return '/../../assets/Glaber.jpg';
    } else if (this.dominus.dominusBoard.title == 'SOLONIUS') {
      return '/../../assets/Solonius.jpg';
    }
  }

}
