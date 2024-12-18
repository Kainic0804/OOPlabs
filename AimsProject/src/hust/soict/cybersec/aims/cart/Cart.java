package hust.soict.cybersec.aims.cart;
import hust.soict.cybersec.aims.media.*;
import java.util.*;

import javax.naming.LimitExceededException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public void addMedia(Media m) throws LimitExceededException {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(m);

        } else {
            throw new LimitExceededException("ERROR");
        }
    }

    public boolean removeMedia (Media m) {
        if (itemsOrdered.contains(m) && itemsOrdered.size() > 0) {
            itemsOrdered.remove(m);
            return true;
        } return false;
    }

    public void sortCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }

    public void sortTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public float totalCost() {
        float total_cost = (float) 0;
        for (Media item: itemsOrdered){
            total_cost = total_cost + item.getCost();
        } return total_cost;
    }

    public Media searchID(int id){
        for (Media item: itemsOrdered) {
            if (item.getId()== id) {
                return item;
            }
        } return null;
    }

    public Media searchTitle(String title) {
        for (Media item: itemsOrdered) {
            if (item.getTitle().equals(title)) {
                return item;
            }
        } return null;
    }

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void print() {
        System.out.println("********"  + "CART" + "*********");

        List<Integer> ids = new ArrayList<Integer>();
        for (Media m: itemsOrdered) {
            ids.add(m.getId());
        }
        Collections.sort(ids);

        for (Integer id: ids) {
            System.out.println(searchID(id));
        }
    }
}