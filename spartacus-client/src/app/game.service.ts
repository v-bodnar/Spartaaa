import {Injectable} from '@angular/core';
import {RsocketService} from "./rsocket.service";
import {Gladiator} from "./dto/gladiator";
import {Single} from 'rsocket-flowable';
import {GameDto} from "./dto/game.dto";

@Injectable({
  providedIn: 'root'
})
export class GameService {
  private _currentGame:GameDto;

  constructor(private  rsocketService: RsocketService) {
  }

  getGladiators(): Single<Gladiator[]> {
    return this.rsocketService.requestResponse('', 'getGladiators').map((payload) => {
      let gladiators: Gladiator[] = [];
      for (let gladiatorString of payload.data) {
        gladiators.push(new Gladiator(gladiatorString));
      }
      return gladiators;
    });
  }

  createNewGame():Single<GameDto>{
    return this.rsocketService.requestResponse('', 'createNewGame').map((payload) => {
      this._currentGame = new GameDto(payload.data);
      return this._currentGame;
    });
  }


  get currentGame(): GameDto {
    return this._currentGame;
  }


}
