package library2.dao;

import library2.model.Book;

import java.util.List;

public interface BookDao {

    List<Book> getBooks();

    boolean saveBook(List<Book> books);
}
