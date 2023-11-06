package be.heh.application.domain.service;

import be.heh.application.domain.service.ManagementGameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import be.heh.application.domain.model.Game;
import be.heh.application.port.out.GameRepository;
import static org.mockito.Mockito.*;

public class ManagementGameServiceTest {

    @Mock
    private GameRepository gameRepository;

    private ManagementGameService managementGameService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        managementGameService = new ManagementGameService(gameRepository);
    }

    @Test
    public void testCreateGame() {
        // Crée un objet de test Game
        Game game = new Game();
        game.setTitle("Test Game");


        doNothing().when(gameRepository).save(game);


        managementGameService.CreateGame(game);


        verify(gameRepository, times(1)).save(game);
    }
    @Test
    public void testUpdateGame() {
        // Créez un objet de test Game
        Game game = new Game();
        game.setId("z");
        game.setTitle("Updated Game");

        // Définissez le comportement attendu pour le repository (simulez la mise à jour)
        doNothing().when(gameRepository).update(game);

        // Appelez la méthode de service pour mettre à jour le jeu
        managementGameService.UpdateGame(game);

        // Vérifiez que la méthode update du repository a été appelée avec le jeu mis à jour en argument
        verify(gameRepository, times(1)).update(game);
    }
    @Test
    public void testDeleteGame() {
        // ID du jeu à supprimer
        long gameId = 123;

        // Définissez le comportement attendu pour le repository (simulez la suppression)
        doNothing().when(gameRepository).deleteById(gameId);

        // Appelez la méthode de service pour supprimer le jeu
        managementGameService.DeleteGame(gameId);

        // Vérifiez que la méthode deleteById du repository a été appelée avec l'ID du jeu en argument
        verify(gameRepository, times(1)).deleteById(gameId);
    }
}