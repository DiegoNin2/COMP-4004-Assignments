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

    }

    public int getP1HandSize() {
        return 0;
    }

    public int getP2HandSize() {
        return 0;
    }

    public int getP3HandSize() {
        return 0;
    }

    public int getP4HandSize() {
        return 0;
    }

    public Card drawCard() {
        return new Card();
    }

}