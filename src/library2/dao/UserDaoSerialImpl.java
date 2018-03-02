package library2.dao;

import library2.model.User;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDaoSerialImpl implements UserDao, Serializable{

    List<User> users = new ArrayList<>();

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public boolean saveUser(List<User> users) {

        try {
            FileOutputStream fileOut =
                    new FileOutputStream("/tmp/users.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(users);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/users.ser");
        } catch (IOException i) {
            i.printStackTrace();
            return false;
        }

        return true;
    }
}
