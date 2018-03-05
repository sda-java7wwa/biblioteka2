package UserDaoSerialLmpl;

import library2.dao.BooksDaoSerialImpl;
import library2.model.Book;
import library2.model.User;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class BooksDaoSerialImplTest {

    public BooksDaoSerialImpl booksDaoSerial = new BooksDaoSerialImpl();

    @Test
    public void BooksDaoTest () {
        Book book = new Book("Janusz","Ogniem i Mieczwm", 1598, 0001);
        Book book2 = new Book("Mickiewicz Adam","Pamiętniki Dody", 2010, 0002);

        List<Book> books = new ArrayList<>();
        books.add(book);
        books.add(book2);


    }
}
