package hust.soict.globalict.test.cart;

import java.util.ArrayList;

import javax.naming.LimitExceededException;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.*;

public class CartTest {
    public static void main(String[] args) throws LimitExceededException {
        Cart cart = new Cart();

        ArrayList<Track> playlist = new ArrayList<>();
        Track track1 = new Track("Track1", 60);
        Track track2 = new Track("Track2", 120);
        playlist.add(track1);
        playlist.add(track2);
        CompactDisc cd = new CompactDisc(1, "Album", "Pop", 12.99f, "Director", 60,  "JB", playlist);
        
        DigitalVideoDisc dvd = new DigitalVideoDisc("Movie", "Category", "Director", 120, 9.99f);
        
        ArrayList<String> authors = new ArrayList<>();
        authors.add("Author 1");
        authors.add("Author 2");
        Book book = new Book(3, "Book 1", "Fiction", 5.99f, authors);


        cart.addMedia(cd);
        cart.addMedia(dvd);
        cart.addMedia(book);

        cart.sortByTitleCost();
        cart.showCart();

        cart.sortByCostTitle();
        cart.showCart();

        // Iterate through the list and print out the information using toString()
        // for (Media item : cart) {
        //     System.out.println(item.toString());
        // }
        
    }
    
}
