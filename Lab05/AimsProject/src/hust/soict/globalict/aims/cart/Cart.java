package hust.soict.globalict.aims.cart;

import java.util.ArrayList;

import javax.naming.LimitExceededException;

import hust.soict.globalict.aims.media.*;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void setItemsOrdered(ArrayList<Media> itemsOrdered) {
        this.itemsOrdered = itemsOrdered;
    }

    public Cart()
    {
        itemsOrdered = new ArrayList<>(MAX_NUMBERS_ORDERED);
    }

    public Media getMediaByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public void addMedia(Media media) throws LimitExceededException {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
            System.out.println("The media has been added to cart.");
        } else {
            throw new LimitExceededException("ERROR : The number of media has reached its limit");
            // System.out.println("The cart is almost full");
        }
    }

    public void removeMedia(Media media) {
        boolean removed = itemsOrdered.remove(media);
        if (removed) {
            System.out.println("The media has been removed from cart.");
        } else {
            System.out.println("The media was not found");
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }
    
    public void showCart() {
        System.out.println("***********************CART************************");
        System.out.println("Ordered Items:");
        int count = 1;
        for (Media media : itemsOrdered) {
            System.out.println(count + ". " + media.toString());
            count++;
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }

    public void searchByID(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                found = true;
                System.out.println("Media found:");
                System.out.println(media.toString());
                break;
            }
        }
        if (!found) {
            System.out.println("Media with ID " + id + " was not found.");
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                found = true;
                System.out.println("Media found:");
                System.out.println(media.toString());
            }
        }
        if (!found) {
            System.out.println("No media matching the title \"" + title + "\" were found.");
        }
    }
    public void filterMediaById(int mediaId) {
        ArrayList<Media> filteredMedia = new ArrayList<>();

        for (Media media : itemsOrdered) {
            if (media.getId() == mediaId) {
                filteredMedia.add(media);
            }
        }

        if (!filteredMedia.isEmpty()) {
            System.out.println("Filtered media with ID " + mediaId + ":");
            for (Media media : filteredMedia) {
                System.out.println(media.toString());
            }
        } else {
            System.out.println("No media with ID " + mediaId + " found in the cart.");
        }
    }

    public void filterMediaByTitle(String mediaTitle) {
        ArrayList<Media> filteredMedia = new ArrayList<>();

        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(mediaTitle)) {
                filteredMedia.add(media);
            }
        }

        if (!filteredMedia.isEmpty()) {
            System.out.println("Filtered media with title \"" + mediaTitle + "\":");
            for (Media media : filteredMedia) {
                System.out.println(media.toString());
            }
        } else {
            System.out.println("No media with title \"" + mediaTitle + "\" found in the cart.");
        }
    }

    public void sortByTitleCost() {
        this.itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCostTitle() {
        this.itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
    }

    public void clear()
    {
        this.itemsOrdered = new ArrayList<Media>();
    }
}
