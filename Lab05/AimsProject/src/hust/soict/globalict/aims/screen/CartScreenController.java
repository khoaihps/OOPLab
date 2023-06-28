package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.media.*;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.*;

public class CartScreenController {

    private Cart cart;
    private Store store;

    @FXML
    private Button btnPlaceOrder;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private MenuItem btnViewStore;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, String> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TextField tfFilter;

    @FXML
    private Label totalValue;

    public CartScreenController(Cart cart, Store store) {
        this.cart = cart;
        this.store = store;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        ObservableList<Media> observableList = FXCollections.observableArrayList(cart.getItemsOrdered());
        tblMedia.setItems(observableList);

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        btnPlay.setOnAction(e -> {
            JDialog playDialog = new JDialog();
            playDialog.setTitle("Play");
            playDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

            JLabel label = new JLabel("Playing");
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.PLAIN, 16));

            playDialog.add(label);
            playDialog.setSize(100, 100);
            playDialog.setLocationRelativeTo(null); // Center the dialog on the screen
            playDialog.setVisible(true);
        });

        btnRemove.setOnAction(event -> {
            Media media = tblMedia.getSelectionModel().getSelectedItem();
            if (media != null) {
                cart.removeMedia(media);
                tblMedia.getItems().remove(media);
                tblMedia.getSelectionModel().clearSelection();
                float totalCost = cart.totalCost();
                totalValue.setText(totalCost + "$");
            }
        });

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                        if (newValue != null) {
                            updateButtonBar(newValue);
                        }
                    }
                }
        );

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilterMedia(newValue);
            }
        });

        btnPlaceOrder.setOnAction(e -> {
            colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
            colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
            colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

            tblMedia.setItems(null);
            cart.clear();
            float totalCost = cart.totalCost();
            totalValue.setText(totalCost + "$");
        });

        float totalCost = cart.totalCost();
        totalValue.setText(totalCost + "$");

        btnViewStore.setOnAction(e -> {
            MenuItem menuItem = (MenuItem) e.getSource();
            javafx.scene.control.MenuButton parentMenuButton = (javafx.scene.control.MenuButton) menuItem.getParentPopup().getOwnerNode();
            javafx.scene.Scene currentScene = parentMenuButton.getScene();
            javafx.stage.Window currentWindow = currentScene.getWindow();
            currentWindow.hide();
            new StoreScreen(store, cart);
        });
    }

    private void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    private void showFilterMedia(String newValue) {
        ObservableList<Media> filteredList = FXCollections.observableArrayList();

        if (radioBtnFilterId.selectedProperty().get()) {
            // System.out.println(newValue + " "+ newValue.matches("\\d+"));
            if (newValue.matches("\\d+")) {
                for (Media media : cart.getItemsOrdered()) {
                    if (media.getId() == Integer.parseInt(newValue)) {
                        filteredList.add(media);
                    }
                }
            }
            if (newValue.equals("")) {
                filteredList.addAll(cart.getItemsOrdered());
            }
        } else {
            for (Media media : cart.getItemsOrdered()) {
                if (media.getTitle().contains(newValue)) {
                    filteredList.add(media);
                }
            }
        }

        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        tblMedia.setItems(filteredList);
    }
}
