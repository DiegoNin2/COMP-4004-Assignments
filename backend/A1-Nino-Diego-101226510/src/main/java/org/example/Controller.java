package org.example;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:8081")
public class Controller {

    private GameService gameService;

    public Controller() {
        gameService = new GameService();
    }

    @PostMapping("/start-game")
    public String startGame() {
        gameService.reset();
        gameService.initalizeDecks();
        gameService.initalizePlayers();
        gameService.dealCards();
        return "Starting Game...";
    }

    @GetMapping("/display-winners")
    public GameResponse displayWinner(@RequestBody GameRequest request) {
        return gameService.displayWinners(request.getPlayerID());
    }

    @PostMapping("/attack-sequence")
    public GameResponse attackSequence(@RequestBody GameRequest request) {
        return gameService.attackSequence(request.getPlayerID(), request.getCurrentStage(), request.getEventCard());
    }

    @PostMapping("/build-attack")
    public GameResponse buildAttack(@RequestBody GameRequest request) {
        return gameService.buildAttack(request.getPlayerID(), request.getInput());
    }

    @PostMapping("/build-quest")
    public GameResponse buildQuest(@RequestBody GameRequest request) {
        return gameService.buildQuest(request.getPlayerID(), request.getInput(), request.getEventCard());
    }

    @PostMapping("/find-eligible-players")
    public GameResponse findEligiblePlayers(@RequestBody GameRequest request) {
        return gameService.findEligiblePlayers(request.getPlayerID(), request.getEventCard());
    }

    @PostMapping("/get-participants")
    public GameResponse getParticipants(@RequestBody GameRequest request) {
        return gameService.getParticipants(request.getPlayerID(), request.getInput(), request.getEventCard());
    }

    @PostMapping("/select-builder")
    public GameResponse selectBuilder(@RequestBody GameRequest request) {
        return gameService.selectBuilder(request.getPlayerID(), request.getInput());
    }

    @PostMapping("/reward-players")
    public GameResponse rewardPlayers(@RequestBody GameRequest request) {
        return gameService.rewardPlayers(request.getPlayerID(), request.getEventCard());
    }

    @PostMapping("/start-turn")
    public GameResponse startTurn(@RequestBody GameRequest request) {
        return gameService.startTurn(request.getPlayerID());
    }

    @PostMapping("/draw-event")
    public GameResponse drawEvent(@RequestBody GameRequest request) {
        return gameService.drawEvent(request.getPlayerID());
    }

    @PostMapping("/handle-event")
    public GameResponse handleEvent(@RequestBody GameRequest request) {
        return gameService.handleEvent(request.getPlayerID(), request.getEventCard(), request.getInput());
    }

    @PostMapping("/end-turn")
    public GameResponse endTurn(@RequestBody GameRequest request) {
        return gameService.endTurn(request.getPlayerID());
    }

    @PostMapping("/trim-hand")
    public GameResponse trimHand(@RequestBody GameRequest request) {
        return gameService.trimHand(request.getPlayerID(), request.getInput());
    }
}
