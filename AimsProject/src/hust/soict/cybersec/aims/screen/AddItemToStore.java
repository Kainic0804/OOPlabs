package hust.soict.cybersec.aims.screen;

import javax.swing.JFrame;

import hust.soict.cybersec.aims.store.Store;
import hust.soict.cybersec.aims.media.Media;

public class AddItemToStore extends JFrame {
    protected Store store;
    protected String type;

    public AddItemToStore (Store store, String mediaType) {
        super();
        this.store = store;
        this.type = mediaType;
    }

    public void setType(String newType) {
        this.type = newType;
    }

    public Store getUpdatedStore(Media media) {
        this.store.addMedia(media);
        return store;
    }

}