package hust.soict.cybersec.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title) {
        this.title = title;
    }

    public Track(int length) {
        this.length = length;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD Length: " + this.getLength());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Track)) {
            return false;
        }
        else {
            Track track = (Track) o;
            return (this.title != null &&this.title.equals(track.getTitle())) && this.length == track.getLength();
        }
    }
}
