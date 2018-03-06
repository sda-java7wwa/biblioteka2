package library2.dao;
import library2.model.User;

import java.nio.file.Path;
import java.util.List;

public interface UserDao {

    void addUser(User user);

    List<User> getUsersList();

    List<User> getUsersData();

    boolean saveUser(List<User> users);
}
