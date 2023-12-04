package be.heh.adapter;

import be.heh.adapter.in.web.AdaptateurGameControlleur;
import be.heh.application.domain.model.Game;
import be.heh.application.domain.service.GameService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class AdaptateurGameControlleurTest {
    @Test
    public void testGetGameById() throws Exception {
        int gameId = 1;
        Game gameTest = new Game(gameId, "maxime", new String[]{"test"});

        // userServiceMock
        GameService gameServiceTest = Mockito.mock(GameService.class);
        Mockito.when(gameServiceTest.getGameById(Mockito.anyInt())).thenReturn(gameTest);

        AdaptateurGameControlleur gameController = new AdaptateurGameControlleur(gameServiceTest);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(gameController).build();

        mockMvc.perform(get("/game/{gameId}", gameId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.id").value(gameId))
                .andExpect(jsonPath("$.name").value("maxime"))
                .andExpect(jsonPath("$.images").isArray());
    }
}
