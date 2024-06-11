package com.bigl.game;

public class Card {
    
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }
    
    public String toString(){
        return rank + " of " + suit;
    }

}
