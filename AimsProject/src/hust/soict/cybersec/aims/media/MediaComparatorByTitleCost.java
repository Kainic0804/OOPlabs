package hust.soict.cybersec.aims.media;
import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {

    @Override
    public int compare(Media m1, Media m2) {
        int compareTitle = m1.getTitle().compareTo(m2.getTitle());
        if (compareTitle < 0){
            return 1;
        } else {
            if (compareTitle == 0){
                boolean compareCost = m1.getCost() < m2.getCost();
                if (compareCost) return 1;
                else {return -1;}
            } return -1;
        }
    }
}