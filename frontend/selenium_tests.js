const { Builder, By, until } = require('selenium-webdriver');
const assert = require('assert');

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
        console.assert(winners.includes('Winners: P2 and P4'), 'wrong winners');

    } catch (error) {
        console.error("something went wrong", error);
    }
}

async function scenario2() {
    let driver = await new Builder().forBrowser('chrome').build();

    try {
        await rigScene2();

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
        console.assert(winners.includes('Winners: P2 and P4'), 'wrong winners');

    } catch (error) {
        console.error("something went wrong", error);
    }
}