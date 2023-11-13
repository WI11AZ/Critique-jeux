package be.heh.application.port.out;

import be.heh.application.domain.model.Game;

import java.util.List;

public interface GameRepository {
    List<Game> getAllGames();
    Game getGameById(int gameId);
    Game createGame(Game game);
    void updateGame(Game game);
    void deleteGame(int gameId);
}
