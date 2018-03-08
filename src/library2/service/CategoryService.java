package library2.service;

import library2.model.Book;
import library2.model.Category;

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

}
