package library2.service;

import library2.model.User;

import java.util.Optional;

public interface UserService {

    boolean saveUserToList(User user);

    boolean addNewUser(User user);

    Optional<User> logIn(String login);

}
