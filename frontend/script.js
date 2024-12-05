const apiBaseUrl = "http://localhost:8080";

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

async function startGame() {
    const response = await fetch(`${apiBaseUrl}/start-game`, {
        method: "POST",
    });
    const message = await response.text();
    updateLog(message);
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
}

async function drawEvent(playerID) {
    const response = await fetch(`${apiBaseUrl}/draw-event`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ playerID })
        });
    const data = await response.json();
    updateLog(data.message);
}

async function handleEvent(playerID, input) {
    const response = await fetch(`${apiBaseUrl}/handle-event`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ playerID, input })
        });
    const data = await response.json();
    updateLog(data.message);
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
}

async function attackSequence(playerID, input, eventCard) {
    const response = await fetch(`${apiBaseUrl}/attack-sequence`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ playerID, input, eventCard })
        });
    const data = await response.json();
    updateLog(data.message);
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
}

async function displayWinners(playerID) {
    const response = await fetch(`${apiBaseUrl}/display-winners`, {
        method: "GET",
        headers: { "Content-Type": "application/json" }
    });
    const data = await response.json();
    updateLog(data.message);
}

async function endTurn(playerID) {
    const response = await fetch(`${apiBaseUrl}/display-winners`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ playerID })
    });
    const data = await response.json();
    updateLog(data.message);
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
}

function selectCard(index) {
    updateLog(`Card at position ${index} selected.`);
}

document.getElementById("start-game-btn").addEventListener("click", startGame);