package be.heh.application.port.in;

import be.heh.application.domain.model.Comment;
import be.heh.application.domain.model.User;

import java.util.List;

public interface UseCaseInComment {
    Comment createComment(int gameId, String content, User author, int rating);
    Comment getCommentById(int commentId);
    List<Comment> getCommentsForGame(int gameId);
    void deleteComment(int commentId);
}
