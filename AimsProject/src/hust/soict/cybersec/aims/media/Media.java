package hust.soict.cybersec.aims.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST =
            new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE =
            new MediaComparatorByCostTitle();

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Media)) {
            return false;
        }
        Media media = (Media) o;
        return this.title != null && this.title.equals(media.getTitle());
    }

    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();

        CompactDisc cd = new CompactDisc(50, "superman", "action", 305.5f, 2, "Bryan Singer");
        DigitalVideoDisc dvd = new DigitalVideoDisc(1, "starwar", "action", 1563.6f, 3, "George Lucas");
        Book book = new Book(84, "Cryptography Engineering", "specialized", 55.6f);

        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);

        Collections.sort(mediae, Media.COMPARE_BY_TITLE_COST);
        for (Media m : mediae) {
            System.out.println(m.toString());
        }
    }
}
