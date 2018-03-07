package library2.service;

import library2.model.Book;
import library2.model.Category;
import library2.model.User;

import java.util.List;

public interface BookService {

    void borrowBook(int id, User user);

    Category getBooksList();

}
