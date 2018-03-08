package library2.dao;

import library2.model.Book;
import library2.model.Category;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

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

        return true;
    }


    public boolean saveBookToFile(Book book){
        try {

            Files.write(PATH, getBookAsString(book).getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    public void initFileToSave(){
        try {
            Files.write(PATH, constructFirstRowOfText().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        System.out.println("działą??");
        StringBuilder sb = new StringBuilder();
        sb.append(CATEGORYNAME).append(DELIMITER).append(BOOKNAME).append(DELIMITER)
                .append(AUTHORNAME).append(DELIMITER).append(YEAR).append(DELIMITER).append(BOOKID).append("\n");

        return sb.toString();
    }
}
