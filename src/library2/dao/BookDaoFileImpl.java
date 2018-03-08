package library2.dao;

import library2.model.Category;

import java.nio.file.Path;
import java.nio.file.Paths;

public class BookDaoFileImpl implements BookDao {

    private static final String FILE_NAME = "bookdata.txt";
    private static final String BOOKNAME = "Tytul";
    private static final String AUTHORNAME = "Autor";
    private static final String CATEGORYNAME = "Kategoria";
    private static final String DELIMITER = ";";
    private static final Path PATH = Paths.get(FILE_NAME);
    @Override
    public Category getBooks() {
        return null;
    }

    @Override
    public boolean saveBook(Category main) {
        return false;
    }
}
