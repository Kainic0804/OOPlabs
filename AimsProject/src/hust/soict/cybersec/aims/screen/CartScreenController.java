package hust.soict.cybersec.aims.screen;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import hust.soict.cybersec.aims.media.Media;
import javafx.scene.control.RadioButton;

import javafx.event.ActionEvent;
import hust.soict.cybersec.aims.cart.Cart;
import hust.soict.cybersec.aims.exception.PlayerException;
import hust.soict.cybersec.aims.store.Store;
import hust.soict.cybersec.aims.media.Playable;
import hust.soict.cybersec.aims.screen.*;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.value.*;
import javafx.collections.transformation.FilteredList;



public class CartScreenController {
    private Cart cart;
    private Store store;

    @FXML private TableView<Media> tblMedia;
    @FXML private TableColumn<Media, String> colMediaTitle;
    @FXML private TableColumn<Media, String> colMediaCategory;
    @FXML private TableColumn<Media, Float> colMediaCost;
    @FXML private Button btnPlay;
    @FXML private Button btnRemove;
    @FXML private TextField tfFilter;
    @FXML private RadioButton radioBtnFilterID;
    @FXML private RadioButton radioBtnFilterTitle;
    @FXML private TextField tfTotalCost;
    @FXML private Button btnPlaceOrder;

    private float totalCost;

    public CartScreenController(Cart cart, Store store) {
        super();
        this.cart = cart;
        this.store = store;
        totalCost = this.cart.totalCost();
    }

    @FXML   // set the display
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        btnPlaceOrder.setVisible(true);

        tblMedia.setItems(this.cart.getItemsOrdered());

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                        if (newValue != null) {
                            updateButtonBar(newValue);
                        }
                    }
                });

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed (ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });

        tfTotalCost.setText(totalCost + "");
    }

    @FXML   // remove button
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        totalCost = cart.totalCost();
        tfTotalCost.setText(totalCost + ""); // reset the total cost
    }

    @FXML   // play button
    void btnPlayPressed(ActionEvent event) throws PlayerException {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            Playable disc = (Playable) media;
            new PlayMedia(disc);
        }
    }

    @FXML   // place order pressed
    void btnPlaceOrderPressed(ActionEvent event) {
        this.cart = new Cart();
        tblMedia.setItems(this.cart.getItemsOrdered());
        totalCost = cart.totalCost();
        tfTotalCost.setText(totalCost + ""); // reset the total cost
    }

    @FXML
    void menuItemAddBookPressed (ActionEvent event) {
        new AddBookToStoreScreen(store);
    }

    @FXML
    void menuItemAddCDPressed (ActionEvent event) {
        new AddCompactDiscToStoreScreen(store);
    }

    @FXML
    void menuItemAddDVDPressed (ActionEvent event) {
        new AddDigitalVideoDiscToStoreScreen(store);
    }

    @FXML
    void menuItemViewStorePressed (ActionEvent event) {
        new StoreScreen(this.store, this.cart);
    }

    @FXML
    void menuItemViewCartPressed (ActionEvent event) {

    }

    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    void showFilteredMedia(String newValue) {
        String valueType;
        if (radioBtnFilterID.isSelected()) {
            valueType = "id";
        } else {
            valueType = "title";
        }

        FilteredList<Media> list = new FilteredList<>(cart.getItemsOrdered(), null);
        list.setPredicate(media -> media.filterByProperty(newValue, valueType));

        if (cart.getItemsOrdered() != null) {
            tblMedia.setItems(list);
        }
    }
}