const { Builder, By, until } = require('selenium-webdriver');
const assert = require('assert');
const { rigScene1, rigScene2, rigScene3, rigScene4 } = require('./script')
const apiBaseUrl = "http://localhost:8080";
global.apiBaseUrl = apiBaseUrl;

async function handleInput(input) {
    let inputField = driver.findElement(By.id('player-input'));
    let userInput = input;
    console.log("input: ", userInput);
    console.log("sending input...");
    await inputField.sendKeys(userInput);
}

//two winner
async function scenario1() {
    let driver = await new Builder().forBrowser('chrome').build();

    try {
        await rigScene1(driver);

        await driver.get('http://127.0.0.1:8081');

        console.log("starting game...");
        let startButton = driver.findElement(By.id('start-game-btn'));
        await startButton.click();
        await driver.sleep(2000);

        //input for sponsoring quest 1
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Would you like to build the quest? (y/n)'));
        handleInput("y");
        let submitButton = driver.findElement(By.id('submit-input-btn'));
        await submitButton.click();
        await driver.sleep(2000);

        //input for building quest 1
        //settles stage 1
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //settles stage 2
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("6");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //settles stage 3
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("5");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //settles stage 4
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("5");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //input for stage 1
        //gets participants
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        //trimming
        //P2
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        //P3
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        //P4
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P2
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("6");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P3
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P4
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("6");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //input for stage 2
        //gets participants
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P2
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("4");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P4
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("4");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //input for stage 3
        //gets participants
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P2
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("7");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("5");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P4
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("7");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("5");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //input for stage 4
        //gets participants
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P2
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("6");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("6");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P4
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("6");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("6");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //input for builder discard
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        //input for sponsoring quest 2
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Would you like to build the quest? (y/n)'));
        handleInput("n");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Would you like to build the quest? (y/n)'));
        handleInput("y");
        await submitButton.click();
        await driver.sleep(2000);

        //input for building quest 2
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("4");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("4");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //input for stage 1
        //get participants
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("withdraw");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P2
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("6");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P4
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("6");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //input for stage 2
        //get participants
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P2
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("7");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P4
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("7");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //input for stage 3
        //get participants
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P2
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("10");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P4
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("10");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //input for builder discard
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("2");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("2");
        await submitButton.click();
        await driver.sleep(2000);

        //asserts
        let player1Cards = await driver.findElement(By.id("player1-hand")).getText();
        let player2Cards = await driver.findElement(By.id("player2-hand")).getText();
        let player3Cards = await driver.findElement(By.id("player3-hand")).getText();
        let player4Cards = await driver.findElement(By.id("player4-hand")).getText();
        console.assert(player1Cards.includes('F15, value = 15 F15, value = 15 F20, value = 20 F20, value = 20 F20, value = 20 F20, value = 20 F25, value = 25 F25, value = 25 F30, value = 30 Horse, value = 10 Battle-Axe, value = 15 Lance, value = 20'), 'wrong cards in hand');
        console.assert(player2Cards.includes('F10, value = 10 F15, value = 15 F15, value = 15 F25, value = 25 F30, value = 30 F40, value = 40 F50, value = 50 Lance, value = 20'), 'wrong cards in hand');
        console.assert(player3Cards.includes('F20, value = 20 F40, value = 40 Dagger, value = 5 Dagger, value = 5 Sword, value = 10 Horse, value = 10 Horse, value = 10 Horse, value = 10 Horse, value = 10 Battle-Axe, value = 15 Battle-Axe, value = 15 Lance, value = 20'), 'wrong cards in hand');
        console.assert(player4Cards.includes('F15, value = 15 F15, value = 15 F20, value = 20 F25, value = 25 F30, value = 30 F50, value = 50 F70, value = 70 Lance, value = 20 Lance, value = 20'), 'wrong cards in hand');

        let winners = await driver.findElement(By.id("game-log-section")).getText();
        console.assert(winners.includes('Winners: P2 and P4'), 'wrong winner(s)');

    } catch (error) {
        console.error("something went wrong", error);
    } finally {
        await driver.quit();
    }
}

