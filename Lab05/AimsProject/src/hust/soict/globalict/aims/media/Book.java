package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

import javax.naming.LimitExceededException;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();
    
    public Book(int id, String title, String category, float cost) throws LimitExceededException {
        super(id, title, category, cost);
    }
    public void addAuthor(String authorName) {
        if (authors.contains(authorName)) {
            System.out.println("The author already existed.");
        } else {
            this.authors.add(authorName);
            System.out.println("The author was added successfully.");
        }
    }

    public void removeAuthor(String authorName)  {
        if (!authors.contains(authorName)) {
            throw new NullPointerException("ERROR : The author does not existed.");
        } else {
            this.authors.remove(authorName);
            System.out.println("The author was removed successfully.");
        }
    }

    public Book(String title, String category, float cost) throws LimitExceededException {
        super(title, category, cost);
    }

    public Book(String title, String category, float cost, List<String> authors) throws LimitExceededException {
        super(title, category, cost);
        this.authors = authors;
    }

    public Book(int id, String title, String category, float cost, List<String> authors) throws LimitExceededException {
        super(id, title, category, cost);
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book " + getId() + " - " + getTitle() + " - " + getCategory() + " - " + getCost() + " - " + this.authors;
    }

}
