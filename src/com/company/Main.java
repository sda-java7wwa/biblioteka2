package com.company;

import library2.dao.BooksDaoSerialImpl;
import library2.dao.UserDao;
import library2.dao.UserDaoSerialImpl;
import library2.model.Book;
import library2.model.User;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<Book> bookList = new ArrayList<>();

        bookList.add(new Book("Ja","On",1999,1));
        bookList.add(new Book("Ja2","On2",1998,2));
        bookList.add(new Book("Ja3","On3",1997,3));
        bookList.add(new Book("Ja4","On4",1996,4));

        BooksDaoSerialImpl booksDaoSerial = new BooksDaoSerialImpl();

        booksDaoSerial.saveBook(bookList);

        System.out.println(booksDaoSerial.getBooks());

        List<User> userList = new ArrayList<>();
        userList.add(new User("bartek","polak","aaa",null,"bbb"));
        userList.add(new User("bartek1","polak1","aaa1",null,"bbb1"));
        userList.add(new User("bartek2","polak2","aaa2",null,"bbb2"));
        userList.add(new User("bartek3","polak3","aaa3",null,"bbb3"));

        UserDao userDao = new UserDaoSerialImpl();

        userDao.saveUser(userList);

        System.out.println(userDao.getUsersData());
    }
}
