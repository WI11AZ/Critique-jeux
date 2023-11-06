package be.heh.application.domain.service;

import be.heh.application.domain.model.Comment;
import be.heh.application.port.in.ManagementComment;
import be.heh.application.port.out.CommentOut;

import java.util.List;

public class CommentService {
    private ManagementComment managementComment;
    private CommentOut commentOut;

    public CommentService(ManagementComment managementComment, CommentOut commentOut) {
        this.managementComment = managementComment;
        this.commentOut = commentOut;
    }

    public void addComment(Comment comment) {
        managementComment.addComment(comment);
    }

    public Comment getComment(String commentId) {
        return commentOut.getComment(commentId);
    }

    public List<Comment> getCommentsByAuthor(String author) {
        return commentOut.getCommentAuthor(author);
    }
}
