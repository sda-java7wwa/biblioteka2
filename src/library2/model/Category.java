package library2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Category implements Serializable{
    private String name;
    private List<Category> subcategory;
    private List<Book> bookList;

    public Category(String name) {
        this.name = name;
    }

    public String getNazwa() {
        return name;
    }

    public void addToList(Book book){
        if(bookList==null){
            bookList=new ArrayList<>();
        }
        bookList.add(book);
    }

    public void setNazwa(String nazwa) {
        this.name = nazwa;
    }

    public List<Category> getSubcategory() {
        return subcategory;
    }

    public void addToList(Category category) {
        if(subcategory==null){
            subcategory=new ArrayList<>();
        }
        subcategory.add(category);
    }

    public void setSubcategory(List<Category> podkategorie) {
        this.subcategory = podkategorie;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", subcategory=" + getSubcategory() +
                ", bookList=" + bookList +
                '}';
    }
}
