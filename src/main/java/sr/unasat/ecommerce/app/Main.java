package sr.unasat.ecommerce.app;

import sr.unasat.ecommerce.entities.User;
import sr.unasat.ecommerce.services.UserService;

public class Main {
    public static void main(String[] args) {
        UserService service = new UserService();
        User user = new User();
        user.setName("justin");
        user.setPassword("123");
        user.setEmail("justin@bitdynamics.sr");

        service.createUser(user);
    }
}
