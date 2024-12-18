package hust.soict.cybersec.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    public int compare(Media m1, Media m2) {
        boolean compareCost = m1.getCost() < m2.getCost();
        if (compareCost) {
            return 1;
        } else {
            if (m1.getCost() == m2.getCost()) {
                int compareTitle = m1.getTitle().compareTo(m2.getTitle());
                if (compareTitle < 0) {
                    return 1;
                } else {return -1;}
            } else {
                return - 1;
            }
        }
    }
}