package org.example;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GameService {

    private GameState gameState;
    private boolean riggingGame;

    public GameService() {
        gameState = new GameState();
        riggingGame = false;
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

    public boolean isFinishedQuest() { return gameState.isFinishedQuest(); }

    public boolean isRiggingGame() { return riggingGame; }

    //use only for testing purposes
    public void pickCard(int index, String type, String name, String value, int playerID) { gameState.pickCard(index, type, name, value, playerID);}

    //two winner
    public void rigScene1() {
        riggingGame = true;

        //P1 Hand
        pickCard(0,"Foe","F5","5",1);
        pickCard(1,"Foe","F5","5",1);
        pickCard(2,"Foe","F10","10",1);
        pickCard(3,"Foe","F10","10",1);
        pickCard(4,"Foe","F15","15",1);
        pickCard(5,"Foe","F15","15",1);
        pickCard(6,"Weapon","Dagger","5",1);
        pickCard(7,"Weapon","Horse","10",1);
        pickCard(8,"Weapon","Battle-Axe","15",1);
        pickCard(9,"Weapon","Battle-Axe","15",1);
        pickCard(10,"Weapon","Horse","10",1);
        pickCard(11,"Weapon","Lance","20",1);

        //P2 Hand
        pickCard(0,"Foe","F40","40",2);
        pickCard(1,"Foe","F50","50",2);
        pickCard(2,"Weapon","Sword","10",2);
        pickCard(3,"Weapon","Sword","10",2);
        pickCard(4,"Weapon","Sword","10",2);
        pickCard(5,"Weapon","Lance","20",2);
        pickCard(6,"Weapon","Excalibur","30",2);
        pickCard(7,"Weapon","Horse","10",2);
        pickCard(8,"Weapon","Battle-Axe","15",2);
        pickCard(9,"Weapon","Battle-Axe","15",2);
        pickCard(10,"Weapon","Horse","10",2);
        pickCard(11,"Weapon","Lance","20",2);

        //P3 Hand
        pickCard(0,"Foe","F5","5",3);
        pickCard(1,"Foe","F5","5",3);
        pickCard(2,"Foe","F5","5",3);
        pickCard(3,"Foe","F5","5",3);
        pickCard(4,"Weapon","Dagger","5",3);
        pickCard(5,"Weapon","Dagger","5",3);
        pickCard(6,"Weapon","Dagger","5",3);
        pickCard(7,"Weapon","Horse","10",3);
        pickCard(8,"Weapon","Horse","10",3);
        pickCard(9,"Weapon","Horse","10",3);
        pickCard(10,"Weapon","Horse","10",3);
        pickCard(11,"Weapon","Horse","10",3);

        //P4 Hand
        pickCard(0,"Foe","F70","70",4);
        pickCard(1,"Foe","F50","50",4);
        pickCard(2,"Weapon","Sword","10",4);
        pickCard(3,"Weapon","Sword","10",4);
        pickCard(4,"Weapon","Sword","10",4);
        pickCard(5,"Weapon","Lance","20",4);
        pickCard(6,"Weapon","Excalibur","30",4);
        pickCard(7,"Weapon","Horse","10",4);
        pickCard(8,"Weapon","Battle-Axe","15",4);
        pickCard(9,"Weapon","Battle-Axe","15",4);
        pickCard(10,"Weapon","Horse","10",4);
        pickCard(11,"Weapon","Lance","20",4);

        //event deck rigging
        Card c = new Card("Quest", "4 Stage Quest", "Q4");
        gameState.getEventDeck().setCardAt(c,0);
        Card c1 = new Card("Quest", "3 Stage Quest", "Q3");
        gameState.getEventDeck().setCardAt(c1,1);

        //adventure deck rigging
        Card c2 = new Card("Foe", "F5", "5");
        gameState.getAdventureDeck().setCardAt(c2,0);
        Card c3 = new Card("Foe", "F40", "40");
        gameState.getAdventureDeck().setCardAt(c3,1);
        Card c4 = new Card("Foe", "F10", "10");
        gameState.getAdventureDeck().setCardAt(c4,2);
        Card c5 = new Card("Foe", "F10", "10");
        gameState.getAdventureDeck().setCardAt(c5,3);
        Card c6 = new Card("Foe", "F30", "30");
        gameState.getAdventureDeck().setCardAt(c6,4);
        Card c7 = new Card("Foe", "F30", "30");
        gameState.getAdventureDeck().setCardAt(c7,5);
        Card c8 = new Card("Foe", "F15", "15");
        gameState.getAdventureDeck().setCardAt(c8,6);
        Card c9 = new Card("Foe", "F15", "15");
        gameState.getAdventureDeck().setCardAt(c9,7);
        Card c10 = new Card("Foe", "F20", "20");
        gameState.getAdventureDeck().setCardAt(c10,9);
        Card c11 = new Card("Foe", "F5", "5");
        gameState.getAdventureDeck().setCardAt(c11,10);
        Card c12 = new Card("Foe", "F10", "10");
        gameState.getAdventureDeck().setCardAt(c12,11);
        Card c13 = new Card("Foe", "F15", "15");
        gameState.getAdventureDeck().setCardAt(c13,12);
        Card c14 = new Card("Foe", "F15", "15");
        gameState.getAdventureDeck().setCardAt(c14,13);
        Card c15 = new Card("Foe", "F20", "20");
        gameState.getAdventureDeck().setCardAt(c15,14);
        Card c16 = new Card("Foe", "F20", "20");
        gameState.getAdventureDeck().setCardAt(c16,15);
        Card c17 = new Card("Foe", "F20", "20");
        gameState.getAdventureDeck().setCardAt(c17,16);
        Card c18 = new Card("Foe", "F20", "20");
        gameState.getAdventureDeck().setCardAt(c18,17);
        Card c19 = new Card("Foe", "F25", "25");
        gameState.getAdventureDeck().setCardAt(c19,18);
        Card c20 = new Card("Foe", "F25", "25");
        gameState.getAdventureDeck().setCardAt(c20,19);
        Card c21 = new Card("Foe", "F30", "30");
        gameState.getAdventureDeck().setCardAt(c21,20);
        Card c22 = new Card("Weapon", "Dagger", "5");
        gameState.getAdventureDeck().setCardAt(c22,21);
        Card c23 = new Card("Weapon", "Dagger", "5");
        gameState.getAdventureDeck().setCardAt(c23,22);
        Card c24 = new Card("Foe", "F15", "15");
        gameState.getAdventureDeck().setCardAt(c24,23);
        Card c25 = new Card("Foe", "F15", "15");
        gameState.getAdventureDeck().setCardAt(c25,24);
        Card c26 = new Card("Foe", "F25", "25");
        gameState.getAdventureDeck().setCardAt(c26,25);
        Card c27 = new Card("Foe", "F25", "25");
        gameState.getAdventureDeck().setCardAt(c27,26);
        Card c28 = new Card("Foe", "F20", "20");
        gameState.getAdventureDeck().setCardAt(c28,27);
        Card c29 = new Card("Foe", "F20", "20");
        gameState.getAdventureDeck().setCardAt(c29,28);
        Card c30 = new Card("Foe", "F25", "25");
        gameState.getAdventureDeck().setCardAt(c30,29);
        Card c31 = new Card("Foe", "F30", "30");
        gameState.getAdventureDeck().setCardAt(c31,30);
        Card c32 = new Card("Weapon", "Sword", "10");
        gameState.getAdventureDeck().setCardAt(c32,31);
        Card c33 = new Card("Weapon", "Battle-Axe", "15");
        gameState.getAdventureDeck().setCardAt(c33,32);
        Card c34 = new Card("Weapon", "Battle-Axe", "15");
        gameState.getAdventureDeck().setCardAt(c34,33);
        Card c35 = new Card("Weapon", "Lance", "20");
        gameState.getAdventureDeck().setCardAt(c35,34);
    }

    //one winner
    public void rigScene2() {
        riggingGame = true;

        //P1 Hand
        pickCard(0,"Foe","F5","5",1);
        pickCard(1,"Foe","F5","5",1);
        pickCard(2,"Foe","F10","10",1);
        pickCard(3,"Foe","F10","10",1);
        pickCard(4,"Foe","F15","15",1);
        pickCard(5,"Foe","F15","15",1);
        pickCard(6,"Weapon","Dagger","5",1);
        pickCard(7,"Foe","F20","20",1);
        pickCard(8,"Foe","F20","20",1);
        pickCard(9,"Weapon","Dagger","5",1);
        pickCard(10,"Weapon","Dagger","5",1);
        pickCard(11,"Weapon","Dagger","5",1);

        //P2 Hand
        pickCard(0,"Foe","F25","25",2);
        pickCard(1,"Weapon","Horse","10",2);
        pickCard(2,"Foe","F30","30",2);
        pickCard(3,"Weapon","Horse","10",2);
        pickCard(4,"Weapon","Sword","10",2);
        pickCard(5,"Weapon","Sword","10",2);
        pickCard(6,"Weapon","Sword","10",2);
        pickCard(7,"Weapon","Battle-Axe","15",2);
        pickCard(8,"Weapon","Battle-Axe","15",2);
        pickCard(9,"Weapon","Lance","20",2);
        pickCard(10,"Weapon","Lance","20",2);
        pickCard(11,"Weapon","Excalibur","30",2);

        //P3 Hand
        pickCard(0,"Foe","F25","25",3);
        pickCard(1,"Weapon","Horse","10",3);
        pickCard(2,"Foe","F30","30",3);
        pickCard(3,"Weapon","Horse","10",3);
        pickCard(4,"Weapon","Sword","10",3);
        pickCard(5,"Weapon","Sword","10",3);
        pickCard(6,"Weapon","Sword","10",3);
        pickCard(7,"Weapon","Battle-Axe","15",3);
        pickCard(8,"Weapon","Battle-Axe","15",3);
        pickCard(9,"Weapon","Lance","20",3);
        pickCard(10,"Weapon","Lance","20",3);
        pickCard(11,"Weapon","Excalibur","30",3);

        //P4 Hand
        pickCard(0,"Foe","F25","25",4);
        pickCard(1,"Weapon","Horse","10",4);
        pickCard(2,"Foe","F30","30",4);
        pickCard(3,"Weapon","Horse","10",4);
        pickCard(4,"Weapon","Sword","10",4);
        pickCard(5,"Weapon","Sword","10",4);
        pickCard(6,"Weapon","Sword","10",4);
        pickCard(7,"Weapon","Battle-Axe","15",4);
        pickCard(8,"Weapon","Battle-Axe","15",4);
        pickCard(9,"Weapon","Lance","20",4);
        pickCard(10,"Weapon","Lance","20",4);
        pickCard(11,"Foe","F70","70",4);

        //event deck rigging
        Card c = new Card("Quest", "4 Stage Quest", "Q4");
        gameState.getEventDeck().setCardAt(c,0);
        Card c1 = new Card("Event", "Plague", "-2Sh");
        gameState.getEventDeck().setCardAt(c1,1);
        Card ec2 = new Card("Event", "Prosperity", "+2All");
        gameState.getEventDeck().setCardAt(ec2,2);
        Card ec3 = new Card("Event", "Queen's Favor", "+2P");
        gameState.getEventDeck().setCardAt(ec3,3);
        Card ec4 = new Card("Quest", "3 Stage Quest", "Q3");
        gameState.getEventDeck().setCardAt(ec4,4);

        //adventure deck rigging
        Card c2 = new Card("Foe", "F5", "5");
        gameState.getAdventureDeck().setCardAt(c2,0);
        Card c3 = new Card("Foe", "F10", "10");
        gameState.getAdventureDeck().setCardAt(c3,1);
        Card c4 = new Card("Foe", "F20", "20");
        gameState.getAdventureDeck().setCardAt(c4,2);
        Card c5 = new Card("Foe", "F15", "15");
        gameState.getAdventureDeck().setCardAt(c5,3);
        Card c6 = new Card("Foe", "F5", "5");
        gameState.getAdventureDeck().setCardAt(c6,4);
        Card c7 = new Card("Foe", "F25", "25");
        gameState.getAdventureDeck().setCardAt(c7,5);
        Card c8 = new Card("Foe", "F5", "5");
        gameState.getAdventureDeck().setCardAt(c8,6);
        Card c9 = new Card("Foe", "F10", "10");
        gameState.getAdventureDeck().setCardAt(c9,7);
        Card c10 = new Card("Foe", "F20", "20");
        gameState.getAdventureDeck().setCardAt(c10,9);
        Card c11 = new Card("Foe", "F5", "5");
        gameState.getAdventureDeck().setCardAt(c11,10);
        Card c12 = new Card("Foe", "F10", "10");
        gameState.getAdventureDeck().setCardAt(c12,11);
        Card c13 = new Card("Foe", "F20", "20");
        gameState.getAdventureDeck().setCardAt(c13,12);
        Card c14 = new Card("Foe", "F5", "5");
        gameState.getAdventureDeck().setCardAt(c14,13);
        Card c15 = new Card("Foe", "F5", "5");
        gameState.getAdventureDeck().setCardAt(c15,14);
        Card c16 = new Card("Foe", "F10", "10");
        gameState.getAdventureDeck().setCardAt(c16,15);
        Card c17 = new Card("Foe", "F10", "10");
        gameState.getAdventureDeck().setCardAt(c17,16);
        Card c18 = new Card("Foe", "F15", "15");
        gameState.getAdventureDeck().setCardAt(c18,17);
        Card c19 = new Card("Foe", "F15", "15");
        gameState.getAdventureDeck().setCardAt(c19,18);
        Card c20 = new Card("Foe", "F15", "15");
        gameState.getAdventureDeck().setCardAt(c20,19);
        Card c21 = new Card("Foe", "F15", "15");
        gameState.getAdventureDeck().setCardAt(c21,20);
        Card c22 = new Card("Foe", "F25", "25");
        gameState.getAdventureDeck().setCardAt(c22,21);
        Card c23 = new Card("Foe", "F25", "25");
        gameState.getAdventureDeck().setCardAt(c23,22);
        Card c24 = new Card("Weapon", "Horse", "10");
        gameState.getAdventureDeck().setCardAt(c24,23);
        Card c25 = new Card("Weapon", "Sword", "10");
        gameState.getAdventureDeck().setCardAt(c25,24);
        Card c26 = new Card("Weapon", "Battle-Axe", "15");
        gameState.getAdventureDeck().setCardAt(c26,25);
        Card c27 = new Card("Foe", "F40", "40");
        gameState.getAdventureDeck().setCardAt(c27,26);
        Card c28 = new Card("Weapon", "Dagger", "5");
        gameState.getAdventureDeck().setCardAt(c28,27);
        Card c29 = new Card("Weapon", "Dagger", "5");
        gameState.getAdventureDeck().setCardAt(c29,28);
        Card c30 = new Card("Foe", "F30", "30");
        gameState.getAdventureDeck().setCardAt(c30,29);
        Card c31 = new Card("Foe", "F25", "25");
        gameState.getAdventureDeck().setCardAt(c31,30);
        Card c32 = new Card("Weapon", "Battle-Axe", "15");
        gameState.getAdventureDeck().setCardAt(c32,31);
        Card c33 = new Card("Weapon", "Horse", "10");
        gameState.getAdventureDeck().setCardAt(c33,32);
        Card c34 = new Card("Foe", "F50", "50");
        gameState.getAdventureDeck().setCardAt(c34,33);
        Card c35 = new Card("Weapon", "Sword", "10");
        gameState.getAdventureDeck().setCardAt(c35,34);
        Card c36 = new Card("Weapon", "Sword", "10");
        gameState.getAdventureDeck().setCardAt(c36,35);
        Card c37 = new Card("Foe", "F40", "40");
        gameState.getAdventureDeck().setCardAt(c37,36);
        Card c38 = new Card("Foe", "F50", "50");
        gameState.getAdventureDeck().setCardAt(c38,37);
        Card c39 = new Card("Weapon", "Horse", "10");
        gameState.getAdventureDeck().setCardAt(c39,38);
        Card c40 = new Card("Weapon", "Horse", "10");
        gameState.getAdventureDeck().setCardAt(c40,39);
        Card c41 = new Card("Weapon", "Horse", "10");
        gameState.getAdventureDeck().setCardAt(c41,40);
        Card c42 = new Card("Weapon", "Sword", "10");
        gameState.getAdventureDeck().setCardAt(c42,41);
        Card c43 = new Card("Weapon", "Sword", "10");
        gameState.getAdventureDeck().setCardAt(c43,42);
        Card c44 = new Card("Weapon", "Sword", "10");
        gameState.getAdventureDeck().setCardAt(c44,43);
        Card c45 = new Card("Weapon", "Sword", "10");
        gameState.getAdventureDeck().setCardAt(c45,44);
        Card c46 = new Card("Foe", "F35", "35");
        gameState.getAdventureDeck().setCardAt(c46,45);

    }

    //0 winner
    public void rigScene3() {
        riggingGame = true;

        //P1 Hand
        pickCard(0,"Foe","F50","50",1);
        pickCard(1,"Weapon","Dagger","5",1);
        pickCard(2,"Weapon","Horse","10",1);
        pickCard(3,"Foe","F70","70",1);
        pickCard(4,"Weapon","Sword","10",1);
        pickCard(5,"Weapon","Battle-Axe","15",1);
        pickCard(6,"Weapon","Dagger","5",1);
        pickCard(7,"Weapon","Sword","10",1);
        pickCard(8,"Weapon","Battle-Axe","15",1);
        pickCard(9,"Weapon","Lance","20",1);
        pickCard(10,"Weapon","Horse","10",1);
        pickCard(11,"Weapon","Lance","20",1);

        //P2 Hand
        pickCard(0,"Foe","F5","5",2);
        pickCard(1,"Foe","F5","5",2);
        pickCard(2,"Foe","F10","10",2);
        pickCard(3,"Foe","F40","40",2);
        pickCard(4,"Foe","F15","15",2);
        pickCard(5,"Foe","F15","15",2);
        pickCard(6,"Foe","F20","20",2);
        pickCard(7,"Foe","F20","20",2);
        pickCard(8,"Foe","F25","25",2);
        pickCard(9,"Foe","F30","30",2);
        pickCard(10,"Foe","F30","30",2);
        pickCard(11,"Weapon","Excalibur","30",2);

        //P3 Hand
        pickCard(0,"Foe","F5","5",3);
        pickCard(1,"Foe","F5","5",3);
        pickCard(2,"Foe","F10","10",3);
        pickCard(3,"Foe","F40","40",3);
        pickCard(4,"Foe","F15","15",3);
        pickCard(5,"Foe","F15","15",3);
        pickCard(6,"Foe","F20","20",3);
        pickCard(7,"Foe","F20","20",3);
        pickCard(8,"Foe","F25","25",3);
        pickCard(9,"Foe","F25","25",3);
        pickCard(10,"Foe","F30","30",3);
        pickCard(11,"Weapon","Lance","20",3);

        //P4 Hand
        pickCard(0,"Foe","F5","5",4);
        pickCard(1,"Foe","F5","5",4);
        pickCard(2,"Foe","F10","10",4);
        pickCard(3,"Foe","F50","50",4);
        pickCard(4,"Foe","F15","15",4);
        pickCard(5,"Foe","F15","15",4);
        pickCard(6,"Foe","F20","20",4);
        pickCard(7,"Foe","F20","20",4);
        pickCard(8,"Foe","F25","25",4);
        pickCard(9,"Foe","F25","25",4);
        pickCard(10,"Foe","F30","30",4);
        pickCard(11,"Weapon","Excalibur","30",4);

        //event deck rigging
        Card c = new Card("Quest", "2 Stage Quest", "Q2");
        gameState.getEventDeck().setCardAt(c,0);

        //adventure deck rigging
        Card c1 = new Card("Foe", "F5", "5");
        gameState.getAdventureDeck().setCardAt(c1,0);
        Card c2 = new Card("Foe", "F15", "15");
        gameState.getAdventureDeck().setCardAt(c2,1);
        Card c3 = new Card("Foe", "F10", "10");
        gameState.getAdventureDeck().setCardAt(c3,2);
        Card c4 = new Card("Foe", "F5", "5");
        gameState.getAdventureDeck().setCardAt(c4,3);
        Card c5 = new Card("Foe", "F10", "10");
        gameState.getAdventureDeck().setCardAt(c5,4);
        Card c6 = new Card("Foe", "F15", "15");
        gameState.getAdventureDeck().setCardAt(c6,5);
        Card c7 = new Card("Weapon", "Dagger", "5");
        gameState.getAdventureDeck().setCardAt(c7,6);
        Card c8 = new Card("Weapon", "Dagger", "5");
        gameState.getAdventureDeck().setCardAt(c8,7);
        Card c9 = new Card("Weapon", "Dagger", "5");
        gameState.getAdventureDeck().setCardAt(c9,8);
        Card c10 = new Card("Weapon", "Dagger", "5");
        gameState.getAdventureDeck().setCardAt(c10,9);
        Card c11 = new Card("Weapon", "Horse", "10");
        gameState.getAdventureDeck().setCardAt(c11,10);
        Card c12 = new Card("Weapon", "Horse", "10");
        gameState.getAdventureDeck().setCardAt(c12,11);
        Card c13 = new Card("Weapon", "Horse", "10");
        gameState.getAdventureDeck().setCardAt(c13,12);
        Card c14 = new Card("Weapon", "Horse", "10");
        gameState.getAdventureDeck().setCardAt(c14,13);
        Card c15 = new Card("Weapon", "Sword", "10");
        gameState.getAdventureDeck().setCardAt(c15,14);
        Card c16 = new Card("Weapon", "Sword", "10");
        gameState.getAdventureDeck().setCardAt(c16,15);
        Card c17 = new Card("Weapon", "Sword", "10");
        gameState.getAdventureDeck().setCardAt(c17,16);
    }

    //A1 scenario
    public void rigScene4() {
        riggingGame = true;

        //P1 Hand
        pickCard(0,"Foe","F5","5",1);
        pickCard(1,"Weapon","Dagger","5",1);
        pickCard(2,"Weapon","Horse","10",1);
        pickCard(3,"Foe","F5","5",1);
        pickCard(4,"Weapon","Sword","10",1);
        pickCard(5,"Weapon","Battle-Axe","15",1);
        pickCard(6,"Foe","F15","15",1);
        pickCard(7,"Weapon","Sword","10",1);
        pickCard(8,"Weapon","Battle-Axe","15",1);
        pickCard(9,"Foe","F15","15",1);
        pickCard(10,"Weapon","Horse","10",1);
        pickCard(11,"Weapon","Lance","20",1);

        //P2 Hand
        pickCard(0,"Foe","F5","5",2);
        pickCard(1,"Foe","F40","40",2);
        pickCard(2,"Weapon","Horse","10",2);
        pickCard(3,"Foe","F5","5",2);
        pickCard(4,"Weapon","Dagger","5",2);
        pickCard(5,"Weapon","Battle-Axe","15",2);
        pickCard(6,"Foe","F15","15",2);
        pickCard(7,"Weapon","Sword","10",2);
        pickCard(8,"Weapon","Battle-Axe","15",2);
        pickCard(9,"Foe","F15","15",2);
        pickCard(10,"Weapon","Horse","10",2);
        pickCard(11,"Weapon","Excalibur","30",2);

        //P3 Hand
        pickCard(0,"Foe","F5","5",3);
        pickCard(1,"Weapon","Dagger","5",3);
        pickCard(2,"Weapon","Horse","10",3);
        pickCard(3,"Foe","F5","5",3);
        pickCard(4,"Weapon","Sword","10",3);
        pickCard(5,"Weapon","Horse","10",3);
        pickCard(6,"Foe","F5","5",3);
        pickCard(7,"Weapon","Sword","10",3);
        pickCard(8,"Weapon","Battle-Axe","15",3);
        pickCard(9,"Foe","F15","15",3);
        pickCard(10,"Weapon","Sword","10",3);
        pickCard(11,"Weapon","Lance","20",3);

        //P4 Hand
        pickCard(0,"Foe","F5","5",4);
        pickCard(1,"Weapon","Dagger","5",4);
        pickCard(2,"Weapon","Horse","10",4);
        pickCard(3,"Foe","F15","15",4);
        pickCard(4,"Weapon","Dagger","5",4);
        pickCard(5,"Weapon","Battle-Axe","15",4);
        pickCard(6,"Foe","F15","15",4);
        pickCard(7,"Weapon","Sword","10",4);
        pickCard(8,"Weapon","Lance","20",4);
        pickCard(9,"Foe","F40","40",4);
        pickCard(10,"Weapon","Horse","10",4);
        pickCard(11,"Weapon","Excalibur","30",4);

        //event deck rigging
        Card c = new Card("Quest", "4 Stage Quest", "Q4");
        gameState.getEventDeck().setCardAt(c,0);

        //adventure deck rigging
        Card c1 = new Card("Foe","F30","30");
        gameState.getAdventureDeck().setCardAt(c1,0);
        Card c2 = new Card("Weapon","Sword","10");
        gameState.getAdventureDeck().setCardAt(c2,1);
        Card c3 = new Card("Weapon","Battle-Axe","15");
        gameState.getAdventureDeck().setCardAt(c3,2);
        Card c4 = new Card("Foe","F10","10");
        gameState.getAdventureDeck().setCardAt(c4,3);
        Card c5 = new Card("Weapon","Lance","20");
        gameState.getAdventureDeck().setCardAt(c5,4);
        Card c6 = new Card("Weapon","Lance","20");
        gameState.getAdventureDeck().setCardAt(c6,5);
        Card c7 = new Card("Weapon","Battle-Axe","15");
        gameState.getAdventureDeck().setCardAt(c7,6);
        Card c8 = new Card("Weapon","Sword","10");
        gameState.getAdventureDeck().setCardAt(c8,7);
        Card c9 = new Card("Foe","F30","30");
        gameState.getAdventureDeck().setCardAt(c9,8);
        Card c10 = new Card("Weapon","Lance","20");
        gameState.getAdventureDeck().setCardAt(c10,9);
        Card c11 = new Card("Foe","F5","5");
        gameState.getAdventureDeck().setCardAt(c11,10);

        //im too lazy to think about rigging p2's hand post quest
        for (int i = 10; i < 23; i++) {
            Card c12 = new Card("Foe" , "F5", "5");
            gameState.getAdventureDeck().setCardAt(c12,i);
        }
    }

    //the rest of the game (divided by sections)
    //because it makes it easier to work with the frontend

    public void reset() {
        gameState = new GameState();
    }

    private ArrayList<String> getAllPlayerHands() {
        ArrayList<String> allPlayerHands = new ArrayList<String>();
        for (int i = 0; i < gameState.getPlayerList().size(); i++) {
            Collections.sort(gameState.getPlayerList().get(i).getHand());
            allPlayerHands.add(gameState.getPlayerList().get(i).displayHand());
        }
        return allPlayerHands;
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

        ArrayList<String> allPlayerHands = getAllPlayerHands();

        return new GameResponse(
          "success",
                message,
                id,
                allPlayerHands,
                gameState.getPlayerList(),
                null,
                false,
                gameState.isFinishedQuest()
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
            ArrayList<String> allPlayerHands = getAllPlayerHands();

            return new GameResponse(
                    "success",
                    "need to trim more...",
                    id,
                    allPlayerHands,
                    gameState.getPlayerList(),
                    null,
                    true,
                    gameState.isFinishedQuest()
            );
        }

        ArrayList<Player> toTrim = gameState.getTrimQueue();
        toTrim.remove(0);

        if (!toTrim.isEmpty()) {
            Player nextPlayer = toTrim.get(0);
            gameState.setTrimmingID(nextPlayer.getId());
            gameState.setAmountToDelete(checkHand(nextPlayer.getId()));
            String message = "trimming done for " + id + ". moving on to player " + nextPlayer.getId();
            ArrayList<String> allPlayerHands = getAllPlayerHands();

            return new GameResponse(
                    "success",
                    message,
                    nextPlayer.getId(),
                    allPlayerHands,
                    gameState.getPlayerList(),
                    null,
                    true,
                    gameState.isFinishedQuest()
            );
        } else {
            gameState.setTrimmingID(null);
            gameState.setAmountToDelete(0);
            gameState.setTrimQueue(null);
            ArrayList<String> allPlayerHands = getAllPlayerHands();

            return new GameResponse(
                    "success",
                    "trimming complete",
                    id,
                    allPlayerHands,
                    gameState.getPlayerList(),
                    null,
                    false,
                    gameState.isFinishedQuest()
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
        gameState.getEligiblePlayersList().clear();
        for (int i = 0; i < gameState.getPlayerList().size(); i++) {
            if (!gameState.getPlayerList().get(i).getId().equals(id)) {
                if (gameState.getPlayerList().get(i).getEligibleStatus()) {
                    gameState.getEligiblePlayersList().add(gameState.getPlayerList().get(i));
                    if (i == gameState.getPlayerList().size()-1) {
                        eligiblePlayers += gameState.getPlayerList().get(i).getId();
                    } else {
                        eligiblePlayers += gameState.getPlayerList().get(i).getId() + ", ";
                    }
                }
            }
        }

        gameState.setEligiblePlayerID(gameState.getEligiblePlayersList().get(0).getId());

        String message = "Eligible Players: " + eligiblePlayers;
        ArrayList<String> allPlayerHands = getAllPlayerHands();

        return new GameResponse (
          "success",
                message,
                id,
                allPlayerHands,
                gameState.getPlayerList(),
                c,
                false,
                gameState.isFinishedQuest()
        );
    }

    public GameResponse getParticipants(String id, String decision, Card c) {
        String message = "";

        ArrayList<Player> eligiblePlayers = gameState.getEligiblePlayersList();

        if (gameState.getEligiblePlayerID().equals(eligiblePlayers.get(0).getId())) {
            if (decision.equals("withdraw")) {
                eligiblePlayers.get(0).setEligibleStatus(false);
                message = "Player " + gameState.getEligiblePlayerID() + " decided to not participate.";
            } else {
                gameState.getParticipantList().add(eligiblePlayers.get(0));
                gameState.getAttackBuildersList().add(eligiblePlayers.get(0));
                message = "Player " + gameState.getEligiblePlayerID() + " decided to participate.";
            }
        }

        eligiblePlayers.remove(0);

        if (!eligiblePlayers.isEmpty()) {
            Player nextPlayer = eligiblePlayers.get(0);
            gameState.setEligiblePlayerID(nextPlayer.getId());
            message = message + " asking next player...";
            ArrayList<String> allPlayerHands = getAllPlayerHands();
            return new GameResponse(
                    "success",
                    message,
                    id,
                    allPlayerHands,
                    gameState.getPlayerList(),
                    c,
                    true,
                    gameState.isFinishedQuest()
            );
        } else {
            gameState.setEligiblePlayerID(null);
            gameState.setAttackBuilderID(gameState.getAttackBuildersList().get(0).getId());
            message = message + " all eligible players asked.";
            ArrayList<String> allPlayerHands = getAllPlayerHands();
            return new GameResponse(
                    "success",
                    message,
                    id,
                    allPlayerHands,
                    gameState.getPlayerList(),
                    c,
                    false,
                    gameState.isFinishedQuest()
            );
        }
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
                c,
                false,
                gameState.isFinishedQuest()

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
        Player currentPlayer = gameState.getPlayerList().get(translateID(gameState.getAttackBuilderID()));
        StringBuilder message = new StringBuilder();

        if (decision.equalsIgnoreCase("quit")) {
            if (currentPlayer.isAttackHandEmpty()) {
                message.append("Player ").append(id).append(" chose to not play any cards");
            } else {
                String cardsInAttack = currentPlayer.displayAttackHand();
                message.append("Player ").append(id).append("'s current attack: ").append(cardsInAttack);
            }
            ArrayList<String> allPlayerHands = getAllPlayerHands();
            gameState.getAttackBuildersList().remove(0);

            if (!gameState.getAttackBuildersList().isEmpty()) {
                gameState.setAttackBuilderID(gameState.getAttackBuildersList().get(0).getId());
                return new GameResponse(
                        "success",
                        message.toString(),
                        gameState.getAttackBuilderID(),
                        allPlayerHands,
                        gameState.getPlayerList(),
                        null,
                        true,
                        gameState.isFinishedQuest()
                );
            } else {
                return new GameResponse(
                        "success",
                        message.toString(),
                        gameState.getAttackBuilderID(),
                        allPlayerHands,
                        gameState.getPlayerList(),
                        null,
                        false,
                        gameState.isFinishedQuest()
                );
            }
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
            gameState.getAdventureDeck().addToDiscard(currentPlayer.getCardAt(inputNum-1));
            message.append(currentPlayer.getCardAt(inputNum-1).getName()).append(" added.");
            currentPlayer.addAttackCard(currentPlayer.removeCardAt(inputNum-1));
        }

        ArrayList<String> allPlayerHands = getAllPlayerHands();
        return new GameResponse(
                "success",
                message.toString(),
                gameState.getAttackBuilderID(),
                allPlayerHands,
                gameState.getPlayerList(),
                null,
                true,
                gameState.isFinishedQuest()
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

            ArrayList<String> allPlayerHands = getAllPlayerHands();

            return new GameResponse(
              "success",
                    message.toString(),
                    gameState.getAttackBuilderID(),
                    allPlayerHands,
                    gameState.getPlayerList(),
                    null,
                    false,
                    gameState.isFinishedQuest()
            );
        }

        int inputNum = Integer.parseInt(decision);
        if (inputNum > currentPlayer.getHandSize() || inputNum < 0) {
            message.append("Rejected: Invalid Position.");
        } else {
            for (int i = 0; i < quest.getStageSize(); i++) {
                if (quest.getCardAt(i).getType().equals("Foe") && currentPlayer.getCardAt(inputNum-1).getType().equals("Foe")) {
                    message.append("Rejected: Foe already chosen.");
                    ArrayList<String> allPlayerHands = getAllPlayerHands();
                    return new GameResponse(
                            "error",
                            message.toString(),
                            gameState.getAttackBuilderID(),
                            allPlayerHands,
                            gameState.getPlayerList(),
                            null,
                            true,
                            gameState.isFinishedQuest()
                    );
                } else if (quest.getCardAt(i).getType().equals("Weapon")) {
                    if (quest.getCardAt(i).getName().equals(currentPlayer.getCardAt(inputNum-1).getName())) {
                        message.append("Rejected: Duplicate weapon.");
                        ArrayList<String> allPlayerHands = getAllPlayerHands();
                        return new GameResponse(
                                "error",
                                message.toString(),
                                gameState.getAttackBuilderID(),
                                allPlayerHands,
                                gameState.getPlayerList(),
                                null,
                                true,
                                gameState.isFinishedQuest()
                        );
                    }
                }
            }
            quest.addCard(currentPlayer.getCardAt(inputNum-1));
            message.append(currentPlayer.getCardAt(inputNum-1).getName()).append(" added.");
            gameState.getAdventureDeck().addToDiscard(currentPlayer.removeCardAt(inputNum-1));
        }
        ArrayList<String> allPlayerHands = getAllPlayerHands();
        return new GameResponse(
                "success",
                message.toString(),
                gameState.getAttackBuilderID(),
                allPlayerHands,
                gameState.getPlayerList(),
                null,
                true,
                gameState.isFinishedQuest()
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
            ArrayList<String> allPlayerHands = getAllPlayerHands();
            return new GameResponse(
                    "success",
                    message.toString(),
                    id,
                    allPlayerHands,
                    gameState.getPlayerList(),
                    null,
                    false,
                    gameState.isFinishedQuest()
            );
        } else {
            gameState.setPlayerQuestIndex(gameState.getPlayerQuestIndex()+1);
            if (gameState.getPlayerQuestIndex() >= gameState.getPlayerList().size()) {
                message.append("All players have declined. Ending turn...");
                ArrayList<String> allPlayerHands = getAllPlayerHands();
                return new GameResponse(
                        "success",
                        message.toString(),
                        id,
                        allPlayerHands,
                        gameState.getPlayerList(),
                        null,
                        false,
                        gameState.isFinishedQuest()
                );
            }
        }
        message.append("Player ").append(id).append(" declined, asking next player...");
        ArrayList<String> allPlayerHands = getAllPlayerHands();
        return new GameResponse(
                "success",
                message.toString(),
                id,
                allPlayerHands,
                gameState.getPlayerList(),
                null,
                true,
                gameState.isFinishedQuest()
        );
    }

    public GameResponse prepareParticipants(String id) {
        StringBuilder message = new StringBuilder();
        Player currentPlayer = gameState.getPlayerList().get(translateID(id));

        if (gameState.getParticipantList().isEmpty()) {
            message.append("No participants, quest cancelled...");
            gameState.setFinishedQuest(true);
            ArrayList<String> allPlayerHands = getAllPlayerHands();

            return new GameResponse(
                    "success",
                    message.toString(),
                    id,
                    allPlayerHands,
                    gameState.getPlayerList(),
                    null,
                    false,
                    gameState.isFinishedQuest()
            );
        }

        for (int i = 0; i < gameState.getParticipantList().size(); i++) {
            gameState.getParticipantList().get(i).addCard(gameState.getAdventureDeck().drawCard());
        }

        ArrayList<Player> toTrim = new ArrayList<Player>();
        for (int i = 0; i < gameState.getPlayerList().size(); i++) {
            int amountToDelete = checkHand(gameState.getPlayerList().get(i).getId());
            if (amountToDelete > 0) {
                toTrim.add(gameState.getPlayerList().get(i));
            }
        }

        if (!toTrim.isEmpty()) {
            Player firstPlayer = toTrim.get(0);
            gameState.setTrimmingID(firstPlayer.getId());
            gameState.setAmountToDelete(checkHand(firstPlayer.getId()));
            gameState.setTrimQueue(toTrim);

            message.append("Too many cards, trimming hand for player ").append(firstPlayer.getId());

            ArrayList<String> allPlayerHands = getAllPlayerHands();
            return new GameResponse(
                    "success",
                    message.toString(),
                    firstPlayer.getId(),
                    allPlayerHands,
                    gameState.getPlayerList(),
                    null,
                    true,
                    gameState.isFinishedQuest()
            );
        } else {
            message.append("All participants ready to build attack.");
            ArrayList<String> allPlayerHands = getAllPlayerHands();
            return new GameResponse(
                    "success",
                    message.toString(),
                    id,
                    allPlayerHands,
                    gameState.getPlayerList(),
                    null,
                    false,
                    gameState.isFinishedQuest()
            );
        }
    }

    public GameResponse prepareNextStage(String id, int currentStage, Card c) {
        int finalStage = getQuestLength(c.getType());
        StringBuilder message = new StringBuilder();
        Player currentPlayer = gameState.getPlayerList().get(translateID(id));

        if (!noEligibleParticipants()) {
            message.append("No eligible participants for next stage. Ending quest...");
            gameState.setFinishedQuest(true);
            ArrayList<String> allPlayerHands = getAllPlayerHands();

            return new GameResponse(
              "failure",
                    message.toString(),
                    id,
                    allPlayerHands,
                    gameState.getPlayerList(),
                    c,
                    false,
                    gameState.isFinishedQuest()
            );
        }

        for (int i = 0; i < gameState.getParticipantList().size(); i++) {
            gameState.getParticipantList().get(i).removeAttackCards();
        }

        if (currentStage < finalStage) {
            message.append("Prepare for next stage...");
            ArrayList<String> allPlayerHands = getAllPlayerHands();
            return new GameResponse(
                    "success",
                    message.toString(),
                    id,
                    allPlayerHands,
                    gameState.getPlayerList(),
                    c,
                    false,
                    gameState.isFinishedQuest()
            );
        } else {
            message.append("Final stage of quest complete. Ending quest & rewarding winner(s)...");
            gameState.setFinishedQuest(true);
            ArrayList<String> allPlayerHands = getAllPlayerHands();

            return new GameResponse(
                    "success",
                    message.toString(),
                    id,
                    allPlayerHands,
                    gameState.getPlayerList(),
                    c,
                    false,
                    gameState.isFinishedQuest()
            );
        }
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
        clearParticipants();
        int amountToGet = (amountToGet(gameState.getBuilderID()) + questLength);
        for (int i = 0; i < amountToGet; i++) {
            gameState.getPlayerList().get(translateID(gameState.getBuilderID())).addCard(gameState.getAdventureDeck().drawCard());
        }
        int amountToDelete = checkHand(gameState.getBuilderID());
        if (amountToDelete > 0) {
            message.append("Too many cards, trimming hand for player ").append(gameState.getBuilderID());
            ArrayList<String> allPlayerHands = getAllPlayerHands();
            return new GameResponse(
              "success",
                    message.toString(),
                    id,
                    allPlayerHands,
                    gameState.getPlayerList(),
                    c,
                    true,
                    gameState.isFinishedQuest()
            );
        }
        message.append("Eligible players have been rewarded!");
        ArrayList<String> allPlayerHands = getAllPlayerHands();
        return new GameResponse(
                "success",
                message.toString(),
                id,
                allPlayerHands,
                gameState.getPlayerList(),
                c,
                false,
                gameState.isFinishedQuest()
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
        ArrayList<String> allPlayerHands = getAllPlayerHands();
        return new GameResponse (
                "success",
                "Current Player: " + currentPlayer.getId(),
                id,
                allPlayerHands,
                gameState.getPlayerList(),
                null,
                false,
                gameState.isFinishedQuest()
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
                c,
                false,
                gameState.isFinishedQuest()
        );
    }

    public GameResponse handleEvent(String id, Card c) {
        Player currentPlayer = gameState.getPlayerList().get(gameState.getPlayerTurnIndex());
        String message = "unhandled card";
        ArrayList<String> allPlayerHands;

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
                    allPlayerHands = getAllPlayerHands();

                    return new GameResponse(
                            "success",
                            message,
                            id,
                            allPlayerHands,
                            gameState.getPlayerList(),
                            c,
                            false,
                            gameState.isFinishedQuest()
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
                        allPlayerHands = getAllPlayerHands();

                        return new GameResponse(
                          "success",
                                message,
                                id,
                                allPlayerHands,
                                gameState.getPlayerList(),
                                c,
                                true,
                                gameState.isFinishedQuest()
                        );
                    } else {
                        message = "Player " + id + " draws 2 cards!";
                        allPlayerHands = getAllPlayerHands();

                        return new GameResponse(
                                "success",
                                message,
                                id,
                                allPlayerHands,
                                gameState.getPlayerList(),
                                c,
                                false,
                                gameState.isFinishedQuest()
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
                        allPlayerHands = getAllPlayerHands();

                        return new GameResponse(
                          "success",
                                message,
                                firstPlayer.getId(),
                                allPlayerHands,
                                gameState.getPlayerList(),
                                c,
                                true,
                                gameState.isFinishedQuest()
                        );
                    } else {
                        message = "All players draw 2 cards!";
                        allPlayerHands = getAllPlayerHands();

                        return new GameResponse(
                                "success",
                                message,
                                id,
                                allPlayerHands,
                                gameState.getPlayerList(),
                                c,
                                false,
                                gameState.isFinishedQuest()
                        );
                    }
            }
        } else if (c.getType().equals("Quest")) {
            message = "A quest will start!";
            gameState.setFinishedQuest(false);
        }
        allPlayerHands = getAllPlayerHands();
        return new GameResponse(
                "success",
                message,
                id,
                allPlayerHands,
                gameState.getPlayerList(),
                c,
                false,
                gameState.isFinishedQuest()
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
                id,
                null,
                gameState.getPlayerList(),
                null,
                false,
                gameState.isFinishedQuest()
        );
    }

}
