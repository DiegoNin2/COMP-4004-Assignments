package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
            if (game.adventureDeck.get(i).type.equals("Weapon")) {
                numWeaponCards++;
            } else if (game.adventureDeck.get(i).type.equals("Foe")) {
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
            if (game.eventDeck.get(i).type.equals("Quest")) {
                numQuestCards++;
            } else if (game.eventDeck.get(i).type.equals("Event")) {
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
            if (game.adventureDeck.get(i).type.equals("Foe")) {
                switch(game.adventureDeck.get(i).value) {
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
            if (game.adventureDeck.get(i).type.equals("Weapon")) {
                switch(game.adventureDeck.get(i).name) {
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
            if (game.eventDeck.get(i).type.equals("Quest")) {
                switch(game.eventDeck.get(i).value) {
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
            if (game.eventDeck.get(i).type.equals("Event")) {
                switch(game.eventDeck.get(i).value) {
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

}