package hust.soict.cybersec.aims.media;
import java.util.*;

import hust.soict.cybersec.aims.exception.PlayerException;

public class CompactDisc extends Disc {
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();
    private int id;

    public String getArtist() {
        return artist;
    }

    public CompactDisc(int id, String title) {
        super(id, title);
    }

    public CompactDisc(int id, String title, String category, int length, String author, float cost) {
        super(id, title, category, length, author, cost);
    }

    public CompactDisc(String title) {
        super(title);
    }

    public boolean addTrack (Track track) {
        if (!(tracks.contains(track))){
            tracks.add(track);
            return true;
        } else {return false;}
    }

    public boolean removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            return true;
        } else {
            return false;
        }
    }

    public int getLength() {
        int total_length = 0;
        for (Track track: tracks) {
            total_length = total_length + track.getLength();
        } return total_length;
    }

    public String toString() {
        return "CD by " + artist + super.toString();
    }

    public String play() throws PlayerException{
        if (this.getLength() > 0) {
            String playing = "";
            for (Track track: tracks) {
                try {
                    playing = playing + track.play() + '\n';
                } catch (PlayerException e) {
                    throw e;
                }
            } return playing;
        } else {
            throw new PlayerException("ERROR: CD length is non-positive");
        }
    }
}