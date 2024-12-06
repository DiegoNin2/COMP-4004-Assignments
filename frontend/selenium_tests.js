const { Builder, By, until } = require('selenium-webdriver');
const assert = require('assert');

//two winner
async function scenario1() {
    let driver = await new Builder().forBrowser('chrome').build();

    try {
        await rigScene1();

        await driver.get('http://127.0.0.1:8081');



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
    }
}

//1 winner
async function scenario2() {
    let driver = await new Builder().forBrowser('chrome').build();

    try {
        await rigScene2();

        await driver.get('http://127.0.0.1:8081');



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
    }
}

//0 winner
async function scenario3() {
    let driver = await new Builder().forBrowser('chrome').build();

    try {
        await rigScene3();

        await driver.get('http://127.0.0.1:8081');



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
    }
}

//A1 scenario
async function scenario4() {
    let driver = await new Builder().forBrowser('chrome').build();

    try {
        await rigScene4();

        await driver.get('http://127.0.0.1:8081');



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
    }
}