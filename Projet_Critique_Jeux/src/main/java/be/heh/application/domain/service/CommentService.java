package be.heh.application.domain.service;

import be.heh.application.domain.model.Comment;
import be.heh.application.domain.model.User;
import be.heh.application.port.out.CommentRepository;


import java.util.List;

public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment createComment(int gameId, String content, User author, int rating) {
        Comment newComment = new Comment(0, gameId, content, rating, author);
        return commentRepository.createComment(newComment);
    }

    public Comment getCommentById(int commentId) {
        return commentRepository.getCommentById(commentId);
    }

    public List<Comment> getCommentsForGame(int gameId) {
        return commentRepository.getCommentsForGame(gameId);
    }

    public void deleteComment(int commentId) {
        commentRepository.deleteComment(commentId);
    }
}
