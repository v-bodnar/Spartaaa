package com.freetimers.spartacus.game;

import com.freetimers.spartacus.game.exception.UnexpectedException;
import com.freetimers.spartacus.gamebox.*;

import java.util.List;

class Dominus {

private  DominusBoard dominusBoard;
private  Player player;
private  List<GladiatorCard> gladiators;
private  List<SlaveCard> slaves;
private  List<EquipmentCard> equipment;
private  List<IntrigueCard> hand;
private  Integer guardsNumber;
private  Integer goldCoins;
private  Integer influence;
private  boolean host;

    Dominus(DominusBoard dominusBoard, Player player, List<GladiatorCard> gladiators, List<SlaveCard> slaves,
            List<EquipmentCard> equipment, List<IntrigueCard> hand) {
        this.dominusBoard = dominusBoard;
        this.player = player;
        this.gladiators = gladiators;
        this.slaves = slaves;
        this.equipment = equipment;
        this.hand = hand;
        this.guardsNumber = dominusBoard.getStartingGuards();
        this.goldCoins = dominusBoard.getStartingGold();
        this.influence = 1;
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

    public DominusBoard getDominusBoard() {
        return dominusBoard;
    }

    public Player getPlayer() {
        return player;
    }

    public List<GladiatorCard> getGladiators() {
        return gladiators;
    }

    public List<SlaveCard> getSlaves() {
        return slaves;
    }

    public List<EquipmentCard> getEquipment() {
        return equipment;
    }

    public List<IntrigueCard> getHand() {
        return hand;
    }

    public Integer getGuardsNumber() {
        return guardsNumber;
    }

    public Integer getGoldCoins() {
        return goldCoins;
    }

    public boolean isHost() {
        return host;
    }

    void giveCard(Card card){
        if (card instanceof GladiatorCard){
            gladiators.add((GladiatorCard) card);
        }else if (card instanceof SlaveCard){
            slaves.add((SlaveCard)card);
        }else if (card instanceof IntrigueCard){
            hand.add((IntrigueCard) card);
        }else if (card instanceof EquipmentCard){
            equipment.add((EquipmentCard) card);
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

    public String getPlayersName() {
        return player.getName();
    }

    int getInfluence(){
        return influence;
    }

    void changeInfluence(int delta) {influence += delta;}


    @Override
    public String toString() {
        return "Dominus{" +
                "dominusBoard=" + dominusBoard +
                ", player=" + player +
                ", gladiators=" + gladiators +
                ", slaves=" + slaves +
                ", equipment=" + equipment +
                ", hand=" + hand +
                ", guardsNumber=" + guardsNumber +
                ", goldCoins=" + goldCoins +
                ", influence=" + influence +
                ", host=" + host +
                '}';
    }
}
