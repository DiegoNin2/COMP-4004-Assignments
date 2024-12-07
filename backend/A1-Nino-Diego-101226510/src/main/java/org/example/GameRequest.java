package org.example;

import java.util.ArrayList;

public class GameRequest {
    private String playerID;
    private String type;
    private ArrayList<Card> cards;
    private String input;
    private int currentStage;
    private Card eventCard;

    public GameRequest(String id, String t, ArrayList<Card> hand, String i, int currentStage, Card c) {
        playerID = id;
        type = t;
        cards = hand;
        input = i;
        this.currentStage = currentStage;
        eventCard = c;
    }

    public String getPlayerID() { return playerID; }

    public void setPlayerID(String playerID) { this.playerID = playerID; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public ArrayList<Card> getCards() { return cards; }

    public void setCards(ArrayList<Card> cards) { this.cards = cards; }

    public String getInput() { return input; }

    public void setInput(String newInput) { this.input = newInput; }

    public int getCurrentStage() { return currentStage; }

    public void setCurrentStage(int currentStage) { this.currentStage = currentStage; }

    public Card getEventCard() { return eventCard; }

    public void setEventCard(Card eventCard) { this.eventCard = eventCard; }
}
