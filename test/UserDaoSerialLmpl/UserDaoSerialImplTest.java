package UserDaoSerialLmpl;

import library2.dao.UserDaoSerialImpl;
import library2.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

public class UserDaoSerialImplTest {


UserDaoSerialImpl userDao = new UserDaoSerialImpl();




@Test
    public void saveUserTest () {

    User user1 = new User("Jnusz", "Kowalski", "hasło", null, "login");
    User user2 = new User("Zbigniew", "Stonoga", "tablica", null, "Małysz");
    List<User> list = new ArrayList<>();
    list.add(user1);
    list.add(user2);

    userDao.saveUser(list);

}
@Test
    public void getUswerDataTest (){
    List<User> list = userDao.getUsersList();

    Assert.assertEquals(2,list.size());
    Assert.assertEquals(list.get(1), new User("Zbigniew", "Stonoga", "tablica", null, "Małysz"));
}
}
