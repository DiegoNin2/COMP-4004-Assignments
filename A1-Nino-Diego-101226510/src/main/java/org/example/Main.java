package org.example;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //game setup functions here

        //take turn function here
    }

    //variables
    ArrayList<Card> adventureDeck = new ArrayList<Card>();
    ArrayList<Card> eventDeck = new ArrayList<Card>();
    ArrayList<Card> eventDiscardDeck = new ArrayList<Card>();
    ArrayList<Card> adventureDiscardDeck = new ArrayList<Card>();
    ArrayList<Card> currentStageSet = new ArrayList<Card>();
    ArrayList<Player> playerList = new ArrayList<Player>();
    ArrayList<Player> participantList = new ArrayList<Player>();

    private int playerTurnIndex = 0;
    private int playerQuestIndex = 0;
    public int prevQuestVal = 0;
    private int currentQuestVal = 0;

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

    //this will be changed to just checking the scores probably whenever i get around to that
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
        output.println("Current Player: " + playerList.get(playerTurnIndex).getId());

        output.println("Displaying hand: ");

        Collections.sort(playerList.get(playerTurnIndex).getHand());

        for (int i = 0; i < playerList.get(playerTurnIndex).getHandSize(); i++) {
            output.print(playerList.get(playerTurnIndex).getCardAt(i).toString());
            output.print(" \n");
        }

        output.println("drawing from event deck: ");
        Card c = drawCard("event");
        output.println(c.toString());

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
            } else {
                //this is the prosperity card
                for (int i = 0; i < 2; i++) {
                    playerList.get(0).addCard(drawCard("adventure"));
                    playerList.get(1).addCard(drawCard("adventure"));
                    playerList.get(2).addCard(drawCard("adventure"));
                    playerList.get(3).addCard(drawCard("adventure"));
                }
            }
        } else if (c.getType().equals("Quest")) {
            output.println("A " + c.getName() + " will start!");
            //questEvent call here
        }

        eventDiscardDeck.add(c);

        output.println("Turn End. Please move out of hot seat for next player.");
        output.println("Press Enter key if you are the next player");
        String inputStr = input.nextLine();
        if (inputStr.isEmpty()) {
            output.println("Clearing output for next player...");
            output.print("\033[H\033[2J");
            output.flush();
        }
        if (playerTurnIndex >= playerList.size()) {
            playerTurnIndex = 0;
        } else {
            playerTurnIndex++;
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

    public void trimHand(Scanner input, PrintWriter output, String currentPlayerID) {
        int amountToDelete = checkHand(currentPlayerID);
        int pIndex = translateID(currentPlayerID);

        output.println("Displaying hand: ");
        Collections.sort(playerList.get(pIndex).getHand());

        //this would be wrapped in a while loop
        //maybe not idk
        for (int i = 0; i < playerList.get(pIndex).getHandSize(); i++) {
            output.print("[" + Integer.toString(i+1) + "] " + playerList.get(pIndex).getCardAt(i).toString());
            output.print(" \n");
        }

        output.println("Select the position of the card to remove: ");
        String inputStr = input.nextLine();
        boolean validNum = false;
        for (int i = 0; i < inputStr.length(); i++) {
            if (Character.isDigit(inputStr.charAt(i))) {
                validNum = true;
                break;
            }
        }

        //this is just temporary
        if (!validNum) {
            return;
        }

        adventureDiscardDeck.add(playerList.get(pIndex).removeCardAt((Integer.parseInt(inputStr) -1)));

        output.println("Displaying trimmed hand: ");
        Collections.sort(playerList.get(pIndex).getHand());

        for (int i = 0; i < playerList.get(pIndex).getHandSize(); i++) {
            output.print("[" + Integer.toString(i+1) + "] " + playerList.get(pIndex).getCardAt(i).toString());
            output.print(" \n");
        }

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

    private int increaseStageVal() {
        int newStageVal = 0;
        for (int i = 0; i < currentStageSet.size(); i++) {
            switch(currentStageSet.get(i).getValue()) {
                case "5":
                    newStageVal += 5;
                    break;
                case "10":
                    newStageVal += 10;
                    break;
                case "15":
                    newStageVal += 15;
                    break;
                case "20":
                    newStageVal += 20;
                    break;
                case "25":
                    newStageVal += 25;
                    break;
                case "30":
                    newStageVal += 30;
                    break;
                case "35":
                    newStageVal += 35;
                    break;
                case "40":
                    newStageVal += 40;
                    break;
                case "50":
                    newStageVal += 50;
                    break;
                case "70":
                    newStageVal += 70;
                    break;
            }
        }
        return newStageVal;
    }

    private int getAttackVal(Player p) {
        int attackVal = 0;
        for (int i = 0; i < p.getAttackHandSize(); i++) {
            switch(p.getAttackCardAt(i).getValue()) {
                case "5":
                    attackVal += 5;
                    break;
                case "10":
                    attackVal += 10;
                    break;
                case "15":
                    attackVal += 15;
                    break;
                case "20":
                    attackVal += 20;
                    break;
                case "25":
                    attackVal += 25;
                    break;
                case "30":
                    attackVal += 30;
                    break;
            }
        }
        return attackVal;
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
                    String responseStr = input.nextLine();
                    if (responseStr.equals("withdraw")) {
                        playerList.get(i).isEligible(false);
                    } else {
                        participantList.add(playerList.get(i));
                    }
                }
            }
        }
    }

    public void questEvent(Scanner input, PrintWriter output, String questValue, String currentPlayerID) {
        boolean questFinished = false;

        int index = translateID(currentPlayerID);

        while (!questFinished) {
            if (index >= playerList.size()) {
                index = 0;
            }

            output.println("Do you, " + playerList.get(index).getId() + ", want to sponsor this quest? (y/n)");
            String inputStr = input.nextLine();
            if (inputStr.contains("n")) {
                output.println(playerList.get(index).getId()  + " declined, asking next player...");
                playerQuestIndex++;
                index++;
                if (playerQuestIndex >= playerList.size()) {
                    output.println("All players have declined. Ending turn...");
                    questFinished = true;
                }
            } else if (inputStr.contains("y")) {
                output.println(playerList.get(index).getId()  + " has sponsored! Quest starting soon!");
                //looped for the amount of stages the quest is
                    //buildQuest call here
                    //store previous stage values
                //end loop
                //while true loop (or something equivalent)
                    //loop for the amount of players
                        //eligible test here
                    //end loop
                getParticipants(input, output, currentPlayerID);
                for (int i = 0; i < participantList.size(); i++) {
                    participantList.get(i).addCard(drawCard("adventure"));
                    int amountToDelete = checkHand(participantList.get(i).getId());
                    if (amountToDelete > 0) {
                        output.println("Too many cards, trimming hand");
                        for (int j = 0; j < amountToDelete; j++) {
                            trimHand(input,output,participantList.get(i).getId());
                        }
                    }
                }

                if (participantList.isEmpty()) {
                    output.println("No participants, quest cancelled...");
                } else {
                    //for the amount of eligible players
                        //buildAttack call here
                    //end loop
                    //proceed attack function here
                    //determine stage winners here
                    //determine if quest end here & reward winners if so
                }
                //discard & redraw here
                questFinished = true;
            }
        }
    }

    public void buildQuest(Scanner input, PrintWriter output, String currentPlayerID) {
        int pIndex = translateID(currentPlayerID);

        output.println(currentPlayerID + " is currently building the quest!");

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
            int inputNum = -1;
            String inputStr = "";
            if (input.hasNextInt()) {
                inputNum = input.nextInt();
            } else {
                inputStr = input.next();
            }

            if (inputStr.equalsIgnoreCase("Quit")) {
                if (currentStageSet.isEmpty()) {
                    output.println("Cannot Quit: Stage cannot be empty.");
                } else if (prevQuestVal >= currentQuestVal && prevQuestVal != 0) {
                    output.println("Cannot Quit: Insufficient values for this stage");
                } else {
                    Collections.sort(currentStageSet);
                    String cardsInStage = "";
                    for (int i = 0; i < currentStageSet.size(); i++) {
                        if (i == currentStageSet.size()-1) {
                            cardsInStage += currentStageSet.get(i).toString();
                        } else {
                            cardsInStage += currentStageSet.get(i).toString() + ", ";
                        }
                    }
                    output.println("The finished quest stage: " + cardsInStage);
                    finishedBuilding = true;
                }
            } else if (inputStr.isEmpty()) {
                if (inputNum > playerList.get(pIndex).getHandSize() || inputNum < 0) {
                    output.println("Rejected: Invalid position.");
                } else {
                    for (int i = 0; i < currentStageSet.size(); i++) {
                        if (currentStageSet.get(i).getType().equals("Foe") && playerList.get(pIndex).getCardAt(inputNum-1).getType().equals("Foe")) {
                            output.println("Rejected: Foe already chosen.");
                            invalid = true;
                            break;
                        } else if (currentStageSet.get(i).getType().equals("Weapon")) {
                            if (currentStageSet.get(i).getName().equals(playerList.get(pIndex).getCardAt(inputNum-1).getName())) {
                                output.println("Rejected: Duplicate weapon.");
                                invalid = true;
                                break;
                            }
                        }
                    }
                    if (!invalid) {
                        currentStageSet.add(playerList.get(pIndex).getCardAt(inputNum-1));

                        String cardsInStage = "";
                        for (int i = 0; i < currentStageSet.size(); i++) {
                            if (i == currentStageSet.size()-1) {
                                cardsInStage += currentStageSet.get(i).toString();
                            } else {
                                cardsInStage += currentStageSet.get(i).toString() + ", ";
                            }
                        }
                        currentQuestVal = increaseStageVal();

                        output.println("Current Stage: " + cardsInStage);

                    }
                }
            }
        }
    }

    public void buildAttack(Scanner input, PrintWriter output, String currentPlayerID) {
        int pIndex = translateID(currentPlayerID);

        output.println("Building attack for " + currentPlayerID);

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
            int inputNum = -1;
            String inputStr = "";
            if (input.hasNextInt()) {
                inputNum = input.nextInt();
            } else {
                inputStr = input.next();
            }

            if (inputStr.equalsIgnoreCase("quit")) {
                if (playerList.get(pIndex).isAttackHandEmpty()) {
                    output.println(currentPlayerID + " chose to not play any cards");
                    finishedBuilding = true;
                } else {
                    String cardsInAttack = "";
                    for (int i = 0; i < playerList.get(pIndex).getAttackHandSize(); i++) {
                        cardsInAttack += playerList.get(pIndex).getAttackCardAt(i).toString();
                    }
                    output.println(currentPlayerID + "'s current attack: " + cardsInAttack);
                    finishedBuilding = true;
                }
            } else if (inputStr.isEmpty()) {
                if (inputNum > playerList.get(pIndex).getHandSize() || inputNum < 0) {
                    output.println("Rejected: Invalid position.");
                    invalid = true;
                } else {
                    if (playerList.get(pIndex).getCardAt(inputNum-1).getType().equals("Foe")) {
                        output.println("Rejected: Foe cannot be selected.");
                        invalid = true;
                    } else {
                        for (int i = 0; i < playerList.get(pIndex).getAttackHandSize(); i++) {
                            if (playerList.get(pIndex).getAttackCardAt(i).getName().equals(playerList.get(pIndex).getCardAt(inputNum-1).getName())) {
                                output.println("Rejected: Duplicate weapon.");
                                invalid = true;
                                break;
                            }
                        }
                    }
                }
                if (!invalid) {
                    playerList.get(pIndex).addAttackCard(playerList.get(pIndex).getCardAt(inputNum-1));

                    String cardsInAttack = "";
                    for (int i = 0; i < playerList.get(pIndex).getAttackHandSize(); i++) {
                        cardsInAttack += playerList.get(pIndex).getAttackCardAt(i).toString();
                    }
                    output.println("Current Attack Cards: " + cardsInAttack);
                }
            }
        }
    }

    public void attackSequence(Scanner input, PrintWriter output) {
        int stageValue = increaseStageVal();

        for (int i = 0; i < participantList.size(); i++) {
            int playerValue = getAttackVal(participantList.get(i));
            if (playerValue < stageValue) {
                output.println("Insufficient attack. " + participantList.get(i).getId() + " Loses!");
                //make player be ineligible here later im lazy & forgot for R-CODE-31 commit
            } else {
                output.println("Sufficient attack. " + participantList.get(i).getId() + " Wins!");
            }
        }
    }

}