//1 winner
async function scenario2() {
    let driver = await new Builder().forBrowser('chrome').build();

    try {
        await rigScene2(driver);

        await driver.get('http://127.0.0.1:8081');

        //input for sponsoring quest 1
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Would you like to build the quest? (y/n)'));
        handleInput("y");
        let submitButton = driver.findElement(By.id('submit-input-btn'));
        await submitButton.click();
        await driver.sleep(2000);

        //input for quest
        //settles stage 1
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //settles stage 2
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("2");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //settles stage 3
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("3");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //settles stage 4
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("4");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //input for stage 1
        //get participants
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        //trimming
        //P2
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        //P3
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        //P4
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("3");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P2
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("3");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P3
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("3");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P4
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("4");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //input for stage 2
        //get participants
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P2
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("6");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P3
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("6");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P4
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("7");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //input for stage 3
        //get participants
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P2
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("8");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P3
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("8");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P4
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("9");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //input for stage 4
        //get participants
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P2
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("10");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P3
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("10");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P4
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("12");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //input for builder discard
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("2");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("2");
        await submitButton.click();
        await driver.sleep(2000);

        //input for prosperity
        //Player 1
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        //Player 2
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        //Player 3
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        //Player 4
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        //input for Queen's Favor
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("5");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("4");
        await submitButton.click();
        await driver.sleep(2000);

        //input for sponsoring quest 2
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Would you like to build the quest? (y/n)'));
        handleInput("y");
        await submitButton.click();
        await driver.sleep(2000);

        //input for building quest 2
        //settles stage 1
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("3");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //settles stage 2
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("3");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("10");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //settles stage 3
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("6");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("8");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //input for stage 1
        //get participants
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        //trimming
        //P2
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        //P3
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        //P4
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P2
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("9");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P3
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("9");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P4
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("10");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //input for stage 2
        //get participants
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P2
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("10");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("9");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P3
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("10");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("7");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //input for stage 3
        //get participants
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P2
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("10");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("8");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P3
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("11");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //input for builder discard
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("3");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("3");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("3");
        await submitButton.click();
        await driver.sleep(2000);

        //asserts
        let player1Cards = await driver.findElement(By.id("player1-hand")).getText();
        let player2Cards = await driver.findElement(By.id("player2-hand")).getText();
        let player3Cards = await driver.findElement(By.id("player3-hand")).getText();
        let player4Cards = await driver.findElement(By.id("player4-hand")).getText();
        console.assert(player1Cards.includes('F25, value = 25 F25, value = 25 F35, value = 35 Dagger, value = 5 Dagger, value = 5 Sword, value = 10 Sword, value = 10 Sword, value = 10 Sword, value = 10 Horse, value = 10 Horse, value = 10 Horse, value = 10'), 'wrong cards in hand');
        console.assert(player2Cards.includes('F15, value = 15 F25, value = 25 F30, value = 30 F40, value = 40 Sword, value = 10 Sword, value = 10 Sword, Horse, value = 10 value = 10 Excalibur, value = 30'), 'wrong cards in hand');
        console.assert(player3Cards.includes('F10, value = 10 F25, value = 25 F30, value = 30 F40, value = 40 F50, value = 50 Sword, value = 10 Sword, value = 10 Horse, value = 10 Horse, value = 10 Lance, value = 20'), 'wrong cards in hand');
        console.assert(player4Cards.includes('F25, value = 25 F25, value = 25 F30, value = 30 F50, value = 50 F70, value = 70 Dagger, value = 5 Dagger, value = 5 Sword, value = 10 Sword, value = 10 Battle-Axe, value = 15 Lance, value = 20'), 'wrong cards in hand');

        let winners = await driver.findElement(By.id("game-log-section")).getText();
        console.assert(winners.includes('Winners: P3'), 'wrong winner(s)');

    } catch (error) {
        console.error("something went wrong", error);
    } finally {
              await driver.quit();
    }
}

