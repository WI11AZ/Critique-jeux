package be.heh.application.port.out;

import be.heh.application.domain.model.Comment;

import java.util.List;

public interface CommentOut {
    Comment getComment(String comment);

    List<Comment> getCommentAuthor(String auteur);
}
