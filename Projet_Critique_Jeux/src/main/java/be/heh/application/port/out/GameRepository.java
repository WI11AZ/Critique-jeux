package be.heh.application.port.out;

import be.heh.application.domain.model.Game;

public interface GameRepository {
    public void save(Game game);
    public void deleteById(long gameId);
    public void update(Game gameId);
}
