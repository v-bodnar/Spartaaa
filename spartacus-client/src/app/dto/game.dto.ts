import {DominusDto} from "./dominus.dto";
import {Phase} from "./phase";
import {GameState} from "./game.state";

export class GameDto {
  id: String;
  password: String;
  startTime: Date;
  finishedTime: Date;
  listDominus: DominusDto[];
  gamePhase: Phase;
  gameState: GameState;

  constructor(jsonObj: Object) {
    for (let prop in jsonObj) {
      this[prop] = jsonObj[prop];
    }
  }
}
