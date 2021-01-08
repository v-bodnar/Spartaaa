import {NgModule} from '@angular/core';
import {Router, RouterModule, Routes} from '@angular/router';
import {ConnectionStateListener, RsocketService} from "./rsocket.service";
import {StartScreenComponent} from "./screens/start-screen/start-screen.component";
import {ServerDisconnectedScreenComponent} from "./screens/server-disconnected-screen/server-disconnected-screen.component";
import {LobbyScreenComponent} from "./screens/lobby-screen/lobby-screen.component";
import {IntriguePhaseScreenComponent} from "./screens/intrigue-phase-screen/intrigue-phase-screen.component";
import {MarketPhaseScreenComponent} from "./screens/market-phase-screen/market-phase-screen.component";
import {ArenaPhaseScreenComponent} from "./screens/arena-phase-screen/arena-phase-screen.component";
import {JoinGameScreenComponent} from "./screens/join-game-screen/join-game-screen.component";
import {JupitersCockScreenComponent} from "./screens/jupiters-cock-screen/jupiters-cock-screen.component";
import {GamePhaseListener, GameService} from "./game.service";
import {Phase} from "./dto/phase";

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
  constructor(private  rsocketService: RsocketService,
              private gameService: GameService,
              private router: Router) {
    this.rsocketService.registerStateListener(new ConnectionStateListenerImpl(this.rsocketService, this.gameService, this.router));
    this.gameService.registerGamePhaseListener(new RouterGamePhaseListener(this.router));
  }

  static navigateAccordingPhase(phase: Phase, router: Router){
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
}

export class ConnectionStateListenerImpl implements ConnectionStateListener {


  constructor(private  rsocketService: RsocketService,
              private gameService: GameService,
              private router: Router) {
  }

  onConnected(): void {
    if(this.gameService.currentGame){
      AppRoutingModule.navigateAccordingPhase(this.gameService.currentGame.gamePhase, this.router)
    }else{
      console.log('navigating to start')
      this.router.navigate(['/start']);
    }
  }

  onDisconnected(): void {
    console.log('navigating to error')
    this.router.navigate(['/connection-error']);
  }
}

export class RouterGamePhaseListener implements GamePhaseListener {
  constructor(private router: Router) {
  }

  onGamePhaseChange(phase: Phase) {
    AppRoutingModule.navigateAccordingPhase(phase, this.router)
  }
}
