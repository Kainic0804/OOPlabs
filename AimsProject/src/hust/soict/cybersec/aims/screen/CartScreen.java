package hust.soict.cybersec.aims.screen;

import java.io.IOException;
import hust.soict.cybersec.aims.cart.Cart;
import hust.soict.cybersec.aims.store.Store;
import javafx.embed.swing.JFXPanel;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javax.swing.JFrame;

import javafx.fxml.FXMLLoader;

public class CartScreen extends JFrame {
    private Cart cart;
    private Store store;


    public CartScreen(Cart cart, Store store) {
        super();
        this.cart = cart;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/cybersec/aims/screen/cart.fxml"));
                    CartScreenController controller = new CartScreenController(cart, store);
                    loader.setController(controller);
                    Parent root = (Parent) loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        this.setSize(1024, 768);
    }
}