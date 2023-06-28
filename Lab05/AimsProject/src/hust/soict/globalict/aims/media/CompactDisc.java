package hust.soict.globalict.aims.media;

import java.util.ArrayList;

import javax.naming.LimitExceededException;

import hust.soict.globalict.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks;
    
    public CompactDisc(String title, String category, float cost, String director, int length, String artist, ArrayList<Track> tracks) throws LimitExceededException {
        super(title, category, cost, length, director);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(int id, String title, String category, float cost) throws LimitExceededException {
        super(id, title, category, cost);
    }

    public CompactDisc(int id, String title, String category, float cost, String director, int length, String artist, ArrayList<Track> tracks) throws LimitExceededException {
        super(id, title, category, cost, length, director);
        this.artist = artist;
        this.tracks = tracks;
    }
    
    public String getArtist() {
        return artist;
    }
    
    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("The track is already in the CD.");
        } else {
            tracks.add(track);
            System.out.println("The track was added successfully.");
        }
    }
    
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("The track was removed successfully.");
        } else {
            System.out.println("The track does not exist in the CD.");
        }
    }
    
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: CompactDisc length is non-positive!");
        }

        for (Track track : tracks) {
            try {
                track.play();
            } catch (PlayerException e) {
                System.err.println("ERROR: Failed to play track - " + e.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        return "CD " + getId() + " - " + getTitle() + " - " + getCategory() + " - " + getCost() + " - " + artist;
    }
}
