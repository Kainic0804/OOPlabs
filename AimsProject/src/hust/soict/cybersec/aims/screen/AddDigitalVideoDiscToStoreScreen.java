package hust.soict.cybersec.aims.screen;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import hust.soict.cybersec.aims.media.DigitalVideoDisc;
import hust.soict.cybersec.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

import javax.swing.JOptionPane;

import hust.soict.cybersec.aims.cart.Cart;
import hust.soict.cybersec.aims.media.*;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;


import java.awt.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStore {
    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store, "DVD");

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Add Book");
        this.setVisible(true);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/cybersec/aims/screen/addDVD.fxml"));
                    AddDigitalVideoDiscToScreenController controller = new AddDigitalVideoDiscToScreenController(store);
                    loader.setController(controller);
                    Parent root = (Parent) loader.load();
                    fxPanel.setScene (new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        this.setSize(640, 480);
    }

    private class AddDigitalVideoDiscToScreenController {

        @FXML private TextField titleDVD;
        @FXML private TextField authorDVD;
        @FXML private TextField categoryDVD;
        @FXML private TextField costDVD;
        @FXML private TextField lengthDVD;
        @FXML private Button btnAddDVD;


        public AddDigitalVideoDiscToScreenController(Store _store) {
            super();
            store = _store;
        }

        @FXML
        private void initialize() {
            btnAddDVD.setVisible(true);
            titleDVD.setVisible(true);
            authorDVD.setVisible(true);
            categoryDVD.setVisible(true);
            costDVD.setVisible(true);
            lengthDVD.setVisible(true);

        }

        @FXML
        private void btnAddDVDPressed() {
            String title = titleDVD.getText();
            String author = authorDVD.getText();
            String category = categoryDVD.getText();
            try {
                Float cost = Float.parseFloat(costDVD.getText());
                if (cost <= 0.0){
                    throw new IllegalArgumentException();
                }
                Integer length = Integer.parseInt(lengthDVD.getText());
                if (length <= 0) {
                    throw new IllegalArgumentException();
                }
                Integer curr_id = store.getItemsInStore().size() + 1;
                store.addMedia(new DigitalVideoDisc(curr_id, title, category, length , author, cost));

                setVisible(false);
            } catch (IllegalArgumentException iae) {
                JOptionPane.showMessageDialog(null, "Error: Wrong format of input");;
            }
        }
    }
}