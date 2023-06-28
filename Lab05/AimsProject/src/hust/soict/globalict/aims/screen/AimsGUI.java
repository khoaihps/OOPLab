package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.store.Store;

public class AimsGUI {
    public static void main(String[] args) {
        Store store = initStore();
        Cart cart = new Cart();

        new StoreScreen(store, cart);
    }

    private static Store initStore() {
        return null;
    }
}
