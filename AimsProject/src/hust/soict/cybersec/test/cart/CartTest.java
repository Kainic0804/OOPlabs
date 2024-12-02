package hust.soict.cybersec.test.cart;

import hust.soict.cybersec.aims.cart.Cart;
import hust.soict.cybersec.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The lion King",
                "Animation", "Rogger Aller", 19.95f);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 24.95f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", "John Musker", 18.99f);
        cart.addMedia(dvd3);

       cart.printOrders();
       cart.searchById(3);
       cart.searchById(2);
       cart.searchByTitle("Star Wars");
       cart.searchByTitle("Blackhat");
    }
}
