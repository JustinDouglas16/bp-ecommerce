package sr.unasat.ecommerce.commands;

import sr.unasat.ecommerce.entities.User;
import sr.unasat.ecommerce.services.UserService;

import java.util.Scanner;

public class CreateUserCommand implements Command {
    private final UserService userService;
    private final Scanner scanner;

    public CreateUserCommand(UserService userService, Scanner scanner) {
        this.userService = userService;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        User newUser = new User();
        scanner.nextLine();
        System.out.print("Enter user name: ");
        newUser.setName(scanner.nextLine());

        System.out.print("Enter user password: ");
        newUser.setPassword(scanner.nextLine());

        System.out.print("Enter user email: ");
        newUser.setEmail(scanner.nextLine());

        userService.createUser(newUser);
        System.out.println("User created successfully.");
    }
}
