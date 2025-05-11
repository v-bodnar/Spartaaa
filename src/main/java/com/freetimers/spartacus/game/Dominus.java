package com.freetimers.spartacus.game;

import com.freetimers.spartacus.game.exception.UnexpectedException;
import com.freetimers.spartacus.gamebox.*;

import java.util.LinkedList;
import java.util.List;

class Dominus {

    private DominusBoard dominusBoard;
    private Player player;
    private List<GladiatorCard> gladiators = new LinkedList<>();
    private List<SlaveCard> slaves = new LinkedList<>();
    private List<EquipmentCard> equipment = new LinkedList<>();
    private List<IntrigueCard> hand = new LinkedList<>();
    private List<GuardCard> guards = new LinkedList<>();
    private Integer goldCoins = 0;
    private Integer influence = 0;
    private boolean host = false;

    Dominus(DominusBoard dominusBoard, Player player) {
        this.dominusBoard = dominusBoard;
        this.player = player;
    }


    void giveGold(Integer goldCoins) {
        this.goldCoins += goldCoins;
    }

    void takeGold(Integer goldCoins) {
        this.goldCoins -= goldCoins;
    }

    void increaseInfluence(Integer influence) {
        this.influence += influence;
    }

    void decreaseInfluence(Integer influence) {
        this.influence -= influence;
    }

    void setInfluence(int influence) {
        this.influence = influence;
    }

    public DominusBoard getDominusBoard() {
        return dominusBoard;
    }

    public void setPlayersSessionId(String sessionId) {
        player = new Player(player.getName(), sessionId, player.getAvatar(), player.isGameOwner());
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

    public List<GuardCard> getGuards() {
        return guards;
    }

    public Integer getGoldCoins() {
        return goldCoins;
    }

    public boolean isHost() {
        return host;
    }

    void giveCard(Card card) {
        if (card instanceof GladiatorCard gladiatorCard) {
            gladiators.add(gladiatorCard);
        } else if (card instanceof SlaveCard slaveCard) {
            slaves.add(slaveCard);
        }else if (card instanceof GuardCard guardCard) {
            guards.add(guardCard);
        } else if (card instanceof IntrigueCard intrigueCard) {
            hand.add(intrigueCard);
        } else if (card instanceof EquipmentCard equipmentCard) {
            equipment.add(equipmentCard);
        } else throw new UnexpectedException("Can not give card(s)");
    }

    void giveCards(List<? extends Card> cards) {
        cards.forEach(this::giveCard);
    }

    void takeCard(Card card) {
        if (card instanceof GladiatorCard) {
            gladiators.remove(card);
        } else if (card instanceof SlaveCard) {
            slaves.remove(card);
        } else if (card instanceof IntrigueCard) {
            hand.remove(card);
        } else throw new UnexpectedException("Can not remove card(s)");
    }

    public String getPlayersName() {
        return player.getName();
    }

    int getInfluence() {
        return influence;
    }

    void changeInfluence(int delta) {
        influence += delta;
    }


    @Override
    public String toString() {
        return "Dominus{" +
                "dominusBoard=" + dominusBoard +
                ", player=" + player +
                ", gladiators=" + gladiators +
                ", slaves=" + slaves +
                ", equipment=" + equipment +
                ", hand=" + hand +
                ", guardsNumber=" + guards +
                ", goldCoins=" + goldCoins +
                ", influence=" + influence +
                ", host=" + host +
                '}';
    }
}
