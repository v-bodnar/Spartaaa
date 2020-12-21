import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import { StartScreenComponent } from './start-screen/start-screen.component';
import { ServerDisconnectedComponent } from './server-disconnected/server-disconnected.component';

@NgModule({
  declarations: [
    AppComponent,
    StartScreenComponent,
    ServerDisconnectedComponent
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
