export class DominusBoardDto {
  id: String;
  titleKey: String;
  title: String;
  descriptionKey: String;
  description: String;
  startingGold: Number;
  startingGladiators: Number;
  startingSlaves: Number;
  startingGuards: Number;

  constructor(jsonObj: Object) {
    for (let prop in jsonObj) {
      this[prop] = jsonObj[prop];
    }
  }


}
