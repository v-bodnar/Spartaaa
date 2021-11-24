import {Injectable} from '@angular/core';
import {RsocketService} from './rsocket.service';
import {Single} from 'rsocket-flowable';
import {GameDto} from './dto/game.dto';
import {DominusBoardDto} from './dto/dominus.board.dto';
import {Subject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GameService {
  private _playersName: string;
  private _currentGame: GameDto;
  private _dominusBoardsDto: DominusBoardDto[] = [];
  private _gameStateSubject: Subject<GameDto> = new Subject<GameDto>();
  private _playersNameSubject: Subject<string> = new Subject<string>();

  constructor(private  rsocketService: RsocketService) {
    this.rsocketService.connectedSubject.subscribe(value => {
      if (value) {
        this.subscribeForGameEvents();
      }
    });
  }

  subscribeForGameEvents(): void{
    console.log('subscribing for game events:');
    this.rsocketService.requestStream('', 'subscribeForGameEvents').map((payload) => {
      console.log('new event arrived:' + JSON.stringify(payload.data));
      this._currentGame = new GameDto(payload.data.coreGame);
      this._gameStateSubject.next(this._currentGame);
    }).subscribe({
      onComplete: () => console.log('Game event subscription completed'),
      onError: error => console.error('Game event subscription failed:' + error),
      onNext: value => console.log('Game event arrived:' + JSON.stringify(value)),
      onSubscribe: sub => sub.request(100),
    });
  }


  createNewGame(): Single<GameDto> {
    return this.rsocketService.requestResponse('', 'createNewGame').map((payload) => {
      this._currentGame = new GameDto(payload.data.key);
      for (const value of payload.data.value) {
        this._dominusBoardsDto.push(new DominusBoardDto(value));
      }
      this._gameStateSubject.next(this._currentGame);
      return this._currentGame;
    });
  }


  selectDominus(dominusBoardDto: DominusBoardDto): void {
    const data = {gameId: this.currentGame.id, dominusBoardId: dominusBoardDto.id, playersName: this._playersName};
    return this.rsocketService.requestResponse(data, 'selectDominus').subscribe({
      onComplete: value => {
        console.log('dominus selected: ');
      },
      onError: error => {
        console.error('Failed to select dominus' + error);
      }
    });
  }

  public get currentGame(): GameDto {
    return this._currentGame;
  }


  public get playersName(): string {
    return this._playersName;
  }

  public set playersName(value: string) {
    this._playersName = value;
    this._playersNameSubject.next(value);
  }

  public get dominusBoardsDto(): DominusBoardDto[] {
    return this._dominusBoardsDto;
  }

  get gameStateSubject(): Subject<GameDto> {
    return this._gameStateSubject;
  }

  get playersNameSubject(): Subject<string> {
    return this._playersNameSubject;
  }
}
