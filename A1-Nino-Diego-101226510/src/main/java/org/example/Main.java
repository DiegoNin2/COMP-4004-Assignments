package org.example;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

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
            p1.getHand().add(drawCard("adventure"));
            p2.getHand().add(drawCard("adventure"));
            p3.getHand().add(drawCard("adventure"));
            p4.getHand().add(drawCard("adventure"));
        }
    }

    public Card drawCard(String deck) {
        if (deck.equals("adventure")) {
            Card drawnCard = null;
            drawnCard = adventureDeck.removeFirst();
            return drawnCard;
        } else {
            Card drawnCard = null;
            drawnCard = eventDeck.removeFirst();
            return drawnCard;
        }
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
    public void takeTurn(Scanner input, PrintWriter output) {
        output.println("Current Player: P1");

        output.println("Displaying hand: ");

        Collections.sort(p1.getHand());

        for (int i = 0; i < p1.getHandSize(); i++) {
            output.print(p1.getHand().get(i).toString());
            output.print(" \n");
        }

        output.println("drawing from event deck: ");
        Card c = drawCard("event");
        output.println(c.toString());

        if (c.getType().equals("Event")) {
            if (c.getName().equals("Plague")) {
                if (p1.getShields() >= 2) {
                    p1.setShields(p1.getShields()-2);
                } else {
                    p1.setShields(0);
                }
            } else if (c.getName().equals("Queen's Favor")) {
                for (int i = 0; i < 2; i++) {
                    p1.getHand().add(drawCard("adventure"));
                }
            } else {
                //this is the prosperity card
                for (int i = 0; i < 2; i++) {
                    p1.getHand().add(drawCard("adventure"));
                    p2.getHand().add(drawCard("adventure"));
                    p3.getHand().add(drawCard("adventure"));
                    p4.getHand().add(drawCard("adventure"));
                }
            }
        }

        //other turn stuff goes here

        eventDiscardDeck.add(c);

        output.println("Turn End. Please move out of hot seat for next player.");
        output.println("Press Enter key if you are the next player");
        String inputStr = input.nextLine();
        if (inputStr.isEmpty()) {
            output.println("Clearing output for next player...");
            output.print("\033[H\033[2J");
            output.flush();
        }
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

}