package hust.soict.cybersec.aims.store;

import java.util.ArrayList;
import hust.soict.cybersec.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (itemsInStore.contains(media)) {
            System.out.println("Media already added to the store");
        }
        else {
            itemsInStore.add(media);
            System.out.println("Added media to the store");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Removed media from the store");
        }
        else {
            System.out.println("Media does not exist in the store");
        }
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}
