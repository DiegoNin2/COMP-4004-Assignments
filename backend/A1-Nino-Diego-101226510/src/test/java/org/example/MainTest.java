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
                () -> assertEquals(12, game.playerList.get(0).getHandSize()),
                () -> assertEquals(12, game.playerList.get(1).getHandSize()),
                () -> assertEquals(12, game.playerList.get(2).getHandSize()),
                () -> assertEquals(12, game.playerList.get(3).getHandSize())
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
        game.playerList.get(0).setShields(8);

        game.checkForWinners();

        assertTrue(game.playerList.get(0).getWinnerStatus());
    }

    @Test
    @DisplayName("Determine if more than one player has achieved 7 or more shields")
    void RESP_03_test_02() {
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should determine that player 2 & player 4 win
        game.playerList.get(1).setShields(10);
        game.playerList.get(3).setShields(25243);

        game.checkForWinners();

        assertTrue(game.playerList.get(1).getWinnerStatus() && game.playerList.get(3).getWinnerStatus());
    }

    @Test
    @DisplayName("Determine if no one has achieved more than 7 or more shields")
    void RESP_03_test_03() {
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should determine that no one wins
        game.playerList.get(0).setShields(1);
        game.playerList.get(1).setShields(0);
        game.playerList.get(2).setShields(6);
        game.playerList.get(3).setShields(5);

        game.checkForWinners();

        //im adding a 0 check because it would pass automatically otherwise (this was for the R-TEST-3 commit)
        //also it shouldn't be less than 0 anyway
        assertAll(
                "score check",
                () -> assertTrue(game.playerList.get(0).getShields() >= 0 && !game.playerList.get(0).getWinnerStatus()),
                () -> assertTrue(game.playerList.get(1).getShields() >= 0 && !game.playerList.get(1).getWinnerStatus()),
                () -> assertTrue(game.playerList.get(2).getShields() >= 0 && !game.playerList.get(2).getWinnerStatus()),
                () -> assertTrue(game.playerList.get(3).getShields() >= 0 && !game.playerList.get(3).getWinnerStatus())
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

        game.playerList.get(0).setShields(8);

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

        game.playerList.get(1).setShields(8);
        game.playerList.get(2).setShields(7);
        game.playerList.get(3).setShields(9999999);

        game.displayWinner(new PrintWriter(output));

        assertTrue(output.toString().contains("Winners: P2, P3 and P4"));
    }

    @Test
    @DisplayName("Displays id of current player's turn")
    void RESP_05_test_01() {
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should display P1
        StringWriter output = new StringWriter();
        String input = "\n";

        Card c = new Card("Event","Plague", "-2Sh");
        game.eventDeck.set(0,c);

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

        Card c = new Card("Event","Plague", "-2Sh");
        game.eventDeck.set(0,c);

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

        Card c = new Card("Event","Plague", "-2Sh");
        game.eventDeck.set(0,c);

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
        game.dealCards();

        //game should display event card
        Card c = new Card("Event", "Queen's Favor", "+2P");
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
        game.dealCards();

        //event deck should have 1 less card and discard deck should have 1 card
        Card c = new Card("Event","Plague", "-2Sh");
        game.eventDeck.set(0,c);

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
        game.dealCards();

        //player should lose 2 shields
        game.playerList.get(0).setShields(4);

        Card c = new Card("Event", "Plague", "-2Sh");
        game.eventDeck.set(0, c);
        game.takeTurn(new Scanner(input), new PrintWriter(output));

        assertEquals(2,game.playerList.get(0).getShields());
    }

    @Test
    @DisplayName("Check if Plague card effect is applied (shields < 2)")
    void RESP_07_test_02() {
        StringWriter output = new StringWriter();
        String input = "\n";
        Main game = new Main();
        game.initializePlayers();
        game.initializeDecks();
        game.dealCards();

        //player should lose 2 shields but remain at 0
        Card c = new Card("Event","Plague","-2Sh");
        game.eventDeck.set(0, c);
        game.takeTurn(new Scanner(input), new PrintWriter(output));

        assertEquals(0,game.playerList.get(0).getShields());
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
        Card c = new Card("Event", "Queen's Favor", "+2P");
        game.eventDeck.set(0, c);
        game.takeTurn(new Scanner(input), new PrintWriter(output));

        assertEquals(14, game.playerList.get(0).getHandSize());
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
        Card c = new Card("Event","Prosperity","+2All");
        game.eventDeck.set(0, c);
        game.takeTurn(new Scanner(input), new PrintWriter(output));

        assertAll(
                "hand size check",
                () -> assertEquals(14, game.playerList.get(0).getHandSize()),
                () -> assertEquals(14, game.playerList.get(1).getHandSize()),
                () -> assertEquals(14, game.playerList.get(2).getHandSize()),
                () -> assertEquals(14, game.playerList.get(3).getHandSize())
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
        game.dealCards();

        //game should tell player to move
        Card c = new Card("Event","Plague","-2Sh");
        game.eventDeck.set(0, c);

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
        game.dealCards();

        //game should clear the console after return key is pressed
        Card c = new Card("Event","Plague","-2Sh");
        game.eventDeck.set(0, c);
        game.takeTurn(new Scanner(input), new PrintWriter(output));

        String flushTest = "";
        for (int i = 0; i < 50; i++) {
            flushTest += "\n";
        }

        //apparently this string text should work to clear the screen
        assertTrue(output.toString().contains(flushTest));
    }

    @Test
    @DisplayName("Check if all 4 players get their turn")
    void RESP_09_test_01() {
        StringWriter output = new StringWriter();
        String input = "\n";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should print out every player's id
        Card c = new Card("Event","Plague","-2Sh");
        game.eventDeck.set(0, c);
        Card c1 = new Card("Event","Plague","-2Sh");
        game.eventDeck.set(1, c1);
        Card c2 = new Card("Event","Plague","-2Sh");
        game.eventDeck.set(2, c2);
        Card c3 = new Card("Event","Plague","-2Sh");
        game.eventDeck.set(3, c3);

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
        game.playerList.get(0).addCard(game.drawCard("adventure"));
        game.playerList.get(0).addCard(game.drawCard("adventure"));
        game.playerList.get(0).addCard(game.drawCard("adventure"));
        game.playerList.get(0).addCard(game.drawCard("adventure"));

        int newHandAmount = game.checkHand(game.playerList.get(0).getId());

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
        game.dealCards();

        //game should calculate the right amount of cards to discard
        game.playerList.get(0).getHand().clear();
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

        game.trimHand(new Scanner(input), new PrintWriter(output), game.playerList.get(0).getId());

        String expectedOutput = "[1] F5, value = 5 \n[2] F10, value = 10 \n[3] F15, value = 15 \n[4] F20, value = 20 \n[5] F35, value = 35 \n[6] F40, value = 40 " +
                "\n[7] F50, value = 50 \n[8] F70, value = 70 \n[9] Dagger, value = 5 \n[10] Dagger, value = 5 \n[11] Dagger, value = 5 \n[12] Sword, value = 10 " +
                "\n[13] Horse, value = 10 \n[14] Battle-Axe, value = 15 \n[15] Lance, value = 20 \n[16] Excalibur, value = 30";

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
        game.playerList.get(0).addCard(game.drawCard("adventure"));
        game.playerList.get(0).addCard(game.drawCard("adventure"));
        game.playerList.get(0).addCard(game.drawCard("adventure"));
        game.playerList.get(0).addCard(game.drawCard("adventure"));

        game.trimHand(new Scanner(input), new PrintWriter(output), game.playerList.get(0).getId());

        assertTrue(output.toString().contains("Select the position of the card to remove: "));
    }

    @Test
    @DisplayName("Check if game deletes card based on selected position provided by player")
    void RESP_12_test_01() {
        StringWriter output = new StringWriter();
        String input = "5";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should move the card to a discard pile
        game.playerList.get(0).addCard(game.drawCard("adventure"));

        game.trimHand(new Scanner(input), new PrintWriter(output), game.playerList.get(0).getId());

        assertAll(
                "hand check",
                () -> assertEquals(12,game.playerList.get(0).getHandSize()),
                () -> assertEquals(1, game.getAdventureDiscardDeckSize())
        );
    }

    @Test
    @DisplayName("Check if game displays trimmed hand of player")
    void RESP_12_test_02() {
        StringWriter output = new StringWriter();
        String input = "6";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should display new hand without the card at the 6th position
        game.playerList.get(0).getHand().clear();
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

        game.trimHand(new Scanner(input), new PrintWriter(output), game.playerList.get(0).getId());

        String expectedOutput = "[1] F5, value = 5 \n[2] F10, value = 10 \n[3] F15, value = 15 \n[4] F20, value = 20 \n[5] F70, value = 70 " +
                "\n[6] Dagger, value = 5 \n[7] Dagger, value = 5 \n[8] Sword, value = 10 \n[9] Horse, value = 10 \n[10] Battle-Axe, value = 15 " +
                "\n[11] Lance, value = 20 \n[12] Excalibur, value = 30";

        assertTrue(output.toString().contains(expectedOutput));
    }

    @Test
    @DisplayName("Check if 2 Stage Quest was applied")
    void RESP_13_test_01() {
        StringWriter output = new StringWriter();
        String input = "n\nn\nn\nn\n\n";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should display that a 2 stage quest will start
        Card c = new Card("Quest","2 Stage Quest", "Q2");
        game.eventDeck.set(0, c);

        game.takeTurn(new Scanner(input), new PrintWriter(output));

        assertTrue(output.toString().contains("A 2 Stage Quest will start!"));
    }

    @Test
    @DisplayName("Check if 5 Stage Quest was applied")
    void RESP_13_test_02() {
        StringWriter output = new StringWriter();
        String input = "n\nn\nn\nn\n\n";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should display that a 2 stage quest will start
        Card c = new Card("Quest", "5 Stage Quest", "Q5");
        game.eventDeck.set(0, c);
        game.takeTurn(new Scanner(input), new PrintWriter(output));

        assertTrue(output.toString().contains("A 5 Stage Quest will start!"));
    }

    @Test
    @DisplayName("Check if the game prompts if the player wants to sponsor the quest")
    void RESP_14_test_01() {
        StringWriter output = new StringWriter();
        String input = "n\nn\nn\nn";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should display prompt if player wants to sponsor quest or not
        game.questEvent(new Scanner(input), new PrintWriter(output), "Q1", game.playerList.get(0).getId());

        assertTrue(output.toString().contains("Do you, P1, want to sponsor this quest? (y/n)"));
    }

    @Test
    @DisplayName("Check if the game prompts all players")
    void RESP_14_test_02() {
        StringWriter output = new StringWriter();
        String input = "n\nn\nn\nn";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should display prompt all players wants to sponsor quest or not
        game.questEvent(new Scanner(input), new PrintWriter(output), "Q1", game.playerList.get(0).getId());

        assertAll(
                "prompt check",
                () -> assertTrue(output.toString().contains("Do you, P1, want to sponsor this quest? (y/n)")),
                () -> assertTrue(output.toString().contains("Do you, P2, want to sponsor this quest? (y/n)")),
                () -> assertTrue(output.toString().contains("Do you, P3, want to sponsor this quest? (y/n)")),
                () -> assertTrue(output.toString().contains("Do you, P4, want to sponsor this quest? (y/n)"))
        );
    }

    @Test
    @DisplayName("Check if a player can decline to sponsor quest")
    void RESP_15_test_01() {
        StringWriter output = new StringWriter();
        String input = "n\nn\nn\nn";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should indicate that it is moving on to ask the next player
        game.questEvent(new Scanner(input), new PrintWriter(output), "Q1", game.playerList.get(0).getId());

        assertTrue(output.toString().contains("P1 declined, asking next player..."));
    }

    @Test
    @DisplayName("Check if turn ends after all players decline to sponsor quest")
    void RESP_15_test_02() {
        StringWriter output = new StringWriter();
        String input = "n\nn\nn\nn";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should end turn after all players decline to sponsor quest
        game.questEvent(new Scanner(input), new PrintWriter(output), "2Q", game.playerList.get(2).getId());

        assertTrue(output.toString().contains("All players have declined. Ending turn..."));
    }

    @Test
    @DisplayName("Check if sponsor segment starts after player says 'yes'")
    void RESP_16_test_01() {
        StringWriter output = new StringWriter();
        String input = "y\nwithdraw\nwithdraw\nwithdraw";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should indicate the player who has sponsored the quest and then start it
        Quest q = new Quest();
        Card c = new Card("Weapon","Dagger","5");
        q.addCard(c);
        q.increaseValue();
        game.questStageList.add(q);

        game.questEvent(new Scanner(input), new PrintWriter(output), "Q1", game.playerList.get(0).getId());

        assertTrue(output.toString().contains("P1 has sponsored! Quest starting soon!"));
    }

    @Test
    @DisplayName("Check if sponsor segment starts after a series of 'no's before a 'yes'")
    void RESP_16_test_02() {
        StringWriter output = new StringWriter();
        String input = "n\nn\ny\nwithdraw\nwithdraw\nwithdraw";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should indicate that P3 has sponsored the quest then start it
        Quest q = new Quest();
        Card c = new Card("Weapon","Dagger","5");
        q.addCard(c);
        q.increaseValue();
        game.questStageList.add(q);

        game.questEvent(new Scanner(input), new PrintWriter(output), "Q1", game.playerList.get(0).getId());

        assertTrue(output.toString().contains("P3 has sponsored! Quest starting soon!"));
    }

    @Test
    @DisplayName("Check if game displays hand of sponsor with numbered positions")
    void RESP_17_test_01() {
        StringWriter output = new StringWriter();
        String input = "1\nQuit";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should display hand in order with numbered positions
        game.playerList.get(0).getHand().clear();
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

        game.buildQuest(new Scanner(input), new PrintWriter(output), game.playerList.get(0).getId(), 0);

        String expectedOutput = "[1] F5, value = 5 \n[2] F10, value = 10 \n[3] F15, value = 15 \n[4] F20, value = 20 \n[5] Dagger, value = 5 \n[6] Dagger, value = 5 " +
                "\n[7] Dagger, value = 5 \n[8] Sword, value = 10 \n[9] Horse, value = 10 \n[10] Battle-Axe, value = 15 \n[11] Lance, value = 20 \n[12] Excalibur, value = 30";

        assertTrue(output.toString().contains(expectedOutput));
    }

    @Test
    @DisplayName("Check if game prompts for position of card (or to quit if finished)")
    void RESP_17_test_02() {
        StringWriter output = new StringWriter();
        String input = "4\nQuit";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should prompt player for position of card to add to the current stage (or they can quit)
        game.playerList.get(0).getHand().clear();
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
        game.buildQuest(new Scanner(input), new PrintWriter(output), game.playerList.get(0).getId(), 0);

        assertTrue(output.toString().contains("Select position of card to add to current stage. Type 'Quit' when you are finished."));
    }

    @Test
    @DisplayName("Check if game reprompts if invalid position is inputted")
    void RESP_18_test_01() {
        StringWriter output = new StringWriter();
        String input = "15\n1\nQuit";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should explain why the input is invalid then reprompt
        game.playerList.get(0).getHand().clear();
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
        game.buildQuest(new Scanner(input), new PrintWriter(output), game.playerList.get(0).getId(), 0);

        assertAll(
                "reprompt check",
                () -> assertTrue(output.toString().contains("Rejected: Invalid position.")),
                () -> assertTrue(output.toString().contains("Select position of card to add to current stage. Type 'Quit' when you are finished."))
        );
    }

    @Test
    @DisplayName("Check if game reprompts if the player tries to add another foe")
    void RESP_18_test_02() {
        StringWriter output = new StringWriter();
        String input = "1\n1\n3\nQuit";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should explain why the input is invalid then reprompt
        game.playerList.get(0).getHand().clear();
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

        game.buildQuest(new Scanner(input), new PrintWriter(output), game.playerList.get(0).getId(), 0);

        assertAll(
                "reprompt check",
                () -> assertTrue(output.toString().contains("Rejected: Foe already chosen.")),
                () -> assertTrue(output.toString().contains("Select position of card to add to current stage. Type 'Quit' when you are finished."))
        );

    }

    @Test
    @DisplayName("Check if game reprompts if the player tries to add a repeated weapon")
    void RESP_18_test_03() {
        StringWriter output = new StringWriter();
        String input = "6\n5\n1\nQuit";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should explain why the input is invalid then reprompt
        game.playerList.get(0).getHand().clear();
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

        game.buildQuest(new Scanner(input), new PrintWriter(output), game.playerList.get(0).getId(), 0);

        assertAll(
                "reprompt check",
                () -> assertTrue(output.toString().contains("Rejected: Duplicate weapon.")),
                () -> assertTrue(output.toString().contains("Select position of card to add to current stage. Type 'Quit' when you are finished."))
        );
    }

    //im not sure if there is any other conditions for a reprompt

    @Test
    @DisplayName("Check if the game displays the selected card for the stage")
    void RESP_19_test_01() {
        StringWriter output = new StringWriter();
        String input = "1\nQuit";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should display the card chosen after it was added
        game.playerList.get(0).getHand().clear();
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

        game.buildQuest(new Scanner(input), new PrintWriter(output), game.playerList.get(0).getId(), 0);

        assertTrue(output.toString().contains("Current Stage: F5, value = 5"));
    }
    //could add another test for RESP_19 here idk yet

    @Test
    @DisplayName("Check if game handles player quitting with no cards")
    void RESP_20_test_01() {
        StringWriter output = new StringWriter();
        String input = "Quit\n5\nQuit";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should tell the player that the stage cannot be empty
        game.playerList.get(0).getHand().clear();
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
        game.buildQuest(new Scanner(input), new PrintWriter(output), game.playerList.get(0).getId(), 0);

        assertTrue(output.toString().contains("Cannot Quit: Stage cannot be empty."));
    }

    @Test
    @DisplayName("Check if game handles player quitting with insufficient value")
    void RESP_21_test_01() {
        StringWriter output = new StringWriter();
        String input = "1\nQuit\n11\nQuit";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should tell player that the stage value must be higher
        Quest q = new Quest();
        Card c = new Card("Weapon","Dagger","5");
        q.addCard(c);
        q.increaseValue();
        game.questStageList.add(q);
        game.playerList.get(0).getHand().clear();
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

        game.buildQuest(new Scanner(input), new PrintWriter(output), game.playerList.get(0).getId(), 0);

        assertTrue(output.toString().contains("Cannot Quit: Insufficient values for this stage"));
    }

    @Test
    @DisplayName("Check if the game displays the cards being used when a valid Quit is sent")
    void RESP_22_test_01() {
        StringWriter output = new StringWriter();
        String input = "1\n4\nQuit";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should display the cards used for the stage
        game.playerList.get(0).getHand().clear();
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

        game.buildQuest(new Scanner(input), new PrintWriter(output), game.playerList.get(0).getId(), 0);

        assertTrue(output.toString().contains("The finished quest stage: F5, value = 5, Dagger, value = 5"));
    }

    @Test
    @DisplayName("Check if game prompts for position for position of card (or quit if finished)")
    void RESP_23_test_01() {
        StringWriter output = new StringWriter();
        String input = "12\nquit";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should prompt player for position of card to add to the attack (or they can quit)
        game.playerList.get(0).getHand().clear();
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

        game.buildAttack(new Scanner(input), new PrintWriter(output), game.playerList.get(0).getId());

        assertTrue(output.toString().contains("Select position of card to add to your attack. Type 'quit' when you are finished."));
    }

    @Test
    @DisplayName("Check if game displays hand of sponsor with numbered positions")
    void RESP_23_test_02() {
        StringWriter output = new StringWriter();
        String input = "6\nquit";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should display hand in order with numbered positions
        game.playerList.get(0).getHand().clear();
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

        game.buildAttack(new Scanner(input), new PrintWriter(output), game.playerList.get(0).getId());

        String expectedOutput = "[1] F5, value = 5 \n[2] F10, value = 10 \n[3] F15, value = 15 \n[4] F20, value = 20 \n[5] Dagger, value = 5 \n[6] Dagger, value = 5 " +
                "\n[7] Dagger, value = 5 \n[8] Sword, value = 10 \n[9] Horse, value = 10 \n[10] Battle-Axe, value = 15 \n[11] Lance, value = 20 \n[12] Excalibur, value = 30";

        assertTrue(output.toString().contains(expectedOutput));
    }

    @Test
    @DisplayName("Check if game reprompts if invalid position is inputted")
    void RESP_24_test_01() {
        StringWriter output = new StringWriter();
        String input = "16\n6\nquit";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should explain why the input is invalid then reprompt
        game.playerList.get(0).getHand().clear();
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

        game.buildAttack(new Scanner(input), new PrintWriter(output), game.playerList.get(0).getId());

        assertAll(
                "reprompt check",
                () -> assertTrue(output.toString().contains("Rejected: Invalid position.")),
                () -> assertTrue(output.toString().contains("Select position of card to add to your attack. Type 'quit' when you are finished."))
        );
    }

    @Test
    @DisplayName("Check if game reprompts if player tries to add a repeated weapon")
    void RESP_24_test_02() {
        StringWriter output = new StringWriter();
        String input = "5\n8\nquit";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should explain why the input is invalid then reprompt
        game.playerList.get(0).getHand().clear();
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

        Card c = new Card("Weapon","Dagger","5");
        game.playerList.get(0).addAttackCard(c);

        game.buildAttack(new Scanner(input), new PrintWriter(output), game.playerList.get(0).getId());

        assertAll(
                "reprompt check",
                () -> assertTrue(output.toString().contains("Rejected: Duplicate weapon.")),
                () -> assertTrue(output.toString().contains("Select position of card to add to your attack. Type 'quit' when you are finished."))
        );
    }

    @Test
    @DisplayName("Check if game reprompts if player tries to add a foe card")
    void RESP_24_test_03() {
        StringWriter output = new StringWriter();
        String input = "1\n6\nquit";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should explain why the input is invalid then reprompt
        game.playerList.get(0).getHand().clear();
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

        game.buildAttack(new Scanner(input), new PrintWriter(output), game.playerList.get(0).getId());

        assertAll(
                "reprompt check",
                () -> assertTrue(output.toString().contains("Rejected: Foe cannot be selected.")),
                () -> assertTrue(output.toString().contains("Select position of card to add to your attack. Type 'quit' when you are finished."))
        );
    }

    @Test
    @DisplayName("Check if the game displays the selected card for the attack")
    void RESP_25_test_01() {
        StringWriter output = new StringWriter();
        String input = "6\nquit";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should display the card chosen after it was added
        game.playerList.get(0).getHand().clear();
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

        game.buildAttack(new Scanner(input), new PrintWriter(output), game.playerList.get(0).getId());

        assertTrue(output.toString().contains("Current Attack Cards: Dagger, value = 5"));
    }

    @Test
    @DisplayName("Check if game displays cards if 'quit' was sent with cards")
    void RESP_26_test_01() {
        StringWriter output = new StringWriter();
        String input = "quit";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should display the cards of the attack after the player quits
        Card c = new Card("Weapon","Dagger","5");
        game.playerList.get(0).addAttackCard(c);

        game.buildAttack(new Scanner(input), new PrintWriter(output), game.playerList.get(0).getId());

        assertTrue(output.toString().contains("P1's current attack: Dagger, value = 5"));
    }

    @Test
    @DisplayName("Check if game displays nothing if 'quit' was sent with no cards")
    void RESP_26_test_02() {
        StringWriter output = new StringWriter();
        String input = "quit";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should display no cards after the player quits
        game.buildAttack(new Scanner(input), new PrintWriter(output), game.playerList.get(0).getId());

        assertTrue(output.toString().contains("P1 chose to not play any cards"));
    }

    @Test
    @DisplayName("Check if game displays eligible players")
    void RESP_27_test_01() {
        StringWriter output = new StringWriter();
        String input = "withdraw\nwithdraw";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should display all those who are eligible to play
        //for the sake of this test we'll just have 2 eligible players (P1 will be the quest builder)
        game.playerList.get(1).setEligibleStatus(true);
        game.playerList.get(2).setEligibleStatus(false);
        game.playerList.get(3).setEligibleStatus(true);

        game.getParticipants(new Scanner(input), new PrintWriter(output), game.playerList.get(0).getId());

        assertTrue(output.toString().contains("Eligible Players: P2, P4"));
    }

    @Test
    @DisplayName("Check if game prompts player to withdraw or participate")
    void RESP_28_test_01() {
        StringWriter output = new StringWriter();
        String input = "withdraw\nwithdraw\nwithdraw";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should prompt all eligible players
        game.getParticipants(new Scanner(input), new PrintWriter(output), game.playerList.get(0).getId());

        assertAll(
                "prompt check",
                () -> assertTrue(output.toString().contains("P2, would you like to participate or withdraw from the quest?")),
                () -> assertTrue(output.toString().contains("P3, would you like to participate or withdraw from the quest?")),
                () -> assertTrue(output.toString().contains("P4, would you like to participate or withdraw from the quest?"))
        );
    }

    @Test
    @DisplayName("Check if game changes player to be ineligible if they withdraw")
    void RESP_28_test_02() {
        StringWriter output = new StringWriter();
        String input = "withdraw\nwithdraw\nwithdraw";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should change the player to be ineligible
        game.getParticipants(new Scanner(input), new PrintWriter(output), game.playerList.get(0).getId());

        assertAll(
                "withdraw check",
                () -> assertFalse(game.playerList.get(1).getEligibleStatus()),
                () -> assertFalse(game.playerList.get(2).getEligibleStatus()),
                () -> assertFalse(game.playerList.get(3).getEligibleStatus())
        );
    }

    @Test
    @DisplayName("Check if game stores players who participate")
    void RESP_28_test_03() {
        StringWriter output = new StringWriter();
        String input = "participate\nwithdraw\nparticipate";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should change the player to be ineligible
        game.getParticipants(new Scanner(input), new PrintWriter(output), game.playerList.get(0).getId());

        assertEquals(2, game.participantList.size());
    }

    @Test
    @DisplayName("Check if all eligible players draw an adventure card")
    void RESP_29_test_01() {
        StringWriter output = new StringWriter();
        String input = "y\nparticipate\nwithdraw\nwithdraw\nquit\nwithdraw";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //player's hand should have one more card
        game.playerList.get(1).getHand().clear();

        game.pickCard(0,"Weapon","Sword", "10", 2);
        game.pickCard(1,"Foe","F5", "5", 2);
        game.pickCard(2,"Weapon","Horse", "10", 2);
        game.pickCard(3,"Foe","F10", "10", 2);
        game.pickCard(4,"Weapon","Excalibur", "30", 2);
        game.pickCard(5,"Weapon","Lance", "20", 2);
        game.pickCard(6,"Weapon","Battle-Axe", "15", 2);
        game.pickCard(7,"Weapon","Dagger", "5", 2);
        game.pickCard(8,"Weapon","Dagger", "5", 2);
        game.pickCard(9,"Weapon","Dagger", "5", 2);
        game.pickCard(10,"Foe","F15", "15", 2);

        Card c = new Card("Foe", "F5", "5");
        Quest q = new Quest();
        q.addCard(c);
        q.increaseValue();
        game.questStageList.add(q);

        game.questEvent(new Scanner(input), new PrintWriter(output), "Q1", game.playerList.get(0).getId());

        assertEquals(12,game.playerList.get(1).getHandSize());
    }

    @Test
    @DisplayName("Check if player goes to trim their hand if they have too many cards")
    void RESP_29_test_02() {
        StringWriter output = new StringWriter();
        String input = "y\nparticipate\nwithdraw\nwithdraw\n6\nquit";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should activate trim hand section & the player's hand should be updated
        Card c = new Card("Foe", "F5", "5");
        Quest q = new Quest();
        q.addCard(c);
        q.increaseValue();
        game.questStageList.add(q);

        game.questEvent(new Scanner(input), new PrintWriter(output), "Q1", game.playerList.get(0).getId());

        assertAll(
                "trim hand section",
                () -> assertTrue(output.toString().contains("Too many cards, trimming hand")),
                () -> assertEquals(12, game.playerList.get(1).getHandSize())
        );
    }

    @Test
    @DisplayName("Check if quest ends with no participants")
    void RESP_30_test_01() {
        StringWriter output = new StringWriter();
        String input = "y\nwithdraw\nwithdraw\nwithdraw";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should print out that the quest will be cancelled due to no participants
        Card c = new Card("Foe", "F5", "5");
        Quest q = new Quest();
        q.addCard(c);
        q.increaseValue();
        game.questStageList.add(q);

        game.questEvent(new Scanner(input), new PrintWriter(output), "Q1", game.playerList.get(0).getId());

        assertTrue(output.toString().contains("No participants, quest cancelled..."));
    }

    @Test
    @DisplayName("Check if all players with less attack lose")
    void RESP_31_test_01() {
        StringWriter output = new StringWriter();
        String input = "y\nparticipate\nparticipate\nwithdraw";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should go through all participants and make those who don't have a high enough attack lose
        Card c = new Card("Foe","F70","70");
        Quest q = new Quest();
        q.addCard(c);
        q.increaseValue();
        game.questStageList.add(q);

        Card c1 = new Card("Weapon", "Dagger", "5");
        Card c2 = new Card("Weapon", "Horse", "10");
        game.playerList.get(1).addAttackCard(c1);
        game.playerList.get(2).addAttackCard(c2);
        game.participantList.add(game.playerList.get(1));
        game.participantList.add(game.playerList.get(2));

        game.attackSequence(new PrintWriter(output), 0);

        assertAll(
                "battle check",
                () -> assertTrue(output.toString().contains("Insufficient attack. P2 Loses!")),
                () -> assertTrue(output.toString().contains("Insufficient attack. P3 Loses!"))
        );
    }

    @Test
    @DisplayName("Check if all players with greater or equal attack win")
    void RESP_32_test_01() {
        StringWriter output = new StringWriter();
        String input = "y\nparticipate\nparticipate\nwithdraw";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should go through all participants and make those who don't have a high enough attack lose
        Card c = new Card("Foe","F10","10");
        Quest q = new Quest();
        q.addCard(c);
        q.increaseValue();
        game.questStageList.add(q);

        Card c1 = new Card("Weapon", "Battle-Axe", "15");
        Card c2 = new Card("Weapon", "Horse", "10");
        game.playerList.get(1).addAttackCard(c1);
        game.playerList.get(2).addAttackCard(c2);
        game.participantList.add(game.playerList.get(1));
        game.participantList.add(game.playerList.get(2));

        game.attackSequence(new PrintWriter(output), 0);

        assertAll(
                "battle check",
                () -> assertTrue(output.toString().contains("Sufficient attack. P2 Wins!")),
                () -> assertTrue(output.toString().contains("Sufficient attack. P3 Wins!"))
        );
    }

    @Test
    @DisplayName("Check if all winners receive the shields (assuming it is last stage)")
    void RESP_33_test_01() {
        StringWriter output = new StringWriter();
        String input = "y\nparticipate\nparticipate\nwithdraw\n6\n6\n6\n6";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should award the winners with the shields based on how many stages there were
        Card c = new Card("Foe","F10","10");
        Quest q = new Quest();
        q.addCard(c);
        q.increaseValue();
        game.questStageList.add(q);

        Card c1 = new Card("Weapon", "Battle-Axe", "15");
        Card c2 = new Card("Weapon", "Horse", "10");
        game.playerList.get(1).addAttackCard(c1);
        game.playerList.get(2).addAttackCard(c2);

        game.questEvent(new Scanner(input), new PrintWriter(output), "Q1", game.playerList.get(0).getId());

        assertAll(
                "shield check",
                () -> assertEquals(1,game.playerList.get(1).getShields()),
                () -> assertEquals(1,game.playerList.get(2).getShields())
        );
    }

    @Test
    @DisplayName("Check if game discards all cards used for attack")
    void RESP_34_test_01() {
        StringWriter output = new StringWriter();
        String input = "y\nparticipate\nparticipate\nwithdraw\n6\n6\n6\n6";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should remove all attack cards in participant's hand
        Card c = new Card("Foe","F10","10");
        Quest q = new Quest();
        q.addCard(c);
        q.increaseValue();
        game.questStageList.add(q);

        Card c1 = new Card("Weapon", "Battle-Axe", "15");
        Card c2 = new Card("Weapon", "Horse", "10");
        game.playerList.get(1).addAttackCard(c1);
        game.playerList.get(2).addAttackCard(c2);

        game.questEvent(new Scanner(input), new PrintWriter(output), "Q1", game.playerList.get(0).getId());

        assertAll(
                "attack hand check",
                () -> assertEquals(0,game.playerList.get(1).getAttackHandSize()),
                () -> assertEquals(0,game.playerList.get(2).getAttackHandSize())
        );
    }

    @Test
    @DisplayName("Check if game ends quest if there are no eligible participants after attack")
    void RESP_35_test_01() {
        StringWriter output = new StringWriter();
        String input = "y\nparticipate\nparticipate\nwithdraw\n6\n6\n6";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should quit quest if everyone loses
        Card c = new Card("Foe","F70","70");
        Quest q = new Quest();
        q.addCard(c);
        q.increaseValue();
        game.questStageList.add(q);

        Card c1 = new Card("Weapon", "Dagger", "5");
        Card c2 = new Card("Weapon", "Horse", "10");
        game.playerList.get(1).addAttackCard(c1);
        game.playerList.get(2).addAttackCard(c2);

        game.questEvent(new Scanner(input), new PrintWriter(output), "Q1", game.playerList.get(0).getId());

        assertTrue(output.toString().contains("No eligible participants for next stage. Ending quest..."));
    }

    @Test
    @DisplayName("Check if game ends quest if it was the last stage")
    void RESP_35_test_02() {
        StringWriter output = new StringWriter();
        String input = "y\nparticipate\nparticipate\nwithdraw\n6\n6\n6";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should quit quest if last stage
        Card c = new Card("Foe","F5","5");
        Quest q = new Quest();
        q.addCard(c);
        q.increaseValue();
        game.questStageList.add(q);

        Card c1 = new Card("Weapon", "Dagger", "5");
        Card c2 = new Card("Weapon", "Horse", "10");
        game.playerList.get(1).addAttackCard(c1);
        game.playerList.get(2).addAttackCard(c2);

        game.questEvent(new Scanner(input), new PrintWriter(output), "Q1", game.playerList.get(0).getId());

        assertTrue(output.toString().contains("Last stage of quest complete. Ending quest & rewarding winner(s)..."));
    }

    @Test
    @DisplayName("Check if game discards all cards used to build quest")
    void RESP_36_test_01() {
        StringWriter output = new StringWriter();
        String input = "y\nparticipate\nparticipate\nwithdraw\n6\n6\n6";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should remove all cards in quest
        Card c = new Card("Foe","F5","5");
        Quest q = new Quest();
        q.addCard(c);
        q.increaseValue();
        game.questStageList.add(q);

        Card c1 = new Card("Weapon", "Dagger", "5");
        Card c2 = new Card("Weapon", "Horse", "10");
        game.playerList.get(1).addAttackCard(c1);
        game.playerList.get(2).addAttackCard(c2);

        game.questEvent(new Scanner(input), new PrintWriter(output), "Q1", game.playerList.get(0).getId());

        assertEquals(0, game.questStageList.size());
    }

    @Test
    @DisplayName("Check if player redraws the same number of cards + the number of stages")
    void RESP_36_test_02() {
        StringWriter output = new StringWriter();
        String input = "y\nparticipate\nparticipate\nwithdraw\n6\n6";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //game should draw 3 more cards for the builder
        game.playerList.get(0).getHand().clear();
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

        Card c = new Card("Foe","F70","70");
        Quest q = new Quest();
        q.addCard(c);
        q.increaseValue();
        game.questStageList.add(q);

        Card c1 = new Card("Weapon", "Dagger", "5");
        Card c2 = new Card("Weapon", "Horse", "10");
        game.playerList.get(1).addAttackCard(c1);
        game.playerList.get(2).addAttackCard(c2);

        game.questEvent(new Scanner(input), new PrintWriter(output), "Q1", game.playerList.get(0).getId());

        assertEquals(13, game.playerList.get(0).getHandSize());
    }

    @Test
    @DisplayName("Check if player trims hand after redrawing")
    void RESP_36_test_03() {
        StringWriter output = new StringWriter();
        String input = "y\nparticipate\nparticipate\nwithdraw\n6\n6\n6";
        Main game = new Main();
        game.initializeDecks();
        game.initializePlayers();
        game.dealCards();

        //builder should trim hand back to 12
        game.playerList.get(0).getHand().clear();
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

        Card c = new Card("Foe","F70","70");
        Quest q = new Quest();
        q.addCard(c);
        q.increaseValue();
        game.questStageList.add(q);

        Card c1 = new Card("Weapon", "Dagger", "5");
        Card c2 = new Card("Weapon", "Horse", "10");
        game.playerList.get(1).addAttackCard(c1);
        game.playerList.get(2).addAttackCard(c2);

        game.questEvent(new Scanner(input), new PrintWriter(output), "Q1", game.playerList.get(0).getId());

        assertAll(
                "trim hand section",
                () -> assertTrue(output.toString().contains("Too many cards, trimming hand")),
                () -> assertEquals(12, game.playerList.get(0).getHandSize())
        );
    }

}