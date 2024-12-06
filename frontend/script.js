const apiBaseUrl = "http://localhost:8080";

const gameState = {
    currentState: "n/a",
    currentPlayer: null,
    inputEnabled: false,
    currentEventCard: null,
    currentStage: 0,
    previousState: "n/a"
};

function updateLog(message) {
    const log = document.getElementById("game-log");
    log.innerHTML = `<div>${message}</div>`;
    log.scrollTop = log.scrollHeight;
}

function updateStats(players) {
    const stats = document.getElementById("player-stats");
    stats.innerHTML = '';

    players.forEach(player => {
        const playerStats = document.createElement('div');
        playerStats.textContent = `Player ${player.id} - Shields: ${player.shields}, Cards: ${player.hand.length}`;
        stats.appendChild(playerStats);
    });
}

function updateHand(hand) {
    const handSection = document.getElementById("player-hand")
    handSection.innerHTML = hand;
}

function enableInput(placeHolderText) {
    const inputField = document.getElementById("player-input");
    const submitButton = document.getElementById("submit-input-btn");
    inputField.disabled = false;
    submitButton.disabled = false;
    inputField.placeholder = placeHolderText;
}

function disableInput() {
    const inputField = document.getElementById("player-input");
    const submitButton = document.getElementById("submit-input-btn");
    inputField.disabled = true;
    submitButton.disabled = true;
    inputField.placeholder = "";
}

async function submitInput() {
    const inputField = document.getElementById("player-input");
    const input = inputField.value.trim();
    inputField.value = "";

    if (!gameState.inputEnabled) {
        return;
    }

    switch (gameState.currentState) {
        case "trimHand":
            await trimHand(gameState.currentPlayer, input);
            break;
        case "buildQuest":
            await buildQuest(gameState.currentPlayer, input, gameState.currentEventCard);
            break;
        case "buildAttack":
            await buildAttack(gameState.currentPlayer, input);
            break;
        case "getParticipants":
            await getParticipants(gameState.currentPlayer, input, gameState.currentEventCard);
            break;
        case "selectBuilder":
            await selectBuilder(gameState.currentPlayer, input);
            break;
        default:
            updateLog("invalid game phase");
            break;
    }

}

async function nextGameStep() {
    switch (gameState.currentState) {
        case "startTurn":
            await startTurn(gameState.currentPlayer);
            break;
        case "drawEvent":
            await drawEvent(gameState.currentPlayer);
            break;
        case "handleEvent":
            await handleEvent(gameState.currentPlayer, gameState.currentEventCard);
            break;
        case "trimHand":
            enableInput("Trim your hand to the correct size, select a card to discard");
            break;
        case "selectBuilder":
            enableInput("Picking a builder for the quest, would you like to build for it? (y/n)");
            gameState.currentState = "buildQuest";
            break;
        case "buildQuest":
            enableInput("Build the quest, select a card to add to the stage or quit");
            break;
        case "findEligiblePlayers":
            await findEligiblePlayers(gameState.currentPlayer, gameState.currentEventCard);
            break;
        case "getParticipants":
            enableInput("Getting participants for quest, would you like to participate in it? (participate/withdraw)");
            break;
        case "buildAttack":
            enableInput("Build the attack for the stage, select a card for your attack or quit");
            break;
        case "attackSequence":
            await attackSequence(gameState.currentPlayer, gameState.currentStage, gameState.currentEventCard);
            break;
        case "rewardPlayers":
            await rewardPlayers(gameState.currentPlayer, gameState.currentEventCard);
            break;
        case "displayWinners":
            await displayWinners(gameState.currentPlayer);
            break;
        case "endTurn":
            await endTurn(gameState.currentPlayer);
            break;
        case "prepareParticipants":
            await prepareParticipants(gameState.currentPlayer);
            break;
        case "prepareNextStage":
            await prepareNextStage(gameState.currentPlayer, gameState.currentStage, gameState.currentEventCard);
            break;
        default:
            updateLog("invalid game phase");
            break;
    }
}

async function startGame() {
    const response = await fetch(`${apiBaseUrl}/start-game`, {
        method: "POST"
    });
    const message = await response.text();
    updateLog(message);

    gameState.currentState = "startTurn";
    await nextGameStep();
}

async function startTurn(playerID) {
    const response = await fetch(`${apiBaseUrl}/start-turn`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ playerID })
    });
    const data = await response.json();

    updateLog(data.message);
    updateStats(data.playerList);
    updateHand(data.currentHand);

    gameState.currentState = "drawEvent";
    await nextGameStep();
}

async function drawEvent(playerID) {
    const response = await fetch(`${apiBaseUrl}/draw-event`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ playerID })
    });
    const data = await response.json();
    updateLog(data.message);

    console.log(data);

    gameState.currentState = "handleEvent";
    await nextGameStep();
}

async function handleEvent(playerID, eventCard) {
    const response = await fetch(`${apiBaseUrl}/handle-event`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ playerID, eventCard })
    });
    const data = await response.json();
    updateLog(data.message);

    if (data.requiredInput) {
        gameState.previousState = gameState.currentState;
        gameState.currentState = "trimHand";
        await nextGameStep();
    } else if (data.message === "A quest will start!") {
        gameState.currentState = "selectBuilder";
        await nextGameStep();
    } else {
        gameState.currentState = "endTurn";
        await nextGameStep();
    }
}

