import {DominusBoardDto} from "./dominus.board.dto";
import {PlayerDto} from "./player.dto";
import {GladiatorCardDto} from "./gladiator.card.dto";
import {SlaveCardDto} from "./slave,card.dto";
import {EquipmentCardDto} from "./equipment.card.dto";
import {IntrigueCardDto} from "./intrigue.card.dto";

export class DominusDto {
   dominusBoard: DominusBoardDto ;
   player:PlayerDto ;
   gladiators:GladiatorCardDto[] ;
   slaves:SlaveCardDto[];
   equipment:EquipmentCardDto[] ;
   hand:IntrigueCardDto[];
   guardsNumber:number ;
   goldCoins:number ;
   influence:number ;
   host:boolean ;

  constructor(jsonObj: Object) {
    for (let prop in jsonObj) {
      this[prop] = jsonObj[prop];
    }
  }
}
