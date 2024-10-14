package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainAcceptanceTest {

    @Test
    @DisplayName("A-Test JP-Scenario")
    void A_TEST_JP_Scenario() {
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //card rigging
        for (int i = 0; i < game.playerList.size(); i++) {
            game.playerList.get(i).getHand().clear();
        }

        //P1 Hand
        game.pickCard(0,"Foe","F5","5",1);
        game.pickCard(1,"Weapon","Dagger","5",1);
        game.pickCard(2,"Weapon","Horse","10",1);
        game.pickCard(3,"Foe","F5","5",1);
        game.pickCard(4,"Weapon","Sword","10",1);
        game.pickCard(5,"Weapon","Battle-Axe","15",1);
        game.pickCard(6,"Foe","F15","15",1);
        game.pickCard(7,"Weapon","Sword","10",1);
        game.pickCard(8,"Weapon","Battle-Axe","15",1);
        game.pickCard(9,"Foe","F15","15",1);
        game.pickCard(10,"Weapon","Horse","10",1);
        game.pickCard(11,"Weapon","Lance","20",1);
        //P2 Hand
        game.pickCard(0,"Foe","F5","5",2);
        game.pickCard(1,"Foe","F40","40",2);
        game.pickCard(2,"Weapon","Horse","10",2);
        game.pickCard(3,"Foe","F5","5",2);
        game.pickCard(4,"Weapon","Dagger","5",2);
        game.pickCard(5,"Weapon","Battle-Axe","15",2);
        game.pickCard(6,"Foe","F15","15",2);
        game.pickCard(7,"Weapon","Sword","10",2);
        game.pickCard(8,"Weapon","Battle-Axe","15",2);
        game.pickCard(9,"Foe","F15","15",2);
        game.pickCard(10,"Weapon","Horse","10",2);
        game.pickCard(11,"Weapon","Excalibur","30",2);
        //P3 Hand
        game.pickCard(0,"Foe","F5","5",3);
        game.pickCard(1,"Weapon","Dagger","5",3);
        game.pickCard(2,"Weapon","Horse","10",3);
        game.pickCard(3,"Foe","F5","5",3);
        game.pickCard(4,"Weapon","Sword","10",3);
        game.pickCard(5,"Weapon","Horse","10",3);
        game.pickCard(6,"Foe","F5","5",3);
        game.pickCard(7,"Weapon","Sword","10",3);
        game.pickCard(8,"Weapon","Battle-Axe","15",3);
        game.pickCard(9,"Foe","F15","15",3);
        game.pickCard(10,"Weapon","Sword","10",3);
        game.pickCard(11,"Weapon","Lance","20",3);
        //P4 Hand
        game.pickCard(0,"Foe","F5","5",4);
        game.pickCard(1,"Weapon","Dagger","5",4);
        game.pickCard(2,"Weapon","Horse","10",4);
        game.pickCard(3,"Foe","F15","15",4);
        game.pickCard(4,"Weapon","Dagger","5",4);
        game.pickCard(5,"Weapon","Battle-Axe","15",4);
        game.pickCard(6,"Foe","F15","15",4);
        game.pickCard(7,"Weapon","Sword","10",4);
        game.pickCard(8,"Weapon","Lance","20",4);
        game.pickCard(9,"Foe","F40","40",4);
        game.pickCard(10,"Weapon","Horse","10",4);
        game.pickCard(11,"Weapon","Excalibur","30",4);

        //other cards that are picked up are rigged here (im just fixing input)
        Card c1 = new Card("Foe","F30","30");
        game.adventureDeck.set(0,c1);
        Card c2 = new Card("Weapon","Sword","10");
        game.adventureDeck.set(1,c2);
        Card c3 = new Card("Weapon","Battle-Axe","15");
        game.adventureDeck.set(2,c3);
        Card c4 = new Card("Foe","F10","10");
        game.adventureDeck.set(3,c4);
        Card c5 = new Card("Weapon","Lance","20");
        game.adventureDeck.set(4,c5);
        Card c6 = new Card("Weapon","Lance","20");
        game.adventureDeck.set(5,c6);
        Card c7 = new Card("Weapon","Battle-Axe","15");
        game.adventureDeck.set(6,c7);
        Card c8 = new Card("Weapon","Sword","10");
        game.adventureDeck.set(7,c8);
        Card c9 = new Card("Foe","F30","30");
        game.adventureDeck.set(8,c9);
        Card c10 = new Card("Weapon","Lance","20");
        game.adventureDeck.set(9,c10);

        //rig the event deck such that the next card drawn is the 4 stage quest
        for (int i = 0; i < game.getEventDeckSize(); i++) {
            if (game.eventDeck.get(i).getName().equals("4 Stage Quest")) {
                game.eventDeck.set(0, game.eventDeck.get(i));
            }
        }

        String input = "n\ny" + //for sponsoring
                "\n1\n7\nQuit\n2\n5\nQuit\n2\n3\n4\nQuit\n2\n3\nQuit" + //for stage building
                "\nparticipate\nparticipate\nparticipate" + //stage 1 participation
                "\n1\n1\n1" + //card trimming for participants
                "\n5\n5\nquit\n5\n4\nquit\n4\n6\nquit" + //stage 1 attack card set up
                "\nparticipate\nparticipate\nparticipate" + //stage 2 participation
                "\n7\n6\nquit\n9\n4\nquit\n6\n6\nquit" + //stage 2 attack card set up
                "\nparticipate\nparticipate" + //stage 3 participation
                "\n9\n6\n4\nquit\n7\n5\n6\nquit" + //stage 3 attack card set up
                "\nparticipate\nparticipate" + //stage 4 participation
                "\n8\n6\n6\nquit\n4\n4\n4\n5\nquit" + //stage 4 attack card set up
                "\n1\n1\n1\n1\n\n"; //card trimming for quest builder
        StringWriter output = new StringWriter();

        //everything will (hopefully) take place here
        game.takeTurn(new Scanner(input), new PrintWriter(output));

        //final hands
        String p1Hand = "F5, value = 5 \nF10, value = 10 \nF15, value = 15 \nF15, value = 15 \nF30, value = 30 \nHorse, value = 10 \nBattle-Axe, value = 15 " +
                "\nBattle-Axe, value = 15 \nLance, value = 20";
        String p3Hand = "F5, value = 5 \nF5, value = 5 \nF15, value = 15 \nF30, value = 30 \nSword, value = 10";
        String p4Hand = "F15, value = 15 \nF15, value = 15 \nF40, value = 40 \nLance, value = 20";

        assertAll(
                "acceptance test",
                () -> assertEquals(0, game.playerList.get(0).getShields()),
                () -> assertEquals(0, game.playerList.get(2).getShields()),
                () -> assertEquals(4, game.playerList.get(3).getShields()),
                () -> assertTrue(game.playerList.get(0).displayHand().contains(p1Hand)),
                () -> assertTrue(game.playerList.get(2).displayHand().contains(p3Hand)),
                () -> assertTrue(game.playerList.get(3).displayHand().contains(p4Hand)),
                () -> assertEquals(12, game.playerList.get(1).getHandSize())
        );
    }
}