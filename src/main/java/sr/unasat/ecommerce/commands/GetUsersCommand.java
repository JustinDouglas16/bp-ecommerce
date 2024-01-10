package sr.unasat.ecommerce.commands;

import sr.unasat.ecommerce.services.UserService;

public class GetUsersCommand implements Command {
    private final UserService userService;

    public GetUsersCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute() {
        userService.getUsers().forEach(System.out::println);
    }
}
