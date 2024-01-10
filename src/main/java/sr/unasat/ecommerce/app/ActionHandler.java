package sr.unasat.ecommerce.app;

import sr.unasat.ecommerce.commands.*;
import sr.unasat.ecommerce.services.UserService;

import java.util.Scanner;

public class ActionHandler {
    private final Scanner scanner;
    private final Command[] commands;

    public ActionHandler() {
        this.scanner = new Scanner(System.in);
        this.commands = new Command[]{
                new GetUsersCommand(new UserService()),
                new GetUserByIdCommand(new UserService(), scanner),
                new CreateUserCommand(new UserService(), scanner),
                new DeleteUserCommand(new UserService(), scanner),
        };
    }

    public void run() {
        int choice;

        do {
            displayMenu();
            choice = getUserChoice();

            if (choice >= 1 && choice <= commands.length) {
                commands[choice - 1].execute();
            } else if (choice != commands.length + 1) {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != commands.length + 1);

        System.out.println("Exiting the application. Goodbye!");
    }

    private void displayMenu() {
        System.out.println("Choose an option:");
        for (int i = 0; i < commands.length; i++) {
            System.out.println((i + 1) + ". " + commands[i].getClass().getSimpleName());
        }
        System.out.println((commands.length + 1) + ". Exit");
        System.out.print("Enter your choice: ");
    }

    private int getUserChoice() {
        return scanner.nextInt();
    }
}