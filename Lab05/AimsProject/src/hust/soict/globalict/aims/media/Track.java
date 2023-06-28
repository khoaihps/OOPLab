package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

public class Track implements Playable {
    private String title;
    private int length;
    
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    
    public String getTitle() {
        return title;
    }
    
    public int getLength() {
        return length;
    }  
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Track other = (Track) obj;
        return title.equals(other.title) && length == other.length;
    }

    public void play() throws PlayerException {
        if (this.getLength() > 0) { 
            System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
        } else { 
            throw new PlayerException("ERROR: Track length is non-positive!");
        }
    }

}
