package library2.model;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable{
    private String author;
    private String title;
    private int year;
    private int id;
    private User bookUser;

    public Book(String author, String title, int year, int id) {
        this.author = author;
        this.title = title;
        this.year = year;
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getId() {
        return id;
    }

    public User getBookUser() {
        return bookUser;
    }

    public void setBookUser(User bookUser) {
        this.bookUser = bookUser;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", id=" + id +
                ", bookUser=" + bookUser +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year &&
                id == book.id &&
                Objects.equals(author, book.author) &&
                Objects.equals(title, book.title) &&
                Objects.equals(bookUser, book.bookUser);
    }

    @Override
    public int hashCode() {

        return Objects.hash(author, title, year, id, bookUser);
    }
}