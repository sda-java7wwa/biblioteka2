package UserDaoSerialLmpl;

import library2.dao.UserDaoSerialImpl;
import library2.model.User;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

public class UserDaoSerialImplTest {

public UserDaoSerialImpl user = new UserDaoSerialImpl();

@Test
    public void saveUserTest () {


    User user1 = new User("Jnusz","Biznesy","hasło",null);
    List<User> list = new ArrayList<>();

    user.saveUser(list);

}
}
