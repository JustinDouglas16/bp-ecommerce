package sr.unasat.ecommerce.commands;

import sr.unasat.ecommerce.entities.User;
import sr.unasat.ecommerce.services.UserService;

import java.util.Scanner;

public class DeleteUserCommand implements Command {
    private final UserService userService;
    private final Scanner scanner;

    public DeleteUserCommand(UserService userService, Scanner scanner) {
        this.userService = userService;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Enter user ID to delete: ");
        int userId = scanner.nextInt();
        User userToDelete = userService.getUserById(userId);

        if (userToDelete != null) {
            userService.deleteUser(userToDelete);
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("User not found for ID " + userId);
        }
    }
}
