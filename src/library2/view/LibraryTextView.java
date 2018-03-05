package library2.view;

import library2.dao.UserDao;
import library2.dao.UserDaoSerialImpl;
import library2.model.User;
import library2.service.UserService;
import library2.service.UserServiceImpl;

import java.util.Optional;
import java.util.Scanner;

public class LibraryTextView {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();

        System.out.println("test");

        int input;


        do{
            System.out.println("Wybierz operację: ");
            System.out.println("0. Zakończ");
            System.out.println("1. Dodaj użytkownika");
            System.out.println("2. Dodaj ksiazke");
            System.out.println("3. Zaloguj się");

            input = scanner.nextInt();

            switch (input){
                case 0: System.exit(0);
                case 1: //operation1(clientService); break;
                case 2:// operation2(clientService);break;
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

        userService.addNewUser(new User(name,surname,password,null,login));
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

    private static boolean operation3(){
        UserService userService = new UserServiceImpl();
        System.out.println("Podaj login: ");
        String login = scanner.next();
        Optional<User> user = userService.logIn(login);
        user.map(s ->(User)s);
        System.out.println("Podaj haslo: ");
        String password = scanner.next();
        return true;
    }
}
