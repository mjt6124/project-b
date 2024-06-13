package com.bigl.game;
import java.util.ArrayList;

public class Table {

    public ArrayList<Player> players;
    public ArrayList<Card> communityCards;
    private Deck deck;
    private Deck discard;

    public Table(){
        this.players = new ArrayList<Player>();
        this.communityCards = new ArrayList<Card>();
        this.deck = new Deck();
        this.deck.shuffle();
        this.discard = new Deck(new ArrayList<Card>());
    }

    public void playRound(){
        preRound();
        dealCards();
        dealFlop();
        dealTurn();
        dealRiver();
        calcHands();
        resetRound();
    }

    private void calcHands(){
        
    }

    private void resetRound(){
        while(communityCards.size() > 0){
            discard.addCard(this.communityCards.remove(0));
        }
        for (Player player : this.players) {
                this.discard.addCards(player.discardHand());
        }
    }

    private void dealFlop(){
        // burn card
        discard.addCard(this.deck.draw());
        communityCards.add(this.deck.draw());
        communityCards.add(this.deck.draw());
        communityCards.add(this.deck.draw());
    }

    private void dealTurn(){
        discard.addCard(this.deck.draw());
        communityCards.add(this.deck.draw());
    }

    private void dealRiver(){
        discard.addCard(this.deck.draw());
        communityCards.add(this.deck.draw());
    }

    private void dealCards(){
        for (Player player : this.players) {
            player.addCard(deck.draw());
        }
        for (Player player : this.players) {
            player.addCard(deck.draw());
        }
    }

    private void preRound(){
        if(!checkCap()){
            returnDiscard();
        }
    }

    private boolean checkCap(){
        if(deck.size() >= ((players.size() * 2) + 8)){
            return true;
        }
        else{
            return false;
        }
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public void addPlayers(String[] players){
        for (String player : players) {
            this.addPlayer(new Player(player));
        }
    }
    
    public void returnDiscard(){
        while(discard.hasCards()){
            Card temp = discard.draw();
            deck.addCard(temp);
        }
        shuffleDeck();
    }

    public void shuffleDeck(){
        this.deck.shuffle();
    }

    public String toString(){
        String string = "Gamestate:\n";
        for (Player player : players) {
            string = string + player + "\n";
        }
        string = string + "\n" + "Community:\t";
        for (Card card : communityCards) {
            string = string + card + ", ";
        }

        return string;
    }
}
