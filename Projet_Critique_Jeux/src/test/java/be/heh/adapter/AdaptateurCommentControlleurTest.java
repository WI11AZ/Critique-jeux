package be.heh.adapter;

import be.heh.adapter.in.web.AdaptateurCommentControlleur;
import be.heh.adapter.in.web.AdaptateurGameControlleur;
import be.heh.application.domain.model.Comment;
import be.heh.application.domain.model.Game;
import be.heh.application.domain.model.User;
import be.heh.application.domain.service.CommentService;
import be.heh.application.domain.service.GameService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
public class AdaptateurCommentControlleurTest {
    @Test
    public void testGetGameById() throws Exception {
        int commentId = 1;
        Game gameTest = new Game(1, "pokemon", "test", "description");
        User userTest = new User(1, "max","Test123*");
        Comment commentTest = new Comment(commentId, gameTest.getId(), "jolie", 3, userTest);
        System.out.println(commentTest.getAuthor());


        CommentService commentServiceTest = Mockito.mock(CommentService.class);
        Mockito.when(commentServiceTest.getCommentById(Mockito.anyInt())).thenReturn(commentTest);

        AdaptateurCommentControlleur commentControlleur = new AdaptateurCommentControlleur(commentServiceTest);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(commentControlleur).build();

        mockMvc.perform(get("/comment/{commentId}", commentId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.id").value(commentId))
                .andExpect(jsonPath("$.gameId").value(1))
                .andExpect(jsonPath("$.content").value("jolie"))
                .andExpect(jsonPath("$.rating").value(3))
                .andExpect(jsonPath("$.author.username").value("max"));

    }
}


