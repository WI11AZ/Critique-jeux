package be.heh.application.domain.service;

import be.heh.application.domain.model.Game;
import be.heh.application.port.in.ManagementGame;
import be.heh.application.port.out.GameRepository;
public class ManagementGameService implements ManagementGame {
    private final GameRepository gameRepository;
    public ManagementGameService(GameRepository gameRepository){
        this.gameRepository=gameRepository;
    }
    @Override
    public void CreateGame(Game game) {
        gameRepository.save(game);

    }

    @Override
    public void DeleteGame(long gameId) {
        gameRepository.deleteById(gameId);

    }

    @Override
    public void UpdateGame(Game gameId) {
        gameRepository.update(gameId);
    }


}
