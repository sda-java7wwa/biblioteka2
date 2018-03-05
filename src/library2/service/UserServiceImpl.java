package library2.service;

import library2.Exceptions.InvalidLoginException;
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
        return true;
    }

    @Override
    public User logIn(String login) throws InvalidLoginException {

        if(userDao.getUsersList()
                .stream()
                .filter(s -> s.getLogin().equals(login))
                .findFirst()
                .isPresent()){
           return userDao.getUsersList()
                    .stream()
                    .filter(s -> s.getLogin().equals(login))
                    .findFirst()
                    .get();

        } else throw new InvalidLoginException();
    }
}
