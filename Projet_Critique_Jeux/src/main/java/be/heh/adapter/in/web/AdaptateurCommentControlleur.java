package be.heh.adapter.in.web;

import be.heh.application.domain.model.Comment;
import be.heh.application.domain.model.Game;
import be.heh.application.domain.service.CommentService;
import be.heh.application.domain.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdaptateurCommentControlleur {
    private final CommentService commentService;

    public AdaptateurCommentControlleur(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/comment/{commentId}")
    public ResponseEntity<Comment> getCommentById(@PathVariable int commentId) {
        Comment comment = commentService.getCommentById(commentId);

        if (comment != null) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(comment);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }
}
