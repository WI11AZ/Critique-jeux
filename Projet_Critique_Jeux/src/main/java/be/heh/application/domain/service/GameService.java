package be.heh.application.domain.service;

import be.heh.application.domain.model.Game;
import be.heh.application.port.out.GameRepository;


import java.util.List;

public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getAllGames() {
        return gameRepository.getAllGames();
    }

    public Game getGameById(int gameId) {
        return gameRepository.getGameById(gameId);
    }

    public Game createGame(String name, String[] images) {
        Game newGame = new Game(0, name, images);
        return gameRepository.createGame(newGame);
    }

    public void updateGame(int gameId, String name, String[] images) {
        Game existingGame = gameRepository.getGameById(gameId);
        if (existingGame != null) {
            existingGame.setName(name);
            existingGame.setImages(images);
            gameRepository.updateGame(existingGame);
        }
    }

    public void deleteGame(int gameId) {
        gameRepository.deleteGame(gameId);
    }
}
