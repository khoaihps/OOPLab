package hust.soict.globalict.aims.store;

import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class Store {
    private DigitalVideoDisc itemsInStore[];

    public Store(int capacity) {
        itemsInStore = new DigitalVideoDisc[capacity];
    }

    public void addDVD(DigitalVideoDisc dvd) {
        for (int i = 0; i < itemsInStore.length; i++) {
            if (itemsInStore[i] == null) {
                itemsInStore[i] = dvd;
                System.out.println("DVD \"" + dvd.getTitle() + "\" has been added to the store.");
                return;
            }
        }
        System.out.println("The store is full. Cannot add DVD.");
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        for (int i = 0; i < itemsInStore.length; i++) {
            if (itemsInStore[i] == dvd) {
                itemsInStore[i] = null;
                System.out.println("DVD \"" + dvd.getTitle() + "\" has been removed from the store.");
                return;
            }
        }
        System.out.println("DVD \"" + dvd.getTitle() + "\" was not found in the store.");
    }
}
