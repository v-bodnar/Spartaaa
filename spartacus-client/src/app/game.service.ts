import {Injectable} from '@angular/core';
import {RsocketService} from "./rsocket.service";
import {Gladiator} from "./dto/gladiator";
import {Single} from 'rsocket-flowable';
import {GameDto} from "./dto/game.dto";
import {Phase} from "./dto/phase";
import {DominusBoardDto} from "./dto/dominus.board.dto";

@Injectable({
  providedIn: 'root'
})
export class GameService {
  private _currentGame: GameDto;
  private _dominusBoardsDto: DominusBoardDto[];

  private gamePhaseListeners: GamePhaseListener[];


  constructor(private  rsocketService: RsocketService) {
    this.gamePhaseListeners = []
    this._dominusBoardsDto = []
  }

  public getGladiators(): Single<Gladiator[]> {
    return this.rsocketService.requestResponse('', 'getGladiators').map((payload) => {
      let gladiators: Gladiator[] = [];
      for (let gladiatorString of payload.data) {
        gladiators.push(new Gladiator(gladiatorString));
      }
      return gladiators;
    });
  }

  createNewGame(): Single<GameDto> {
    return this.rsocketService.requestResponse('', 'createNewGame').map((payload) => {
      this._currentGame = new GameDto(payload.data.key);
      for (let string of payload.data.value) {
        this._dominusBoardsDto.push(new DominusBoardDto(string))
      }
      this.gamePhaseListeners.forEach(listener => listener.onGamePhaseChange(this._currentGame.gamePhase));
      return this._currentGame;
    });
  }


  public get currentGame(): GameDto {
    return this._currentGame;
  }


  public get dominusBoardsDto(): DominusBoardDto[] {
    return this._dominusBoardsDto;
  }

  public registerGamePhaseListener(listener: GamePhaseListener): void {
    this.gamePhaseListeners.push(listener)
  }
}

export interface GamePhaseListener {
  onGamePhaseChange(phase: Phase);
}
