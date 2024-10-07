package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    @DisplayName("Check if adventure deck has 100 cards")
    void RESP_01_test_01() {
        Main game = new Main();
        game.initializeDecks();

        //there should be 100 adventure cards total in the deck
        int adventureDeckSize = game.getAdventureDeckSize();
        assertEquals(100, adventureDeckSize);

    }

    @Test
    @DisplayName("Check if event deck has 17 cards")
    void RESP_01_test_02() {
        Main game = new Main();
        game.initializeDecks();

        //there should be 17 event cards total in deck
        int eventDeckSize = game.getEventDeckSize();
        assertEquals(17, eventDeckSize);
    }

    @Test
    @DisplayName("Check if there are 50 Foe cards & 50 Weapon cards")
    void RESP_01_test_03() {
        Main game = new Main();
        game.initializeDecks();

        int adventureDeckSize = game.getAdventureDeckSize();

        //there should be 50 Foe cards & 50 Weapon cards
        int numWeaponCards = 0;
        int numFoeCards = 0;

        for (int i = 0; i < adventureDeckSize; i++) {
            if (game.adventureDeck.get(i).getType().equals("Weapon")) {
                numWeaponCards++;
            } else if (game.adventureDeck.get(i).getType().equals("Foe")) {
                numFoeCards++;
            }
        }

        int finalNumFoeCards = numFoeCards;
        int finalNumWeaponCards = numWeaponCards;
        assertAll(
                "Foe card & Weapon card check",
                () -> assertEquals(50, finalNumFoeCards),
                () -> assertEquals(50, finalNumWeaponCards)
        );
    }

    @Test
    @DisplayName("Check if there are 12 Quest cards & 5 Event cards")
    void RESP_01_test_04() {
        Main game = new Main();
        game.initializeDecks();

        int eventDeckSize = game.getEventDeckSize();

        //there should be 12 Quest cards & 5 Event cards
        int numQuestCards = 0;
        int numEventCards = 0;

        for (int i = 0; i < eventDeckSize; i++) {
            if (game.eventDeck.get(i).getType().equals("Quest")) {
                numQuestCards++;
            } else if (game.eventDeck.get(i).getType().equals("Event")) {
                numEventCards++;
            }
        }
        int finalNumQuestCards = numQuestCards;
        int finalNumEventCards = numEventCards;
        assertAll(
                "Quest card & Event card check",
                () -> assertEquals(12, finalNumQuestCards),
                () -> assertEquals(5, finalNumEventCards)
        );
    }

    @Test
    @DisplayName("Check if the Foe card type amount & values are accurate")
    void RESP_01_test_05() {
        Main game = new Main();
        game.initializeDecks();

        int adventureDeckSize = game.getAdventureDeckSize();

        //the amount of Foe card types & values should be the same according to the specification
        //(i was too lazy to write out each one in comments)
        int numF5Cards = 0, numF10Cards = 0, numF15Cards = 0, numF20Cards = 0, numF25Cards = 0,
                numF30Cards = 0, numF35Cards = 0, numF40Cards = 0, numF50Cards = 0,
                numF70Cards = 0;

        for (int i = 0; i < adventureDeckSize; i++) {
            if (game.adventureDeck.get(i).getType().equals("Foe")) {
                switch(game.adventureDeck.get(i).getValue()) {
                    case "5":
                        numF5Cards++;
                        break;
                    case "10":
                        numF10Cards++;
                        break;
                    case "15":
                        numF15Cards++;
                        break;
                    case "20":
                        numF20Cards++;
                        break;
                    case "25":
                        numF25Cards++;
                        break;
                    case "30":
                        numF30Cards++;
                        break;
                    case "35":
                        numF35Cards++;
                        break;
                    case "40":
                        numF40Cards++;
                        break;
                    case "50":
                        numF50Cards++;
                        break;
                    case "70":
                        numF70Cards++;
                        break;
                }
            }
        }

        //this may check the amounts but if the values are accurate, then the amounts should be accurate
        int finalNumF5Cards = numF5Cards, finalNumF10Cards = numF10Cards,
                finalNumF15Cards = numF15Cards, finalNumF20Cards = numF20Cards,
                finalNumF25Cards = numF25Cards, finalNumF30Cards = numF30Cards,
                finalNumF35Cards = numF35Cards, finalNumF40Cards = numF40Cards,
                finalNumF50Cards = numF50Cards, finalNumF70Cards = numF70Cards;
        assertAll(
                "Amount Check",
                () -> assertEquals(8, finalNumF5Cards),
                () -> assertEquals(7, finalNumF10Cards),
                () -> assertEquals(8, finalNumF15Cards),
                () -> assertEquals(7, finalNumF20Cards),
                () -> assertEquals(7, finalNumF25Cards),
                () -> assertEquals(4, finalNumF30Cards),
                () -> assertEquals(4, finalNumF35Cards),
                () -> assertEquals(2, finalNumF40Cards),
                () -> assertEquals(2, finalNumF50Cards),
                () -> assertEquals(1, finalNumF70Cards)
        );

    }

    @Test
    @DisplayName("Check if the Weapon card type amount & values are accurate")
    void RESP_01_test_06() {
        Main game = new Main();
        game.initializeDecks();

        int adventureDeckSize = game.getAdventureDeckSize();

        //the amount of Weapon card types & values should be the same according to the specification
        //(i was too lazy to write out each one in comments)
        int numVal5Cards = 0, numVal10HCards = 0, numVal10SCards = 0,
                numVal15Cards = 0, numVal20Cards = 0, numVal30Cards = 0;

        for (int i = 0; i < adventureDeckSize; i++) {
            if (game.adventureDeck.get(i).getType().equals("Weapon")) {
                switch(game.adventureDeck.get(i).getName()) {
                    case "Dagger":
                        numVal5Cards++;
                        break;
                    case "Horse":
                        numVal10HCards++;
                        break;
                    case "Sword":
                        numVal10SCards++;
                        break;
                    case "Battle-Axe":
                        numVal15Cards++;
                        break;
                    case "Lance":
                        numVal20Cards++;
                        break;
                    case "Excalibur":
                        numVal30Cards++;
                        break;
                }
            }
        }

        //this may check the amounts but if the values are accurate, then the amounts should be accurate
        int finalNumVal5Cards = numVal5Cards, finalNumVal10HCards = numVal10HCards,
                finalNumVal10SCards = numVal10SCards, finalNumVal15Cards = numVal15Cards,
                finalNumVal20Cards = numVal20Cards, finalNumVal30Cards = numVal30Cards;
        assertAll(
                "Amount Check",
                () -> assertEquals(6, finalNumVal5Cards),
                () -> assertEquals(12, finalNumVal10HCards),
                () -> assertEquals(16, finalNumVal10SCards),
                () -> assertEquals(8, finalNumVal15Cards),
                () -> assertEquals(6, finalNumVal20Cards),
                () -> assertEquals(2, finalNumVal30Cards)
        );
    }

    @Test
    @DisplayName("Check if the Quest card type amount & values are accurate")
    void RESP_01_test_07() {
        Main game = new Main();
        game.initializeDecks();

        int eventDeckSize = game.getEventDeckSize();

        //the amount of Quest card types & values should be the same according to the specification
        //(i was too lazy to write out each one in comments)
        int numQ2Cards = 0, numQ3Cards = 0, numQ4Cards = 0,
                numQ5Cards = 0;

        for (int i = 0; i < eventDeckSize; i++) {
            if (game.eventDeck.get(i).getType().equals("Quest")) {
                switch(game.eventDeck.get(i).getValue()) {
                    case "Q2":
                        numQ2Cards++;
                        break;
                    case "Q3":
                        numQ3Cards++;
                        break;
                    case "Q4":
                        numQ4Cards++;
                        break;
                    case "Q5":
                        numQ5Cards++;
                        break;
                }
            }
        }

        //this may check the amounts but if the values are accurate, then the amounts should be accurate
        int finalNumQ2Cards = numQ2Cards, finalNumQ3Cards = numQ3Cards,
                finalNumQ4Cards = numQ4Cards, finalNumQ5Cards = numQ5Cards;
        assertAll(
                "Amount Check",
                () -> assertEquals(3, finalNumQ2Cards),
                () -> assertEquals(4, finalNumQ3Cards),
                () -> assertEquals(3, finalNumQ4Cards),
                () -> assertEquals(2, finalNumQ5Cards)
        );
    }

    @Test
    @DisplayName("Check if the Event card type amount & values are accurate")
    void RESP_01_test_08() {
        Main game = new Main();
        game.initializeDecks();

        int eventDeckSize = game.getEventDeckSize();

        //the amount of Event card types & values should be the same according to the specification
        //(i was too lazy to write out each one in comments)
        int numPlCards = 0, numQFCards = 0, numPrCards = 0;

        for (int i = 0; i < eventDeckSize; i++) {
            if (game.eventDeck.get(i).getType().equals("Event")) {
                switch(game.eventDeck.get(i).getValue()) {
                    case "-2Sh":
                        numPlCards++;
                        break;
                    case "+2P":
                        numQFCards++;
                        break;
                    case "+2All":
                        numPrCards++;
                        break;
                }
            }
        }

        //this may check the amounts but if the values are accurate, then the amounts should be accurate
        int finalNumPlCards = numPlCards, finalNumQFCards = numQFCards,
                finalNumPrCards = numPrCards;
        assertAll(
                "Amount Check",
                () -> assertEquals(1, finalNumPlCards),
                () -> assertEquals(2, finalNumQFCards),
                () -> assertEquals(2, finalNumPrCards)
        );
    }

    @Test
    @DisplayName("Deal 12 cards to each player")
    void RESP_02_test_01() {
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();

        game.dealCards();

        //all players should have 12 cards
        assertAll(
                "hand check",
                () -> assertEquals(12, game.p1.getHandSize()),
                () -> assertEquals(12, game.p2.getHandSize()),
                () -> assertEquals(12, game.p3.getHandSize()),
                () -> assertEquals(12, game.p4.getHandSize())
        );
    }

    @Test
    @DisplayName("Check if adventure deck is updated after dealing cards")
    void RESP_02_test_02() {
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();

        game.dealCards();

        //adventure deck should have 52 cards after dealing
        assertEquals(52,game.getAdventureDeckSize());
    }

    @Test
    @DisplayName("Determine if one player has achieved 7 or more shields")
    void RESP_03_test_01() {
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should determine that player 1 wins
        game.p1.setShields(8);

        game.checkForWinners();

        assertTrue(game.p1.getWinnerStatus());
    }

    @Test
    @DisplayName("Determine if more than one player has achieved 7 or more shields")
    void RESP_03_test_02() {
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should determine that player 2 & player 4 win
        game.p2.setShields(10);
        game.p4.setShields(25243);

        game.checkForWinners();

        assertTrue(game.p2.getWinnerStatus() && game.p4.getWinnerStatus());
    }

    @Test
    @DisplayName("Determine if no one has achieved more than 7 or more shields")
    void RESP_03_test_03() {
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should determine that no one wins
        game.p1.setShields(1);
        game.p2.setShields(0);
        game.p3.setShields(6);
        game.p4.setShields(5);

        game.checkForWinners();

        //im adding a 0 check because it would pass automatically otherwise
        //also it shouldn't be less than 0 anyway
        assertAll(
                "score check",
                () -> assertTrue(game.getPlayerScore(1) >= 0 && !game.p1.getWinnerStatus()),
                () -> assertTrue(game.getPlayerScore(2) >= 0 && !game.p2.getWinnerStatus()),
                () -> assertTrue(game.getPlayerScore(3) >= 0 && !game.p3.getWinnerStatus()),
                () -> assertTrue(game.getPlayerScore(4) >= 0 && !game.p4.getWinnerStatus())
        );
    }

    @Test
    @DisplayName("Displays id of one winner")
    void RESP_04_test_01() {
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should display player 1 as the winner
        StringWriter output = new StringWriter();

        game.p1.setShields(8);

        game.displayWinner(new PrintWriter(output));

        assertTrue(output.toString().contains("Winner: P1"));
    }

    @Test
    @DisplayName("Displays id of multiple winners")
    void RESP_04_test_02() {
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should display player 2, 3 & 4 as the winners
        StringWriter output = new StringWriter();

        game.p2.setShields(8);
        game.p3.setShields(7);
        game.p4.setShields(9999999);

        game.displayWinner(new PrintWriter(output));

        assertTrue(output.toString().contains("Winners: P2, P3 and P4"));
    }

    @Test
    @DisplayName("Displays id of current player's turn")
    void RESP_05_test_01() {
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();

        //game should display P1
        StringWriter output = new StringWriter();
        String input = "\n";

        game.takeTurn(new Scanner(input), new PrintWriter(output));

        assertTrue(output.toString().contains("Current Player: P1"));
    }

    @Test
    @DisplayName("Displays hand of current player's turn")
    void RESP_05_test_02() {
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();

        //game should display a dagger weapon card for P1
        StringWriter output = new StringWriter();
        String input = "\n";

        game.pickCard(0, "Weapon", "Dagger", "5", 1);

        game.takeTurn(new Scanner(input), new PrintWriter(output));

        assertTrue(output.toString().contains("Dagger, value = 5"));
    }

    @Test
    @DisplayName("Displays hand of current player's turn in increasing order")
    void RESP_05_test_03() {
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();

        //game should display a series of Foe and Weapon cards in increasing order with Foe cards first then Weapon cards
        StringWriter output = new StringWriter();
        String input = "\n";

        game.pickCard(0,"Weapon","Sword", "10", 1);
        game.pickCard(1,"Foe","F5", "5", 1);
        game.pickCard(2,"Weapon","Horse", "10", 1);
        game.pickCard(3,"Foe","F10", "10", 1);
        game.pickCard(4,"Weapon","Excalibur", "30", 1);
        game.pickCard(5,"Weapon","Dagger", "5", 1);

        game.takeTurn(new Scanner(input), new PrintWriter(output));

        String expectedOutput = "F5, value = 5 \nF10, value = 10 \nDagger, value = 5 \nSword, value = 10 \nHorse, value = 10 \nExcalibur, value = 30";

        assertTrue(output.toString().contains(expectedOutput));
    }

    @Test
    @DisplayName("Check if Event Card is displayed")
    void RESP_06_test_01() {
        StringWriter output = new StringWriter();
        String input = "\n";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();

        //game should display event card
        Card c = new Card();
        c.setName("Queen's Favor");
        c.setType("Event");
        c.setValue("+2P");
        game.eventDeck.set(0, c);
        game.takeTurn(new Scanner(input), new PrintWriter(output));

        assertTrue(output.toString().contains("Queen's Favor, value = +2P"));
    }

    @Test
    @DisplayName("Check if event deck & discard deck is updated after card is drawn")
    void RESP_06_test_02() {
        StringWriter output = new StringWriter();
        String input = "\n";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();

        //event deck should have 1 less card and discard deck should have 1 card
        game.takeTurn(new Scanner(input), new PrintWriter(output));

        assertAll(
                "deck size check",
                () -> assertEquals(16, game.getEventDeckSize()),
                () -> assertEquals(1, game.getEventDiscardSize())
        );

    }

    @Test
    @DisplayName("Check if Plague card effect is applied (shields >= 2)")
    void RESP_07_test_01() {
        StringWriter output = new StringWriter();
        String input = "\n";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();

        //player should lose 2 shields
        game.p1.setShields(4);

        Card c = new Card();
        c.setName("Plague");
        c.setType("Event");
        c.setValue("-2Sh");
        game.eventDeck.set(0, c);
        game.takeTurn(new Scanner(input), new PrintWriter(output));

        assertEquals(2,game.p1.getShields());
    }

    @Test
    @DisplayName("Check if Plague card effect is applied (shields < 2)")
    void RESP_07_test_02() {
        StringWriter output = new StringWriter();
        String input = "\n";
        Main game = new Main();
        game.initializeDecks();

        //player should lose 2 shields but remain at 0
        game.p1.setShields(0);
        game.playerList.add(game.p1);

        Card c = new Card();
        c.setName("Plague");
        c.setType("Event");
        c.setValue("-2Sh");
        game.eventDeck.set(0, c);
        game.takeTurn(new Scanner(input), new PrintWriter(output));

        assertEquals(0,game.p1.getShields());
    }

    @Test
    @DisplayName("Check if Queen's Favor card effect is applied")
    void RESP_07_test_03() {
        StringWriter output = new StringWriter();
        String input = "\n";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //player should receive 2 more adventure cards
        Card c = new Card();
        c.setName("Queen's Favor");
        c.setType("Event");
        c.setValue("+2P");
        game.eventDeck.set(0, c);
        game.takeTurn(new Scanner(input), new PrintWriter(output));

        assertEquals(14,game.p1.getHandSize());
    }

    @Test
    @DisplayName("Check if Prosperity card effect is applied")
    void RESP_07_test_04() {
        StringWriter output = new StringWriter();
        String input = "\n";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //all players should receive 2 more adventure cards
        Card c = new Card();
        c.setName("Prosperity");
        c.setType("Event");
        c.setValue("+2All");
        game.eventDeck.set(0, c);
        game.takeTurn(new Scanner(input), new PrintWriter(output));

        assertAll(
                "hand size check",
                () -> assertEquals(14, game.p1.getHandSize()),
                () -> assertEquals(14, game.p2.getHandSize()),
                () -> assertEquals(14, game.p3.getHandSize()),
                () -> assertEquals(14, game.p4.getHandSize())
        );
    }

    @Test
    @DisplayName("Check if game prompts player to move hot seat")
    void RESP_08_test_01() {
        StringWriter output = new StringWriter();
        String input = "\n";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();

        //game should tell player to move
        game.takeTurn(new Scanner(input), new PrintWriter(output));

        assertTrue(output.toString().contains("Turn End. Please move out of hot seat for next player."));
    }

    @Test
    @DisplayName("Check if game flushes display after return key is pressed")
    void RESP_08_test_02() {
        StringWriter output = new StringWriter();
        String input = "\n";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();

        //game should clear the console after return key is pressed
        game.takeTurn(new Scanner(input), new PrintWriter(output));

        //apparently this string text should work to clear the screen
        assertTrue(output.toString().contains("\033[H\033[2J"));
    }

    @Test
    @DisplayName("Check if the P2 is displayed after P1 finishes their turn")
    void RESP_09_test_01() {
        StringWriter output = new StringWriter();
        String input = "\n";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();

        //game should print out the P2 id after P1 takes their turn
        for (int i = 0; i < 2; i++) {
            game.takeTurn(new Scanner(input), new PrintWriter(output));
        }

        assertTrue(output.toString().contains("Current Player: P2"));
    }

    @Test
    @DisplayName("Check if all 4 players get their turn")
    void RESP_09_test_02() {
        StringWriter output = new StringWriter();
        String input = "\n";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();

        //game should print out every player's id
        for (int i = 0; i < 4; i++) {
            game.takeTurn(new Scanner(input), new PrintWriter(output));
        }

        assertAll (
                "id display check",
                () -> assertTrue(output.toString().contains("Current Player: P1")),
                () -> assertTrue(output.toString().contains("Current Player: P2")),
                () -> assertTrue(output.toString().contains("Current Player: P3")),
                () -> assertTrue(output.toString().contains("Current Player: P4"))
        );
    }

    @Test
    @DisplayName("Check if amount of times that the number of cards need to be discarded is accurate")
    void RESP_10_test_01() {
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should calculate the right amount of cards to discard
        game.p1.getHand().add(game.drawCard("adventure"));
        game.p1.getHand().add(game.drawCard("adventure"));
        game.p1.getHand().add(game.drawCard("adventure"));
        game.p1.getHand().add(game.drawCard("adventure"));

        int newHandAmount = game.checkHand(game.p1.getId());

        assertEquals(4,newHandAmount);
    }

    @Test
    @DisplayName("Check if the game displays the hand with numbered positions")
    void RESP_11_test_01() {
        StringWriter output = new StringWriter();
        String input = "\n";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();

        //game should calculate the right amount of cards to discard
        game.pickCard(0,"Weapon","Sword", "10", 1);
        game.pickCard(1,"Foe","F5", "5", 1);
        game.pickCard(2,"Weapon","Horse", "10", 1);
        game.pickCard(3,"Foe","F10", "10", 1);
        game.pickCard(4,"Weapon","Excalibur", "30", 1);
        game.pickCard(5,"Weapon","Lance", "20", 1);
        game.pickCard(6,"Weapon","Battle-Axe", "15", 1);
        game.pickCard(7,"Weapon","Dagger", "5", 1);
        game.pickCard(8,"Weapon","Dagger", "5", 1);
        game.pickCard(9,"Weapon","Dagger", "5", 1);
        game.pickCard(10,"Foe","F15", "15", 1);
        game.pickCard(11,"Foe","F20", "20", 1);
        game.pickCard(12,"Foe","F70", "70", 1);
        game.pickCard(13,"Foe","F50", "50", 1);
        game.pickCard(14,"Foe","F35", "35", 1);
        game.pickCard(15,"Foe","F40", "40", 1);

        game.trimHand(new Scanner(input), new PrintWriter(output));

        String expectedOutput = "[1] Foe, value = 5 \n[2] Foe, value = 10 \n[3] Foe, value = 15 \n[4] Foe, value = 20 \n[5] Foe, value = 35 \n[6] Foe, value = 40 " +
                "\n[7] Foe, value = 50 \n[8] Foe, value = 70 \n[9] Dagger, value = 5 \n[10] Dagger, value = 5 \n[11] Dagger, value = 5 \n[12] Sword, value = 10 " +
                "\n[13] Horse, value = 10 \n[14] battle-Axe, value = 15 \n[15] Lance, value = 20 \n[16] Excalibur, value = 30";

        assertTrue(output.toString().contains(expectedOutput));
    }

    @Test
    @DisplayName("Check if the game prompts which position of the card to delete")
    void RESP_11_test_02() {
        StringWriter output = new StringWriter();
        String input = "\n";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should calculate the right amount of cards to discard
        game.p1.getHand().add(game.drawCard("adventure"));
        game.p1.getHand().add(game.drawCard("adventure"));
        game.p1.getHand().add(game.drawCard("adventure"));
        game.p1.getHand().add(game.drawCard("adventure"));

        game.trimHand(new Scanner(input), new PrintWriter(output));

        assertTrue(output.toString().contains("Select the position of the card to remove: "));
    }

}