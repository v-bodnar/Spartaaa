package com.freetimers.spartacus.dto;

import java.util.List;
import java.util.Objects;

public class DominusDto {

    private final DominusBoardDto dominusBoard;
    private final PlayerDto activePlayer;
    private final List<GladiatorCardDto> gladiators;
    private final  List<SlaveCardDto> slaves;
    private final  List<EquipmentCardDto> equipments;
    private final  List<IntrigueCardDto> hand;
    private final  Integer guardsNumber;
    private final  Integer goldCoins;
    private final  Integer influence;
    private final  boolean host;

    public DominusDto(DominusBoardDto dominusBoard, PlayerDto activePlayer, List<GladiatorCardDto> gladiators,
                      List<SlaveCardDto> slaves, List<EquipmentCardDto> equipments, List<IntrigueCardDto> hand,
                      Integer guardsNumber, Integer goldCoins, Integer influence, boolean host) {
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

    public DominusBoardDto getDominusBoard() {
        return dominusBoard;
    }

    public PlayerDto getActivePlayer() {
        return activePlayer;
    }

    public List<GladiatorCardDto> getGladiators() {
        return gladiators;
    }

    public List<SlaveCardDto> getSlaves() {
        return slaves;
    }

    public List<EquipmentCardDto> getEquipments() {
        return equipments;
    }

    public List<IntrigueCardDto> getHand() {
        return hand;
    }

    public Integer getGuardsNumber() {
        return guardsNumber;
    }

    public Integer getGoldCoins() {
        return goldCoins;
    }

    public Integer getInfluence() {
        return influence;
    }

    public boolean isHost() {
        return host;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DominusDto that = (DominusDto) o;
        return host == that.host &&
                Objects.equals(dominusBoard, that.dominusBoard) &&
                Objects.equals(activePlayer, that.activePlayer) &&
                Objects.equals(gladiators, that.gladiators) &&
                Objects.equals(slaves, that.slaves) &&
                Objects.equals(equipments, that.equipments) &&
                Objects.equals(hand, that.hand) &&
                Objects.equals(guardsNumber, that.guardsNumber) &&
                Objects.equals(goldCoins, that.goldCoins) &&
                Objects.equals(influence, that.influence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dominusBoard, activePlayer, gladiators, slaves, equipments, hand, guardsNumber, goldCoins, influence, host);
    }

    @Override
    public String toString() {
        return "DominusDto{" +
                "dominusBoard=" + dominusBoard +
                ", activePlayer=" + activePlayer +
                ", gladiators=" + gladiators +
                ", slaves=" + slaves +
                ", equipments=" + equipments +
                ", hand=" + hand +
                ", guardsNumber=" + guardsNumber +
                ", goldCoins=" + goldCoins +
                ", influence=" + influence +
                ", host=" + host +
                '}';
    }
}
