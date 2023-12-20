package be.heh.adapter.in.web;

import be.heh.application.domain.model.Game;
import be.heh.application.domain.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdaptateurGameControlleur {
    private final GameService gameService;

    public AdaptateurGameControlleur(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/games/{gameId}")
    public ResponseEntity<Game> getGameById(@PathVariable int gameId) {
        Game game = gameService.getGameById(gameId);

        if (game != null) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(game);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @PutMapping("/games/{gameId}")
    public ResponseEntity<Game> updateGame(@PathVariable int gameId, @RequestBody Game updatedGameData) {
        gameService.updateGame(gameId, updatedGameData.getName(), updatedGameData.getImages());

        // Assuming updateGame method in GameService doesn't return the updated game
        Game updatedGame = gameService.getGameById(gameId);

        if (updatedGame != null) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(updatedGame);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @DeleteMapping("/games/{gameId}")
    public ResponseEntity<Void> deleteGame(@PathVariable int gameId) {
        boolean deleted = gameService.deleteGame(gameId);

        if (deleted) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @PostMapping("/games")
    public ResponseEntity<Game> createGame(@RequestBody Game gameData) {
        Game createdGame = gameService.createGame(gameData.getName(), gameData.getImages());

        if (createdGame != null) {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(createdGame);
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
}
