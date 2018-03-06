package library2.dao;

import library2.model.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BooksDaoSerialImpl implements BookDao, Serializable {

    private List<Book> bookList;

    private String path;

    public BooksDaoSerialImpl(String path){
        this.path=path;
    }

    public String getPath() {
        return path;
    }

    @Override
    public List<Book> getBooks() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(getPath()))){
            bookList = (List<Book>) in.readObject();
            System.out.println("Deserializacja listy książek z pliku");
        } catch (IOException i) {
            System.out.println("Błąd odczytu");
        } catch (ClassNotFoundException c) {
            System.out.println("Nie znaleziono klasy");
        }
        return bookList;
    }

    @Override
    public boolean saveBook(List<Book> books) {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(getPath()))) {
            out.writeObject(books);
            System.out.println("Lista ksiażek zserializowana do pliku");
        } catch (IOException i) {
            System.out.println("Błąd zapisu");
            return false;
        }
        return true;
    }
}
