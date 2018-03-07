package library2.dao;

import library2.model.Book;
import library2.model.Category;

import java.util.List;

public interface BookDao {

    List<Category> getBooks();

    boolean saveBook(List<Category> books);
}
