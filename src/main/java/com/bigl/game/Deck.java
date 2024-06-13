
package com.bigl.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Deck {

    private static ArrayList<Suit> freshTopHalfSuitOrder = new ArrayList<Suit>(  
        Arrays.asList(
            Suit.HEARTS,
            Suit.CLUBS
        )
    );

    private static ArrayList<Suit> freshBottomHalfSuitOrder = new ArrayList<Suit>(  
        Arrays.asList(
            Suit.DIAMONDS,
            Suit.SPADES
        )
    );

    private static ArrayList<Rank> freshRankOrder = new ArrayList<Rank>(
        Arrays.asList(
            Rank.KING,
            Rank.QUEEN,
            Rank.JACK,
            Rank.TEN,
            Rank.NINE,
            Rank.EIGHT,
            Rank.SEVEN,
            Rank.SIX,
            Rank.FIVE,
            Rank.FOUR,
            Rank.THREE,
            Rank.TWO,
            Rank.ACE
        )
    );

    private ArrayList<Card> cards; 

    public Deck(){
        cards = new ArrayList<Card>();
        for (Suit suit: freshTopHalfSuitOrder) {
            for (Rank rank : reverse(freshRankOrder)) {
                cards.add(new Card(rank, suit));
            }
        }
        for (Suit suit: freshBottomHalfSuitOrder) {
            for (Rank rank : freshRankOrder) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    public Deck(ArrayList<Card> cards){
        this.cards = cards;
    }

    public Card draw(){
        return this.cards.remove(0);
    }

    public void addCard(Card card){
        this.cards.add(0, card);
    }

    public void addCards(ArrayList<Card> cards){
        for (Card card : cards) {
            this.addCard(card);
        }
    }

    public int size(){
        return this.cards.size();
    }

    public void shuffle(){
        Collections.shuffle(this.cards);
    }

    public boolean hasCards(){
        if(this.cards.size() > 0){
            return true;
        }
        else{
            return false;
        }
    }

    public String toString(){
        String string = "Deck (" + cards.size() + "):\n";
        for (Card card : this.cards) {
            string = string + "\t" + card.toString() + "\n";
        }
        return string;
    }

    public static <E> ArrayList<E> reverse(ArrayList<E> arrayList){
        ArrayList<E> newArrayList = new ArrayList<E>();
        for(int i = arrayList.size() - 1 ; i >= 0 ; i-- ) {
            newArrayList.add(arrayList.get(i));
        }
        return newArrayList;
    }
}
