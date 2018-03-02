package library2.view;

import library2.model.User;
import library2.service.UserService;

import java.util.Scanner;

public class LibraryTextView {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {



        UserService userService = new UserService() {
            @Override
            public boolean saveUserToList(User user) {
                return false;
            }
        };
        int input;


        do{
            System.out.println("Wybierz operację: ");
            System.out.println("0. Zakończ");
            System.out.println("1. Dodaj użytkownika");
            System.out.println("2. Dodaj ksiazke");
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
        //User user = new User
//        clientService.getClientByPESEL(pesel)
//                .ifPresent(System.out::println);
    }
}
