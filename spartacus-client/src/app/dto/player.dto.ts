export class PlayerDto{
    name:string ;
    sessionToken:string ;
    gameOwner:boolean ;

  constructor(jsonObj: Object) {
    for (let prop in jsonObj) {
      this[prop] = jsonObj[prop];
    }
  }
}
