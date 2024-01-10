package sr.unasat.ecommerce.handlers;

import sr.unasat.ecommerce.entities.User;
import sr.unasat.ecommerce.services.UserService;

import java.util.Scanner;

public class ActionHandler {

    private final UserService service = new UserService();
    private final Scanner scanner = new Scanner(System.in);

    public void runInteractiveApp() {
        int choice;

        do {
            displayMenu();
            choice = getUserChoice();

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
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);
    }

    private void displayMenu() {
        System.out.println("Choose an option:");
        System.out.println("1. Get all users");
        System.out.println("2. Get user by ID");
        System.out.println("3. Create a user");
        System.out.println("4. Delete a user");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getUserChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        return choice;
    }

    private void getAllUsers() {
        service.getUsers().forEach(System.out::println);
    }

    private void getUserById() {
        System.out.print("Enter user ID: ");
        int userId = scanner.nextInt();
        User user = service.getUserById(userId);
        if (user != null) {
            System.out.println("User by ID: " + user);
        } else {
            System.out.println("User not found for ID " + userId);
        }
    }

    private void createUser() {
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

    private void deleteUser() {
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
//    public void runInteractiveApp() {
//        displayMenu();
//        int choice = getUserChoice();
//
//        switch (choice) {
//            case 1:
//                getAllUsers();
//                break;
//            case 2:
//                getUserById();
//                break;
//            case 3:
//                createUser();
//                break;
//            case 4:
//                deleteUser();
//                break;
//            default:
//                System.out.println("Invalid choice. Exiting.");
//        }
//    }
//
//    private void displayMenu() {
//        System.out.println("Choose an option:");
//        System.out.println("1. Get all users");
//        System.out.println("2. Get user by ID");
//        System.out.println("3. Create a user");
//        System.out.println("4. Delete a user");
//        System.out.print("Enter your choice: ");
//    }
//
//    private int getUserChoice() {
//        int choice = scanner.nextInt();
//        scanner.nextLine(); // Consume the newline character
//        return choice;
//    }
//
//    private void getAllUsers() {
//        service.getUsers().forEach(System.out::println);
//    }
//
//    private void getUserById() {
//        System.out.print("Enter user ID: ");
//        int userId = scanner.nextInt();
//        User user = service.getUserById(userId);
//        if (user != null) {
//            System.out.println("User by ID: " + user);
//        } else {
//            System.out.println("User not found for ID " + userId);
//        }
//    }
//
//    private void createUser() {
//        User newUser = new User();
//
//        System.out.print("Enter user name: ");
//        newUser.setName(scanner.nextLine());
//
//        System.out.print("Enter user password: ");
//        newUser.setPassword(scanner.nextLine());
//
//        System.out.print("Enter user email: ");
//        newUser.setEmail(scanner.nextLine());
//
//        service.createUser(newUser);
//        System.out.println("User created successfully.");
//    }
//
//    private void deleteUser() {
//        System.out.print("Enter user ID to delete: ");
//        int userId = scanner.nextInt();
//        User userToDelete = service.getUserById(userId);
//
//        if (userToDelete != null) {
//            service.deleteUser(userToDelete);
//            System.out.println("User deleted successfully.");
//        } else {
//            System.out.println("User not found for ID " + userId);
//        }
//    }
}