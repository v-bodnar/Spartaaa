import {NgModule} from '@angular/core';
import {Router, RouterModule, Routes} from '@angular/router';
import {StartScreenComponent} from "./start-screen/start-screen.component";
import {ServerDisconnectedComponent} from "./server-disconnected/server-disconnected.component";
import {ConnectionStateListener, RsocketService} from "./rsocket.service";

const routes: Routes = [
  {path: 'start', component: StartScreenComponent},
  {path: 'connection-error', component: ServerDisconnectedComponent},
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
