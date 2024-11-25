package hust.soict.cybersec.aims;

import hust.soict.cybersec.aims.cart.Cart;
import hust.soict.cybersec.aims.disc.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        Cart an0rder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The lion King",
                "Animation", "Rogger Aller", 87, 19.95f);
        an0rder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        an0rder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);
        an0rder.addDigitalVideoDisc(dvd3);

        System.out.println("Total cost is: ");
        System.out.println(an0rder.totalCost());

        an0rder.removeDigitalVideoDisc(dvd2);   //Xóa dvd2
        System.out.println("Total cost is: ");  //In ra giá tiền tổng sau khi xóa
        System.out.println(an0rder.totalCost());
    }
}
