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
        String input = ""; //set the input up properly
        StringWriter output = new StringWriter();
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();

        //pickCard will take place of dealCards to rig it
        //it just makes it less of a pain to deal with

        //rig the event deck such that the next card drawn is the 4 stage quest
        for (int i = 0; i < game.getEventDeckSize(); i++) {
            if (game.eventDeck.get(i).getName().equals("4 Stage Quest")) {
                game.eventDeck.set(0, game.eventDeck.get(i));
            }
        }

        game.takeTurn(new Scanner(input), new PrintWriter(output));

        //unsure if the following methods will be called within each other or here
        //Input Required: n\ny
        game.questEvent(new Scanner(input), new PrintWriter(output), "Q4", game.playerList.get(0).getId());

        //this would be wrapped in a for loop
        /* Input Required:
        1\n7 --Stage 1
        2\n5 --Stage 2
        2\n3\n4 --Stage 3
        2\n3 -- Stage 4
         */
        game.buildQuest(new Scanner(input), new PrintWriter(output), game.playerList.get(1).getId(),0);

        //the following would be wrapped in a for loop (until quest finishes)
        /*Input Required:
        participate\nparticipate\nparticipate --Stage 1
        5\n5\n5 --trimHand for stage 1
        --attack cards for stage 1
        --attack cards for stage 2
        --attack cards for stage 3
        --attack cards for stage 4
         */
        game.getParticipants(new Scanner(input), new PrintWriter(output), game.playerList.get(1).getId());

        //this would be wrapped in a for loop also
        game.buildAttack(new Scanner(input), new PrintWriter(output), game.playerList.get(0).getId());

        game.attackSequence(new PrintWriter(output), 0);
        assertEquals(0, game.playerList.get(0).getShields());
        assertEquals(0, game.playerList.get(2).getShields());
        assertEquals(4, game.playerList.get(3).getShields());
        String p1Hand = game.playerList.get(0).displayHand();
        String p3Hand = game.playerList.get(2).displayHand();
        String p4Hand = game.playerList.get(3).displayHand();
        assertTrue(output.toString().contains(p1Hand));
        assertTrue(output.toString().contains(p3Hand));
        assertTrue(output.toString().contains(p4Hand));

        //Input Required: 1 (im allowed to pick any to trim
        assertEquals(12, game.playerList.get(1).getHandSize());

    }
}