async function selectBuilder(playerID, input) {
    const response = await fetch(`${apiBaseUrl}/select-builder`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ playerID, input })
    });
    const data = await response.json();
    updateLog(data.message);

    if (data.requiredInput) {
        enableInput("Would you like to build the quest? (y/n)");
    } else if (data.message.includes("All players have declined. Ending turn...")) {
        disableInput();
        gameState.currentState = "endTurn";
        await nextGameStep();
    } else {
        disableInput();
        gameState.currentState = "buildQuest";
        await nextGameStep();
    }
}

async function findEligiblePlayers(playerID, eventCard) {
    const response = await fetch(`${apiBaseUrl}/find-eligible-players`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ playerID, eventCard })
    });
    const data = await response.json();
    updateLog(data.message);

    gameState.currentState = "getParticipants";
    await nextGameStep();
}

async function getParticipants(playerID, input, eventCard) {
    const response = await fetch(`${apiBaseUrl}/get-participants`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ playerID, input, eventCard })
    });
    const data = await response.json();
    updateLog(data.message);

    if (data.requiredInput) {
        enableInput("do you want to participate in the quest? (participate/withdraw)")
    } else {
        gameState.currentState = "prepareParticipants";
        await nextGameStep();
    }
}

async function buildQuest(playerID, input, eventCard) {
    const response = await fetch(`${apiBaseUrl}/build-quest`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ playerID, input, eventCard })
    });
    const data = await response.json();
    updateLog(data.message);
    updateHand(data.currentHand);

    if (data.requiredInput) {
        enableInput("select a card to add to the stage or quit")
    } else {
        gameState.currentState = "findEligiblePlayers";
        await nextGameStep();
    }
}

async function buildAttack(playerID, input) {
    const response = await fetch(`${apiBaseUrl}/build-attack`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ playerID, input })
    });
    const data = await response.json();
    updateLog(data.message);
    updateHand(data.currentHand);

    if (data.requiredInput) {
        enableInput("select a card for your attack or quit")
    } else {
        gameState.currentState = "attackSequence";
        await nextGameStep();
    }
}

async function attackSequence(playerID, stage, eventCard) {
    const response = await fetch(`${apiBaseUrl}/attack-sequence`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ playerID, stage, eventCard })
    });
    const data = await response.json();
    updateLog(data.message);

    gameState.currentState = "prepareNextStage";
    await nextGameStep();
}

async function rewardPlayers(playerID, eventCard) {
    const response = await fetch(`${apiBaseUrl}/reward-players`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ playerID, eventCard })
    });
    const data = await response.json();
    updateLog(data.message);
    updateStats(data.playerList);

    gameState.currentState = "displayWinners";
    await nextGameStep();
}

async function displayWinners(playerID) {
    const response = await fetch(`${apiBaseUrl}/display-winners`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ playerID })
    });
    const data = await response.json();
    updateLog(data.message);

    if (data.message.includes("no winners yet")) {
        gameState.currentState = "endTurn";
        await nextGameStep();
    }
}

async function endTurn(playerID) {
    const response = await fetch(`${apiBaseUrl}/display-winners`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ playerID })
    });
    const data = await response.json();
    updateLog(data.message);

    gameState.currentState = "startTurn";
    await nextGameStep();
}

async function trimHand(playerID, input) {
    const response = await fetch(`${apiBaseUrl}/trim-hand`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ playerID, input })
    });
    const data = await response.json();
    updateLog(data.message);
    updateHand(data.currentHand);

    if (!data.requiredInput) {
        disableInput();
        switch (gameState.previousState) {
            case "handleEvent":
                gameState.currentState = "endTurn";
                break;
            case "rewardPlayers":
                updateLog("Eligible players have been rewarded!");
                gameState.currentState = "endTurn";
                break;
            case "prepareParticipants":
                gameState.currentState = "buildAttack";
                break;
        }
        await nextGameStep();
    } else {
        enableInput("Select a card to discard.");
    }
}

async function prepareParticipants(playerID) {
    const response = await fetch(`${apiBaseUrl}/prepare-participants`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ playerID })
    });
    const data = await response.json();
    updateLog(data.message);
    updateStats(data.playerList);

    if (data.requiredInput) {
        gameState.previousState = gameState.currentState;
        gameState.currentState = "trimHand";
        await nextGameStep();
    } else {
        gameState.currentState = "buildAttack";
        await nextGameStep();
    }
}

async function prepareNextStage(playerID, currentStage, eventCard) {
    const response = await fetch(`${apiBaseUrl}/prepare-next-stage`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ playerID, currentStage, eventCard })
    });
    const data = await response.json();
    updateLog(data.message);

    if (data.finishedQuest) {
        gameState.currentState = "rewardPlayers";
        await nextGameStep();
    } else {
        gameState.currentState = "findEligiblePlayers";
        await nextGameStep();
    }
}

function selectCard(index) {
    updateLog(`Card at position ${index} selected.`);
}

document.getElementById("start-game-btn").addEventListener("click", startGame);