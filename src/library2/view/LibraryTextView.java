package library2.view;

import library2.Exceptions.InvalidLoginException;
import library2.Exceptions.InvalidUserException;
import library2.dao.UserDao;
import library2.dao.UserDaoSerialImpl;
import library2.model.User;
import library2.service.UserService;
import library2.service.UserServiceImpl;

import java.util.Optional;
import java.util.Scanner;




import java.util.Scanner;

public class LibraryTextView {
    public enum State {
        INIT,
        DURING_LOGIN,
        DURING_REGISTRATION,
        LOGGED_IN,
        STOP
    }

    private static User currentUser = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        State state = State.INIT;

        while(state != State.STOP) {
            switch (state) {
                case INIT: {
                    state = handleInit(scanner);
                    break;
                }

                case DURING_LOGIN: {
                    state = handleDuringLogin(scanner);
                    break;
                }

                case LOGGED_IN:{
                    System.out.println("Pomyślnie zalogowano");
                    break;
                }

                case DURING_REGISTRATION:{
                    System.out.println("Rejestracja");
                    state= handleDurningRegistration(scanner);
                    break;
                }
            }
        }

    }

    private static State handleInit(Scanner scanner) {
        System.out.println("Dzień dobry");
        System.out.println("Co chcesz zrobić?");
        System.out.println("1 - zalogować się");
        System.out.println("2 - zarejestrować się");
        System.out.println("3 - wyjść z programu");

        int answer = scanner.nextInt();
        switch (answer) {
            case 1:
                return State.DURING_LOGIN;
            case 2:
                return State.DURING_REGISTRATION;
            case 3:
                return State.STOP;
            default:
                System.out.println("Podano złą opcję");
                return State.INIT;
        }
    }


    private static State handleDuringLogin(Scanner scanner) {
        System.out.println("Podaj login");
        String username = scanner.nextLine();
        System.out.println("Podaj hasło");
        String password = scanner.nextLine();

        UserService userService = new UserServiceImpl();

        try {
            currentUser = userService.logIn(username);
            return State.LOGGED_IN;
        } catch (InvalidLoginException e) {
            System.out.println("Błędne logowanie. Spróbuj ponownie.");
            return State.INIT;
        }
    }

    private static State handleDurningRegistration(Scanner scanner){
        System.out.println("Podaj Imie: ");
        String name = scanner.next();
        System.out.println("Podaj nazwisko: ");
        String surname = scanner.next();
        String login=null;
        do{// TODO oddzielienie logiki
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
        currentUser = user;
        return State.LOGGED_IN;
    }

    private static boolean checkLogin(String login){
        UserDao userDao = new UserDaoSerialImpl();
        return userDao.getUsersList()
                .stream()
                .anyMatch(s -> s.getLogin().equals(login));
    }
}
/*public class LibraryTextView {

    private static Scanner scanner = new Scanner(System.in);

    private static User CurrentUser;

    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();

        System.out.println("test");

        int input;


        do{
            System.out.println("Wybierz operację: ");
            System.out.println("0. Zakończ");
            System.out.println("1. Dodaj użytkownika");
            System.out.println("2. Dodaj ksiazke");
            System.out.println("3. Pokaz kto jest zalogowany");
            System.out.println("4. Zaloguj się");

            input = scanner.nextInt();

            switch (input){
                case 0: System.exit(0);
                case 1: operation1(userService); break;
                case 2: //;break;
                case 3:
                    System.out.println(CurrentUser.getLogin());
                    break;
                default:
                    System.out.println("Niepoprawna operacja"); break;
            }

        }while (true);

    }
    private static void operation1(UserService userService){
        System.out.println("Podaj Imie: ");
        String name = scanner.next();
        System.out.println("Podaj nazwisko: ");
        String surname = scanner.next();
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
        userService.addNewUser(user);
        CurrentUser = user;
        //User user = new User
//        clientService.getClientByPESEL(pesel)
//                .ifPresent(System.out::println);
    }

    private static boolean checkLogin(String login){
        UserDao userDao = new UserDaoSerialImpl();
        return userDao.getUsersList()
                .stream()
                .anyMatch(s -> s.getLogin().equals(login));
    }

    private static boolean operation4(){
        UserService userService = new UserServiceImpl();
        User user=null;
        do {
            System.out.println("Podaj login: ");
            String login = scanner.next();
            try {
                user = userService.logIn(login);
            } catch (InvalidLoginException e) {
                System.out.println("Błędny login");
                return false;
            }
        }while (user!=null);

        System.out.println("Podaj haslo: ");
        String password = scanner.next();
        if(user.getPasswd().equals(password)){
            CurrentUser = user;
            return true;
        } else {
            System.out.println("Błędne hasło");
            return false;
        }
    }
}
*/