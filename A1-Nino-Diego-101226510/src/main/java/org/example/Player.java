package org.example;

import java.util.ArrayList;

public class Player {
    private int shields = -1;
    private ArrayList<Card> hand = new ArrayList<Card>();
    private String id;
    private boolean winnerStatus;

    //getters
    public int getShields() {return shields;}
    public ArrayList<Card> getHand() {return hand;}
    public String getId() {return id;}
    public int getHandSize() {return hand.size();}
    public boolean getWinnerStatus() {return winnerStatus;}

    //setters
    public void setShields(int amount) {shields = amount;}
    public void addShields(int amount) {shields += amount;}
    public void setID (String newID) {id = newID;}
    public void setWinnerStatus(boolean status) {winnerStatus = status;}

}
