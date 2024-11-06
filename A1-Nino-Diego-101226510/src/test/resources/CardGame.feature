Feature: Card Game

  Scenario: A1_Scenario
    Given a new game starts with A1_Scenario
    When A 4 stage quest card
    And Player 2 sponsors the quest
    Then Player 1 should have 0 shields
    And Player 3 should have 0 shields
    And Player 4 should have 4 shields
    And Player 2 should have 12 cards in hand
    And Player 1 should have "F5, value = 5 F10, value = 10 F15, value = 15 F15, value = 15 F30, value = 30 Horse, value = 10 Battle-Axe, value = 15 Battle-Axe, value = 15 Lance, value = 20" in their hand
    And Player 3 should have "F5, value = 5 F5, value = 5 F15, value = 15 F30, value = 30 Sword, value = 10" in their hand
    And Player 4 should have "F15, value = 15 F15, value = 15 F40, value = 40 Lance, value = 20" in their hand