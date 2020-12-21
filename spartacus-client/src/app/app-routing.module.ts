import {NgModule} from '@angular/core';
import {Router, RouterModule, Routes} from '@angular/router';
import {StartScreenComponent} from "./start-screen/start-screen.component";
import {ServerDisconnectedComponent} from "./server-disconnected/server-disconnected.component";
import {ConnectionStateListener, RsocketService} from "./rsocket.service";
import {GameLoadScreenComponent} from "./game-load-screen/game-load-screen.component";
import {JoinGameScreenComponent} from "./join-game-screen/join-game-screen.component";
import {LobbyScreenComponent} from "./lobby-screen/lobby-screen.component";
import {IntriguePhaseScreenComponent} from "./intrigue-phase-screen/intrigue-phase-screen.component";
import {MarketPhaseScreenComponent} from "./market-phase-screen/market-phase-screen.component";
import {ArenaPhaseScreenComponent} from "./arena-phase-screen/arena-phase-screen.component";

const routes: Routes = [
  {path: 'start', component: StartScreenComponent},
  {path: 'connection-error', component: ServerDisconnectedComponent},
  {path: 'load', component: GameLoadScreenComponent},
  {path: 'join', component: JoinGameScreenComponent},
  {path: 'lobby', component: LobbyScreenComponent},
  {path: 'intrigue', component: IntriguePhaseScreenComponent},
  {path: 'market', component: MarketPhaseScreenComponent},
  {path: 'arena', component: ArenaPhaseScreenComponent},
  {path: '**', component: ServerDisconnectedComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
  constructor(private  rsocketService: RsocketService,
              public router: Router) {
    this.rsocketService.registerStateListener(new ConnectionStateListenerImpl(this.rsocketService, this.router));
  }
}

export class ConnectionStateListenerImpl implements ConnectionStateListener {


  constructor(private  rsocketService: RsocketService,
              private router: Router) {
  }

  onConnected(): void {
    console.log('navigating to start')
    this.router.navigate(['/start']);
  }

  onDisconnected(): void {
    console.log('navigating to error')
    this.router.navigate(['/connection-error']);
  }

}
