import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import { StartScreenComponent } from './screens/start-screen/start-screen.component';
import { ServerDisconnectedScreenComponent } from './screens/server-disconnected-screen/server-disconnected-screen.component';
import { GameLoadScreenComponent } from './screens/game-load-screen/game-load-screen.component';
import { LobbyScreenComponent } from './screens/lobby-screen/lobby-screen.component';
import { JoinGameScreenComponent } from './screens/join-game-screen/join-game-screen.component';
import { IntriguePhaseScreenComponent } from './screens/intrigue-phase-screen/intrigue-phase-screen.component';
import { MarketPhaseScreenComponent } from './screens/market-phase-screen/market-phase-screen.component';
import { ArenaPhaseScreenComponent } from './screens/arena-phase-screen/arena-phase-screen.component';
import { JupitersCockScreenComponent } from './screens/jupiters-cock-screen/jupiters-cock-screen.component';

@NgModule({
  declarations: [
    AppComponent,
    StartScreenComponent,
    ServerDisconnectedScreenComponent,
    GameLoadScreenComponent,
    LobbyScreenComponent,
    JoinGameScreenComponent,
    IntriguePhaseScreenComponent,
    MarketPhaseScreenComponent,
    ArenaPhaseScreenComponent,
    JupitersCockScreenComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
