package library2.dao;

import library2.model.Book;
import library2.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoSerialImpl implements UserDao, Serializable{

    private List<User> users = new ArrayList<>();

    public void addUser(User user){
        this.users.add(user);
        saveUser(users);
    }

    public List<User> getUsersList(){
        users = getUsersData();
        return users;
    }

    @Override
    public List<User> getUsersData() {// TODO konstruktor x nszwa pliku
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("users.ser"))){
            users = (List<User>) in.readObject();
        } catch (IOException i) {
            System.out.println("Błąd odczytu pliku");// TODO log i wiadomośc dla usera system.err
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Nie znaleziono klasy");
            return null;
        }
        return users;
    }



    @Override
    public boolean saveUser(List<User> users) {

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("users.ser"))){
            out.writeObject(users);
            System.out.printf("Serializacja listy userow do pliku");
        } catch (IOException i) {
            System.out.println("Błąd zapisu userow");
            return false;
        }
        return true;
    }
}
