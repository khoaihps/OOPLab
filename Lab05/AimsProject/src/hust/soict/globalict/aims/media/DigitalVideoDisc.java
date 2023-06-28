package hust.soict.globalict.aims.media;

import javax.naming.LimitExceededException;

import hust.soict.globalict.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;
    private String director;
    private int length;
    
    public String getDirector() {
        return director;
    }
    public int getLength() {
        return length;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public void setLength(int length) {
        this.length = length;
    }

    public DigitalVideoDisc(int id, String title, String category, float cost) throws LimitExceededException {
        super(id, title, category, cost);
    }
    public DigitalVideoDisc(String title) throws LimitExceededException {
        super(++nbDigitalVideoDiscs, title, "", 0.0f);
    }
    
    public DigitalVideoDisc(String title, String category, float cost) throws LimitExceededException {
        super(++nbDigitalVideoDiscs, title, category, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) throws LimitExceededException {
        super(++nbDigitalVideoDiscs, title, category, cost);
        this.director = director;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) throws LimitExceededException {
        super(++nbDigitalVideoDiscs, title, category, cost);
        this.director = director;
        this.length = length;
    }

    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }
    
    public boolean isMatch(String title) {
        return getTitle().equalsIgnoreCase(title);
    }
    
    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) { 
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else { 
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }

    @Override
    public String toString() {
        return "DVD " + getId() + " - " + getTitle() + " - " + getCategory() + " - " + getCost() + " - " + director + " - " + length;
    }
}
