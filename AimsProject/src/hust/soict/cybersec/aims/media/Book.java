package hust.soict.cybersec.aims.media;

import java.util.List;
import java.util.ArrayList;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public List<String> getAuthors() {
        return authors;
    }
    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String authorName){
        if (authors.contains(authorName)) {
            System.out.println("Author already exists");
        }
        else {
            authors.add(authorName);
        }
    }

    public void removeAuthor(String authorName){
        if (authors.contains(authorName)) {
            authors.remove(authorName);
        }
        else {
            System.out.println("Author does not exist");
        }
    }


}
