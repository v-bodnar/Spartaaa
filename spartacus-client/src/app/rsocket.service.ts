import {Injectable} from '@angular/core';
import type {Payload, ReactiveSocket,} from 'rsocket-types';
import {IdentitySerializer, JsonSerializer, RSocketClient} from 'rsocket-core';
import {Flowable, Single} from 'rsocket-flowable';
import RSocketWebSocketClient from 'rsocket-websocket-client';
import {Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class RsocketService {
  private socket: ReactiveSocket<string, string>
  private _connected: boolean;
  private _connectedSubject: Subject<boolean> = new Subject<boolean>();

  constructor() {
    this._connected = false;
    this.connect().subscribe({
      onComplete: (socket) => {
        this.socket = socket;
        this.socket.connectionStatus().subscribe(
          status => {
            console.log('Connection status:', status);
            this._connectedSubject.next(status.kind==='CONNECTED')
          }
        );
        this._connected = true;
        console.log('WS connected')
      },
      onError: error => {
        console.error("Error in ws connect: %s", error)
        this._connectedSubject.next(false)
      }
    });
  }

  private getClientTransport() {
    return new RSocketWebSocketClient({
      url: 'ws://localhost:8080/spartacus'
    });
  }

  private connect(): Single<ReactiveSocket<string, string>> {
    const client = new RSocketClient({
      serializers: {
        data: JsonSerializer,
        metadata: IdentitySerializer
      },
      setup: {
        // ms btw sending keepalive to server
        keepAlive: 60000,
        // ms timeout if no keepalive response
        lifetime: 180000,
        // format of `data`
        dataMimeType: 'application/json',
        // format of `metadata`
        metadataMimeType: 'message/x.rsocket.routing.v0',
      },
      transport: this.getClientTransport(),
    });
    return client.connect();
  }

  /**
   * This method sends data/metadata to the server, which returns a single response. The data is sent lazily when the
   * returned Single is subscribed to.
   */
  public requestResponse(data, endpoint: string): Single<Payload<string, string>> {
    return this.socket.requestResponse({
      data: data,
      metadata: String.fromCharCode(endpoint.length) + endpoint,
    });
  }

  /**
   * This method sends data/metadata to the server without waiting for a response. The data is sent immediately.
   */
  public fireAndForget(data: string, endpoint: string): void {
    return this.socket.requestResponse({
      data: data,
      metadata: String.fromCharCode(endpoint.length) + endpoint,
    });
  }

  /**
   *
   This method sends data/metadata to the server, which returns a stream of responses. The semantics of the stream are
   application-specific. For example, the stream may represent updates to a single conceptual value over time, items in
   an incrementally loaded list, events, etc. The data is sent to the peer lazily when the returned Flowable is
   subscribed to and request(n) is called to signal demand.
   */
  public requestStream(data: string, endpoint: string): Flowable<Payload<string, string>> {
    return this.socket.requestStream({
      data: data,
      metadata: String.fromCharCode(endpoint.length) + endpoint,
    });
  }

  /**
   * This method establishes an understanding between a client and a server where each intends to send and receive
   * streams of data from the other. Each actor in this relationship is responsible for signaling to the other that
   * they are ready to receive data by invoking request(n), where n is the max number of payloads the actor is
   * comfortable handling. Conceptually, requestChannel can be thought of as two entities 'polling' from each other by
   * signaling to the others that they are ready to accept n number of messages. Inversely, requestChannel can be
   * leveraged to facilitate a consistent stream of data transfer payloads between client and server by each (or either)
   * invoking request(0x7fffffff), where 0x7fffffff is the max integer value for int32.
   */
  public requestChannel(data: string, endpoint: string): Flowable<Payload<string, string>> {
    return this.socket.requestStream({
      data: data,
      metadata: String.fromCharCode(endpoint.length) + endpoint,
    });
  }


  public isConnected(): boolean {
    return this._connected;
  }


  get connectedSubject(): Subject<boolean> {
    return this._connectedSubject;
  }
}
