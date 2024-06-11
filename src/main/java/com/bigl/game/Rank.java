package com.bigl.game;

public enum Rank {
    ACE(11, "Ace"),
    KING(10, "King"),
    QUEEN(10, "Queen"),
    JACK(10, "Jack"),
    TEN(10, "Ten"),
    NINE(9, "Nine"),
    EIGHT(8, "Eight"),
    SEVEN(7, "Seven"),
    SIX(6, "Six"),
    FIVE(5, "Five"),
    FOUR(4, "Four"),
    THREE(3, "Three"),
    TWO(2, "Two");

    private int value;
    private String name;

    private Rank(int value, String name){
        this.value = value;
        this.name = name;
    }

    public int getValue(){
        return this.value;
    }

    public String toString(){
        return this.name;
    }
}
