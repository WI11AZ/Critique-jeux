package be.heh.application.port.in;

import be.heh.application.domain.model.Game;

import java.util.List;

public interface UseCaseInGame {
    List<Game> getAllGames();
    Game getGameById(int gameId);
    Game createGame(String name, String[] images);
    void updateGame(int gameId, String name, String[] images);
    void deleteGame(int gameId);
}
