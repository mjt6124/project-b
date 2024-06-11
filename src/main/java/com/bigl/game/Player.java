
package com.bigl.game;
import java.util.ArrayList;

public class Player {

    public String name;
    public ArrayList<Card> hand;

    public Player(String name){
        this.name = name;
        this.hand = new ArrayList<Card>();
    }

    public void addCard(Card card){
        hand.add(card);
    }
    
    public ArrayList<Card> discardHand(){
        ArrayList<Card> discards = hand;
        this.hand = new ArrayList<Card>();
        return discards;
    }
    
    public String toString(){
        if(hand.size() == 0){
            return name + ":\t\tFolded";
        }
        else{
            return this.name + ":\t\t" + hand; 
        }
        
    }
}
