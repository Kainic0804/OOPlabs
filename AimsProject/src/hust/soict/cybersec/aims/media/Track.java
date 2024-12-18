package hust.soict.cybersec.aims.media;

import hust.soict.cybersec.aims.exception.PlayerException;

public class Track implements Playable {
    private String title;
    private int length;
    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }
    public Track (String title, int length){
        this.title = title;
        this.length = length;
    }

    public String play () throws PlayerException{
        if (this.getLength() > 0){
            return "Playing track: " + this.getTitle() + "\n" +"Track Length: " + this.getLength();
        } else {
            System.err.println("Error: Track length is non-positive");
            throw new PlayerException("ERROR: Track length is non-positive");
        }
    }

    public boolean equals (Object o) {
        if (o instanceof Track) {
            Track t = (Track) o;
            return ((title == t.getTitle()) && (length == t.getLength()));
        } else {
            return false;
        }

    }

}