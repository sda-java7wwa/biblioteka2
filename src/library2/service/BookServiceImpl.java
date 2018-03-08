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
        BookDao bookDao = new BooksDaoSerialImpl("books.ser");

        List<Category> categoryList = bookDao.getBooks().getSubcategory();

        checkBooks(id,categoryList,user);
//        user.getBooklist().add()
    }

    private void checkBooks(int id,List<Category> categoryList,User user){
        for(Category category:categoryList){
            List<Book> bookList = category.getBookList();
            for(Book book:bookList){
                if(book.getId()==id){
                    book.setBookUser(user);
                }
            }
        }
    }

    @Override
    public Category getBooksList() {

        BooksDaoSerialImpl booksDaoSerial = new BooksDaoSerialImpl("books.ser");

        return booksDaoSerial.getBooks();
    }
}
