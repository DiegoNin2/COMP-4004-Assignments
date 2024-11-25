Feature: Card Game

  Scenario: A1_Scenario
    Given a new game starts with "A1_Scenario"
    When a "4 Stage Quest" card is drawn with Player 2 sponsoring
    Then Player 1 should have 0 shields
    And Player 3 should have 0 shields
    And Player 4 should have 4 shields
    And Player 2 should have 12 cards in hand
    And Player 1 should have 9 cards in hand
    And Player 3 should have 5 cards in hand
    And Player 4 should have 4 cards in hand
    And Player 1 should have "F5, value = 5 F10, value = 10 F15, value = 15 F15, value = 15 F30, value = 30 Horse, value = 10 Battle-Axe, value = 15 Battle-Axe, value = 15 Lance, value = 20" in their hand
    And Player 3 should have "F5, value = 5 F5, value = 5 F15, value = 15 F30, value = 30 Sword, value = 10" in their hand
    And Player 4 should have "F15, value = 15 F15, value = 15 F40, value = 40 Lance, value = 20" in their hand

  Scenario: 2winner_game_2winner_quest
    Given a new game starts with "2winner_game"
    When a "4 Stage Quest" card is drawn with Player 1 sponsoring and a "3 Stage Quest" card is drawn with Player 3 sponsoring
    Then Player 2 should have 7 shields
    And Player 4 should have 7 shields
    And Player 2 is declared as a Winner
    And Player 4 is declared as a Winner

  Scenario: 1winner_game_with_events
    Given a new game starts with "events"
    When a "4 Stage Quest" card is drawn with Player 1 sponsoring and a "Plague" card is drawn and a "Prosperity" card is drawn and a "Queen's Favor" card is drawn and a "3 Stage Quest" card is drawn with Player 1 Sponsoring
    Then Player 3 should have 7 shields
    And Player 2 should have 5 shields
    And Player 4 should have 4 shields
    And Player 3 is declared as a Winner

  Scenario: 0_winner_quest
    Given a new game starts with "0_winner"
    When a "2 Stage Quest" card is drawn with Player 1 sponsoring
    Then Player 2 should have 0 shields
    And Player 3 should have 0 shields
    And Player 4 should have 0 shields
    And Player 2 should have 9 cards in hand
    And Player 3 should have 10 cards in hand
    And Player 4 should have 11 cards in hand
    And Player 1 should have 12 cards in hand
