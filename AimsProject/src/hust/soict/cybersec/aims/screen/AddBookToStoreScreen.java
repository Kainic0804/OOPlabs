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

public class AddBookToStoreScreen extends AddItemToStore {
    public AddBookToStoreScreen(Store store) {
        super(store, "Book");

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Add Book");
        this.setVisible(true);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/cybersec/aims/screen/addBook.fxml"));
                    AddBookToScreenController controller = new AddBookToScreenController(store);
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

    public Store getUpdatedStore() {
        return store;
    }

    private class AddBookToScreenController {

        @FXML private TextField titleBook;
        @FXML private TextField authorsBook;
        @FXML private TextField categoryBook;
        @FXML private TextField costBook;
        @FXML private Button btnAddBook;


        public AddBookToScreenController(Store _store) {
            super();
            store = _store;
        }

        @FXML
        private void intitialize() {
            btnAddBook.setVisible(true);
            titleBook.setVisible(true);
            authorsBook.setVisible(true);
            categoryBook.setVisible(true);
            costBook.setVisible(true);

        }

        @FXML
        private void btnAddBookPressed() {
            String title = titleBook.getText();
            String[] authors = authorsBook.getText().split(",");
            String category = categoryBook.getText();
            try {
                Float cost = Float.parseFloat(costBook.getText());
                if (cost >= 0.0) {
                    Integer curr_id = store.getItemsInStore().size() + 1;
                    Book book = new Book(curr_id, title, category, cost);
                    for (String author: authors) {
                        book.addAuthor(author);
                    }

                    store.addMedia(book);
                    setVisible(false);
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException iae){
                JOptionPane.showMessageDialog(null,"Only positive float cost accepted");
            }


        }
    }
}