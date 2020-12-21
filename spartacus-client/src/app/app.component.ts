import {Component, Input} from '@angular/core';
import {Gladiator} from "./dto/gladiator";
import {GameService} from "./game.service";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"]
})
export class AppComponent {
  title = 'client';
  @Input()
  gladiators: Gladiator[] = [];

  constructor(private gameService: GameService) {
    //example
    // this.getGladiators()
  }

  //todo remove example below
  async getGladiators(): Promise<any> {
    await this.delay(1000);
    console.log('Getting gladiators')
    this.gameService.getGladiators().subscribe({
      onComplete: (gladiators) => {
        console.log('Gladiators fetched')
        this.gladiators = this.gladiators.concat(gladiators);
      },
      onError: error => {
        console.error('Failed to get gladiators' + error)
      }
    });
  }

  delay(ms: number): Promise<any> {
    return new Promise(resolve => setTimeout(resolve, ms));
  }

}


