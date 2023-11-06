package be.heh.application.port.in;

import be.heh.application.domain.model.Game;

public interface ManagementGame {
    public void CreateGame(Game game);
    public void DeleteGame(long gameId);
    public void UpdateGame(Game gameId);
}
