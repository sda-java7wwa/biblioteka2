package library2.dao;

import library2.model.Book;
import library2.model.Category;

import java.nio.file.Path;
import java.nio.file.Paths;

public class BookDaoFileImpl implements BookDao {

    private static final String FILE_NAME = "bookdata.txt";
    private static final String BOOKNAME = "Tytul";
    private static final String AUTHORNAME = "Autor";
    private static final String CATEGORYNAME = "Kategoria";
    private static final String YEAR = "Rok wydania";
    private static final String BOOKID = "ID książki";
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

    private String getBookAsString(Book book){

        StringBuilder sb = new StringBuilder();
        sb.append(book.getTitle())
                .append(DELIMITER)
                .append(book.getAuthor())
                .append(DELIMITER)
                .append(book.getYear())
                .append(DELIMITER)
                .append(book.getId())
                .append("\n");

        return sb.toString();
    }

    private String constructFirstRowOfText(){
        StringBuilder sb = new StringBuilder();
        sb.append(CATEGORYNAME).append(DELIMITER).append(BOOKNAME).append(DELIMITER)
                .append(AUTHORNAME).append(DELIMITER).append(YEAR).append(DELIMITER).append(BOOKID);
    }
}
