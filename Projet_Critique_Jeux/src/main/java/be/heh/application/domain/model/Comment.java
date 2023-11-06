package be.heh.application.domain.model;

public class Comment {
    public String id;
    public String author;
    public String comment;
    public Comment(String id, String author, String comment){
        this.id=id;
        this.author=author;
        this.comment=comment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
