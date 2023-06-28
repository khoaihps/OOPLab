package hust.soict.globalict.aims.media;

import java.util.Comparator;

import javax.naming.LimitExceededException;

import hust.soict.globalict.aims.exception.PlayerException;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;
    
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public Media(String title, String category, float cost) throws LimitExceededException {
        if (cost >= 0) {
            this.title = title;
            this.category = category;
            this.cost = cost;
        } else {
            throw new LimitExceededException("ERROR : The cost cannot be negative.");
        }
    }

    public Media(int id, String title, String category, float cost) throws LimitExceededException {
        if (cost >= 0) {
            this.id = id;
            this.title = title;
            this.category = category;
            this.cost = cost;
        } else {
            throw new LimitExceededException("ERROR : The cost cannot be negative.");
        }
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
    
    public boolean isMatch(String title) {
        return this.title.equalsIgnoreCase(title);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Media otherMedia = (Media) obj;
        return getTitle().equals(otherMedia.getTitle());
    }

    public void play() throws PlayerException {
        // Implementation of play functionality for media
        // You can customize this method based on the specific media type
        System.out.println("Playing media: " + title);
    }
    
    public String toString() {
        return this.id + " - " + this.title + " - " + this.category + " - " + this.cost;
    }
}
