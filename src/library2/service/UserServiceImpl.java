package library2.service;

import library2.Exceptions.InvalidLoginException;
import library2.dao.UserDao;
import library2.dao.UserDaoSerialImpl;
import library2.model.User;

import java.io.File;
import java.util.Optional;
import java.util.Scanner;

public class UserServiceImpl implements UserService{
    File file = new File("users.ser");

    UserDao userDao = new UserDaoSerialImpl(file);

    @Override
    public User saveUserToList(String name, String surname, Scanner scanner) {

        String login=null;
        do{
            if(login!=null){
                System.out.println("Login znajduje się już w systemie!");
            }
            System.out.println("Podaj login: ");
            login = scanner.next();
        }while (checkLogin(login));
        System.out.println("Podaj hasło: ");
        String password = scanner.next();
        User user = new User(name,surname,password,null,login);
        UserService userService = new UserServiceImpl();
        userService.addNewUser(user);

        return user;

    }

    private static boolean checkLogin(String login){
        UserDao userDao = new UserDaoSerialImpl();
        return userDao.getUsersList()
                .stream()
                .anyMatch(s -> s.getLogin().equals(login));
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
                .anyMatch(s -> s.getLogin().equals(login))){
           return userDao.getUsersList()
                    .stream()
                    .filter(s -> s.getLogin().equals(login))
                    .findFirst()
                    .get();

        } else throw new InvalidLoginException();
    }
}
