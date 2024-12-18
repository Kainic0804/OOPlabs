package hust.soict.cybersec.aims.media;

import hust.soict.cybersec.aims.exception.PlayerException;

public class Disc extends Media implements Playable {
    private int id;
    protected int length;
    protected String author;
    public int getLength() {
        return length;
    }
    public String getAuthor() {
        return author;
    }

    public String play() throws PlayerException{
        return "";
    }

    public Disc (int id, String title) {
        super(id, title);
    }

    public Disc(String title) {
        super();
        this.title = title;
    }

    public Disc(int id, String title, String category, int length, String author, float cost) {
        super(id, title, category, cost);
        this.length = length;
        this.author = author;
    }



}