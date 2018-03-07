package library2.service;

import library2.dao.BookDao;
import library2.dao.BooksDaoSerialImpl;
import library2.model.Book;
import library2.model.Category;

import java.util.List;

public class BookServiceImpl implements BookService {

    @Override
    public Category getBooksList() {

        BooksDaoSerialImpl booksDaoSerial = new BooksDaoSerialImpl("books.ser");

        return booksDaoSerial.getBooks();
    }
}
