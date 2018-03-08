package library2.service;

import library2.dao.BookDao;
import library2.dao.BooksDaoSerialImpl;
import library2.model.Book;
import library2.model.Category;
import library2.model.User;

import java.util.List;

public class BookServiceImpl implements BookService {

    @Override
    public void borrowBook(int id, User user) {
        if(getBooksList().getBookList().stream()
                .anyMatch(s-> s.getId()==id)){
           Book book = getBooksList().getBookList().stream()
                    .filter(s->s.getId()==id)
                    .findFirst()
                    .get();
           book.setBookUser(user);
        } else {

        }

//        user.getBooklist().add()
    }

    @Override
    public Category getBooksList() {

        BooksDaoSerialImpl booksDaoSerial = new BooksDaoSerialImpl("books.ser");

        return booksDaoSerial.getBooks();
    }


}
