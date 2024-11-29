package hust.soict.cybersec.aims.store;

import hust.soict.cybersec.aims.media.DigitalVideoDisc;

public class Store {
    private DigitalVideoDisc[] itemInStore;
    private int itemCount;

    public Store() {
        itemInStore = new DigitalVideoDisc[1000];
        itemCount = 0;
    }

    public void addDVD(DigitalVideoDisc dvd) {
        if (itemCount < itemInStore.length) {
            itemInStore[itemCount] = dvd;
            itemCount++;
            System.out.println(dvd + " added to the store");
        }
        else {
            System.out.println("The storage is full");
        }
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        for (int i = 0; i < itemCount; i++) {
            if (itemInStore[i] == dvd) {
                for (int j = i + 1; j < itemCount - 1; j++) {
                    itemInStore[j] = itemInStore[j + 1];
                }
                itemInStore[itemCount - 1] = null;
                itemCount--;
                System.out.println(dvd + " removed from the store");
                return;
            }

        }
        System.out.println("Cannot find the item");
    }
}
