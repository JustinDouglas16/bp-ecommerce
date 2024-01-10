package sr.unasat.ecommerce.app;

import sr.unasat.ecommerce.entities.User;
import sr.unasat.ecommerce.services.UserService;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final UserService service = new UserService();
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        UserService service = new UserService();

//        User user = new User();
//        user.setName("Peter");
//        user.setPassword("789");
//        user.setEmail("peter@bitdynamics.sr");

//        service.createUser(user);

//        user.setId(2);
//        service.deleteUser(user);

//        user.setId(4);
//        user.setName("Bruce");
//        user.setPassword("123");
//        user.setEmail("bruce@bruce.org");
//        service.updateUser(user);

//        String name = "John";
//        user.setName(name);

//        service.getUserByName("John");
//        System.out.println(service);

//        service.getUserById(3);
//        System.out.println();

//        List<User> users = service.getUsers();
//        users.forEach(user -> System.out.println("Name = " + user.getName() + " " + "Password = " + user.getPassword() + " " + "Email = " + user.getEmail()));

        //normal way
//        User userById = service.getUserById(3);
//        if (userById != null) {
//            System.out.println("User by ID: " + userById);
//        } else {
//            System.out.println("User not found for ID 3");
//        }

        //ternary operator
//        User userById = service.getUserById(3);
//        System.out.println("User by ID: " + (userById != null ? userById : "User not found for ID 3"));



        displayMenu();
        int choice = getUserChoice();

        switch (choice) {
            case 1:
                getAllUsers();
                break;
            case 2:
                getUserById();
                break;
            case 3:
                createUser();
                break;
            case 4:
                deleteUser();
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
        }
    }

    private static void displayMenu() {
        System.out.println("Choose an option:");
        System.out.println("1. Get all users");
        System.out.println("2. Get user by ID");
        System.out.println("3. Create a user");
        System.out.println("4. Delete a user");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        return choice;
    }

    private static void getAllUsers() {
        service.getUsers().forEach(System.out::println);
    }

    private static void getUserById() {
        System.out.print("Enter user ID: ");
        int userId = scanner.nextInt();
        User user = service.getUserById(userId);
        if (user != null) {
            System.out.println("User by ID: " + user);
        } else {
            System.out.println("User not found for ID " + userId);
        }
    }

    private static void createUser() {
        User newUser = new User();

        System.out.print("Enter user name: ");
        newUser.setName(scanner.nextLine());

        System.out.print("Enter user password: ");
        newUser.setPassword(scanner.nextLine());

        System.out.print("Enter user email: ");
        newUser.setEmail(scanner.nextLine());

        service.createUser(newUser);
        System.out.println("User created successfully.");
    }

    private static void deleteUser() {
        System.out.print("Enter user ID to delete: ");
        int userId = scanner.nextInt();
        User userToDelete = service.getUserById(userId);

        if (userToDelete != null) {
            service.deleteUser(userToDelete);
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("User not found for ID " + userId);
        }
    }
}
