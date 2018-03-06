package library2.dao;

import library2.model.User;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UserDaoSerialImpl implements UserDao, Serializable{

    private List<User> users = new ArrayList<>();


    public void addUser(User user, String path){
        this.users.add(user);
        saveUser(users, Paths.get(path));


    }

    public List<User> getUsersList(){
        return users;
    }

//private static final Path path = Paths.get(FILE_NAME);

    @Override
    public List<User> getUsersData(Path path) {// TODO konstruktor x nszwa pliku
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(String.valueOf(path)))){
            users = (List<User>) in.readObject();
        } catch (IOException i) {
           // System.err
            System.out.println("Błąd odczytu pliku");// TODO log i wiadomośc dla usera system.err
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Nie znaleziono klasy");
            return null;
        }
        return users;
    }



    @Override
    public boolean saveUser(List<User> users, Path path) {

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(String.valueOf(path)))){
            out.writeObject(users);
            System.out.printf("Serializacja listy userow do pliku");
        } catch (IOException i) {
            System.out.println("Błąd zapisu userow");
            return false;
        }
        return true;
    }
}
