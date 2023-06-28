package hust.soict.globalict.aims.media;

import javax.naming.LimitExceededException;

public class Disc extends Media {
    private int length;
    private String director;

    public Disc(int id, String title, String category, float cost) throws LimitExceededException {
        super(id, title, category, cost);
    }

    public Disc(String title, String category, float cost, int length, String director) throws LimitExceededException {
        super(title, category, cost);
        this.length = length;
        this.director = director;
    }

    public Disc(int id, String title, String category, float cost, int length, String director) throws LimitExceededException {
        super(id, title, category, cost);
        this.length = length;
        this.director = director;
    }

    public int getLength() {
        return length;
    }
    public String getDirector() {
        return director;
    }
}
