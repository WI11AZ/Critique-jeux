package be.heh.application.domain.service;
import be.heh.application.domain.model.Game;
import be.heh.application.port.out.GameRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GameServiceTest {
    private GameService gameService;

    @Mock
    private GameRepository gameRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        gameService = new GameService(gameRepository);
    }

    @Test
    public void testGetAllGames() {
        // Crée une liste de jeux de test
        List<Game> games = new ArrayList<>();
        games.add(new Game(1, "Game 1", new String[]{"image1.jpg", "image2.jpg"}));
        games.add(new Game(2, "Game 2", new String[]{"image3.jpg", "image4.jpg"}));

        // Configure le comportement du GameRepository mock
        when(gameRepository.getAllGames()).thenReturn(games);

        // Appelle la méthode de service
        List<Game> allGames = gameService.getAllGames();

        // Vérifie que la liste de jeux retournée correspond à celle du mock
        assertEquals(games, allGames);
    }

    @Test
    public void testGetGameById() {
        // Crée un jeu de test
        Game game = new Game(1, "Game 1", new String[]{"image1.jpg", "image2.jpg"});

        // Configure le comportement du GameRepository mock
        when(gameRepository.getGameById(1)).thenReturn(game);

        // Appelle la méthode de service
        Game retrievedGame = gameService.getGameById(1);

        // Vérifie que le jeu retourné correspond à celui du mock
        assertEquals(game, retrievedGame);
    }

    @Test
    public void testCreateGame() {
        // Crée un nouveau jeu de test
        Game newGame = new Game(0, "New Game", new String[]{"new_image.jpg"});

        // Configure le comportement du GameRepository mock
        when(gameRepository.createGame(any(Game.class))).thenReturn(newGame);

        // Appelle la méthode de service
        Game createdGame = gameService.createGame("New Game", new String[]{"new_image.jpg"});

        // Vérifie que le jeu créé correspond à celui du mock
        assertEquals(newGame, createdGame);
    }

    @Test
    public void testUpdateGame() {
        // Crée un jeu de test existant
        Game existingGame = new Game(1, "Game 1", new String[]{"image1.jpg", "image2.jpg"});

        // Configure le comportement du GameRepository mock
        when(gameRepository.getGameById(1)).thenReturn(existingGame);

        // Met à jour le jeu existant
        gameService.updateGame(1, "Updated Game", new String[]{"updated_image.jpg"});

        // Vérifie que le jeu a été mis à jour correctement
        assertEquals("Updated Game", existingGame.getName());
        assertArrayEquals(new String[]{"updated_image.jpg"}, existingGame.getImages());
        verify(gameRepository).updateGame(existingGame);
    }

    @Test
    public void testDeleteGame() {
        // Supprime un jeu avec l'ID 1
        gameService.deleteGame(1);

        // Vérifie que la méthode GameRepository.deleteGame a été appelée avec l'ID 1
        verify(gameRepository).deleteGame(1);
    }
}
