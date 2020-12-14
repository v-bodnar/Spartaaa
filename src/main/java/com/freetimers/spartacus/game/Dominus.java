package com.freetimers.spartacus.game;

import com.freetimers.spartacus.game.exception.UnexpectedException;
import com.freetimers.spartacus.gamebox.*;

import java.util.List;

class Dominus {

private  DominusBoard dominusBoard;
private  Player activePlayer;
private  List<GladiatorCard> gladiators;
private  List<SlaveCard> slaves;
private  List<EquipmentCard> equipments;
private  List<IntrigueCard> hand;
private  Integer guardsNumber;
private  Integer goldCoins;
private  Integer influence;
private  boolean host;

    Dominus(DominusBoard dominusBoard, Player activePlayer, List<GladiatorCard> gladiators, List<SlaveCard> slaves,
            List<EquipmentCard> equipments, List<IntrigueCard> hand, Integer guardsNumber, Integer goldCoins,
            Integer influence, boolean host) {
        this.dominusBoard = dominusBoard;
        this.activePlayer = activePlayer;
        this.gladiators = gladiators;
        this.slaves = slaves;
        this.equipments = equipments;
        this.hand = hand;
        this.guardsNumber = guardsNumber;
        this.goldCoins = goldCoins;
        this.influence = influence;
        this.host = host;
    }

    void giveGold (Integer goldCoins){
        this.goldCoins += goldCoins;
    }

    void takeGold (Integer goldCoins){
        this.goldCoins -= goldCoins;
    }

    void increaseInfluence (Integer influence){
        this.influence += influence;
    }

    void decreaseInfluence (Integer influence){
        this.influence -= influence;
    }

    void giveCard( Card card){
        if (card instanceof GladiatorCard){
            gladiators.add((GladiatorCard) card);
        }else if (card instanceof SlaveCard){
            slaves.add((SlaveCard)card);
        }else if (card instanceof IntrigueCard){
            hand.add((IntrigueCard) card);
        }else if (card instanceof EquipmentCard){
            equipments.add((EquipmentCard) card);
        }else throw new UnexpectedException("Can not give card(s)");
    }

    void takeCard( Card card){
    if (card instanceof GladiatorCard){
        gladiators.remove(card);
    }else if (card instanceof SlaveCard){
        slaves.remove(card);
    }else if ( card instanceof IntrigueCard){
        hand.remove(card);
    }else throw new UnexpectedException("Can not remove card(s)");
    }

    void moveGuardFromHand(ReactionCard guard){
       if ( hand.remove(guard)){
           guardsNumber +=1;
       }
    }

    int getInfluence(){
        return influence;
    }

    void changeInfluence(int delta) {influence += delta;}


}