//0 winner
async function scenario3() {
    let driver = await new Builder().forBrowser('chrome').build();

    try {
        await rigScene3(driver);

        await driver.get('http://127.0.0.1:8081');

        //input for sponsoring quest
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Would you like to build the quest? (y/n)'));
        handleInput("y");
        let submitButton = driver.findElement(By.id('submit-input-btn'));
        await submitButton.click();
        await driver.sleep(2000);

        //input for quest
        //settles stage 1
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("2");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("3");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("4");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("5");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("6");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //settles for stage 2
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //input for stage 1
        //get participants
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        //trimming
        //P2
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        //P3
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("5");
        await submitButton.click();
        await driver.sleep(2000);

        //P4
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("3");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P2
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("12");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P3
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P4
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //input for builder discard
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        //asserts
        let player1Cards = await driver.findElement(By.id("player1-hand")).getText();
        let player2Cards = await driver.findElement(By.id("player2-hand")).getText();
        let player3Cards = await driver.findElement(By.id("player3-hand")).getText();
        let player4Cards = await driver.findElement(By.id("player4-hand")).getText();
        console.assert(player1Cards.includes('F15, value = 15 Dagger, value = 5 Dagger, value = 5 Dagger, value = 5 Dagger, value = 5 Sword, value = 10 Sword, value = 10 Sword, value = 10 Horse, value = 10 Horse, value = 10 Horse, value = 10 Horse, value = 10'), 'wrong cards in hand');
        console.assert(player2Cards.includes('F5, value = 5 F5, value = 5 F10, value = 10 F15, value = 15 F15, value = 15 F20, value = 20 F20, value = 20 F25, value = 25 F30, value = 30 F30, value = 30 F40, value = 40'), 'wrong cards in hand');
        console.assert(player3Cards.includes('F5, value = 5 F5, value = 5 F10, value = 10 F15, value = 15 F15, value = 15 F20, value = 20 F20, value = 20 F25, value = 25 F25, value = 25 F30, value = 30 F40, value = 40 Lance, value = 20'), 'wrong cards in hand');
        console.assert(player4Cards.includes('F5, value = 5 F5, value = 5 F10, value = 10 F15, value = 15 F15, value = 15 F20, value = 20 F20, value = 20 F25, value = 25 F25, value = 25 F30, value = 30 F40, value = 40 Excalibur, value = 30'), 'wrong cards in hand');

        let winners = await driver.findElement(By.id("game-log-section")).getText();
        console.assert(winners.includes('no winners yet'), 'wrong winner(s)');

    } catch (error) {
        console.error("something went wrong", error);
    } finally {
              await driver.quit();
    }
}

//A1 scenario
async function scenario4() {
    let driver = await new Builder().forBrowser('chrome').build();

    try {
        await rigScene4(driver);

        await driver.get('http://127.0.0.1:8081');

        //input for sponsoring quest 1
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Would you like to build the quest? (y/n)'));
        handleInput("n");
        let submitButton = driver.findElement(By.id('submit-input-btn'));
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Would you like to build the quest? (y/n)'));
        handleInput("y");
        await submitButton.click();
        await driver.sleep(2000);

        //input for quest
        //settles stage 1
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("7");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //settles stage 2
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("2");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("5");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //settles stage 3
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("2");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("3");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("4");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //settles stage 4
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("2");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("3");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card to add to the stage or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //input for stage 1
        //get participants
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        //trimming
        //P1
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        //P3
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        //P4
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P1
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("5");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("5");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P3
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("5");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("4");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P4
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("4");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("6");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //input for stage 2
        //get participants
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P1
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("7");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("6");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P3
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("9");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("4");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P4
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("6");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("6");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //input for stage 3
        //get participants
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P3
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("9");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("6");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("4");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P4
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("7");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("5");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("6");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //input for stage 4
        //get participants
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'do you want to participate in the quest? (participate/withdraw)'));
        handleInput("participate");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P3
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("8");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("6");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("7");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //builds attack for P4
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("4");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("4");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("4");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("5");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'select a card for your attack or quit'));
        handleInput("quit");
        await submitButton.click();
        await driver.sleep(2000);

        //input for builder discard
        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        await driver.wait(until.elementTextContains(driver.findElement(By.id('player-input')), 'Select a card to discard.'));
        handleInput("1");
        await submitButton.click();
        await driver.sleep(2000);

        //asserts
        let player1Cards = await driver.findElement(By.id("player1-hand")).getText();
        let player2Cards = await driver.findElement(By.id("player2-hand")).getText();
        let player3Cards = await driver.findElement(By.id("player3-hand")).getText();
        let player4Cards = await driver.findElement(By.id("player4-hand")).getText();
        console.assert(player1Cards.includes('F5, value = 5 F10, value = 10 F15, value = 15 F15, value = 15 F30, value = 30 Horse, value = 10 Battle-Axe, value = 15 Battle-Axe, value = 15 Lance, value = 20'), 'wrong cards in hand');
        console.assert(player2Cards.includes('F5, value = 5 F5, value = 5 F5, value = 5 F5, value = 5 F5, value = 5 F5, value = 5 F5, value = 5 F5, value = 5 F5, value = 5 F5, value = 5 Horse, value = 10 Excalibur, value = 30'), 'wrong cards in hand');
        console.assert(player3Cards.includes('F5, value = 5 F5, value = 5 F15, value = 15 F30, value = 30 Sword, value = 10'), 'wrong cards in hand');
        console.assert(player4Cards.includes('F15, value = 15 F15, value = 15 F40, value = 40 Lance, value = 20'), 'wrong cards in hand');

        let winners = await driver.findElement(By.id("game-log-section")).getText();
        console.assert(winners.includes('no winners yet'), 'wrong winner(s)');

    } catch (error) {
        console.error("something went wrong", error);
    } finally {
              await driver.quit();
    }
}

scenario1();
scenario2();
scenario3();
scenario4();