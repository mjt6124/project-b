package com.bigl.game;
public enum Suit {
    SPADES("Spades"),
    DIAMONDS("Diamonds"),
    CLUBS("Clubs"),
    HEARTS("Hearts");
    

    private String name;

    private Suit(String name){
        this.name = name;
    }

    public String toString(){
        return this.name;
    }

}
