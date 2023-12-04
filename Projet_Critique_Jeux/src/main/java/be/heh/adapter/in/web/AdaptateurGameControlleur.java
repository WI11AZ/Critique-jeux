package be.heh.adapter.in.web;

import be.heh.application.domain.model.Game;
import be.heh.application.domain.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdaptateurGameControlleur {
    private final GameService gameService;

    public AdaptateurGameControlleur(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/game/{gameId}")
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
}

