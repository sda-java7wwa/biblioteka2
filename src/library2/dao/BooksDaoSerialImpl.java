package library2.dao;

import library2.model.Book;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class BooksDaoSerialImpl implements BookDao {



    @Override
    public List<Book> getBooks() {
        return null;
    }

    @Override
    public boolean saveBook(List<Book> books) {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("books.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(books);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in books.ser");
        } catch (IOException i) {
            i.printStackTrace();
            return false;
        }
        return true;
    }
}
