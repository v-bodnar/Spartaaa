import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import { StartScreenComponent } from './start-screen/start-screen.component';
import { ServerDisconnectedComponent } from './server-disconnected/server-disconnected.component';
import { GameLoadScreenComponent } from './game-load-screen/game-load-screen.component';
import { LobbyScreenComponent } from './lobby-screen/lobby-screen.component';
import { JoinGameScreenComponent } from './join-game-screen/join-game-screen.component';
import { IntriguePhaseScreenComponent } from './intrigue-phase-screen/intrigue-phase-screen.component';
import { MarketPhaseScreenComponent } from './market-phase-screen/market-phase-screen.component';
import { ArenaPhaseScreenComponent } from './arena-phase-screen/arena-phase-screen.component';
import { JupitersCockScreenComponent } from './jupiters-cock-screen/jupiters-cock-screen.component';

@NgModule({
  declarations: [
    AppComponent,
    StartScreenComponent,
    ServerDisconnectedComponent,
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
