package hust.soict.cybersec.aims.cart;

import hust.soict.cybersec.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_ORDERED = 20;
    private int qtyOrdered = 0;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_ORDERED];

    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if (qtyOrdered == MAX_ORDERED) {
            System.out.println("Reach maximum order quantity ");
        }
        else {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered ++;
            System.out.println("Added");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            if (qtyOrdered == MAX_ORDERED) {
                System.out.println("Full, cannot add more");
                return;
            }
            else {
                itemsOrdered[qtyOrdered] = disc;
                qtyOrdered ++;
                System.out.println("Added" + disc.getTitle());
            }
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
        DigitalVideoDisc[] dvd = {dvd1, dvd2};
        for (DigitalVideoDisc disc : dvd) {;
            if (qtyOrdered == MAX_ORDERED) {
                System.out.println("Full");
                return;
            }
            else {
                itemsOrdered[qtyOrdered] = disc;
                qtyOrdered += 1;
                System.out.println("Add" + disc.getTitle());
            }
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        for(int i = 0; i < qtyOrdered; i++){
            if (itemsOrdered[i] == disc){
                for (int j = i + 1; j < qtyOrdered - 1; j++){
                    itemsOrdered[j] = itemsOrdered[j+1];
                }
                itemsOrdered[qtyOrdered-1] = null;
                qtyOrdered--;
                System.out.println("Removed");
                return;
            }
        }
        System.out.println("Cannot find the disc");
    }

    public float totalCost(){
        float totalCost = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            totalCost += itemsOrdered[i].getCost();
        }
        return totalCost;
    }

    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Item:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i+1) + itemsOrdered[i].toString());
        }
        System.out.println("Total Cost: $" + totalCost());
        System.out.println("**************************************************");

    }

    public void searchById(int id) {
       boolean found = false;
       for (int i = 0; i < qtyOrdered; i++) {
           if (itemsOrdered[i].getId() == id) {
               found = true;
               System.out.println("DVD found");
               System.out.println(itemsOrdered[i].toString());
               break;
           }
       }
       if (found == false) {
           System.out.println("DVD not found");
       }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getTitle().equals(title)) {
                found = true;
                System.out.println("DVD found");
                System.out.println(itemsOrdered[i].toString());
                break;
            }
        }
        if (found == false) {
            System.out.println("DVD not found");
        }
    }
}

