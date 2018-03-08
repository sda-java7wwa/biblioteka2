package library2.service;

import library2.model.Book;
import library2.model.Category;

import java.util.List;
import java.util.Scanner;

public class CategoryService {


    public void getBokList (Category category){    // prints List <Book> by category

        Scanner sc = new Scanner(System.in);
        int myCase;
        List<Category> cate =  category.getSubcategory();
        List<Book> books = category.getBookList();
        System.out.println("Przejdź do wybranej kategorii , 0 wyświetla listę książek");
        while (cate != null) {
            for (int i = 0; i < cate.size(); i++) {
                System.out.println(i + 1 + ". " + cate.get(i).getNazwa());
            }
            myCase = sc.nextInt();
            if (myCase == 0) {
                System.out.println(category.getBookList());
            } else {
                cate = cate.get(myCase).getSubcategory();
            }
        }


        return;
    }

}
