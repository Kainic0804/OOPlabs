package hust.soict.cybersec.aims.cart;

import java.util.ArrayList;
import java.util.Collections;
import hust.soict.cybersec.aims.media.Media;

public class Cart {
    public static final int MAX_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (itemsOrdered.size() == MAX_ORDERED) {
            System.out.println("Cannot add more media to the cart");
        }
        else if (itemsOrdered.contains(media)) {
            System.out.println("Media already added to the cart");
        }
        else {
            itemsOrdered.add(media);
            System.out.println("Added media to the cart");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Removed media from the cart");
        }
        else {
            System.out.println("Media not exist in the cart");
        }
    }

    public float totalCost(){
        float totalCost = 0;
        for (Media media : itemsOrdered) {
            totalCost += media.getCost();
        }
        return totalCost;
    }

    public void searchById(int id) {
       boolean found = false;
       for (int i = 0; i < itemsOrdered.size(); i++) {
           if (itemsOrdered.get(i).getId() == id) {
               found = true;
               System.out.println("Media found");
               System.out.println(itemsOrdered.get(i).toString());
               break;
           }
       }
       if (found == false) {
           System.out.println("Media not found");
       }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).getTitle().equals(title)) {
                found = true;
                System.out.println("Media found");
                System.out.println(itemsOrdered.get(i).toString());
                break;
            }
        }
        if (found == false) {
            System.out.println("Media not found");
        }
    }

    public void printOrders() {
        for (Media item : itemsOrdered) {
            System.out.println(item.toString());
        }
    }

    public ArrayList<Media> getItemsInCart(){
        return itemsOrdered;
    }
}


