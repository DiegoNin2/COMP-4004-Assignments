package org.example;

import java.util.ArrayList;

public class Player {
    private int shields;
    private ArrayList<Card> hand;
    private String id;
    private boolean winnerStatus;
    private ArrayList<Card> attackHand;

    public Player(String id, int shields) {
        this.id = id;
        this.shields = shields;
        this.hand = new ArrayList<Card>();
        this.winnerStatus = false;
        this.attackHand = new ArrayList<Card>();
    }

    //getters

    public int getShields() {return shields;}
    public ArrayList<Card> getHand() {return hand;}
    public String getId() {return id;}
    public int getHandSize() {return hand.size();}
    public int getAttackHandSize() {return attackHand.size();}
    public boolean getWinnerStatus() {return winnerStatus;}

    //setters

    public void setShields(int amount) {shields = amount;}
    public void setWinnerStatus(boolean status) {winnerStatus = status;}

    //other methods

    public void addCard(Card c) {
        hand.add(c);
    }

    public void addCardAt(int i, Card c) {
        hand.add(i,c);
    }

    public void addAttackCard(Card c) {
        attackHand.add(c);
    }

    public void removeCard(Card c) {
        hand.remove(c);
    }

    public Card removeCardAt(int i) {
        return hand.remove(i);
    }

    public Card getCardAt(int i) {
        return hand.get(i);
    }

    public Card getAttackCardAt(int i) {
        return attackHand.get(i);
    }

}
