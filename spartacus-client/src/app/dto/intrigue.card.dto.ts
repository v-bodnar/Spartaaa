export class IntrigueCardDto {
  title:string;
  description:string;
  price:number;
  requiredInfluence:number;

  constructor(jsonObj: Object) {
    for (let prop in jsonObj) {
      this[prop] = jsonObj[prop];
    }
  }
}
