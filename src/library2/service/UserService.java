package library2.service;

import library2.Exceptions.InvalidLoginException;
import library2.model.User;

import java.util.Optional;
import java.util.Scanner;

public interface UserService {

    User saveUserToList(String name, String surname, Scanner scanner);

    boolean addNewUser(User user);

    User logIn(String login) throws InvalidLoginException;

}
