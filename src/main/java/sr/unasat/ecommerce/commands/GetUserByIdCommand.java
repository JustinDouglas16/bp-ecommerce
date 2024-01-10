package sr.unasat.ecommerce.commands;

import sr.unasat.ecommerce.entities.User;
import sr.unasat.ecommerce.services.UserService;

import java.util.Scanner;

public class GetUserByIdCommand implements Command {
    private final UserService userService;
    private final Scanner scanner;

    public GetUserByIdCommand(UserService userService, Scanner scanner) {
        this.userService = userService;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Enter user ID: ");
        int userId = scanner.nextInt();
        User user = userService.getUserById(userId);
        if (user != null) {
            System.out.println("User by ID: " + user);
        } else {
            System.out.println("User not found for ID " + userId);
        }
    }
}
