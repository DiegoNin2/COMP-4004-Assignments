package org.example;

import java.util.ArrayList;

public class GameResponse {

    private String status;
    private String message;
    private String currentPlayerID;
    private String currentHand;
    private ArrayList<Player> playerList;
    private Card eventCard;

    public GameResponse(String status, String message, String currentID, String hand, ArrayList<Player> playerList, Card event) {
        this.status = status;
        this.message = message;
        currentPlayerID = currentID;
        currentHand = hand;
        this.playerList = playerList;
        eventCard = event;
    }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }

    public String getCurrentPlayerId() { return currentPlayerID; }

    public void setCurrentPlayerId(String currentPlayerId) { this.currentPlayerID = currentPlayerId; }

    public String getCurrentHand() { return currentHand; }

    public void setCurrentHand(String currentHand) { this.currentHand = currentHand; }

    public ArrayList<Player> getPlayerList() { return playerList; }

    public void setPlayerList(ArrayList<Player> playerList) { this.playerList = playerList; }

    public Card getEventCard() { return eventCard; }

    public void setEventCard(Card eventCard) { this.eventCard = eventCard; }
}
