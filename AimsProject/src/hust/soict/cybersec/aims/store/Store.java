package hust.soict.cybersec.aims.store;
import hust.soict.cybersec.aims.media.*;
import java.util.*;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public boolean addMedia(Media m){
        if (!(itemsInStore.contains(m))) {
            itemsInStore.add(m);
            return true;
        } else{
            return false;
        }
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public boolean removeMedia(Media m) {
        if (itemsInStore.contains(m)) {
            itemsInStore.remove(m);
            return true;
        } else {
            return false;
        }
    }

    public int searchMedia(String title) {
        for (Media m: itemsInStore) {
            if (m.getTitle().equals(title)){
                return m.getId();
            }
        } return -1;
    }

    public Media detailsId(int id){
        for (Media m: itemsInStore) {
            if (m.getId() == id) {
                return m;
            }
        } return null;
    }

    public Store(){
        super();
    }

}