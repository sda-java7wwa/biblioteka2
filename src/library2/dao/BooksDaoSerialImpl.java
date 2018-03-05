package library2.dao;

import library2.model.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BooksDaoSerialImpl implements BookDao, Serializable {




    @Override
    public List<Book> getBooks() {
        List<Book> bookList = new ArrayList<>();
        try {
            FileInputStream fileIn = new FileInputStream("books.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            bookList = (List<Book>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {

            System.out.println("Nie znaleziono");

        } catch (ClassNotFoundException c) {
            System.out.println("Nie znaleziono");

        }
        return bookList;
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
            System.out.println("Błąd zapisu");
            return false;
        }
        return true;
    }
}
