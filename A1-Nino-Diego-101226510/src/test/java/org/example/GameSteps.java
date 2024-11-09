package org.example;
import io.cucumber.java.en.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class GameSteps {

    private Main game;
    StringWriter output = new StringWriter();

    //game starting steps
    //TODO: see if i can make this reusable later
    @Given("a new game starts with A1_Scenario")
    public void a_new_game_starts_A1_Scenario() {
        //i literally just ripped the code from the MainAcceptanceTest
        game = new Main();
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
    }

    @Given("a new game starts with 2winner_game")
    public void a_new_game_starts_2winner_game() {
        game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //card rigging
        for (int i = 0; i < game.playerList.size(); i++) {
            game.playerList.get(i).getHand().clear();
        }

        //P1 Hand
        game.pickCard(0, "Foe", "F10", "10", 1);
        game.pickCard(1, "Foe", "F15", "15", 1);
        game.pickCard(2, "Foe", "F20", "20", 1);
        game.pickCard(3, "Foe", "F25", "25", 1);
        game.pickCard(4, "Foe", "F5", "5", 1);
        game.pickCard(5, "Foe", "F5", "5", 1);
        game.pickCard(6, "Weapon", "Lance", "20", 1);
        game.pickCard(7, "Weapon", "Lance", "20", 1);
        game.pickCard(8, "Weapon", "Lance", "20", 1);
        game.pickCard(9, "Weapon", "Lance", "20", 1);
        game.pickCard(10, "Foe", "F50", "50", 1);
        game.pickCard(11, "Foe", "F50", "50", 1);

        //P2 Hand
        game.pickCard(0, "Weapon", "Sword", "10", 2);
        game.pickCard(1, "Weapon", "Battle-Axe", "15", 2);
        game.pickCard(2, "Weapon", "Horse", "10", 2);
        game.pickCard(3, "Weapon", "Lance", "20", 2);
        game.pickCard(4, "Weapon", "Lance", "20", 2);
        game.pickCard(5, "Weapon", "Dagger", "5", 2);
        game.pickCard(6, "Weapon", "Dagger", "5", 2);
        game.pickCard(7, "Weapon", "Sword", "10", 2);
        game.pickCard(8, "Weapon", "Horse", "10", 2);
        game.pickCard(9, "Weapon", "Dagger", "5", 2);
        game.pickCard(10, "Foe", "F10", "10", 2);
        game.pickCard(11, "Foe", "F5", "5", 2);

        //P3 Hand
        game.pickCard(0, "Weapon", "Dagger", "5", 3);
        game.pickCard(1, "Foe", "F5", "5", 3);
        game.pickCard(2, "Foe", "F10", "10", 3);
        game.pickCard(3, "Foe", "F15", "15", 3);
        game.pickCard(4, "Foe", "F70", "70", 3);
        game.pickCard(5, "Weapon", "Sword", "10", 3);
        game.pickCard(6, "Weapon", "Sword", "10", 3);
        game.pickCard(7, "Weapon", "Sword", "10", 3);
        game.pickCard(8, "Weapon", "Horse", "10", 3);
        game.pickCard(9, "Weapon", "Horse", "10", 3);
        game.pickCard(10, "Weapon", "Horse", "10", 3);
        game.pickCard(11, "Foe", "F20", "20", 3);

        //P4 Hand
        game.pickCard(0, "Weapon", "Horse", "10", 4);
        game.pickCard(1, "Weapon", "Battle-Axe", "15", 4);
        game.pickCard(2, "Weapon", "Horse", "10", 4);
        game.pickCard(3, "Weapon", "Sword", "10", 4);
        game.pickCard(4, "Weapon", "Excalibur", "30", 4);
        game.pickCard(5, "Weapon", "Dagger", "5", 4);
        game.pickCard(6, "Weapon", "Sword", "10", 4);
        game.pickCard(7, "Weapon", "Sword", "10", 4);
        game.pickCard(8, "Weapon", "Battle-Axe", "15", 4);
        game.pickCard(9, "Foe", "F5", "5", 4);
        game.pickCard(10, "Foe", "F10", "10", 4);
        game.pickCard(11, "Foe", "F15", "15", 4);

        //rig adventure deck with F5 foe cards because im lazy and don't want to deal with randomness
        for (int i = 0; i < 23; i++) {
            Card c = new Card("Foe" , "F5", "5");
            game.adventureDeck.set(i,c);
        }
    }

    //drawing steps
    @When("a {string} card is drawn with Player 2 sponsoring")
    public void single_quest_card_drawn(String questCard) {
        //i literally just ripped the code from the MainAcceptanceTest again
        //not sure why i shouldn't really
        for (int i = 0; i < game.getEventDeckSize(); i++) {
            if (game.eventDeck.get(i).getName().equals(questCard)) {
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
    }

    @When("a {string} card is drawn with Player 1 sponsoring and a {string} card is drawn with Player 3 sponsoring")
    public void two_quest_cards_drawn(String questCard1, String questCard2) {
        //event card rigging here
        for (int i = 0; i < game.getEventDeckSize(); i++) {
            if (game.eventDeck.get(i).getName().equals(questCard1)) {
                game.eventDeck.set(0, game.eventDeck.get(i));
            } else if (game.eventDeck.get(i).getName().equals(questCard2)) {
                game.eventDeck.set(1, game.eventDeck.get(i));
            }
        }

        //input rigging here
        String input = "y" + //for sponsoring Q4
                "\n3\nQuit\n3\nQuit\n3\nQuit\n3\nQuit" + //P1 stage building
                "\nparticipate\nparticipate\nparticipate" + //stage 1 participation
                "\n1\n1\n1" + //card trimming
                "\n6\nquit\n6\nquit\n9\nquit" + //stage 1 attack
                "\nparticipate\nparticipate" + //stage 2 participation
                "\n10\n8\nquit\n11\nquit" + //stage 2 attack
                "\nparticipate\nparticipate" + //stage 3 participation
                "\n11\nquit\n10\n7\nquit" + //stage 3 attack
                "\nparticipate\nparticipate" + //stage 4 participation
                "\n11\n6\nquit\n11\nquit" + //stage 4 attack
                "\n1\n1\n1\n1\n\n" + //P1 card trimming
                "\nn\ny" +//for sponsoring Q3
                "\n1\nQuit\n1\nQuit\n1\nQuit" + //P3 stage building
                "\nwithdraw\nparticipate\nparticipate" + //stage 1 participation
                "\n6\nquit\n7\nquit" + //stage 1 attack
                "\nparticipate\nparticipate" + //stage 2 participation
                "\n8\nquit\n9\n8\nquit" + //stage 2 attack
                "\nparticipate\nparticipate" + //stage 3 participation
                "\n9\n8\nquit\n9\nquit" + //stage 3 attack
                "\n1\n1\n\n"; //P3 card trimming

        game.takeTurn(new Scanner(input), new PrintWriter(output));
    }

    //Assert steps
    @Then("Player {int} should have {int} shields")
    public void player_should_have_shields(int expectedShieldAmount, int playerNum) {
        switch (playerNum){
            case 1:
                assertEquals(expectedShieldAmount, game.playerList.get(0).getShields());
                break;
            case 2:
                assertEquals(expectedShieldAmount, game.playerList.get(1).getShields());
                break;
            case 3:
                assertEquals(expectedShieldAmount, game.playerList.get(2).getShields());
                break;
            case 4:
                assertEquals(expectedShieldAmount, game.playerList.get(3).getShields());
                break;
        }
    }

    @And("Player {int} should have {string} in their hand")
    public void player_should_have_cards_in_hand(int playerNum, String expectedHand) {
        switch (playerNum) {
            case 1:
                String p1Hand = game.playerList.get(0).displayHand().replace("\n", ""); //forced to do this because cucumber won't take \n
                assertTrue(p1Hand.contains(expectedHand));
                break;
            case 2:
                String p2Hand = game.playerList.get(1).displayHand().replace("\n", ""); //forced to do this because cucumber won't take \n
                assertTrue(p2Hand.contains(expectedHand));
                break;
            case 3:
                String p3Hand = game.playerList.get(2).displayHand().replace("\n", ""); //forced to do this because cucumber won't take \n
                assertTrue(p3Hand.contains(expectedHand));
                break;
            case 4:
                String p4Hand = game.playerList.get(3).displayHand().replace("\n", ""); //forced to do this because cucumber won't take \n
                assertTrue(p4Hand.contains(expectedHand));
                break;
        }


    }

    @And("Player {int} should have {int} cards in hand")
    public void player_should_have_num_of_cards_in_hand(int expectedCardAmount, int playerNum) {
        switch (playerNum) {
            case 1:
                assertEquals(expectedCardAmount, game.playerList.get(0).getHandSize());
                break;
            case 2:
                assertEquals(expectedCardAmount, game.playerList.get(1).getHandSize());
                break;
            case 3:
                assertEquals(expectedCardAmount, game.playerList.get(2).getHandSize());
                break;
            case 4:
                assertEquals(expectedCardAmount, game.playerList.get(3).getHandSize());
                break;
        }
    }

    @And("Player {int} is declared as a Winner")
    public void player_is_winner(int playerNum) {
        switch (playerNum) {
            case 1:
                assertTrue(output.toString().contains("P1"));
                break;
            case 2:
                assertTrue(output.toString().contains("P2"));
                break;
            case 3:
                assertTrue(output.toString().contains("P3"));
                break;
            case 4:
                assertTrue(output.toString().contains("P4"));
                break;
        }
    }

}
