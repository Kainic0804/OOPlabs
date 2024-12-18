package hust.soict.cybersec.aims.media;
import java.util.*;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();
    private int id;

    public Book(int id, String title) {
        super(id, title);
    }

    public Book (String title) {
        super();
        this.title = title;
    }

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public boolean addAuthor(String authorName) {
        if (!(authors.contains(authorName))) {
            authors.add(authorName);
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return "Book " + super.toString();
    }

    public boolean removeAuthod(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            return true;
        } else {
            return false;
        }
    }

}