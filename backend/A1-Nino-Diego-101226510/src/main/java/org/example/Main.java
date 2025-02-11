package org.example;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("COMP 4004 A1");

        //game setup functions here
        Scanner input = new Scanner(System.in);
        PrintWriter output = new PrintWriter(System.out);

        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        System.out.println("Starting game...");

        //take turn function here
        while (!game.gameEnd) {
            System.out.println("Taking turn...");
            game.takeTurn(input,output);
        }
    }

    //variables
    ArrayList<Card> adventureDeck = new ArrayList<Card>();
    ArrayList<Card> eventDeck = new ArrayList<Card>();
    ArrayList<Card> eventDiscardDeck = new ArrayList<Card>();
    ArrayList<Card> adventureDiscardDeck = new ArrayList<Card>();
    ArrayList<Player> playerList = new ArrayList<Player>();
    ArrayList<Player> participantList = new ArrayList<Player>();
    ArrayList<Quest> questStageList = new ArrayList<Quest>();

    private int playerTurnIndex = 0;
    private int playerQuestIndex = 0;
    private boolean gameEnd = false;

    private void flushDisplay(PrintWriter output) {
        for (int i = 0; i < 50; i++) {
            output.print("\n");
        }
    }

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
        adventureDeck = new ArrayList<Card>();
        eventDeck = new ArrayList<Card>();

        //Adventure deck set up
        //Weapon cards
        for (int i = 0; i < 6; i++) {
            switch(i) {
                case 0:
                    for (int j = 0; j < 6; j++) {
                        Card card = new Card("Weapon","Dagger","5");
                        adventureDeck.add(card);
                    }
                    break;
                case 1:
                    for (int j = 0; j < 12; j++) {
                        Card card = new Card("Weapon","Horse","10");
                        adventureDeck.add(card);
                    }
                    break;
                case 2:
                    for (int j = 0; j < 16; j++) {
                        Card card = new Card("Weapon","Sword","10");
                        adventureDeck.add(card);
                    }
                    break;
                case 3:
                    for (int j = 0; j < 8; j++) {
                        Card card = new Card("Weapon","Battle-Axe","15");
                        adventureDeck.add(card);
                    }
                    break;
                case 4:
                    for (int j = 0; j < 6; j++) {
                        Card card = new Card("Weapon","Lance","20");
                        adventureDeck.add(card);
                    }
                    break;
                case 5:
                    for (int j = 0; j < 2; j++) {
                        Card card = new Card("Weapon","Excalibur","30");
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
                        Card card = new Card("Foe","F5","5");
                        adventureDeck.add(card);
                    }
                    break;
                case 1:
                    for (int j = 0; j < 7; j++) {
                        Card card = new Card("Foe","F10","10");
                        adventureDeck.add(card);
                    }
                    break;
                case 2:
                    for (int j = 0; j < 8; j++) {
                        Card card = new Card("Foe","F15","15");
                        adventureDeck.add(card);
                    }
                    break;
                case 3:
                    for (int j = 0; j < 7; j++) {
                        Card card = new Card("Foe","F20","20");
                        adventureDeck.add(card);
                    }
                    break;
                case 4:
                    for (int j = 0; j < 7; j++) {
                        Card card = new Card("Foe","F25","25");
                        adventureDeck.add(card);
                    }
                    break;
                case 5:
                    for (int j = 0; j < 4; j++) {
                        Card card = new Card("Foe","F30","30");
                        adventureDeck.add(card);
                    }
                    break;
                case 6:
                    for (int j = 0; j < 4; j++) {
                        Card card = new Card("Foe","F35","35");
                        adventureDeck.add(card);
                    }
                    break;
                case 7:
                    for (int j = 0; j < 2; j++) {
                        Card card = new Card("Foe","F40","40");
                        adventureDeck.add(card);
                    }
                    break;
                case 8:
                    for (int j = 0; j < 2; j++) {
                        Card card = new Card("Foe","F50","50");
                        adventureDeck.add(card);
                    }
                    break;
                case 9:
                    Card card = new Card("Foe","F70","70");
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
                        Card card = new Card("Event","Queen's Favor", "+2P");
                        eventDeck.add(card);
                    }
                    break;
                case 1:
                    for (int j = 0; j < 2; j++) {
                        Card card = new Card("Event", "Prosperity", "+2All");
                        eventDeck.add(card);
                    }
                    break;
                case 2:
                    Card card = new Card("Event","Plague","-2Sh");
                    eventDeck.add(card);
                    break;
            }
        }

        //Quest cards
        for (int i = 0; i < 4; i++) {
            switch(i) {
                case 0:
                    for (int j = 0; j < 3; j++) {
                        Card card = new Card("Quest", "2 Stage Quest", "Q2");
                        eventDeck.add(card);
                    }
                    break;
                case 1:
                    for (int j = 0; j < 4; j++) {
                        Card card = new Card("Quest", "3 Stage Quest", "Q3");
                        eventDeck.add(card);
                    }
                    break;
                case 2:
                    for (int j = 0; j < 3; j++) {
                        Card card = new Card("Quest", "4 Stage Quest", "Q4");
                        eventDeck.add(card);
                    }
                    break;
                case 3:
                    for (int j = 0; j < 2; j++) {
                        Card card = new Card("Quest", "5 Stage Quest", "Q5");
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

    public int getAdventureDiscardDeckSize() {
        return adventureDiscardDeck.size();
    }

    public void dealCards() {
        for (int i = 0; i < 12; i++) {
            playerList.get(0).addCard(drawCard("adventure"));
            playerList.get(1).addCard(drawCard("adventure"));
            playerList.get(2).addCard(drawCard("adventure"));
            playerList.get(3).addCard(drawCard("adventure"));
        }
    }

    public Card drawCard(String deck) {
        if (adventureDeck.isEmpty()) {
            reshuffleAndReinsert("adventure");
        }
        if (eventDeck.isEmpty()) {
            reshuffleAndReinsert("event");
        }

        if (deck.equals("adventure")) {
            Card drawnCard = null;
            drawnCard = adventureDeck.remove(0);
            return drawnCard;
        } else {
            Card drawnCard = null;
            drawnCard = eventDeck.remove(0);
            return drawnCard;
        }
    }

    private void reshuffleAndReinsert(String deck) {
        if (deck.equals("adventure")) {
            adventureDeck.addAll(adventureDiscardDeck);
            Collections.shuffle(adventureDeck);
            adventureDiscardDeck.clear();
        } else {
            eventDeck.addAll(eventDiscardDeck);
            Collections.shuffle(eventDeck);
            eventDiscardDeck.clear();
        }
    }

    //this will be changed to just checking the scores probably whenever i get around to that
    //never mind i didn't do that
    public void checkForWinners() {
        if (playerList.get(0).getShields() >= 7) { playerList.get(0).setWinnerStatus(true); }
        if (playerList.get(1).getShields() >= 7) { playerList.get(1).setWinnerStatus(true); }
        if (playerList.get(2).getShields() >= 7) { playerList.get(2).setWinnerStatus(true); }
        if (playerList.get(3).getShields() >= 7) { playerList.get(3).setWinnerStatus(true); }
    }

    public void displayWinner(PrintWriter output) {
        checkForWinners();

        int winnerCount = 0;
        ArrayList<String> winnerIDs = new ArrayList<String>();

        if (playerList.get(0).getWinnerStatus()) { winnerCount++; winnerIDs.add("P1"); }
        if (playerList.get(1).getWinnerStatus()) { winnerCount++; winnerIDs.add("P2"); }
        if (playerList.get(2).getWinnerStatus()) { winnerCount++; winnerIDs.add("P3"); }
        if (playerList.get(3).getWinnerStatus()) { winnerCount++; winnerIDs.add("P4");}

        switch(winnerCount) {
            case 1:
                output.println("Winner: " + winnerIDs.get(0));
                gameEnd = true;
                break;
            case 2:
                output.println("Winners: " + winnerIDs.get(0) + " and " + winnerIDs.get(1));
                gameEnd = true;
                break;
            case 3:
                output.println("Winners: " + winnerIDs.get(0) + ", " + winnerIDs.get(1) + " and " + winnerIDs.get(2));
                gameEnd = true;
                break;
            case 4:
                output.println("Winners: " + winnerIDs.get(0) + ", " + winnerIDs.get(1) + ", " + winnerIDs.get(2) + " and " + winnerIDs.get(3));
                gameEnd = true;
                break;
            default:
                break;
        }

    }

    public void takeTurn(Scanner input, PrintWriter output) {
        output.println("Current Player: " + playerList.get(playerTurnIndex).getId());

        output.println("Displaying hand: ");

        Collections.sort(playerList.get(playerTurnIndex).getHand());

        output.print(playerList.get(playerTurnIndex).displayHand());

        output.println("drawing from event deck: ");
        Card c = drawCard("event");
        output.println(c.toString());
        output.flush();

        if (c.getType().equals("Event")) {
            if (c.getName().equals("Plague")) {
                if (playerList.get(playerTurnIndex).getShields() >= 2) {
                    playerList.get(playerTurnIndex).setShields(playerList.get(playerTurnIndex).getShields()-2);
                } else {
                    playerList.get(playerTurnIndex).setShields(0);
                }
            } else if (c.getName().equals("Queen's Favor")) {
                for (int i = 0; i < 2; i++) {
                    playerList.get(playerTurnIndex).addCard(drawCard("adventure"));
                }
                int amountToDelete = checkHand(playerList.get(playerTurnIndex).getId());
                if (amountToDelete > 0) {
                    output.println("Too many cards, trimming hand");
                    output.flush();
                    for (int i = 0; i < amountToDelete; i++) {
                        trimHand(input, output, playerList.get(playerTurnIndex).getId());
                    }
                }
                output.println("continuing...");
                output.flush();
            } else {
                //this is the prosperity card
                for (int i = 0; i < 2; i++) {
                    playerList.get(0).addCard(drawCard("adventure"));
                    playerList.get(1).addCard(drawCard("adventure"));
                    playerList.get(2).addCard(drawCard("adventure"));
                    playerList.get(3).addCard(drawCard("adventure"));
                }

                for (int i = 0; i < playerList.size(); i++) {
                    int amountToDelete = checkHand(playerList.get(i).getId());
                    if (amountToDelete > 0) {
                        output.println("Too many cards, trimming hand");
                        output.flush();
                        for (int j = 0; j < amountToDelete; j++) {
                            trimHand(input, output, playerList.get(i).getId());
                        }
                    }
                }
                output.println("continuing...");
                output.flush();

            }
        } else if (c.getType().equals("Quest")) {
            output.println("A " + c.getName() + " will start!");
            questEvent(input, output, c.getValue(), playerList.get(playerTurnIndex).getId());
            output.println("Displaying Shields: ");
            output.flush();
            for (int i = 0; i < playerList.size(); i++) {
                output.println(playerList.get(i).getId() + "'s Shields: " + playerList.get(i).getShields());
                output.flush();
            }
        }

        displayWinner(output);
        output.flush();

        eventDiscardDeck.add(c);

        if (gameEnd) {
            output.println("Game end.");
        } else {
            output.println("Turn End. Please move out of hot seat for next player.");
            output.println("Press Enter key if you are the next player");
            output.flush();
            String inputStr = input.nextLine();
            if (inputStr.isEmpty()) {
                output.println("Clearing output for next player...");
                output.flush();
                flushDisplay(output);
                output.flush();
                output.println("Moving on to next player...");
                output.flush();
            }
            if (playerTurnIndex >= playerList.size()) {
                playerTurnIndex = 0;
            } else {
                playerTurnIndex++;
            }
        }
    }

    //for testing purposes only
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

    private int amountToGet(String playerID) {
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

    public void trimHand(Scanner input, PrintWriter output, String currentPlayerID) {
        int pIndex = translateID(currentPlayerID);

        output.println("Currently trimming: " + currentPlayerID);

        output.println("Displaying hand: ");
        Collections.sort(playerList.get(pIndex).getHand());

        //this would be wrapped in a while loop
        //maybe not idk
        for (int i = 0; i < playerList.get(pIndex).getHandSize(); i++) {
            output.print("[" + Integer.toString(i+1) + "] " + playerList.get(pIndex).getCardAt(i).toString());
            output.print(" \n");
        }

        output.println("Select the position of the card to remove: ");
        output.flush();
        int inputNum = -1;
        if (input.hasNextInt()) {
            inputNum = input.nextInt();
        } else {
            return;
        }

        adventureDiscardDeck.add(playerList.get(pIndex).removeCardAt(inputNum -1));

        output.println("Displaying trimmed hand: ");
        Collections.sort(playerList.get(pIndex).getHand());

        for (int i = 0; i < playerList.get(pIndex).getHandSize(); i++) {
            output.print("[" + Integer.toString(i+1) + "] " + playerList.get(pIndex).getCardAt(i).toString());
            output.print(" \n");
        }
        output.flush();
    }

    private int translateID(String currentPlayerID) {
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

    private int getQuestLength(String questVal) {
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

    private boolean noEligibleParticipants() {
        for (int i = 0; i < participantList.size(); i++) {
            if (participantList.get(i).getEligibleStatus()) {
                return true;
            }
        }
        return false;
    }

    public void getParticipants(Scanner input, PrintWriter output, String currentPlayerID) {
        String eligiblePlayers = "";
        for (int i = 0; i < playerList.size(); i++) {
            if (!playerList.get(i).getId().equals(currentPlayerID)) {
                if (playerList.get(i).getEligibleStatus()) {
                    if (i == playerList.size()-1) {
                        eligiblePlayers += playerList.get(i).getId();
                    } else {
                        eligiblePlayers += playerList.get(i).getId() + ", ";
                    }
                }
            }
        }
        output.println("Eligible Players: " + eligiblePlayers);

        for (int i = 0; i < playerList.size(); i++) {
            if (!playerList.get(i).getId().equals(currentPlayerID)) {
                if (playerList.get(i).getEligibleStatus()) {
                    output.println(playerList.get(i).getId() + ", would you like to participate or withdraw from the quest?");
                    output.flush();
                    String responseStr = input.nextLine();
                    if (responseStr.equals("withdraw")) {
                        playerList.get(i).setEligibleStatus(false);
                    } else {
                        participantList.add(playerList.get(i));
                    }
                    output.println("Please hot seat for next player...");
                    output.flush();
                }
            }
        }
    }

    public void questEvent(Scanner input, PrintWriter output, String questValue, String currentPlayerID) {
        boolean questFinished = false;

        int index = translateID(currentPlayerID);

        int questLength = getQuestLength(questValue);
        participantList.clear();

        while (!questFinished) {
            if (index >= playerList.size()) {
                index = 0;
            }

            output.println("Do you, " + playerList.get(index).getId() + ", want to sponsor this quest? (y/n)");
            output.flush();
            String inputStr = input.nextLine();
            if (inputStr.contains("n")) {
                output.println(playerList.get(index).getId() + " declined, asking next player...");
                output.flush();
                playerQuestIndex++;
                index++;
                if (playerQuestIndex >= playerList.size()) {
                    output.println("All players have declined. Ending turn...");
                    output.flush();
                    questFinished = true;
                }
            } else if (inputStr.contains("y")) {
                output.println(playerList.get(index).getId() + " has sponsored! Quest starting soon!");
                output.flush();
                //i know this check will never happen but i don't feel like setting up some dummy data to pass
                if (questStageList.isEmpty()) {
                    for (int i = 0; i < questLength; i++) {
                        output.println("Building for quest stage: " + (i + 1));
                        output.flush();
                        buildQuest(input, output, playerList.get(index).getId(), i - 1);
                    }
                }

                output.println("Clearing output for participants...");
                flushDisplay(output);
                output.flush();

                for (int k = 0; k < questStageList.size(); k++) {
                    getParticipants(input, output, playerList.get(index).getId());
                    for (int i = 0; i < participantList.size(); i++) {
                        participantList.get(i).addCard(drawCard("adventure"));
                        int amountToDelete = checkHand(participantList.get(i).getId());
                        if (amountToDelete > 0) {
                            output.println("Too many cards, trimming hand");
                            output.flush();
                            for (int j = 0; j < amountToDelete; j++) {
                                trimHand(input, output, participantList.get(i).getId());
                            }
                            output.println("Please move hot seat for next player.");
                            output.println("Clearing output for next player...");
                            flushDisplay(output);
                            output.flush();
                        }
                    }

                    if (participantList.isEmpty()) {
                        output.println("No participants, quest cancelled...");
                        break;
                    } else {
                        for (int i = 0; i < participantList.size(); i++) {
                            //this check will never happen but i don't feel like setting up more dummy data
                            if (participantList.get(i).isAttackHandEmpty()) {
                                output.println("Building for attack for quest stage: " + (k + 1));
                                output.flush();
                                buildAttack(input, output, participantList.get(i).getId());
                            }
                            output.println("Please move hot seat for next player.");
                            output.println("Clearing output for next player...");
                            flushDisplay(output);
                            output.flush();
                        }
                        attackSequence(output, k);
                        if (!noEligibleParticipants()) {
                            output.println("No eligible participants for next stage. Ending quest...");
                            output.flush();
                            break;
                        } else {
                            for (int i = 0; i < participantList.size(); i++) {
                                for (int j = 0; j < participantList.get(i).getAttackHandSize(); j++) {
                                    adventureDiscardDeck.add(participantList.get(i).getAttackCardAt(j));
                                }
                                participantList.get(i).removeAttackCards();
                            }
                            if (k != questStageList.size()-1) {
                                participantList.clear();
                            }
                        }
                    }
                }
                output.println("Last stage of quest complete. Ending quest & rewarding winner(s)...");
                output.flush();
                for (int i = 0; i < participantList.size(); i++) {
                    if (participantList.get(i).getEligibleStatus()) {
                        int shieldAward = participantList.get(i).getShields() + questLength;
                        participantList.get(i).setShields(shieldAward);
                    }
                }
                for (int i = 0; i < questStageList.size(); i++) {
                    questStageList.get(i).removeAll();
                }
                questStageList.clear();
                int amountToGet = (amountToGet(playerList.get(index).getId()) + questLength);
                for (int i = 0; i < amountToGet; i++) {
                    playerList.get(translateID(playerList.get(index).getId())).addCard(drawCard("adventure"));
                }
                int amountToDelete = checkHand(playerList.get(index).getId());
                if (amountToDelete > 0) {
                    output.println("Too many cards, trimming hand");
                    output.flush();
                    for (int i = 0; i < amountToDelete; i++) {
                        trimHand(input, output, playerList.get(index).getId());
                    }
                }
                questFinished = true;
            }
        }
    }

    public void buildQuest(Scanner input, PrintWriter output, String currentPlayerID, int stageIndex) {
        int pIndex = translateID(currentPlayerID);
        Quest quest = new Quest();

        output.println(currentPlayerID + " is currently building the quest!");
        output.flush();

        output.println("Displaying current hand: ");
        Collections.sort(playerList.get(pIndex).getHand());

        boolean finishedBuilding = false;
        boolean invalid = false;

        while (!finishedBuilding) {
            invalid = false;
            for (int i = 0; i < playerList.get(pIndex).getHandSize(); i++) {
                output.print("[" + Integer.toString(i+1) + "] " + playerList.get(pIndex).getCardAt(i).toString());
                output.print(" \n");
            }

            output.println("Select position of card to add to current stage. Type 'Quit' when you are finished.");
            output.flush();
            int inputNum = -1;
            String inputStr = "";
            if (input.hasNextInt()) {
                inputNum = input.nextInt();
            } else {
                inputStr = input.nextLine();
            }

            if (inputStr.equalsIgnoreCase("Quit")) {
                if (quest.isStageEmpty()) {
                    output.println("Cannot Quit: Stage cannot be empty.");
                } else if (!questStageList.isEmpty()) {
                    if (questStageList.get(stageIndex).getValue() >= quest.getValue() && questStageList.get(stageIndex).getValue() != 0) {
                        output.println("Cannot Quit: Insufficient values for this stage");
                    } else {
                        Collections.sort(quest.getStageSet());
                        String cardsInStage = quest.displaySet();
                        output.println("The finished quest stage: " + cardsInStage);
                        questStageList.add(quest);
                        finishedBuilding = true;
                    }
                } else {
                    Collections.sort(quest.getStageSet());
                    String cardsInStage = quest.displaySet();
                    output.println("The finished quest stage: " + cardsInStage);
                    questStageList.add(quest);
                    finishedBuilding = true;
                }
            } else if (inputNum != -1) {
                if (inputNum > playerList.get(pIndex).getHandSize() || inputNum < 0) {
                    output.println("Rejected: Invalid position.");
                    output.flush();
                } else {
                    for (int i = 0; i < quest.getStageSize(); i++) {
                        if (quest.getCardAt(i).getType().equals("Foe") && playerList.get(pIndex).getCardAt(inputNum-1).getType().equals("Foe")) {
                            output.println("Rejected: Foe already chosen.");
                            output.flush();
                            invalid = true;
                            break;
                        } else if (quest.getCardAt(i).getType().equals("Weapon")) {
                            if (quest.getCardAt(i).getName().equals(playerList.get(pIndex).getCardAt(inputNum-1).getName())) {
                                output.println("Rejected: Duplicate weapon.");
                                output.flush();
                                invalid = true;
                                break;
                            }
                        }
                    }
                    if (!invalid) {
                        quest.addCard(playerList.get(pIndex).removeCardAt(inputNum-1));

                        String cardsInStage = quest.displaySet();
                        quest.increaseValue();

                        output.println("Current Stage: " + cardsInStage);
                        output.flush();
                    }
                }
            }
        }
    }

    public void buildAttack(Scanner input, PrintWriter output, String currentPlayerID) {
        int pIndex = translateID(currentPlayerID);

        output.println("Building attack for " + currentPlayerID);
        output.flush();

        output.println("Displaying current hand: ");
        Collections.sort(playerList.get(pIndex).getHand());

        boolean finishedBuilding = false;
        boolean invalid = false;

        while (!finishedBuilding) {
            invalid = false;

            for (int i = 0; i < playerList.get(pIndex).getHandSize(); i++) {
                output.print("[" + Integer.toString(i+1) + "] " + playerList.get(pIndex).getCardAt(i).toString());
                output.print(" \n");
            }

            output.println("Select position of card to add to your attack. Type 'quit' when you are finished.");
            output.flush();
            int inputNum = -1;
            String inputStr = "";
            if (input.hasNextInt()) {
                inputNum = input.nextInt();
            } else {
                inputStr = input.nextLine();
            }

            if (inputStr.equalsIgnoreCase("quit")) {
                if (playerList.get(pIndex).isAttackHandEmpty()) {
                    output.println(currentPlayerID + " chose to not play any cards");
                    output.flush();
                    finishedBuilding = true;
                } else {
                    String cardsInAttack = playerList.get(pIndex).displayAttackHand();
                    output.println(currentPlayerID + "'s current attack: " + cardsInAttack);
                    output.flush();
                    finishedBuilding = true;
                }
            } else if (inputNum != -1) {
                if (inputNum > playerList.get(pIndex).getHandSize() || inputNum < 0) {
                    output.println("Rejected: Invalid position.");
                    output.flush();
                    invalid = true;
                } else {
                    if (playerList.get(pIndex).getCardAt(inputNum-1).getType().equals("Foe")) {
                        output.println("Rejected: Foe cannot be selected.");
                        output.flush();
                        invalid = true;
                    } else {
                        for (int i = 0; i < playerList.get(pIndex).getAttackHandSize(); i++) {
                            if (playerList.get(pIndex).getAttackCardAt(i).getName().equals(playerList.get(pIndex).getCardAt(inputNum-1).getName())) {
                                output.println("Rejected: Duplicate weapon.");
                                output.flush();
                                invalid = true;
                                break;
                            }
                        }
                    }
                }
                if (!invalid) {
                    playerList.get(pIndex).addAttackCard(playerList.get(pIndex).removeCardAt(inputNum-1));

                    String cardsInAttack = playerList.get(pIndex).displayAttackHand();
                    output.println("Current Attack Cards: " + cardsInAttack);
                    output.flush();
                }
            }
        }
    }

    public void attackSequence(PrintWriter output, int currentStage) {
        int stageValue = questStageList.get(currentStage).getValue();

        for (int i = 0; i < participantList.size(); i++) {
            int playerValue = participantList.get(i).getAttackValue();
            output.println(participantList.get(i).getId() + " value: " + playerValue + " vs Stage value: " + stageValue);
            output.flush();
            if (playerValue < stageValue) {
                output.println("Insufficient attack. " + participantList.get(i).getId() + " Loses!");
                output.flush();
                participantList.get(i).setEligibleStatus(false);
            } else {
                output.println("Sufficient attack. " + participantList.get(i).getId() + " Wins!");
                output.flush();
            }
        }
    }

}