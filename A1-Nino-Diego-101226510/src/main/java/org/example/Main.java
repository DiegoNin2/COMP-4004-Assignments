package org.example;

import java.util.ArrayList;
import java.util.Collections;

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
    ArrayList<Card> p1Hand = new ArrayList<Card>();
    ArrayList<Card> p2Hand = new ArrayList<Card>();
    ArrayList<Card> p3Hand = new ArrayList<Card>();
    ArrayList<Card> p4Hand = new ArrayList<Card>();
    int p1Shields = 0;
    int p2Shields = 0;
    int p3Shields = 0;
    int p4Shields = 0;

    public void initializeDecks() {
        adventureDeck = new ArrayList<Card>();
        eventDeck = new ArrayList<Card>();

        //Adventure deck set up

        //Weapon cards
        for (int i = 0; i < 6; i++) {
            switch(i) {
                case 0:
                    for (int j = 0; j < 6; j++) {
                        Card card = new Card();
                        card.type = "Weapon";
                        card.name = "Dagger";
                        card.value = "5";
                        adventureDeck.add(card);
                    }
                    break;
                case 1:
                    for (int j = 0; j < 12; j++) {
                        Card card = new Card();
                        card.type = "Weapon";
                        card.name = "Horse";
                        card.value = "10";
                        adventureDeck.add(card);
                    }
                    break;
                case 2:
                    for (int j = 0; j < 16; j++) {
                        Card card = new Card();
                        card.type = "Weapon";
                        card.name = "Sword";
                        card.value = "10";
                        adventureDeck.add(card);
                    }
                    break;
                case 3:
                    for (int j = 0; j < 8; j++) {
                        Card card = new Card();
                        card.type = "Weapon";
                        card.name = "Battle-Axe";
                        card.value = "15";
                        adventureDeck.add(card);
                    }
                    break;
                case 4:
                    for (int j = 0; j < 6; j++) {
                        Card card = new Card();
                        card.type = "Weapon";
                        card.name = "Lance";
                        card.value = "20";
                        adventureDeck.add(card);
                    }
                    break;
                case 5:
                    for (int j = 0; j < 2; j++) {
                        Card card = new Card();
                        card.type = "Weapon";
                        card.name = "Excalibur";
                        card.value = "30";
                        adventureDeck.add(card);
                    }
                    break;
            }
        }

        //Foe cards
        for (int i = 0; i < 10; i++) {
            switch(i) {
                case 0:
                    for (int j = 0; j < 8; j++) {
                        Card card = new Card();
                        card.type = "Foe";
                        card.name = "F5";
                        card.value = "5";
                        adventureDeck.add(card);
                    }
                    break;
                case 1:
                    for (int j = 0; j < 7; j++) {
                        Card card = new Card();
                        card.type = "Foe";
                        card.name = "F10";
                        card.value = "10";
                        adventureDeck.add(card);
                    }
                    break;
                case 2:
                    for (int j = 0; j < 8; j++) {
                        Card card = new Card();
                        card.type = "Foe";
                        card.name = "F15";
                        card.value = "15";
                        adventureDeck.add(card);
                    }
                    break;
                case 3:
                    for (int j = 0; j < 7; j++) {
                        Card card = new Card();
                        card.type = "Foe";
                        card.name = "F20";
                        card.value = "20";
                        adventureDeck.add(card);
                    }
                    break;
                case 4:
                    for (int j = 0; j < 7; j++) {
                        Card card = new Card();
                        card.type = "Foe";
                        card.name = "F25";
                        card.value = "25";
                        adventureDeck.add(card);
                    }
                    break;
                case 5:
                    for (int j = 0; j < 4; j++) {
                        Card card = new Card();
                        card.type = "Foe";
                        card.name = "F30";
                        card.value = "30";
                        adventureDeck.add(card);
                    }
                    break;
                case 6:
                    for (int j = 0; j < 4; j++) {
                        Card card = new Card();
                        card.type = "Foe";
                        card.name = "F35";
                        card.value = "35";
                        adventureDeck.add(card);
                    }
                    break;
                case 7:
                    for (int j = 0; j < 2; j++) {
                        Card card = new Card();
                        card.type = "Foe";
                        card.name = "F40";
                        card.value = "40";
                        adventureDeck.add(card);
                    }
                    break;
                case 8:
                    for (int j = 0; j < 2; j++) {
                        Card card = new Card();
                        card.type = "Foe";
                        card.name = "F50";
                        card.value = "50";
                        adventureDeck.add(card);
                    }
                    break;
                case 9:
                    Card card = new Card();
                    card.type = "Foe";
                    card.name = "F70";
                    card.value = "70";
                    adventureDeck.add(card);
                    break;
            }
        }
        Collections.shuffle(adventureDeck);

        //Event deck set up

        //Event cards
        for (int i = 0; i < 3; i++) {
            switch(i) {
                case 0:
                    for (int j = 0; j < 2; j++) {
                        Card card = new Card();
                        card.type = "Event";
                        card.name = "Queen's Favor";
                        card.value = "+2P";
                        eventDeck.add(card);
                    }
                    break;
                case 1:
                    for (int j = 0; j < 2; j++) {
                        Card card = new Card();
                        card.type = "Event";
                        card.name = "Prosperity";
                        card.value = "+2All";
                        eventDeck.add(card);
                    }
                    break;
                case 2:
                    Card card = new Card();
                    card.type = "Event";
                    card.name = "Plague";
                    card.value = "-2Sh";
                    eventDeck.add(card);
                    break;
            }
        }

        //Quest cards
        for (int i = 0; i < 4; i++) {
            switch(i) {
                case 0:
                    for (int j = 0; j < 3; j++) {
                        Card card = new Card();
                        card.type = "Quest";
                        card.name = "2 Stage Quest";
                        card.value = "Q2";
                        eventDeck.add(card);
                    }
                    break;
                case 1:
                    for (int j = 0; j < 4; j++) {
                        Card card = new Card();
                        card.type = "Quest";
                        card.name = "3 Stage Quest";
                        card.value = "Q3";
                        eventDeck.add(card);
                    }
                    break;
                case 2:
                    for (int j = 0; j < 3; j++) {
                        Card card = new Card();
                        card.type = "Quest";
                        card.name = "4 Stage Quest";
                        card.value = "Q4";
                        eventDeck.add(card);
                    }
                    break;
                case 3:
                    for (int j = 0; j < 2; j++) {
                        Card card = new Card();
                        card.type = "Quest";
                        card.name = "5 Stage Quest";
                        card.value = "Q5";
                        eventDeck.add(card);
                    }
                    break;
            }
        }
        Collections.shuffle(eventDeck);
    }

    public int getAdventureDeckSize() {
        return adventureDeck.size();
    }

    public int getEventDeckSize() {
        return eventDeck.size();
    }

    public void dealCards() {
        for (int i = 0; i < 12; i++) {
            p1Hand.add(drawCard());
            p2Hand.add(drawCard());
            p3Hand.add(drawCard());
            p4Hand.add(drawCard());
        }
    }

    public int getP1HandSize() {
        return p1Hand.size();
    }

    public int getP2HandSize() {
        return p2Hand.size();
    }

    public int getP3HandSize() {
        return p3Hand.size();
    }

    public int getP4HandSize() {
        return p4Hand.size();
    }

    public Card drawCard() {
        Card drawnCard = null;
        drawnCard = adventureDeck.removeFirst();
        return drawnCard;
    }

    public void setShield(int score, int playerID) {
        switch(playerID) {
            case 1:
                p1Shields = score;
            case 2:
                p2Shields = score;
            case 3:
                p3Shields = score;
            case 4:
                p4Shields = score;
        }
    }

    public int getPlayerScore(int playerID) {
        switch(playerID) {
            case 1:
                return p1Shields;
            case 2:
                return p2Shields;
            case 3:
                return p3Shields;
            case 4:
                return p4Shields;
            default:
                //this means something went wrong :)
                return -1;
        }
    }

}