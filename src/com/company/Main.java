package com.company;

import library2.dao.BooksDaoSerialImpl;
import library2.dao.UserDao;
import library2.dao.UserDaoSerialImpl;
import library2.model.Book;
import library2.model.Category;
import library2.model.User;
import library2.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Category main = new Category("Główna");
         Category poradniki = new Category("Poradniki");
          Category biznesowe = new Category("Biznesowe");
          Category kulinarne = new Category("kulinarne");

        main.addToList(poradniki);
        poradniki.addToList(biznesowe);

        biznesowe.addToList(new Book("Sienkiewicz","Ogniem i Mieczem",1920,1));
        biznesowe.addToList(new Book("Sienkiewicz1","Ogniem i Mieczem",1920,2));
        biznesowe.addToList(new Book("Sienkiewicz2","Ogniem i Mieczem",1920,3));

        poradniki.addToList(new Book("poradnik1","tytul",1999,4));
        poradniki.addToList(new Book("poradnik2","tytul",1999,5));



        poradniki.addToList(kulinarne);

        kulinarne.addToList(new Book("Okrasa","Pomidorowa",2019,6));
        kulinarne.addToList(new Book("Okrasa2","Pomidorowa",2019,7));
        kulinarne.addToList(new Book("Paskal","Rosół",2019,8));

        //System.out.println(main.getBookList());
        //System.out.println(main.getSubcategory());
        System.out.println("size of sub: "+ main.getSubcategory().get(0).getNazwa());
        System.out.println(main.getSubcategory().get(0).getSubcategory().get(0).getNazwa());


        System.out.println(main);

        CategoryService categoryService = new CategoryService();

        categoryService.getBokList(main);
























//	// write your code here
//        List<Book> bookList = new ArrayList<>();
//
//        bookList.add(new Book("Ja","On",1999,1));
//        bookList.add(new Book("Ja2","On2",1998,2));
//        bookList.add(new Book("Ja3","On3",1997,3));
//        bookList.add(new Book("Ja4","On4",1996,4));
//
//////        BooksDaoSerialImpl booksDaoSerial = new BooksDaoSerialImpl();
////
////        booksDaoSerial.saveBook(bookList);
////
////        System.out.println(booksDaoSerial.getBooks());
//
////        List<User> userList = new ArrayList<>();
////        userList.add(new User("bartek","polak","aaa",null,"bbb"));
////        userList.add(new User("bartek1","polak1","aaa1",null,"bbb1"));
////        userList.add(new User("bartek2","polak2","aaa2",null,"bbb2"));
////        userList.add(new User("bartek3","polak3","aaa3",null,"bbb3"));
//
//        UserDao userDao = new UserDaoSerialImpl("users.ser");
//
// //       userDao.saveUser(userList);
//
//        System.out.println(userDao.getUsersData());
    }
}
