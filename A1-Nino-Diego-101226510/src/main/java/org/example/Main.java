package org.example;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

    }

    /*class Card {
        String type;
        String value;
        String name;

    }*/

    ArrayList<Card> adventureDeck = new ArrayList<Card>();
    ArrayList<Card> eventDeck = new ArrayList<Card>();
    ArrayList<Card> eventDiscardDeck = new ArrayList<Card>();
    Player p1 = new Player();
    Player p2 = new Player();
    Player p3 = new Player();
    Player p4 = new Player();

    public void initializePlayers() {
        //set up ids
        p1.setID("P1");
        p2.setID("P2");
        p3.setID("P3");
        p4.setID("P4");

        //set up shield amounts to 0
        p1.setShields(0);
        p2.setShields(0);
        p3.setShields(0);
        p4.setShields(0);
    }

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
                        card.setType("Weapon");
                        card.setName("Dagger");
                        card.setValue("5");
                        adventureDeck.add(card);
                    }
                    break;
                case 1:
                    for (int j = 0; j < 12; j++) {
                        Card card = new Card();
                        card.setType("Weapon");
                        card.setName("Horse");
                        card.setValue("10");
                        adventureDeck.add(card);
                    }
                    break;
                case 2:
                    for (int j = 0; j < 16; j++) {
                        Card card = new Card();
                        card.setType("Weapon");
                        card.setName("Sword");
                        card.setValue("10");
                        adventureDeck.add(card);
                    }
                    break;
                case 3:
                    for (int j = 0; j < 8; j++) {
                        Card card = new Card();
                        card.setType("Weapon");
                        card.setName("Battle-Axe");
                        card.setValue("15");
                        adventureDeck.add(card);
                    }
                    break;
                case 4:
                    for (int j = 0; j < 6; j++) {
                        Card card = new Card();
                        card.setType("Weapon");
                        card.setName("Lance");
                        card.setValue("20");
                        adventureDeck.add(card);
                    }
                    break;
                case 5:
                    for (int j = 0; j < 2; j++) {
                        Card card = new Card();
                        card.setType("Weapon");
                        card.setName("Excalibur");
                        card.setValue("30");
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
                        card.setType("Foe");
                        card.setName("F5");
                        card.setValue("5");
                        adventureDeck.add(card);
                    }
                    break;
                case 1:
                    for (int j = 0; j < 7; j++) {
                        Card card = new Card();
                        card.setType("Foe");
                        card.setName("F10");
                        card.setValue("10");
                        adventureDeck.add(card);
                    }
                    break;
                case 2:
                    for (int j = 0; j < 8; j++) {
                        Card card = new Card();
                        card.setType("Foe");
                        card.setName("F15");
                        card.setValue("15");
                        adventureDeck.add(card);
                    }
                    break;
                case 3:
                    for (int j = 0; j < 7; j++) {
                        Card card = new Card();
                        card.setType("Foe");
                        card.setName("F20");
                        card.setValue("20");
                        adventureDeck.add(card);
                    }
                    break;
                case 4:
                    for (int j = 0; j < 7; j++) {
                        Card card = new Card();
                        card.setType("Foe");
                        card.setName("F25");
                        card.setValue("25");
                        adventureDeck.add(card);
                    }
                    break;
                case 5:
                    for (int j = 0; j < 4; j++) {
                        Card card = new Card();
                        card.setType("Foe");
                        card.setName("F30");
                        card.setValue("30");
                        adventureDeck.add(card);
                    }
                    break;
                case 6:
                    for (int j = 0; j < 4; j++) {
                        Card card = new Card();
                        card.setType("Foe");
                        card.setName("F35");
                        card.setValue("35");
                        adventureDeck.add(card);
                    }
                    break;
                case 7:
                    for (int j = 0; j < 2; j++) {
                        Card card = new Card();
                        card.setType("Foe");
                        card.setName("F40");
                        card.setValue("40");
                        adventureDeck.add(card);
                    }
                    break;
                case 8:
                    for (int j = 0; j < 2; j++) {
                        Card card = new Card();
                        card.setType("Foe");
                        card.setName("F50");
                        card.setValue("50");
                        adventureDeck.add(card);
                    }
                    break;
                case 9:
                    Card card = new Card();
                    card.setType("Foe");
                    card.setName("F70");
                    card.setValue("70");
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
                        card.setType("Event");
                        card.setName("Queen's Favor");
                        card.setValue("+2P");
                        eventDeck.add(card);
                    }
                    break;
                case 1:
                    for (int j = 0; j < 2; j++) {
                        Card card = new Card();
                        card.setType("Event");
                        card.setName("Prosperity");
                        card.setValue("+2All");
                        eventDeck.add(card);
                    }
                    break;
                case 2:
                    Card card = new Card();
                    card.setType("Event");
                    card.setName("Plague");
                    card.setValue("-2Sh");
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
                        card.setType("Quest");
                        card.setName("2 Stage Quest");
                        card.setValue("Q2");
                        eventDeck.add(card);
                    }
                    break;
                case 1:
                    for (int j = 0; j < 4; j++) {
                        Card card = new Card();
                        card.setType("Quest");
                        card.setName("3 Stage Quest");
                        card.setValue("Q3");
                        eventDeck.add(card);
                    }
                    break;
                case 2:
                    for (int j = 0; j < 3; j++) {
                        Card card = new Card();
                        card.setType("Quest");
                        card.setName("4 Stage Quest");
                        card.setValue("Q4");
                        eventDeck.add(card);
                    }
                    break;
                case 3:
                    for (int j = 0; j < 2; j++) {
                        Card card = new Card();
                        card.setType("Quest");
                        card.setName("5 Stage Quest");
                        card.setValue("Q5");
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

    public int getEventDiscardSize() {
        return eventDiscardDeck.size();
    }

    public void dealCards() {
        for (int i = 0; i < 12; i++) {
            p1.getHand().add(drawCard());
            p2.getHand().add(drawCard());
            p3.getHand().add(drawCard());
            p4.getHand().add(drawCard());
        }
    }

    //update to apply for event deck
    public Card drawCard() {
        Card drawnCard = null;
        drawnCard = adventureDeck.removeFirst();
        return drawnCard;
    }

    //might be removed eventually
    public int getPlayerScore(int playerID) {
        switch(playerID) {
            case 1:
                return p1.getShields();
            case 2:
                return p2.getShields();
            case 3:
                return p3.getShields();
            case 4:
                return p4.getShields();
            default:
                //this means something went wrong :)
                return -1;
        }
    }

    //this will be changed to just checking the scores probably whenever i get around to that
    public void checkForWinners() {
        if (p1.getShields() >= 7) { p1.setWinnerStatus(true); }
        if (p2.getShields() >= 7) { p2.setWinnerStatus(true); }
        if (p3.getShields() >= 7) { p3.setWinnerStatus(true); }
        if (p4.getShields() >= 7) { p4.setWinnerStatus(true); }
    }

    public void displayWinner(PrintWriter output) {
        checkForWinners();

        int winnerCount = 0;
        ArrayList<String> winnerIDs = new ArrayList<String>();

        if (p1.getWinnerStatus()) { winnerCount++; winnerIDs.add("P1"); }
        if (p2.getWinnerStatus()) { winnerCount++; winnerIDs.add("P2"); }
        if (p3.getWinnerStatus()) { winnerCount++; winnerIDs.add("P3"); }
        if (p4.getWinnerStatus()) { winnerCount++; winnerIDs.add("P4");}

        switch(winnerCount) {
            case 1:
                output.println("Winner: " + winnerIDs.get(0));
                break;
            case 2:
                output.println("Winners: " + winnerIDs.get(0) + " and " + winnerIDs.get(1));
                break;
            case 3:
                output.println("Winners: " + winnerIDs.get(0) + ", " + winnerIDs.get(1) + " and " + winnerIDs.get(2));
                break;
            case 4:
                output.println("Winners: " + winnerIDs.get(0) + ", " + winnerIDs.get(1) + ", " + winnerIDs.get(2) + " and " + winnerIDs.get(3));
                break;
            default:
                break;
        }

    }

    //will be modified to handle other players & additional turn stuff soon
    public void takeTurn(PrintWriter output) {
        output.println("Current Player: P1");

        output.println("Displaying hand: ");

        Collections.sort(p1.getHand());

        for (int i = 0; i < p1.getHandSize(); i++) {
            output.print(p1.getHand().get(i).toString());
            output.print(" \n");
        }

        output.println("drawing from event deck: ");
        Card c = drawSpecificCard("Event","Queen's Favor","+2P"); //this will be replaced by the regular drawCard function
        output.println(c.toString());

        eventDiscardDeck.add(c);
    }

    //for testing purposes only
    public void pickCard(int index, String type, String name, String value, int playerID) {
        Card c;
        switch(playerID){
            case 1:
                c = new Card();
                c.setType(type);
                c.setName(name);
                c.setValue(value);
                p1.getHand().add(index, c);
                break;
            case 2:
                c = new Card();
                c.setType(type);
                c.setName(name);
                c.setValue(value);
                p2.getHand().add(index, c);
                break;
            case 3:
                c = new Card();
                c.setType(type);
                c.setName(name);
                c.setValue(value);
                p3.getHand().add(index, c);
                break;
            case 4:
                c = new Card();
                c.setType(type);
                c.setName(name);
                c.setValue(value);
                p4.getHand().add(index, c);
                break;
        }
    }

    //for testing purposes only
    private Card drawSpecificCard(String type, String name, String value) {
        Card drawnCard = null;
        for (int i = 0; i < getEventDeckSize(); i++) {
            if (eventDeck.get(i).getName().equals(name) && eventDeck.get(i).getType().equals(type) && eventDeck.get(i).getValue().equals(value)) {
                drawnCard = eventDeck.remove(i);
                break;
            }
        }
        return drawnCard;
    }

}