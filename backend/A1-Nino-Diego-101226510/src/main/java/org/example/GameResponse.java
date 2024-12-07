package org.example;

import java.util.ArrayList;

public class GameResponse {

    private String status;
    private String message;
    private String currentPlayerID;
    private String currentHand;
    private ArrayList<Player> playerList;
    private Card eventCard;
    private boolean requiredInput;
    private boolean finishedQuest;
    private ArrayList<String> allPlayerHands;

    public GameResponse(String status, String message, String currentID, ArrayList<String> hands, ArrayList<Player> playerList, Card event, boolean inputRequired, boolean questFinished) {
        this.status = status;
        this.message = message;
        currentPlayerID = currentID;
        allPlayerHands = hands;
        this.playerList = playerList;
        eventCard = event;
        requiredInput = inputRequired;
        finishedQuest = questFinished;
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

    public boolean isRequiredInput() { return requiredInput; }

    public void setRequiredInput(boolean requiredInput) { this.requiredInput = requiredInput; }

    public boolean isFinishedQuest() { return finishedQuest; }

    public void setFinishedQuest(boolean finishedQuest) { this.finishedQuest = finishedQuest; }

    public ArrayList<String> getAllPlayerHands() { return allPlayerHands; }

    public void setAllPlayerHands(ArrayList<String> allPlayerHands) { this.allPlayerHands = allPlayerHands; }
}
