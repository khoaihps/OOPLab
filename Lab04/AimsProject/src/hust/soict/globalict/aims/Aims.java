package hust.soict.globalict.aims;

import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.store.Store;

public class Aims {
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void filterCartMenu() {
        System.out.println("Filter Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter by ID");
        System.out.println("2. Filter by Title");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartSortingMenu() {
        System.out.println("Sort options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Sort media in cart by title");
        System.out.println("2. Sort media in cart by cost");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }
    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void addMediaMenu() {
        System.out.println("Type of media you want to add: ");
        System.out.println("--------------------------------");
        System.out.println("1. CD");
        System.out.println("2. DVD");
        System.out.println("3. Book");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void updateStoreMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add a media to the store");
        System.out.println("2. Remove a media from the store");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }
    
    public static Store loadStore()  {
        Store store = new Store(200);
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

        store.addMedia(cd);
        store.addMedia(dvd);
        store.addMedia(book);

        return store;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart();
        Store store = loadStore();

        int mainChoice = 1;
        while (mainChoice != 0)
        {
            showMenu();
            mainChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (mainChoice) {
                case 1: // View store
                    int storeChoice;
                    do {
                        storeMenu();
                        storeChoice = scanner.nextInt();
                        scanner.nextLine(); 

                        switch (storeChoice) {
                            case 1: // See a media's details
                                System.out.println("Enter the title of the media:");
                                String title = scanner.nextLine();
                                Media mediaToDisplay = store.getMediaByTitle(title);
                                if (mediaToDisplay == null) {
                                    System.out.println("The media has not been found.");
                                    break;
                                }
                                store.displayMediaDetails(mediaToDisplay);
                                int mediaDetailsChoice;
                                do {
                                    mediaDetailsMenu();
                                    mediaDetailsChoice = scanner.nextInt();
                                    scanner.nextLine(); 

                                    switch (mediaDetailsChoice) {
                                        case 1: // Add to cart
                                            cart.addMedia(store.getMediaByTitle(title));
                                            break;
                                        case 2: // Play
                                            store.playMedia(title);
                                            break;
                                        case 0: // Back
                                            break;
                                        default:
                                            System.out.println("Invalid choice. Please try again.");
                                            break;
                                    }
                                } while (mediaDetailsChoice != 0);
                                break;
                            case 2: // Add a media to cart
                                System.out.println("Enter the title of the media:");
                                String mediaTitle = scanner.nextLine();
                                Media mediaToAdd = store.getMediaByTitle(mediaTitle);
                                if (mediaToAdd != null) {
                                    cart.addMedia(mediaToAdd);
                                } else System.out.println("The media has not been found.");
                                break;
                            case 3: // Play a media
                                System.out.println("Enter the title of the media:");
                                String mediaToPlay = scanner.nextLine();
                                store.playMedia(mediaToPlay);
                                break;
                            case 4: // See current cart
                                System.out.println("Current cart contents:");
                                cart.showCart();
                                break;
                            case 0: // Back
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                                break;
                        }
                    } while (storeChoice != 0);
                    break;
                case 2: // Update store
                    int updateStoreChoice;
                    do {
                        updateStoreMenu();
                        updateStoreChoice = scanner.nextInt();
                        scanner.nextLine(); 

                        switch (updateStoreChoice) {
                            case 1: // Add a media to the store
                                System.out.println("Enter the media id:");
                                int mediaId = scanner.nextInt();
                                scanner.nextLine(); 
                                System.out.println("Enter the media title:");
                                String mediaTitle = scanner.nextLine();
                                System.out.println("Enter the media category:");
                                String mediaCategory = scanner.nextLine();
                                System.out.println("Enter the media cost:");
                                float mediaCost = scanner.nextFloat();
                                scanner.nextLine(); 
                                int mediaType;
                                Media newMedia = null;
                                do {
                                    addMediaMenu();
                                    mediaType = scanner.nextInt();
                                    scanner.nextLine();
                                    switch (mediaType) {
                                        case 1:
                                            newMedia = new CompactDisc(mediaId, mediaTitle, mediaCategory, mediaCost);
                                            break;
                                        case 2:
                                            newMedia = new DigitalVideoDisc(mediaId, mediaTitle, mediaCategory, mediaCost);
                                            break;
                                        case 3:
                                            newMedia = new Book(mediaId, mediaTitle, mediaCategory, mediaCost);
                                            break;
                                        default:
                                            break;
                                    }
                                } while (mediaType < 1 || mediaType >3);
                                if (newMedia!= null) {
                                    store.addMedia(newMedia);
                                    System.out.println("The media has been added to the store.");
                                }
                                break;
                            case 2: // Remove a media from the store
                                System.out.println("Enter the media title to remove:");
                                String title = scanner.nextLine();
                                Media mediaToRemove = store.getMediaByTitle(title);
                                store.removeMedia(mediaToRemove);
                                break;
                            case 0: // Back
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                                break;
                        }
                    } while (updateStoreChoice != 0);
                    break;
                case 3: // See current cart
                    int cartChoice;
                    do {
                        cart.showCart();
                        cartMenu();
                        cartChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        switch (cartChoice) {
                            case 1: // Filter medias in cart
                                filterCartMenu();
                                int filterChoice = scanner.nextInt();
                                scanner.nextLine();
                                if (filterChoice == 1) {
                                    System.out.println("Input id to filter: ");
                                    int id = scanner.nextInt();
                                    cart.filterMediaById(id);
                                } else if (filterChoice == 2) {
                                    System.out.println("Input title to filter: ");
                                    String title = scanner.nextLine();
                                    cart.filterMediaByTitle(title);
                                } else {
                                    System.out.println("Invalid choice. Please try again.");
                                }
                                break;
                            case 2: // Sort medias in cart
                                int cartSoringChoice;
                                do {
                                    cartSortingMenu();
                                    cartSoringChoice = scanner.nextInt();
                                    scanner.nextLine();
                                    switch (cartSoringChoice) {
                                        case 1:
                                            cart.sortByTitleCost();
                                            break;
                                        case 2:
                                            cart.sortByCostTitle();
                                            break;
                                        default:
                                            break;
                                    }
                                } while (cartSoringChoice < 1 || cartSoringChoice > 2);
                                break;
                            case 3: // Remove media from cart
                                System.out.println("Enter the title of the media to remove:");
                                String mediaToRemove = scanner.nextLine();
                                cart.removeMedia(cart.getMediaByTitle(mediaToRemove));
                                System.out.println("The media has been removed from the cart.");
                                break;
                            case 4: // Play a media
                                System.out.println("Enter the title of the media to play:");
                                String mediaToPlay = scanner.nextLine();
                                cart.getMediaByTitle(mediaToPlay).play();
                                break;
                            case 5: // Place order
                                // Implement the functionality to place an order
                                System.out.println("Order placed. Thank you!");
                                cart = new Cart();
                                break;
                            case 0: // Back
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                                break;
                        }
                    } while (cartChoice != 0);
                    break;
                case 0: // Exit
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } 

        scanner.close();
    }
}
