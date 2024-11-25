package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck;
    private ArrayList<Card> discardDeck;
    private String type;

    public Deck(String t) {
        deck = new ArrayList<Card>();
        discardDeck = new ArrayList<Card>();
        type = t;
    }

    public void initializeDeck(String type) {
        if (type.equals("adventure")) {
            initializeAdventureDeck();
            shuffle();
        } else {
            initializeEventDeck();
            shuffle();
        }
    }

    private void initializeAdventureDeck() {
        //Weapon cards
        for (int i = 0; i < 6; i++) {
            switch(i) {
                case 0:
                    for (int j = 0; j < 6; j++) {
                        Card card = new Card("Weapon","Dagger","5");
                        deck.add(card);
                    }
                    break;
                case 1:
                    for (int j = 0; j < 12; j++) {
                        Card card = new Card("Weapon","Horse","10");
                        deck.add(card);
                    }
                    break;
                case 2:
                    for (int j = 0; j < 16; j++) {
                        Card card = new Card("Weapon","Sword","10");
                        deck.add(card);
                    }
                    break;
                case 3:
                    for (int j = 0; j < 8; j++) {
                        Card card = new Card("Weapon","Battle-Axe","15");
                        deck.add(card);
                    }
                    break;
                case 4:
                    for (int j = 0; j < 6; j++) {
                        Card card = new Card("Weapon","Lance","20");
                        deck.add(card);
                    }
                    break;
                case 5:
                    for (int j = 0; j < 2; j++) {
                        Card card = new Card("Weapon","Excalibur","30");
                        deck.add(card);
                    }
                    break;
            }
        }

        //Foe cards
        for (int i = 0; i < 10; i++) {
            switch(i) {
                case 0:
                    for (int j = 0; j < 8; j++) {
                        Card card = new Card("Foe","F5","5");
                        deck.add(card);
                    }
                    break;
                case 1:
                    for (int j = 0; j < 7; j++) {
                        Card card = new Card("Foe","F10","10");
                        deck.add(card);
                    }
                    break;
                case 2:
                    for (int j = 0; j < 8; j++) {
                        Card card = new Card("Foe","F15","15");
                        deck.add(card);
                    }
                    break;
                case 3:
                    for (int j = 0; j < 7; j++) {
                        Card card = new Card("Foe","F20","20");
                        deck.add(card);
                    }
                    break;
                case 4:
                    for (int j = 0; j < 7; j++) {
                        Card card = new Card("Foe","F25","25");
                        deck.add(card);
                    }
                    break;
                case 5:
                    for (int j = 0; j < 4; j++) {
                        Card card = new Card("Foe","F30","30");
                        deck.add(card);
                    }
                    break;
                case 6:
                    for (int j = 0; j < 4; j++) {
                        Card card = new Card("Foe","F35","35");
                        deck.add(card);
                    }
                    break;
                case 7:
                    for (int j = 0; j < 2; j++) {
                        Card card = new Card("Foe","F40","40");
                        deck.add(card);
                    }
                    break;
                case 8:
                    for (int j = 0; j < 2; j++) {
                        Card card = new Card("Foe","F50","50");
                        deck.add(card);
                    }
                    break;
                case 9:
                    Card card = new Card("Foe","F70","70");
                    deck.add(card);
                    break;
            }
        }
    }

    private void initializeEventDeck() {
        //Event cards
        for (int i = 0; i < 3; i++) {
            switch(i) {
                case 0:
                    for (int j = 0; j < 2; j++) {
                        Card card = new Card("Event","Queen's Favor", "+2P");
                        deck.add(card);
                    }
                    break;
                case 1:
                    for (int j = 0; j < 2; j++) {
                        Card card = new Card("Event", "Prosperity", "+2All");
                        deck.add(card);
                    }
                    break;
                case 2:
                    Card card = new Card("Event","Plague","-2Sh");
                    deck.add(card);
                    break;
            }
        }

        //Quest cards
        for (int i = 0; i < 4; i++) {
            switch(i) {
                case 0:
                    for (int j = 0; j < 3; j++) {
                        Card card = new Card("Quest", "2 Stage Quest", "Q2");
                        deck.add(card);
                    }
                    break;
                case 1:
                    for (int j = 0; j < 4; j++) {
                        Card card = new Card("Quest", "3 Stage Quest", "Q3");
                        deck.add(card);
                    }
                    break;
                case 2:
                    for (int j = 0; j < 3; j++) {
                        Card card = new Card("Quest", "4 Stage Quest", "Q4");
                        deck.add(card);
                    }
                    break;
                case 3:
                    for (int j = 0; j < 2; j++) {
                        Card card = new Card("Quest", "5 Stage Quest", "Q5");
                        deck.add(card);
                    }
                    break;
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public Card drawCard() {
        if (deck.isEmpty()) {
            reshuffleAndReinsert();
        }

        Card drawnCard = null;
        drawnCard = deck.remove(0);
        return drawnCard;
    }

    public void addToDiscard(Card c) {
        discardDeck.add(c);
    }

    private void reshuffleAndReinsert() {
        deck.addAll(discardDeck);
        shuffle();
        discardDeck.clear();
    }

    public int size() {
        return deck.size();
    }

    public int discardSize() {
        return discardDeck.size();
    }

    public String getType() { return type; }

}
