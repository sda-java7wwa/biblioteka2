package library2.dao;
import library2.model.User;

import java.nio.file.Path;
import java.util.List;

public interface UserDao {

    void addUser(User user, String path);

    List<User> getUsersList();

    List<User> getUsersData (Path path);

    boolean saveUser(List<User> users, Path path);


}
