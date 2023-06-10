package hust.soict.globalict.aims.store;

import java.util.ArrayList;

import hust.soict.globalict.aims.media.*;

public class Store {
    public static final int MAX_ITEMS_IN_STORE = 20;
    private ArrayList<Media> itemsInStore;

    public Store(int capacity) {
        itemsInStore = new ArrayList<>(capacity);
    }

    public void playMedia(String title) {
        Media media = getMediaByTitle(title);
        if (media != null && media instanceof Playable) {
            Playable playableMedia = (Playable) media;
            playableMedia.play();
        } else {
            System.out.println("Media not found or not playable.");
        }
    }

    public Media getMediaByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public void displayMediaDetails(Media media) {
        if (media != null) {
            System.out.println("ID: " + media.getId());
            System.out.println("Title: " + media.getTitle());
            System.out.println("Category: " + media.getCategory());
            System.out.println("Cost: " + media.getCost());
        } else {
            System.out.println("Media not found.");
        }
    }

    public void addMedia(Media media) {
        if (itemsInStore.size() < MAX_ITEMS_IN_STORE) {
            itemsInStore.add(media);
            System.out.println("Media \"" + media.getTitle() + "\" has been added to the store.");
        } else {
            System.out.println("The store is full. Cannot add media.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("Media \"" + media.getTitle() + "\" has been removed from the store.");
        } else {
            System.out.println("Media \"" + media.getTitle() + "\" was not found in the store.");
        }
    }

}
