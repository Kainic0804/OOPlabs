package hust.soict.cybersec.aims;

import hust.soict.cybersec.aims.cart.Cart;
import hust.soict.cybersec.aims.exception.PlayerException;
import hust.soict.cybersec.aims.media.Book;
import hust.soict.cybersec.aims.media.CompactDisc;
import hust.soict.cybersec.aims.media.DigitalVideoDisc;
import hust.soict.cybersec.aims.media.Media;
import hust.soict.cybersec.aims.media.Playable;
import hust.soict.cybersec.aims.media.Track;
import hust.soict.cybersec.aims.screen.StoreScreen;
import hust.soict.cybersec.aims.store.Store;
import java.util.Scanner;

import javax.naming.LimitExceededException;


public class Aims {
    public static void main(String[] args) {
        Cart cart = new Cart();
        Store store = new Store();
        new StoreScreen(store, cart);
    }
/*
    public static void mediaDetailsMenu(Scanner scanner, Media media) throws LimitExceededException {
        Cart cart = new Cart();
        int choice;
        do {
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    System.out.println("Media added to cart.");
                    break;
                case 2:
                    if (media instanceof Playable) {
                        if (media instanceof DigitalVideoDisc) {
                            try {
                                ((DigitalVideoDisc) media).play();
                            } catch (PlayerException e) {
                                // TODO Auto-generated catch block
                                e.getMessage();
                                e.toString();
                                e.printStackTrace();
                            }
                        } else if (media instanceof CompactDisc) {
                            try {
                                ((CompactDisc) media).play();
                            } catch (PlayerException e) {
                                // TODO Auto-generated catch block
                                e.getMessage();
                                e.toString();
                                e.printStackTrace();
                            }
                        }
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    public static void playMedia(Scanner scanner) {
        Store store = new Store();
        System.out.print("Enter the title of the media to play: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);

        if (media != null) {
            if (media instanceof Playable) {
                if(media instanceof DigitalVideoDisc){
                    try {
                        ((DigitalVideoDisc) media).play();
                    } catch (PlayerException e) {
                        // TODO Auto-generated catch block
                        e.getMessage();
                        e.toString();
                        e.printStackTrace();
                    }
                }
                else if(media instanceof CompactDisc){
                    try {
                        ((CompactDisc)media).play();
                    } catch (PlayerException e) {
                        // TODO Auto-generated catch block
                        e.getMessage();
                        e.toString();
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("This media cannot be played.");
            }
        } else {
            System.out.println("Media not found in the store.");
        }
    }
*/
}

