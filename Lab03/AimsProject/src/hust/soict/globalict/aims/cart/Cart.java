package hust.soict.globalict.aims.cart;

import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered<MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");

        }
        else System.out.println("The cart is almost full");
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
        for (int i = 0; i < dvdList.length; i++) {
            addDigitalVideoDisc(dvdList[i]);
        }
    }
    
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i <= qtyOrdered-1; i++) {
            if (itemsOrdered[i] == disc) {
                found = true;
                for (int j = i; j <= qtyOrdered-2; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered-1] = null;
                qtyOrdered--;
                System.out.println("The disc has been removed.");
                break;
            }
        }
        if (!found) {
            System.out.println("The disc was not found.");
        }
    }
    
    public float totalCost() {
        float total = 0;
        for (int i = 0; i <= qtyOrdered-1; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            DigitalVideoDisc dvd = itemsOrdered[i];
            System.out.println((i + 1) + ". DVD - " + dvd.toString());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }

    public void searchByID(int id) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                found = true;
                System.out.println("DVD found:");
                System.out.println(itemsOrdered[i].toString());
                break;
            }
        }
        if (!found) {
            System.out.println("DVD with ID " + id + " was not found.");
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(title)) {
                found = true;
                System.out.println("DVD found:");
                System.out.println(itemsOrdered[i].toString());
            }
        }
        if (!found) {
            System.out.println("No DVDs matching the title \"" + title + "\" were found.");
        }
    }
}
