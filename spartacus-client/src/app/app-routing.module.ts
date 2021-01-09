import {NgModule} from '@angular/core';
import {Router, RouterModule, Routes} from '@angular/router';
import {RsocketService} from "./rsocket.service";
import {StartScreenComponent} from "./screens/start-screen/start-screen.component";
import {ServerDisconnectedScreenComponent} from "./screens/server-disconnected-screen/server-disconnected-screen.component";
import {LobbyScreenComponent} from "./screens/lobby-screen/lobby-screen.component";
import {IntriguePhaseScreenComponent} from "./screens/intrigue-phase-screen/intrigue-phase-screen.component";
import {MarketPhaseScreenComponent} from "./screens/market-phase-screen/market-phase-screen.component";
import {ArenaPhaseScreenComponent} from "./screens/arena-phase-screen/arena-phase-screen.component";
import {JoinGameScreenComponent} from "./screens/join-game-screen/join-game-screen.component";
import {JupitersCockScreenComponent} from "./screens/jupiters-cock-screen/jupiters-cock-screen.component";
import {GameService} from "./game.service";
import {Phase} from "./dto/phase";
import {GameDto} from "./dto/game.dto";

const routes: Routes = [
  {path: 'start', component: StartScreenComponent},
  {path: 'join', component: JoinGameScreenComponent},
  {path: 'lobby', component: LobbyScreenComponent},
  {path: 'intrigue', component: IntriguePhaseScreenComponent},
  {path: 'market', component: MarketPhaseScreenComponent},
  {path: 'arena', component: ArenaPhaseScreenComponent},
  {path: 'jupiters-cock', component: JupitersCockScreenComponent},
  {path: 'connection-error', component: ServerDisconnectedScreenComponent},
  {path: '**', component: ServerDisconnectedScreenComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
  phase: Phase;

  constructor(private  rsocketService: RsocketService,
              private gameService: GameService,
              private router: Router) {
    this.rsocketService.connectedSubject.subscribe(value => this.onConnectionStateChanged(value));
    this.gameService.gameStateSubject.subscribe(value => this.onGamePhaseChange(value));
  }

  onGamePhaseChange(gameDto: GameDto) {
    if (this.phase !== gameDto.gamePhase) {
      this.phase = gameDto.gamePhase;
      AppRoutingModule.navigateAccordingPhase(gameDto.gamePhase, this.router)
    } else {
      console.log("Phase did not change")
    }

  }

  static navigateAccordingPhase(phase: Phase, router: Router) {
    if (phase.toString() === "LOBBY") {
      console.log('navigating to LOBBY')
      router.navigate(['/lobby']);
    } else if (phase.toString() === "UPKEEP") {
      console.log('navigating to UPKEEP')
      router.navigate(['/upkeep']);
    } else if (phase.toString() === "INTRIGUE") {
      console.log('navigating to INTRIGUE')
      router.navigate(['/intrigue']);
    } else if (phase.toString() === "MARKET") {
      console.log('navigating to MARKET')
      router.navigate(['/market']);
    } else if (phase.toString() === "ARENA") {
      console.log('navigating to ARENA')
      router.navigate(['/arena']);
    } else if (phase.toString() === "AWARDS") {
      console.log('navigating to jupiters-cock')
      router.navigate(['/jupiters-cock']);
    }
  }

  onConnectionStateChanged(connected: boolean): void {
    if (connected) {
      if (this.gameService.currentGame) {
        AppRoutingModule.navigateAccordingPhase(this.gameService.currentGame.gamePhase, this.router)
      } else {
        console.log('navigating to start')
        this.router.navigate(['/start']);
      }
    } else {
      console.log('navigating to error')
      this.router.navigate(['/connection-error']);
    }
  }
}

