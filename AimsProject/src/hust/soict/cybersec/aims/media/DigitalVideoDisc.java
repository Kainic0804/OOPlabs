package hust.soict.cybersec.aims.media;

import hust.soict.cybersec.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc {
    private int id;

    public String getAuthor() {
        return author;
    }
    public int getLength() {
        return length;
    }


    public DigitalVideoDisc(int id, String title) {
        super(id, title);
    }

    public DigitalVideoDisc (String title) {
        super(title);
    }

    public DigitalVideoDisc(int id, String title, String category, int length, String author, float cost) {
        super(id, title, category, length, author, cost);
    }

    public String play() throws PlayerException {
        if (this.getLength() > 0) {
            return "Playing DVD: " + this.getTitle() + "\n DVD Length: " + this.getLength();
        } else {
            System.err.println("ERROR: DVD length is non-positive");
            throw new PlayerException("ERROR: DVD length is non-positive");
        }
    }

}