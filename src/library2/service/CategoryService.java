package library2.service;

import library2.model.Book;
import library2.model.Category;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CategoryService {


    public void getBokList (Category category){    // prints List <Book> by category

        Scanner sc = new Scanner(System.in);
        int myCase = 0;
        int save;
        List<Category> cate =  category.getSubcategory();

        System.out.println("Przejdź do wybranej kategorii , 0 wyświetla listę książek");
        while (cate != null) {
            for (int i = 0; i < cate.size(); i++) {
                System.out.println(i + 1 + ". " + cate.get(i).getNazwa());
            }
            save = myCase;
            myCase = sc.nextInt();
            if (myCase == 0 || cate.get(save).getSubcategory() == null) {
                System.out.println(cate.get(save).getBookList());
            } else {
                cate = cate.get(myCase - 1).getSubcategory();
                if (cate == null){
                    System.out.println(cate.get(save).getBookList());
                }
            }
        }


        return;
    }


    public List<Category> getAllBooks (Category main){

        List<Category> categories = main.getSubcategory();
        List<Category> withBooks = new ArrayList<>();

        for (int i = 0; i < categories.size(); i++){
            if (categories.get(i).getBookList() != null){
                withBooks.add(categories.get(i));
            } else if (categories.get(i).getSubcategory() == null){
                break;
            } else {
                getAllBooks(categories.get(i));
            }
            }


        return withBooks;
    }

}
