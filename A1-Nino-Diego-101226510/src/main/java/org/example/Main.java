package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

    }

    class Card {
        String type;
        String value;
        String name;

    }

    ArrayList<Card> adventureDeck = new ArrayList<Card>();
    ArrayList<Card> eventDeck = new ArrayList<Card>();

    public void initializeDecks() {

    }

    public int getAdventureDeckSize() {
        return 0;
    }

    public int getEventDeckSize() {
        return 0;
    }

    public Card DrawCard() {
        return new Card();
    }


}