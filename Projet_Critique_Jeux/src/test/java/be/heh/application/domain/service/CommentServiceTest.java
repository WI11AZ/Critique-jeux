package be.heh.application.domain.service;

import be.heh.application.domain.model.Comment;
import be.heh.application.domain.model.Game;
import be.heh.application.domain.model.User;
import be.heh.application.port.out.CommentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;



public class CommentServiceTest {
    private CommentService commentService;

    @Mock
    private CommentRepository commentRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        commentService = new CommentService(commentRepository);
    }

    @Test
    public void testCreateComment() {
        // Crée un commentaire de test
        User author = new User(1, "testuser", "test@test.com", "password");
        Game game = new Game(1, "Test Game", new String[] {"image1.jpg", "image2.jpg"});
        Comment comment = new Comment(1, game.getId(), "Test comment", 5, author);

        // Configure le comportement du CommentRepository mock
        when(commentRepository.createComment(any(Comment.class))).thenReturn(comment);

        // Appelle la méthode de service
        Comment createdComment = commentService.createComment(game.getId(), "Test comment", author, 5);

        // Vérifie que la méthode CommentRepository.createComment a été appelée avec les bons paramètres
        verify(commentRepository).createComment(comment);

        // Verifier que le commentaire créé correspond à celui retourné par le mock
        assertEquals(comment, createdComment);
    }


}
