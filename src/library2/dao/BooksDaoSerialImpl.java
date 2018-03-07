package library2.dao;

import library2.model.Book;
import library2.model.Category;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BooksDaoSerialImpl implements BookDao, Serializable {

    private List<Category> categoryList;

    private String path;

    public BooksDaoSerialImpl(String path){
        this.path=path;
    }

    public String getPath() {
        return path;
    }

    @Override
    public List<Category> getBooks() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(getPath()))){
            categoryList = (List<Category>) in.readObject();
            System.out.println("Deserializacja listy książek z pliku");
        } catch (IOException i) {
            System.out.println("Błąd odczytu");
        } catch (ClassNotFoundException c) {
            System.out.println("Nie znaleziono klasy");
        }
        return categoryList;
    }

    @Override
    public boolean saveBook(List<Category> books) {
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
