package com.freetimers.spartacus.game;

public class Dominus {
    private int influence;
    public int getInfluence(){
        return influence;
    }

    public int changeInfluence(int delta){
        return influence += delta;
    }
}
