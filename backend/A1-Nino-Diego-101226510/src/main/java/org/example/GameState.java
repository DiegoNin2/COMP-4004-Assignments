package org.example;

import io.cucumber.java.bs.A;

import java.util.ArrayList;

public class GameState {

    //a lot of these are just transferred from Main.java

    //variables
    private Deck adventureDeck;
    private Deck eventDeck;
    private ArrayList<Player> playerList;
    private ArrayList<Player> participantList;
    private ArrayList<Quest> questStageList;
    private ArrayList<Player> eligiblePlayersList;
    private ArrayList<Player> attackBuildersList;

    private int playerTurnIndex;
    private int playerQuestIndex;
    private boolean gameEnd;

    private String trimmingID;
    private int amountToDelete;
    private ArrayList<Player> trimQueue;

    private String builderID;
    private String eligiblePlayerID;
    private String attackBuilderID;

    private boolean finishedQuest;

    //constructor
    public GameState() {
        adventureDeck = new Deck("adventure");
        eventDeck = new Deck("event");
        playerList = new ArrayList<Player>();
        participantList = new ArrayList<Player>();
        questStageList = new ArrayList<Quest>();
        eligiblePlayersList = new ArrayList<Player>();
        attackBuildersList = new ArrayList<Player>();

        playerTurnIndex = 0;
        playerQuestIndex = 0;
        gameEnd = false;

        trimmingID = "N/A";
        amountToDelete = 0;
        trimQueue = new ArrayList<Player>();

        builderID = "N/A";
        attackBuilderID = "N/A";
        eligiblePlayerID = "N/A";

        finishedQuest = false;
    }

    //getters
    public Deck getAdventureDeck() {
        return adventureDeck;
    }

    public Deck getEventDeck() {
        return eventDeck;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public ArrayList<Player> getParticipantList() {
        return participantList;
    }

    public ArrayList<Quest> getQuestStageList() {
        return questStageList;
    }

    public int getPlayerTurnIndex() {
        return playerTurnIndex;
    }

    public int getPlayerQuestIndex() {
        return playerQuestIndex;
    }

    public boolean isGameEnd() {
        return gameEnd;
    }

    public int getAmountToDelete() { return amountToDelete; }

    public String getTrimmingID() { return trimmingID; }

    public ArrayList<Player> getTrimQueue() { return trimQueue; }

    public String getBuilderID() { return builderID; }

    public boolean isFinishedQuest() { return finishedQuest; }

    public ArrayList<Player> getEligiblePlayersList() { return eligiblePlayersList; }

    public String getEligiblePlayerID() { return eligiblePlayerID; }

    public String getAttackBuilderID() { return attackBuilderID; }

    public ArrayList<Player> getAttackBuildersList() { return attackBuildersList; }

    //setters
    public void setGameEnd(boolean gameEnd) {
        this.gameEnd = gameEnd;
    }

    public void setPlayerQuestIndex(int playerQuestIndex) {
        this.playerQuestIndex = playerQuestIndex;
    }

    public void setPlayerTurnIndex(int playerTurnIndex) {
        this.playerTurnIndex = playerTurnIndex;
    }

    public void setTrimmingID(String trimmingID) { this.trimmingID = trimmingID; }

    public void setAmountToDelete(int amountToDelete) { this.amountToDelete = amountToDelete; }

    public void setTrimQueue(ArrayList<Player> trimQueue) { this.trimQueue = trimQueue; }

    public void setBuilderID(String builderID) { this.builderID = builderID; }

    public void setFinishedQuest(boolean finishedQuest) { this.finishedQuest = finishedQuest; }

    public void setEligiblePlayerID(String eligiblePlayerID) { this.eligiblePlayerID = eligiblePlayerID; }

    public void setAttackBuilderID(String attackBuilderID) { this.attackBuilderID = attackBuilderID; }

    //initalization functions
    public void initializePlayers() {
        Player p1 = new Player("P1", 0);
        Player p2 = new Player("P2", 0);
        Player p3 = new Player("P3", 0);
        Player p4 = new Player("P4", 0);
        playerList.add(p1);
        playerList.add(p2);
        playerList.add(p3);
        playerList.add(p4);
    }

    public void initializeDecks() {
        adventureDeck.initializeDeck(adventureDeck.getType());
        eventDeck.initializeDeck(eventDeck.getType());
    }

    public void dealCards() {
        for (int i = 0; i < 12; i++) {
            playerList.get(0).addCard(adventureDeck.drawCard());
            playerList.get(1).addCard(adventureDeck.drawCard());
            playerList.get(2).addCard(adventureDeck.drawCard());
            playerList.get(3).addCard(adventureDeck.drawCard());
        }
    }

    //game ending related functions
    public void checkForWinners() {
        if (playerList.get(0).getShields() >= 7) { playerList.get(0).setWinnerStatus(true); }
        if (playerList.get(1).getShields() >= 7) { playerList.get(1).setWinnerStatus(true); }
        if (playerList.get(2).getShields() >= 7) { playerList.get(2).setWinnerStatus(true); }
        if (playerList.get(3).getShields() >= 7) { playerList.get(3).setWinnerStatus(true); }
    }

    //helper functions
    public int checkHand(String playerID) {
        switch(playerID) {
            case "P1":
                return playerList.get(0).getHandSize() - 12;
            case "P2":
                return playerList.get(1).getHandSize() - 12;
            case "P3":
                return playerList.get(2).getHandSize() - 12;
            case "P4":
                return playerList.get(3).getHandSize() - 12;
            default:
                return -1; //something went wrong :)
        }
    }

    public int amountToGet(String playerID) {
        switch(playerID) {
            case "P1":
                return 12 - playerList.get(0).getHandSize();
            case "P2":
                return 12 - playerList.get(1).getHandSize();
            case "P3":
                return 12 - playerList.get(2).getHandSize();
            case "P4":
                return 12 - playerList.get(3).getHandSize();
            default:
                return -1; //something went wrong :)
        }
    }

    public int translateID(String currentPlayerID) {
        switch(currentPlayerID) {
            case "P1":
                return 0;
            case "P2":
                return 1;
            case "P3":
                return 2;
            case "P4":
                return 3;
            default:
                return -1;
        }
    }

    public int getQuestLength(String questVal) {
        switch(questVal) {
            case "Q2":
                return 2;
            case "Q3":
                return 3;
            case "Q4":
                return 4;
            case "Q5":
                return 5;
            default:
                return 1;
        }
    }

    public boolean noEligibleParticipants() {
        for (int i = 0; i < participantList.size(); i++) {
            if (participantList.get(i).getEligibleStatus()) {
                return true;
            }
        }
        return false;
    }

    public void clearParticipants() { participantList.clear(); }

    public void clearQuestStages() { questStageList.clear(); }

    //use only for testing purposes
    public void pickCard(int index, String type, String name, String value, int playerID) {
        Card c;
        switch(playerID){
            case 1:
                c = new Card(type, name, value);
                playerList.get(0).addCardAt(index, c);
                break;
            case 2:
                c = new Card(type, name, value);
                playerList.get(1).addCardAt(index, c);
                break;
            case 3:
                c = new Card(type, name, value);
                playerList.get(2).addCardAt(index, c);
                break;
            case 4:
                c = new Card(type, name, value);
                playerList.get(3).addCardAt(index, c);
                break;
        }
    }
}
