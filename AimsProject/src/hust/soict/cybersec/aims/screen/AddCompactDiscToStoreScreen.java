package hust.soict.cybersec.aims.screen;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import hust.soict.cybersec.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import hust.soict.cybersec.aims.media.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;


import java.awt.*;

public class AddCompactDiscToStoreScreen extends AddItemToStore {
    public AddCompactDiscToStoreScreen(Store store) {
        super(store, "DVD");

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Add CD");
        this.setVisible(true);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/cybersec/aims/screen/addCD.fxml"));
                    AddCompactDiscToScreenController controller = new AddCompactDiscToScreenController(store);
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

    private class AddCompactDiscToScreenController {

        @FXML private TextField titleCD;
        @FXML private TextField authorCD;
        @FXML private TextField categoryCD;
        @FXML private TextField costCD;
        @FXML private TextField tracksCD;
        @FXML private Button btnAddCD;


        public AddCompactDiscToScreenController(Store _store) {
            super();
            store = _store;
        }

        @FXML
        private void initialize() {
            btnAddCD.setVisible(true);
            titleCD.setVisible(true);
            authorCD.setVisible(true);
            categoryCD.setVisible(true);
            costCD.setVisible(true);
            tracksCD.setVisible(true);

        }

        @FXML
        private void btnAddCDPressed() {
            String title = titleCD.getText();
            String author = authorCD.getText();
            String category = categoryCD.getText();
            try {

                ArrayList<Track> TrackListCD = new ArrayList<Track>();

                Float cost = Float.parseFloat(costCD.getText());
                String[] tracks = tracksCD.getText().split(", ");
                Integer length = 0;
                for (int i = 0; i <= tracks.length - 1; i += 2) {
                    String track_title = tracks[i];
                    Integer track_length = Integer.parseInt(tracks[i+1].replace(" ", ""));
                    if (track_length <= 0){
                        throw new IllegalArgumentException(); // exception handle
                    }

                    length += track_length;
                    TrackListCD.add(new Track(track_title, track_length));
                }

                Integer curr_id = store.getItemsInStore().size() + 1;
                CompactDisc cd = new CompactDisc(curr_id, title, category, length , author, cost);
                for (Track t: TrackListCD) {
                    cd.addTrack(t);
                }
                store.addMedia(cd);

                setVisible(false);

            } catch (IllegalArgumentException iae) {
                JOptionPane.showMessageDialog(null, "Error: Wrong format of input");
            }
        }
    }
}