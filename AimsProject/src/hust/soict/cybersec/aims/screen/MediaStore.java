package hust.soict.cybersec.aims.screen;
import javax.naming.LimitExceededException;
import javax.swing.*;
import java.awt.event.*;
import hust.soict.cybersec.aims.media.*;
import hust.soict.cybersec.aims.screen.*;
import hust.soict.cybersec.aims.cart.Cart;
import hust.soict.cybersec.aims.exception.PlayerException;

import java.awt.*;


public class MediaStore extends JPanel {
    private Media media;
    private Playable disc;
    private Cart cart;

    public MediaStore (Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + "$");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Add to cart button
        JButton addCartButton = new JButton("Add to cart");
        container.add(addCartButton);
        addCartButton.addMouseListener(new AddToCartListener());

        // Play button -> for playable classes
        if (media instanceof Playable) {
            JButton PlayButton = new JButton("Play");
            container.add(PlayButton);
            disc = (Playable) media;
            PlayButton.addMouseListener(new PlayButtonListener());
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    // Button Mouse Listener

    private class PlayButtonListener implements MouseListener{
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}

        public void mouseClicked(MouseEvent e) {
            try {
                new PlayMedia(disc);
            } catch (PlayerException pe) {
                pe.printStackTrace();
            }
        }
    }

    // Add to class Listener
    private class AddToCartListener implements MouseListener {
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}

        public void mouseClicked(MouseEvent e) {
            try {
                AddToCart adc = new AddToCart(media, cart);
                cart = adc.getUpdatedCart();
            } catch (LimitExceededException lee) {
                lee.printStackTrace();
            }
        }
    }
}