package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.cart.*;
import hust.soict.globalict.aims.store.*;
import hust.soict.globalict.aims.media.*;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.naming.LimitExceededException;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class CartScreen extends JFrame {
    private Cart cart;

    public CartScreen(Cart cart, Store store) {

        this.cart = cart;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setSize(1024, 768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(
                        "hust/soict/globalict/aims/screen/cart.fxml"));
                CartScreenController controller = new CartScreenController(cart, store);
                loader.setController(controller);
                Parent root = loader.load();
                Scene scene = new Scene(root);
                fxPanel.setScene(scene);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) throws LimitExceededException {
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "Roger Allers", 18.99f);
        anOrder.addMedia(dvd3);


        SwingUtilities.invokeLater(() -> {
            CartScreen cartScreen = new CartScreen(anOrder, new Store());
        });
    }
}