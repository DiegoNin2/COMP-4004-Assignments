package org.example;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GameService {

    private GameState gameState;

    public GameService() {
        gameState = new GameState();
    }

    //all gameState methods (for ease of access)
    public void initalizePlayers() { gameState.initializePlayers(); }

    public void initalizeDecks() { gameState.initializeDecks(); }

    public void dealCards() { gameState.dealCards(); }

    public void checkForWinners() { gameState.checkForWinners(); }

    public int checkHand(String playerID) { return gameState.checkHand(playerID); }

    public int amountToGet(String playerID) { return gameState.amountToGet(playerID); }

    public int translateID(String playerID) { return gameState.translateID(playerID); }

    public int getQuestLength(String questVal) { return gameState.getQuestLength(questVal); }

    public boolean noEligibleParticipants() { return gameState.noEligibleParticipants(); }

    public void clearParticipants() { gameState.clearParticipants(); }

    public void clearQuestStages() { gameState.clearQuestStages(); }

    public boolean isGameEnd() { return gameState.isGameEnd(); }

    //use only for testing purposes
    public void pickCard(int index, String type, String name, String value, int playerID) { gameState.pickCard(index, type, name, value, playerID);}

    //the rest of the game (divided by sections)
    //because it makes it easier to work with the frontend

    public void reset() {
        gameState = new GameState();
    }

    //displayWinner section
    public void displayWinner(PrintWriter output) {
        checkForWinners();

        int winnerCount = 0;
        ArrayList<String> winnerIDs = new ArrayList<String>();

        if (gameState.getPlayerList().get(0).getWinnerStatus()) { winnerCount++; winnerIDs.add("P1"); }
        if (gameState.getPlayerList().get(1).getWinnerStatus()) { winnerCount++; winnerIDs.add("P2"); }
        if (gameState.getPlayerList().get(2).getWinnerStatus()) { winnerCount++; winnerIDs.add("P3"); }
        if (gameState.getPlayerList().get(3).getWinnerStatus()) { winnerCount++; winnerIDs.add("P4");}

        switch(winnerCount) {
            case 1:
                output.println("Winner: " + winnerIDs.get(0));
                gameState.setGameEnd(true);
                break;
            case 2:
                output.println("Winners: " + winnerIDs.get(0) + " and " + winnerIDs.get(1));
                gameState.setGameEnd(true);
                break;
            case 3:
                output.println("Winners: " + winnerIDs.get(0) + ", " + winnerIDs.get(1) + " and " + winnerIDs.get(2));
                gameState.setGameEnd(true);
                break;
            case 4:
                output.println("Winners: " + winnerIDs.get(0) + ", " + winnerIDs.get(1) + ", " + winnerIDs.get(2) + " and " + winnerIDs.get(3));
                gameState.setGameEnd(true);
                break;
            default:
                break;
        }

    }

    public GameResponse displayWinners(String id) {
        checkForWinners();

        int winnerCount = 0;
        ArrayList<String> winnerIDs = new ArrayList<String>();

        if (gameState.getPlayerList().get(0).getWinnerStatus()) { winnerCount++; winnerIDs.add("P1"); }
        if (gameState.getPlayerList().get(1).getWinnerStatus()) { winnerCount++; winnerIDs.add("P2"); }
        if (gameState.getPlayerList().get(2).getWinnerStatus()) { winnerCount++; winnerIDs.add("P3"); }
        if (gameState.getPlayerList().get(3).getWinnerStatus()) { winnerCount++; winnerIDs.add("P4"); }

        String message;
        switch(winnerCount) {
            case 1:
                message = "Winner: " + winnerIDs.get(0);
                gameState.setGameEnd(true);
                break;
            case 2:
                message = "Winners: " + winnerIDs.get(0) + " and " + winnerIDs.get(1);
                gameState.setGameEnd(true);
                break;
            case 3:
                message = "Winners: " + winnerIDs.get(0) + ", " + winnerIDs.get(1) + " and " + winnerIDs.get(2);
                gameState.setGameEnd(true);
                break;
            case 4:
                message = "Winners: " + winnerIDs.get(0) + ", " + winnerIDs.get(1) + ", " + winnerIDs.get(2) + " and " + winnerIDs.get(3);
                gameState.setGameEnd(true);
                break;
            default:
                message = "no winners yet";
                break;
        }

        return new GameResponse(
          "success",
                message,
                id,
                gameState.getPlayerList().get(gameState.getPlayerTurnIndex()).displayHand(),
                gameState.getPlayerList(),
                null
        );
    }

    //trimHand section
    public void trimHand(Scanner input, PrintWriter output, String currentPlayerID) {
        int pIndex = translateID(currentPlayerID);

        output.println("Currently trimming: " + currentPlayerID);

        output.println("Displaying hand: ");
        Collections.sort(gameState.getPlayerList().get(pIndex).getHand());

        //this would be wrapped in a while loop
        //maybe not idk
        for (int i = 0; i < gameState.getPlayerList().get(pIndex).getHandSize(); i++) {
            output.print("[" + Integer.toString(i+1) + "] " + gameState.getPlayerList().get(pIndex).getCardAt(i).toString());
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

        gameState.getAdventureDeck().addToDiscard(gameState.getPlayerList().get(pIndex).removeCardAt(inputNum -1));

        output.println("Displaying trimmed hand: ");
        Collections.sort(gameState.getPlayerList().get(pIndex).getHand());

        for (int i = 0; i < gameState.getPlayerList().get(pIndex).getHandSize(); i++) {
            output.print("[" + Integer.toString(i+1) + "] " + gameState.getPlayerList().get(pIndex).getCardAt(i).toString());
            output.print(" \n");
        }
        output.flush();
    }

    public GameResponse trimHand(String id, String cardIndex) {
        Player currentPlayer = gameState.getPlayerList().get(gameState.getPlayerTurnIndex());

        int index = Integer.parseInt(cardIndex);
        currentPlayer.removeCardAt(index);

        int amountToDelete = checkHand(currentPlayer.getId());
        if (amountToDelete > 0) {
            return new GameResponse(
                    "success",
                    "need to trim more...",
                    id,
                    currentPlayer.displayHand(),
                    gameState.getPlayerList(),
                    null
            );
        }

        ArrayList<Player> toTrim = gameState.getTrimQueue();
        toTrim.remove(0);

        if (!toTrim.isEmpty()) {
            Player nextPlayer = toTrim.get(0);
            gameState.setTrimmingID(nextPlayer.getId());
            gameState.setAmountToDelete(checkHand(nextPlayer.getId()));
            String message = "trimming done for " + id + ". moving on to player " + nextPlayer.getId();

            return new GameResponse(
                    "success",
                    message,
                    nextPlayer.getId(),
                    nextPlayer.displayHand(),
                    gameState.getPlayerList(),
                    null
            );
        } else {
            gameState.setTrimmingID(null);
            gameState.setAmountToDelete(0);
            gameState.setTrimQueue(null);

            return new GameResponse(
                    "success",
                    "trimming complete",
                    id,
                    currentPlayer.displayHand(),
                    gameState.getPlayerList(),
                    null
            );
        }
    }

    //getParticipants section
    public void getParticipants(Scanner input, PrintWriter output, String currentPlayerID) {
        String eligiblePlayers = "";
        for (int i = 0; i < gameState.getPlayerList().size(); i++) {
            if (!gameState.getPlayerList().get(i).getId().equals(currentPlayerID)) {
                if (gameState.getPlayerList().get(i).getEligibleStatus()) {
                    if (i == gameState.getPlayerList().size()-1) {
                        eligiblePlayers += gameState.getPlayerList().get(i).getId();
                    } else {
                        eligiblePlayers += gameState.getPlayerList().get(i).getId() + ", ";
                    }
                }
            }
        }
        output.println("Eligible Players: " + eligiblePlayers);

        for (int i = 0; i < gameState.getPlayerList().size(); i++) {
            if (!gameState.getPlayerList().get(i).getId().equals(currentPlayerID)) {
                if (gameState.getPlayerList().get(i).getEligibleStatus()) {
                    output.println(gameState.getPlayerList().get(i).getId() + ", would you like to participate or withdraw from the quest?");
                    output.flush();
                    String responseStr = input.nextLine();
                    if (responseStr.equals("withdraw")) {
                        gameState.getPlayerList().get(i).setEligibleStatus(false);
                    } else {
                        gameState.getParticipantList().add(gameState.getPlayerList().get(i));
                    }
                    output.println("Please hot seat for next player...");
                    output.flush();
                }
            }
        }
    }

    public GameResponse findEligiblePlayers(String id, Card c) {
        String eligiblePlayers = "";
        for (int i = 0; i < gameState.getPlayerList().size(); i++) {
            if (!gameState.getPlayerList().get(i).getId().equals(id)) {
                if (gameState.getPlayerList().get(i).getEligibleStatus()) {
                    if (i == gameState.getPlayerList().size()-1) {
                        eligiblePlayers += gameState.getPlayerList().get(i).getId();
                    } else {
                        eligiblePlayers += gameState.getPlayerList().get(i).getId() + ", ";
                    }
                }
            }
        }

        String message = "Eligible Players: " + eligiblePlayers;

        return new GameResponse (
          "success",
                message,
                id,
                gameState.getPlayerList().get(gameState.getPlayerTurnIndex()).displayHand(),
                gameState.getPlayerList(),
                c
        );
    }

    public GameResponse getParticipants(String id, String decision, Card c) {
        int currentPlayer = gameState.translateID(id);
        String message = "";

        if (gameState.getPlayerList().get(currentPlayer).getEligibleStatus()) {
            if (decision.equals("withdraw")) {
                gameState.getPlayerList().get(currentPlayer).setEligibleStatus(false);
                message = "Player " + currentPlayer + " decided to not participate.";
            } else {
                gameState.getParticipantList().add(gameState.getPlayerList().get(currentPlayer));
                message = "Player " + currentPlayer + " decided to participate.";
            }
        }

        return new GameResponse(
                "success",
                message,
                id,
                gameState.getPlayerList().get(gameState.getPlayerTurnIndex()).displayHand(),
                gameState.getPlayerList(),
                c
        );
    }

    //attackSequence section
    public void attackSequence(PrintWriter output, int currentStage) {
        int stageValue = gameState.getQuestStageList().get(currentStage).getValue();

        for (int i = 0; i < gameState.getParticipantList().size(); i++) {
            int playerValue = gameState.getParticipantList().get(i).getAttackValue();
            output.println(gameState.getParticipantList().get(i).getId() + " value: " + playerValue + " vs Stage value: " + stageValue);
            output.flush();
            if (playerValue < stageValue) {
                output.println("Insufficient attack. " + gameState.getParticipantList().get(i).getId() + " Loses!");
                output.flush();
                gameState.getParticipantList().get(i).setEligibleStatus(false);
            } else {
                output.println("Sufficient attack. " + gameState.getParticipantList().get(i).getId() + " Wins!");
                output.flush();
            }
        }
    }

    public GameResponse attackSequence(String id, int currentStage, Card c) {
        int stageValue = gameState.getQuestStageList().get(currentStage).getValue();
        StringBuilder message = new StringBuilder("Handling attack for stage " + (currentStage + 1));

        for (int i = 0; i < gameState.getParticipantList().size(); i++){
            int playerValue = gameState.getParticipantList().get(i).getAttackValue();
            message.append(gameState.getParticipantList().get(i).getId())
                    .append(" value: ")
                    .append(playerValue)
                    .append(" vs Stage value: ")
                    .append(stageValue)
                    .append("\n");

            if (playerValue < stageValue) {
                message.append("Insufficient attack. Player ")
                        .append(id)
                        .append(" Loses!\n");
                gameState.getParticipantList().get(i).setEligibleStatus(false);
            } else {
                message.append("Sufficient attack. Player ")
                        .append(id)
                        .append(" Wins!\n");
            }
        }

        return new GameResponse(
                "success",
                message.toString(),
                null,
                null,
                gameState.getPlayerList(),
                c
        );
    }

    //buildAttack section
    public void buildAttack(Scanner input, PrintWriter output, String currentPlayerID) {
        int pIndex = translateID(currentPlayerID);

        output.println("Building attack for " + currentPlayerID);
        output.flush();

        output.println("Displaying current hand: ");
        Collections.sort(gameState.getPlayerList().get(pIndex).getHand());

        boolean finishedBuilding = false;
        boolean invalid = false;

        while (!finishedBuilding) {
            invalid = false;

            for (int i = 0; i < gameState.getPlayerList().get(pIndex).getHandSize(); i++) {
                output.print("[" + Integer.toString(i+1) + "] " + gameState.getPlayerList().get(pIndex).getCardAt(i).toString());
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
                if (gameState.getPlayerList().get(pIndex).isAttackHandEmpty()) {
                    output.println(currentPlayerID + " chose to not play any cards");
                    output.flush();
                    finishedBuilding = true;
                } else {
                    String cardsInAttack = gameState.getPlayerList().get(pIndex).displayAttackHand();
                    output.println(currentPlayerID + "'s current attack: " + cardsInAttack);
                    output.flush();
                    finishedBuilding = true;
                }
            } else if (inputNum != -1) {
                if (inputNum > gameState.getPlayerList().get(pIndex).getHandSize() || inputNum < 0) {
                    output.println("Rejected: Invalid position.");
                    output.flush();
                    invalid = true;
                } else {
                    if (gameState.getPlayerList().get(pIndex).getCardAt(inputNum-1).getType().equals("Foe")) {
                        output.println("Rejected: Foe cannot be selected.");
                        output.flush();
                        invalid = true;
                    } else {
                        for (int i = 0; i < gameState.getPlayerList().get(pIndex).getAttackHandSize(); i++) {
                            if (gameState.getPlayerList().get(pIndex).getAttackCardAt(i).getName().equals(gameState.getPlayerList().get(pIndex).getCardAt(inputNum-1).getName())) {
                                output.println("Rejected: Duplicate weapon.");
                                output.flush();
                                invalid = true;
                                break;
                            }
                        }
                    }
                }
                if (!invalid) {
                    gameState.getPlayerList().get(pIndex).addAttackCard(gameState.getPlayerList().get(pIndex).removeCardAt(inputNum-1));

                    String cardsInAttack = gameState.getPlayerList().get(pIndex).displayAttackHand();
                    output.println("Current Attack Cards: " + cardsInAttack);
                    output.flush();
                }
            }
        }
    }

    public GameResponse buildAttack(String id, String decision) {
        Player currentPlayer = gameState.getPlayerList().get(translateID(id));
        StringBuilder message = new StringBuilder();

        if (decision.equalsIgnoreCase("quit")) {
            if (currentPlayer.isAttackHandEmpty()) {
                message.append("Player ").append(id).append(" chose to not play any cards");
            } else {
                String cardsInAttack = currentPlayer.displayAttackHand();
                message.append("Player ").append(id).append("'s current attack: ").append(cardsInAttack);
            }
            return new GameResponse(
                    "success",
                    message.toString(),
                    id,
                    currentPlayer.displayHand(),
                    gameState.getPlayerList(),
                    null
            );
        }

        int inputNum = Integer.parseInt(decision);
        if (inputNum > currentPlayer.getHandSize() || inputNum < 0) {
            message.append("Rejected: Invalid Position.");
        } else if (currentPlayer.getCardAt(inputNum-1).getType().equals("Foe")) {
            message.append("Rejected: Foe cannot be selected.");
        } else if (currentPlayer.getCardAt(inputNum-1).getType().equals("Weapon")) {
            for (int i = 0; i < currentPlayer.getHandSize(); i++) {
                if (currentPlayer.getAttackCardAt(i).getName().equals(currentPlayer.getCardAt(inputNum-1).getName())) {
                    message.append("Rejected: Duplicate weapon");
                    break;
                }
            }
        } else {
            currentPlayer.addAttackCard(currentPlayer.removeCardAt(inputNum-1));

            message.append(currentPlayer.getCardAt(inputNum-1).getName()).append(" added.");
        }

        return new GameResponse(
                "success",
                message.toString(),
                id,
                currentPlayer.displayHand(),
                gameState.getPlayerList(),
                null
        );
    }

    //buildQuest section
    public void buildQuest(Scanner input, PrintWriter output, String currentPlayerID, int stageIndex) {
        int pIndex = translateID(currentPlayerID);
        Quest quest = new Quest();

        output.println(currentPlayerID + " is currently building the quest!");
        output.flush();

        output.println("Displaying current hand: ");
        Collections.sort(gameState.getPlayerList().get(pIndex).getHand());

        boolean finishedBuilding = false;
        boolean invalid = false;

        while (!finishedBuilding) {
            invalid = false;
            for (int i = 0; i < gameState.getPlayerList().get(pIndex).getHandSize(); i++) {
                output.print("[" + Integer.toString(i+1) + "] " + gameState.getPlayerList().get(pIndex).getCardAt(i).toString());
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
                } else if (!gameState.getQuestStageList().isEmpty()) {
                    if (gameState.getQuestStageList().get(stageIndex).getValue() >= quest.getValue() && gameState.getQuestStageList().get(stageIndex).getValue() != 0) {
                        output.println("Cannot Quit: Insufficient values for this stage");
                    } else {
                        Collections.sort(quest.getStageSet());
                        String cardsInStage = quest.displaySet();
                        output.println("The finished quest stage: " + cardsInStage);
                        gameState.getQuestStageList().add(quest);
                        finishedBuilding = true;
                    }
                } else {
                    Collections.sort(quest.getStageSet());
                    String cardsInStage = quest.displaySet();
                    output.println("The finished quest stage: " + cardsInStage);
                    gameState.getQuestStageList().add(quest);
                    finishedBuilding = true;
                }
            } else if (inputNum != -1) {
                if (inputNum > gameState.getPlayerList().get(pIndex).getHandSize() || inputNum < 0) {
                    output.println("Rejected: Invalid position.");
                    output.flush();
                } else {
                    for (int i = 0; i < quest.getStageSize(); i++) {
                        if (quest.getCardAt(i).getType().equals("Foe") && gameState.getPlayerList().get(pIndex).getCardAt(inputNum-1).getType().equals("Foe")) {
                            output.println("Rejected: Foe already chosen.");
                            output.flush();
                            invalid = true;
                            break;
                        } else if (quest.getCardAt(i).getType().equals("Weapon")) {
                            if (quest.getCardAt(i).getName().equals(gameState.getPlayerList().get(pIndex).getCardAt(inputNum-1).getName())) {
                                output.println("Rejected: Duplicate weapon.");
                                output.flush();
                                invalid = true;
                                break;
                            }
                        }
                    }
                    if (!invalid) {
                        quest.addCard(gameState.getPlayerList().get(pIndex).removeCardAt(inputNum-1));

                        String cardsInStage = quest.displaySet();
                        quest.increaseValue();

                        output.println("Current Stage: " + cardsInStage);
                        output.flush();
                    }
                }
            }
        }
    }

    public GameResponse buildQuest(String id, String decision, Card c) {
        Player currentPlayer = gameState.getPlayerList().get(translateID(id));
        Quest quest = new Quest();
        StringBuilder message = new StringBuilder();
        int stageIndex = gameState.getQuestStageList().size() + 1;

        if (decision.equalsIgnoreCase("quit")) {
            if (quest.isStageEmpty()) {
                message.append("Cannot Quit: Stage cannot be empty.");
            } else if (!gameState.getQuestStageList().isEmpty()) {
                if (gameState.getQuestStageList().get(stageIndex-1).getValue() >= quest.getValue() && gameState.getQuestStageList().get(stageIndex-1).getValue() != 0) {
                    message.append("Cannot Quit: Insufficient value for this stage");
                } else {
                    Collections.sort(quest.getStageSet());
                    String cardsInStage = quest.displaySet();
                    message.append("The finished quest stage: ").append(cardsInStage);
                    gameState.getQuestStageList().add(quest);
                }
            }

            if (stageIndex < gameState.getQuestLength(c.getValue())) {
                message.append("building next stage...");
            } else {
                message.append("Quest built!");
            }

            return new GameResponse(
              "success",
                    message.toString(),
                    id,
                    currentPlayer.displayHand(),
                    gameState.getPlayerList(),
                    null
            );
        }

        int inputNum = Integer.parseInt(decision);
        if (inputNum > currentPlayer.getHandSize() || inputNum < 0) {
            message.append("Rejected: Invalid Position.");
        } else {
            for (int i = 0; i < quest.getStageSize(); i++) {
                if (quest.getCardAt(i).getType().equals("Foe") && currentPlayer.getCardAt(inputNum-1).getType().equals("Foe")) {
                    message.append("Rejected: Foe already chosen.");
                    return new GameResponse(
                            "error",
                            message.toString(),
                            id,
                            currentPlayer.displayHand(),
                            gameState.getPlayerList(),
                            null
                    );
                } else if (quest.getCardAt(i).getType().equals("Weapon")) {
                    if (quest.getCardAt(i).getName().equals(currentPlayer.getCardAt(inputNum-1).getName())) {
                        message.append("Rejected: Duplicate weapon.");
                        return new GameResponse(
                                "error",
                                message.toString(),
                                id,
                                currentPlayer.displayHand(),
                                gameState.getPlayerList(),
                                null
                        );
                    }
                }
            }
            quest.addCard(currentPlayer.getCardAt(inputNum-1));
            message.append(currentPlayer.getCardAt(inputNum-1).getName()).append(" added.");
        }
        return new GameResponse(
                "success",
                message.toString(),
                id,
                currentPlayer.displayHand(),
                gameState.getPlayerList(),
                null
        );
    }

    //questEvent section
    public void questEvent(Scanner input, PrintWriter output, String questValue, String currentPlayerID) {
        boolean questFinished = false;

        int index = translateID(currentPlayerID);

        int questLength = getQuestLength(questValue);
        gameState.getParticipantList().clear();

        while (!questFinished) {
            if (index >= gameState.getPlayerList().size()) {
                index = 0;
            }

            output.println("Do you, " + gameState.getPlayerList().get(index).getId() + ", want to sponsor this quest? (y/n)");
            output.flush();
            String inputStr = input.nextLine();
            if (inputStr.contains("n")) {
                output.println(gameState.getPlayerList().get(index).getId() + " declined, asking next player...");
                output.flush();
                gameState.setPlayerQuestIndex(gameState.getPlayerQuestIndex() + 1);
                index++;
                if (gameState.getPlayerQuestIndex() >= gameState.getPlayerList().size()) {
                    output.println("All players have declined. Ending turn...");
                    output.flush();
                    questFinished = true;
                }
            } else if (inputStr.contains("y")) {
                output.println(gameState.getPlayerList().get(index).getId() + " has sponsored! Quest starting soon!");
                output.flush();
                //i know this check will never happen but i don't feel like setting up some dummy data to pass
                if (gameState.getQuestStageList().isEmpty()) {
                    for (int i = 0; i < questLength; i++) {
                        output.println("Building for quest stage: " + (i + 1));
                        output.flush();
                        buildQuest(input, output, gameState.getPlayerList().get(index).getId(), i - 1);
                    }
                }

                output.println("Clearing output for participants...");
                //flushDisplay(output);
                output.flush();

                for (int k = 0; k < gameState.getQuestStageList().size(); k++) {
                    getParticipants(input, output, gameState.getPlayerList().get(index).getId());
                    for (int i = 0; i < gameState.getParticipantList().size(); i++) {
                        gameState.getParticipantList().get(i).addCard(gameState.getAdventureDeck().drawCard());
                        int amountToDelete = checkHand(gameState.getParticipantList().get(i).getId());
                        if (amountToDelete > 0) {
                            output.println("Too many cards, trimming hand");
                            output.flush();
                            for (int j = 0; j < amountToDelete; j++) {
                                trimHand(input, output, gameState.getParticipantList().get(i).getId());
                            }
                            output.println("Please move hot seat for next player.");
                            output.println("Clearing output for next player...");
                            //flushDisplay(output);
                            output.flush();
                        }
                    }

                    if (gameState.getParticipantList().isEmpty()) {
                        output.println("No participants, quest cancelled...");
                        break;
                    } else {
                        for (int i = 0; i < gameState.getParticipantList().size(); i++) {
                            //this check will never happen but i don't feel like setting up more dummy data
                            if (gameState.getParticipantList().get(i).isAttackHandEmpty()) {
                                output.println("Building for attack for quest stage: " + (k + 1));
                                output.flush();
                                buildAttack(input, output, gameState.getParticipantList().get(i).getId());
                            }
                            output.println("Please move hot seat for next player.");
                            output.println("Clearing output for next player...");
                            //flushDisplay(output);
                            output.flush();
                        }
                        attackSequence(output, k);
                        if (!noEligibleParticipants()) {
                            output.println("No eligible participants for next stage. Ending quest...");
                            output.flush();
                            break;
                        } else {
                            for (int i = 0; i < gameState.getParticipantList().size(); i++) {
                                for (int j = 0; j < gameState.getParticipantList().get(i).getAttackHandSize(); j++) {
                                    gameState.getAdventureDeck().addToDiscard(gameState.getParticipantList().get(i).getAttackCardAt(j));
                                }
                                gameState.getParticipantList().get(i).removeAttackCards();
                            }
                            if (k != gameState.getQuestStageList().size()-1) {
                                gameState.getParticipantList().clear();
                            }
                        }
                    }
                }
                output.println("Last stage of quest complete. Ending quest & rewarding winner(s)...");
                output.flush();
                for (int i = 0; i < gameState.getParticipantList().size(); i++) {
                    if (gameState.getParticipantList().get(i).getEligibleStatus()) {
                        int shieldAward = gameState.getParticipantList().get(i).getShields() + questLength;
                        gameState.getParticipantList().get(i).setShields(shieldAward);
                    }
                }
                for (int i = 0; i < gameState.getQuestStageList().size(); i++) {
                    gameState.getQuestStageList().get(i).removeAll();
                }
                gameState.getQuestStageList().clear();
                int amountToGet = (amountToGet(gameState.getPlayerList().get(index).getId()) + questLength);
                for (int i = 0; i < amountToGet; i++) {
                    gameState.getPlayerList().get(translateID(gameState.getPlayerList().get(index).getId())).addCard(gameState.getAdventureDeck().drawCard());
                }
                int amountToDelete = checkHand(gameState.getPlayerList().get(index).getId());
                if (amountToDelete > 0) {
                    output.println("Too many cards, trimming hand");
                    output.flush();
                    for (int i = 0; i < amountToDelete; i++) {
                        trimHand(input, output, gameState.getPlayerList().get(index).getId());
                    }
                }
                questFinished = true;
            }
        }
    }

    public GameResponse selectBuilder(String id, String decision) {
        Player currentPlayer = gameState.getPlayerList().get(translateID(id));
        StringBuilder message = new StringBuilder();

        if (decision.equalsIgnoreCase("y")) {
            gameState.setBuilderID(id);
            message.append("Player ").append(id).append(" has sponsored!");
            return new GameResponse(
                    "success",
                    message.toString(),
                    id,
                    currentPlayer.displayHand(),
                    gameState.getPlayerList(),
                    null
            );
        } else {
            gameState.setPlayerQuestIndex(gameState.getPlayerQuestIndex()+1);
            if (gameState.getPlayerQuestIndex() >= gameState.getPlayerList().size()) {
                message.append("All players have declined. Ending turn...");
                return new GameResponse(
                        "success",
                        message.toString(),
                        id,
                        currentPlayer.displayHand(),
                        gameState.getPlayerList(),
                        null
                );
            }
        }
        message.append("Player ").append(id).append(" declined, asking next player...");
        return new GameResponse(
                "success",
                message.toString(),
                id,
                currentPlayer.displayHand(),
                gameState.getPlayerList(),
                null
        );
    }

    public GameResponse rewardPlayers(String id, Card c) {
        int questLength = gameState.getQuestLength(c.getType());
        StringBuilder message = new StringBuilder();
        Player currentPlayer = gameState.getPlayerList().get(translateID(id));

        for (int i = 0; i < gameState.getParticipantList().size(); i++) {
            if (gameState.getParticipantList().get(i).getEligibleStatus()) {
                int shieldAward = gameState.getParticipantList().get(i).getShields() + questLength;
                gameState.getParticipantList().get(i).setShields(shieldAward);
            }
        }
        clearQuestStages();
        int amountToGet = (amountToGet(gameState.getBuilderID()) + questLength);
        for (int i = 0; i < amountToGet; i++) {
            gameState.getPlayerList().get(translateID(gameState.getBuilderID())).addCard(gameState.getAdventureDeck().drawCard());
        }
        int amountToDelete = checkHand(gameState.getBuilderID());
        if (amountToDelete > 0) {
            message.append("Too many cards, trimming hand for player ").append(gameState.getBuilderID());
            return new GameResponse(
              "success",
                    message.toString(),
                    id,
                    currentPlayer.displayHand(),
                    gameState.getPlayerList(),
                    c
            );
        }
        clearParticipants();
        message.append("Eligible players have been rewarded!");
        return new GameResponse(
                "success",
                message.toString(),
                id,
                currentPlayer.displayHand(),
                gameState.getPlayerList(),
                c
        );
    }

    //takeTurn section
    public void takeTurn(Scanner input, PrintWriter output) {
        output.println("Current Player: " + gameState.getPlayerList().get(gameState.getPlayerTurnIndex()).getId());

        output.println("Displaying hand: ");

        Collections.sort(gameState.getPlayerList().get(gameState.getPlayerTurnIndex()).getHand());

        output.print(gameState.getPlayerList().get(gameState.getPlayerTurnIndex()).displayHand());

        output.println("drawing from event deck: ");
        Card c = gameState.getEventDeck().drawCard();
        output.println(c.toString());
        output.flush();

        if (c.getType().equals("Event")) {
            if (c.getName().equals("Plague")) {
                if (gameState.getPlayerList().get(gameState.getPlayerTurnIndex()).getShields() >= 2) {
                    gameState.getPlayerList().get(gameState.getPlayerTurnIndex()).setShields(gameState.getPlayerList().get(gameState.getPlayerTurnIndex()).getShields()-2);
                } else {
                    gameState.getPlayerList().get(gameState.getPlayerTurnIndex()).setShields(0);
                }
            } else if (c.getName().equals("Queen's Favor")) {
                for (int i = 0; i < 2; i++) {
                    gameState.getPlayerList().get(gameState.getPlayerTurnIndex()).addCard(gameState.getAdventureDeck().drawCard());
                }
                int amountToDelete = checkHand(gameState.getPlayerList().get(gameState.getPlayerTurnIndex()).getId());
                if (amountToDelete > 0) {
                    output.println("Too many cards, trimming hand");
                    output.flush();
                    for (int i = 0; i < amountToDelete; i++) {
                        trimHand(input, output, gameState.getPlayerList().get(gameState.getPlayerTurnIndex()).getId());
                    }
                }
                output.println("continuing...");
                output.flush();
            } else {
                //this is the prosperity card
                for (int i = 0; i < 2; i++) {
                    gameState.getPlayerList().get(0).addCard(gameState.getAdventureDeck().drawCard());
                    gameState.getPlayerList().get(1).addCard(gameState.getAdventureDeck().drawCard());
                    gameState.getPlayerList().get(2).addCard(gameState.getAdventureDeck().drawCard());
                    gameState.getPlayerList().get(3).addCard(gameState.getAdventureDeck().drawCard());
                }

                for (int i = 0; i < gameState.getPlayerList().size(); i++) {
                    int amountToDelete = checkHand(gameState.getPlayerList().get(i).getId());
                    if (amountToDelete > 0) {
                        output.println("Too many cards, trimming hand");
                        output.flush();
                        for (int j = 0; j < amountToDelete; j++) {
                            trimHand(input, output, gameState.getPlayerList().get(i).getId());
                        }
                    }
                }
                output.println("continuing...");
                output.flush();

            }
        } else if (c.getType().equals("Quest")) {
            output.println("A " + c.getName() + " will start!");
            questEvent(input, output, c.getValue(), gameState.getPlayerList().get(gameState.getPlayerTurnIndex()).getId());
            output.println("Displaying Shields: ");
            output.flush();
            for (int i = 0; i < gameState.getPlayerList().size(); i++) {
                output.println(gameState.getPlayerList().get(i).getId() + "'s Shields: " + gameState.getPlayerList().get(i).getShields());
                output.flush();
            }
        }

        displayWinner(output);
        output.flush();

        gameState.getEventDeck().addToDiscard(c);

        if (gameState.isGameEnd()) {
            output.println("Game end.");
        } else {
            output.println("Turn End. Please move out of hot seat for next player.");
            output.println("Press Enter key if you are the next player");
            output.flush();
            String inputStr = input.nextLine();
            if (inputStr.isEmpty()) {
                output.println("Clearing output for next player...");
                output.flush();
                //flushDisplay(output);
                output.flush();
                output.println("Moving on to next player...");
                output.flush();
            }
            if (gameState.getPlayerTurnIndex() >= gameState.getPlayerList().size()) {
                gameState.setPlayerTurnIndex(0);
            } else {
                gameState.setPlayerTurnIndex(gameState.getPlayerTurnIndex() + 1);
            }
        }
    }

    public GameResponse startTurn(String id) {
        Player currentPlayer = gameState.getPlayerList().get(gameState.getPlayerTurnIndex());
        currentPlayer.sortHand();
        return new GameResponse (
                "success",
                "Current Player: " + currentPlayer.getId(),
                id,
                currentPlayer.displayHand(),
                gameState.getPlayerList(),
                null
        );
    }

    public GameResponse drawEvent(String id) {
        Card c = gameState.getEventDeck().drawCard();
        String message = "Drew card: " + c.toString();

        return new GameResponse(
          "success",
                message,
                id,
                null,
                gameState.getPlayerList(),
                c
        );
    }

    public GameResponse handleEvent(String id, Card c, String input) {
        Player currentPlayer = gameState.getPlayerList().get(gameState.getPlayerTurnIndex());
        String message = "unhandled card";

        if (c.getType().equals("Event")) {
            int amountToDelete;
            switch(c.getName()) {
                case "Plague":
                    if (gameState.getPlayerList().get(gameState.getPlayerTurnIndex()).getShields() >= 2) {
                        gameState.getPlayerList().get(gameState.getPlayerTurnIndex()).setShields(gameState.getPlayerList().get(gameState.getPlayerTurnIndex()).getShields()-2);
                    } else {
                        gameState.getPlayerList().get(gameState.getPlayerTurnIndex()).setShields(0);
                    }

                    message = "Player " + id + " lost 2 shields!";

                    return new GameResponse(
                            "success",
                            message,
                            id,
                            currentPlayer.displayHand(),
                            gameState.getPlayerList(),
                            c
                    );
                case "Queen's Favor":
                    for (int i = 0; i < 2; i++) {
                        gameState.getPlayerList().get(gameState.getPlayerTurnIndex()).addCard(gameState.getAdventureDeck().drawCard());
                    }
                    amountToDelete = checkHand(gameState.getPlayerList().get(gameState.getPlayerTurnIndex()).getId());
                    if (amountToDelete > 0) {
                        gameState.setTrimmingID(id);
                        gameState.setAmountToDelete(amountToDelete);

                        message = "Too many cards, trimming hand for player " + id;

                        return new GameResponse(
                          "success",
                                message,
                                id,
                                currentPlayer.displayHand(),
                                gameState.getPlayerList(),
                                c
                        );
                    } else {
                        message = "Player " + id + " draws 2 cards!";

                        return new GameResponse(
                                "success",
                                message,
                                id,
                                currentPlayer.displayHand(),
                                gameState.getPlayerList(),
                                c
                        );
                    }
                case "Prosperity":
                    for (int i = 0; i < 2; i++) {
                        gameState.getPlayerList().get(0).addCard(gameState.getAdventureDeck().drawCard());
                        gameState.getPlayerList().get(1).addCard(gameState.getAdventureDeck().drawCard());
                        gameState.getPlayerList().get(2).addCard(gameState.getAdventureDeck().drawCard());
                        gameState.getPlayerList().get(3).addCard(gameState.getAdventureDeck().drawCard());
                    }

                    ArrayList<Player> toTrim = new ArrayList<Player>();
                    for (int i = 0; i < gameState.getPlayerList().size(); i++) {
                        amountToDelete = checkHand(gameState.getPlayerList().get(i).getId());
                        if (amountToDelete > 0) {
                            toTrim.add(gameState.getPlayerList().get(i));
                        }
                    }

                    if (!toTrim.isEmpty()) {
                        Player firstPlayer = toTrim.get(0);
                        gameState.setTrimmingID(firstPlayer.getId());
                        gameState.setAmountToDelete(checkHand(firstPlayer.getId()));
                        gameState.setTrimQueue(toTrim);

                        message = "Too many cards, trimming hand for player " + firstPlayer.getId();

                        return new GameResponse(
                          "success",
                                message,
                                firstPlayer.getId(),
                                firstPlayer.displayHand(),
                                gameState.getPlayerList(),
                                c
                        );
                    } else {
                        message = "All players draw 2 cards!";

                        return new GameResponse(
                                "success",
                                message,
                                id,
                                currentPlayer.displayHand(),
                                gameState.getPlayerList(),
                                c
                        );
                    }
            }
        } else if (c.getType().equals("Quest")) {
            message = "A " + c.getName() + " will start!";
        }

        return new GameResponse(
                "success",
                message,
                id,
                currentPlayer.displayHand(),
                gameState.getPlayerList(),
                c
        );
    }

    public GameResponse endTurn(String id) {


        if (gameState.getPlayerTurnIndex() >= gameState.getPlayerList().size()) {
            gameState.setPlayerTurnIndex(0);
        } else {
            gameState.setPlayerTurnIndex(gameState.getPlayerTurnIndex() + 1);
        }

        return new GameResponse(
          "success",
          "Moving on to next player...",
                gameState.getPlayerList().get(gameState.getPlayerTurnIndex()).getId(),
                null,
                gameState.getPlayerList(),
                null
        );
    }

}
