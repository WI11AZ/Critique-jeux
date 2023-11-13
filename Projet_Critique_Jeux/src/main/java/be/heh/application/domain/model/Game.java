package be.heh.application.domain.model;

public class Game {
    private int id;
    private String name;
    private String[] images;

    public Game(int id, String name, String[] images) {
        this.id = id;
        this.name = name;
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

}
