package library2.service;

import library2.dao.BookDao;
import library2.dao.BooksDaoSerialImpl;
import library2.model.Book;

import java.util.List;

public class BookServiceImpl implements BookService {

    @Override
    public List<Book> getBooksList() {

        BooksDaoSerialImpl booksDaoSerial = new BooksDaoSerialImpl("books.ser");

        return booksDaoSerial.getBooks();
    }
}
