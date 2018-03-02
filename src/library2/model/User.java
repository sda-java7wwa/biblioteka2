package library2.model;

import java.util.List;
import java.util.Objects;

public class User {
    private String name;
    private String surname;
    private String passwd;
    private List<Book> booklist;

    public User(String name, String surname, String passwd, List<Book> booklist) {
        this.name = name;
        this.surname = surname;
        this.passwd = passwd;
        this.booklist = booklist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getName(), user.getName()) && Objects.equals(getSurname(), user.getSurname()) && Objects.equals(getPasswd(), user.getPasswd()) && Objects.equals(getBooklist(), user.getBooklist());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getSurname(), getPasswd(), getBooklist());
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", surname='" + surname + '\'' + ", passwd='" + passwd + '\'' + ", booklist=" + booklist + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public List<Book> getBooklist() {
        return booklist;
    }

    public void setBooklist(List<Book> booklist) {
        this.booklist = booklist;
    }
}
