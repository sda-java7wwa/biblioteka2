package library2.dao;
import library2.model.User;
import java.util.List;

public interface UserDao {

    List<User> getUsers ();
    boolean saveUser(List<User> users);

}
