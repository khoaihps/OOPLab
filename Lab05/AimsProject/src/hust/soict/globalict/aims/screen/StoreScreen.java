package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.store.Store;

import javax.naming.LimitExceededException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Track;

public class StoreScreen extends JFrame {
    private final Store store;
    private final Cart cart;
    private JPanel centerPanel;

    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;

        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        container.add(createNorthPanel(), BorderLayout.NORTH);
        centerPanel = createCenterPanel();
        container.add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }

    public static Store initStore() throws LimitExceededException  {
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

    public static void main(String[] args) throws LimitExceededException {
        Store store = initStore();
        Cart cart = new Cart();

        SwingUtilities.invokeLater(() -> {
            StoreScreen storeScreen = new StoreScreen(store, cart);
        });
    }

    JPanel createNorthPanel() {
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        northPanel.add(createMenuBar());
        northPanel.add(createHeader());

        return northPanel;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu updateStoreSubMenu = new JMenu("Update Store");

        JMenuItem addDVDMenuItem = new JMenuItem("Add DVD");
        addDVDMenuItem.addActionListener(e -> {
            AddDigitalVideoDiscToStoreScreen addDVDToStoreScreen = new AddDigitalVideoDiscToStoreScreen(store);
            addDVDToStoreScreen.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    SwingUtilities.invokeLater(() -> {
                        getContentPane().remove(centerPanel);
                        centerPanel = createCenterPanel();
                        getContentPane().add(centerPanel, BorderLayout.CENTER);
                        getContentPane().revalidate();
                        getContentPane().repaint();
                    });
                }
            });
        });
        updateStoreSubMenu.add(addDVDMenuItem);

        JMenuItem addCDMenuItem = new JMenuItem("Add CD");
        addCDMenuItem.addActionListener(e -> {
            AddCompactDiscToStoreScreen addCDToStoreScreen = new AddCompactDiscToStoreScreen(store);
            addCDToStoreScreen.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    SwingUtilities.invokeLater(() -> {
                        getContentPane().remove(centerPanel);
                        centerPanel = createCenterPanel();
                        getContentPane().add(centerPanel, BorderLayout.CENTER);
                        getContentPane().revalidate();
                        getContentPane().repaint();
                    });
                }
            });
        });
        updateStoreSubMenu.add(addCDMenuItem);

        JMenuItem addBookMenuItem = new JMenuItem("Add Book");
        addBookMenuItem.addActionListener(e -> {
            AddBookToStoreScreen addBookToStoreScreen = new AddBookToStoreScreen(store);
            addBookToStoreScreen.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    SwingUtilities.invokeLater(() -> {
                        getContentPane().remove(centerPanel);
                        centerPanel = createCenterPanel();
                        getContentPane().add(centerPanel, BorderLayout.CENTER);
                        getContentPane().revalidate();
                        getContentPane().repaint();
                    });
                }
            });
        });
        updateStoreSubMenu.add(addBookMenuItem);

        menu.add(updateStoreSubMenu);
        menu.add(new JMenuItem("View Store"));
        JMenuItem viewCartMenuItem = new JMenuItem("View Cart");
        viewCartMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CartScreen cartScreen = new CartScreen(cart, store);
            }
        });
        menu.add(viewCartMenuItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel titleLabel = new JLabel("AIMS");
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.PLAIN, 50));
        titleLabel.setForeground(Color.CYAN);

        JButton cartButton = new JButton("View cart");
        cartButton.addActionListener(e -> {
            CartScreen cartScreen = new CartScreen(cart, store);
        });
        cartButton.setPreferredSize(new Dimension(100, 50));
        cartButton.setMaximumSize(new Dimension(100, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(titleLabel);
        header.add(Box.createHorizontalGlue());
        header.add(cartButton);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < store.getItemsInStore().size(); i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
            centerPanel.add(cell);
        }

        return centerPanel;
    }
}
