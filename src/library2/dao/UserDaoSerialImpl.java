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
    }

    public List<User> getUsersList(){
        return users;
    }

    @Override
    public List<User> getUsersData() {
        try {
            FileInputStream fileIn = new FileInputStream("users.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            users = (List<User>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
        }
        return users;
    }



    @Override
    public boolean saveUser(List<User> users) {

        try {
            FileOutputStream fileOut =
                    new FileOutputStream("users.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(users);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in users.ser");
        } catch (IOException i) {
            i.printStackTrace();
            return false;
        }

        return true;
    }
}
