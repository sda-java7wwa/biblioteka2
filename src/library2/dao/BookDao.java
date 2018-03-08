package library2.dao;

import library2.model.Book;
import library2.model.Category;

import java.util.List;

public interface BookDao {

    Category getBooks();

    boolean saveBook(Category main);
}
