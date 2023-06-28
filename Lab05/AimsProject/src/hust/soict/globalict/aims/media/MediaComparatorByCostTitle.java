package hust.soict.globalict.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media media1, Media media2) {
        int costComparison = Float.compare(media2.getCost(), media1.getCost()); // Higher cost first
        if (costComparison != 0) {
            return costComparison;
        } else {
            return media1.getTitle().compareTo(media2.getTitle());
        }
    }
}
