import {DominusDto} from './dominus.dto';
import {Phase} from './phase';
import {GameState} from './game.state';

export class GameDto {
  id: string;
  password: string;
  startTime: Date;
  finishedTime: Date;
  dominusList: DominusDto[];
  gamePhase: Phase;
  gameState: GameState;

  constructor(jsonObj: object) {
    for (const prop in jsonObj) {
      this[prop] = jsonObj[prop];
    }
  }
}
