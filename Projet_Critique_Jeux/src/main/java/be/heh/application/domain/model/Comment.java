package be.heh.application.domain.model;
import java.util.Objects;

public class Comment {
    private int id;
    private int gameId;
    private String content;
    private int rating;
    private User author;

    public Comment(int id, int gameId, String content, int rating, User author) {
        this.id = id;
        this.gameId = gameId;
        this.content = content;
        this.rating = rating;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public int getGameId() {
        return gameId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return gameId == comment.gameId &&
                rating == comment.rating &&
                Objects.equals(content, comment.content) &&
                Objects.equals(author, comment.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, content, rating, author);
    }
}
