package library2.service;

import library2.dao.UserDao;
import library2.dao.UserDaoSerialImpl;
import library2.model.User;

import java.util.Optional;

public class UserServiceImpl implements UserService{

    UserDao userDao = new UserDaoSerialImpl();

    @Override
    public boolean saveUserToList(User user) {
        return false;
    }

    @Override
    public boolean addNewUser(User user) {
        userDao.addUser(user);
        return false;
    }

    @Override
    public Optional<User> logIn(String login) {
        return userDao.getUsersList()
                .stream()
                .filter(s -> s.getLogin().equals(login))
                .findFirst();
    }
}
