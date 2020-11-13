export class Gladiator {
  id: String;
  price: Number;
  description: String;
  title: String;
  attack: Number;
  defence: Number;
  speed: Number;

  constructor(jsonObj: Object) {
    for (let prop in jsonObj) {
      this[prop] = jsonObj[prop];
    }
  }
}
