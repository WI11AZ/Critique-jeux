package be.heh.application.port.out;

import be.heh.application.domain.model.Comment;

import java.util.List;

public interface CommentRepository {
    Comment createComment(Comment comment);
    Comment getCommentById(int commentId);
    List<Comment> getCommentsForGame(int gameId);
    void deleteComment(int commentId);
}
