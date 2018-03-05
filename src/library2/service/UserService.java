package library2.service;

import library2.Exceptions.InvalidLoginException;
import library2.model.User;

import java.util.Optional;

public interface UserService {

    boolean saveUserToList(User user);

    boolean addNewUser(User user);

    User logIn(String login) throws InvalidLoginException;

}
