package be.heh.port.in;

import be.heh.application.domain.model.Comment;
import be.heh.application.domain.model.Game;
import be.heh.application.domain.model.User;
import be.heh.port.out.CommentPersistance;

import java.util.List;

public interface CommentUseCase {
    Comment createComment(Comment comment);
    boolean deleteComment(int commentId);

    Comment getGameByIdGame(int gameId);
}
